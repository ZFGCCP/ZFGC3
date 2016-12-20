var gulp = require('gulp')
,	watch = require('gulp-watch')
,	plumber = require('gulp-plumber')
,	inject = require('gulp-inject')
,	rmdir = require('rimraf')
,	angularFileSort = require('gulp-angular-filesort')
,	uglify = require('gulp-uglify')
,	minifyCSS = require('gulp-minify-css')
,	concat = require('gulp-concat')
,	sourcemaps = require('gulp-sourcemaps')
,	mainBowerFiles = require('main-bower-files')
,	filter = require('gulp-filter')
,	sass = require('gulp-sass')
,	runSequence = require('run-sequence')
,	series = require('stream-series')
,	karma = require('karma').server
,	debug = require('gulp-debug')
,	templateCache = require('gulp-angular-templatecache')
,   minifyHtml = require('gulp-minify-html')
, 	timestamp = new Date().getTime();
;


gulp.task('default', function(){
	return runSequence('clean',['bower-files','template-cache','scripts','styles'],'inject-dependencies','inject-test-dependencies');
});

var root = 'src/main/webapp';
var isProduction = process.env.NODE_ENV === 'production';
var paths = {
	bower: root+'/bower_components/**',
	scripts: [root+'/scripts/vendor/**',root+'/scripts/**'],
	scriptsJs: [root+'/scripts/**/*.js'],
	templates: [root+'/scripts/**/*.html'],
	styles: [root+'/assets/styles/**'],
	//styles: [root+'/scss/**', root+'/bower_components/**/*.scss'],
	compiledStyles: [root+'/assets/dist/**/*.css'],
	dist: [root+'/assets/dist/vendor**',root+'/assets/dist/**'],
	//dist: [root+'/assets/dist/vendor**',root+'/assets/dist/app/**']
	distJs: [root+'/assets/dist/**/*.js'],
	testJs: ['src/test/javascript/**/*.js'],
	scriptsAndTests: [root+'/scripts/**','src/test/javascript/**/*.js']
};

gulp.task('watch', ['default'], function(done){
	watch(paths.bower, function(){ gulp.start(['default']); });
	watch(paths.scriptsAndTests, function(){
		gulp.start(['scripts','inject-dependencies']);
		gulp.start(['test']);
	});
	watch(paths.styles, function(){ gulp.start(['styles','inject-dependencies']); });
	
	runTests(done);
});

function runTests(done){
	karma.start({
		configFile: __dirname + '/karma.conf.js'
	}, function(){
		if (done) done();
	});
}

gulp.task('test',['inject-test-dependencies'], function(done){
	runTests(done);
});

gulp.task('clean', function(done){
	rmdir(root+'/assets/dist', function(error){ 
			if(error){console.error(error);} 
			done(); 
		});
});

function onError(err){
	console.error(err);
	this.emit('end');
}

function minifyResources(src,outputName){
	var jsFilter = filter(['**/*.js']);
	var cssFilter = filter(['**/*.css','**/*.scss']);
	var miscFilter = filter(['!**/*.js','!**/*.css','!**/*.scss']);
	return src
			.pipe( plumber({errorHandler: onError}) )
			.pipe(jsFilter)
				.pipe(sourcemaps.init())
					.pipe(uglify())
					.pipe(concat(outputName + '.min.js'))
				.pipe(sourcemaps.write('maps'))
			.pipe(jsFilter.restore())
			.pipe(cssFilter)
				.pipe(sourcemaps.init())
					.pipe(sass({ style: 'compressed' }))
					.pipe(minifyCSS({keepSpecialComments: 0}))
					.pipe(concat(outputName + '.min.css'))
				.pipe(sourcemaps.write('maps'))
			.pipe(cssFilter.restore())
			.pipe(gulp.dest(root+'/assets/dist'));
}

gulp.task('bower-files', function(){
	if(isProduction){
		return minifyResources(gulp.src(mainBowerFiles()), 'vendor');
	}
});

gulp.task('template-cache', function() {
	if(isProduction) {
		var minifyHtmlOpts = {
			empty: true, //preserve empty attributes (necessary in angular when using directives)
			spare: true, //do not remove redundant attributes
			quotes: true //do not remove arbitrary quotes
		};
		return gulp.src(paths.templates)
			.pipe(minifyHtml(minifyHtmlOpts))
			.pipe(templateCache('templates.js', { root: 'scripts/', module: 'app.templates' }))
			.pipe(gulp.dest(root+'/assets/dist'));
	}
});
gulp.task('scripts', function(){
	if(isProduction){
		var jsFilter = filter(['**/*.js']);
		var scripts = gulp.src(paths.scripts.concat(root+'/assets/dist/templates.js'))
							.pipe( plumber({errorHandler: onError}) )
							.pipe(jsFilter)
								.pipe(angularFileSort())
							.pipe(jsFilter.restore())
							;
		return minifyResources(scripts, 'scripts');
	}
});

gulp.task('styles', function(){
	var src = gulp.src(paths.styles);
	if(isProduction){
		return minifyResources(src, 'styles');
	}else{
		return src
			.pipe(plumber({errorHandler: onError}))
			.pipe(sourcemaps.init())
				.pipe(sass())
			.pipe(sourcemaps.write('maps'))
				.pipe(gulp.dest(root+'/assets/dist'));
	}
});

gulp.task('inject-dependencies', function(){
	var dependencies;
	if (isProduction) {
		dependencies = gulp.src(paths.dist, {read: false});
	} else {
		var bower = gulp.src(mainBowerFiles(), {read: false});
		var scripts = gulp.src(paths.scriptsJs).pipe(plumber({errorHandler: onError})).pipe(angularFileSort());
		var styles = gulp.src(paths.compiledStyles);
		var dependencies = series(bower, scripts, styles);
	}
	
	return gulp.src(root + '/index.html')
		.pipe( plumber({errorHandler: onError}) )
		.pipe( inject(dependencies,{name: 'inject', relative: true, 
			transform: function(filepath) {
				arguments[0] = filepath + '?b=' + timestamp;
				return inject.transform.apply(inject.transform, arguments);
			}
		}) )
		.pipe(gulp.dest(root));
});

gulp.task('inject-test-dependencies', function(){
	var jsFilter = filter(['**/*.js']);
	
	//var libraries = gulp.src(paths.coreLibraries, {read: false});
	var bower = gulp.src(mainBowerFiles(), {read: false}).pipe( plumber({errorHandler: onError}) ).pipe(jsFilter);
	var scripts = gulp.src(paths.scriptsJs).pipe( plumber({errorHandler: onError}) ).pipe(angularFileSort());
	var tests = gulp.src(paths.testJs, {read: false});
	var templates = gulp.src(paths.templates, {read: false});
	var allDependencies = series(/*libraries, */bower, scripts, tests, templates);
	
	return gulp.src('./karma.conf.js')
			.pipe( plumber({errorHandler: onError}) )
			.pipe( inject(allDependencies,{
				starttag: 'files: [',
				endtag: ']',
			    transform: function (filepath, file, i, length) {
			      return '".' + filepath + '"' + (i + 1 < length ? ',' : '');
			    }
			}))
			.pipe(gulp.dest('./'));
});