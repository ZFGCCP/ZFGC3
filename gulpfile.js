var gulp = require('gulp')
,	watch = require('gulp-watch')
,	inject = require('gulp-inject')
,	rmdir = require('rimraf')
,	sourcemaps = require('gulp-sourcemaps')
,	sass = require('gulp-sass')
,	angularFileSort = require('gulp-angular-filesort')
,	mainBowerFiles = require('main-bower-files')
,	runSequence = require('run-sequence')
,	series = require('stream-series')
;

gulp.task('default', function(){
	return runSequence('clean',['bower-files','scripts','styles'],'inject-dependencies');
});

var root = 'src/main/webapp';
var isProduction = process.env.NODE_ENV === 'production';
var paths = {
	bower: root+'/bower_components/**',
	styles: [root+'/scss/**', root+'/bower_components/**/*.scss'],
	compiledStyles: [root+'/assets/dist/**/*.css'],
	scriptsJs: [root+'/scripts/**/*.js'],
	dist: [root+'/assets/dist/vendor**',root+'/assets/dist/app/**']
};

gulp.task('watch', ['default'], function(done){
	watch(paths.bower, function(){ gulp.start(['default']); });
	watch(paths.scriptsJs, function(){ gulp.start(['scripts','inject-dependencies']); });
	watch(paths.styles, function(){ gulp.start(['styles','inject-dependencies']); });
	
	//runTests(done);
});

gulp.task('clean', function(done){
	rmdir(root+'/assets/dist', function(error){ 
		if (error){
			console.error(error);
		} 
		done(); 
	});
});

function minifyResources(src,outputName){
	var jsFilter = filter(['**/*.js']);
	var cssFilter = filter(['**/*.css','**/*.scss']);
	var miscFilter = filter(['!**/*.js','!**/*.css','!**/*.scss']);
	return src
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


gulp.task('scripts', function(){
	if(isProduction){
		var jsFilter = filter(['**/*.js']);
		var scripts = gulp.src(paths.scripts)
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
			.pipe(sourcemaps.init())
				.pipe(sass())
			.pipe(sourcemaps.write('maps'))
				.pipe(gulp.dest(root+'/assets/dist'));
	}
});

gulp.task('inject-dependencies', function() {
    var dependencies;
    if (isProduction) {
        dependencies = gulp.src(paths.dist, {read: false});
    } else {
        var bower = gulp.src(mainBowerFiles(), {read: false});
        var scripts = gulp.src(paths.scriptsJs).pipe(angularFileSort());
        var styles = gulp.src(paths.compiledStyles);
        var dependencies = series(bower, scripts, styles);
    }
    return gulp.src(root + '/index.html')
        .pipe( inject(dependencies,{name: 'inject', relative: true}) )
        .pipe(gulp.dest(root));
});