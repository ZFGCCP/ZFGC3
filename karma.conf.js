module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: './',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
	    
	"./src/main/webapp/bower_components/angular/angular.js",
	    
	"./src/main/webapp/bower_components/jquery/dist/jquery.js",
	    
	"./src/main/webapp/bower_components/angular-ui-router/release/angular-ui-router.js",
	    
	"./src/main/webapp/bower_components/angular-resource/angular-resource.js",
	    
	"./src/main/webapp/bower_components/tether/dist/js/tether.js",
	    
	"./src/main/webapp/bower_components/moment/moment.js",
	    
	"./src/main/webapp/bower_components/moment-timezone/builds/moment-timezone-with-data-2010-2020.js",
	    
	"./src/main/webapp/bower_components/ng-dialog/js/ngDialog.js",
	    
	"./src/main/webapp/bower_components/bootstrap/dist/js/bootstrap.js",
	    
	"./src/main/webapp/bower_components/angular-datepicker/dist/angular-datepicker.js",
	    
	"./src/main/webapp/scripts/vendor/jstz/jstz.min.js",
	    
	"./src/main/webapp/scripts/users/users.module.js",
	    
	"./src/main/webapp/scripts/users/users.service.js",
	    
	"./src/main/webapp/scripts/users/registration.controller.js",
	    
	"./src/main/webapp/scripts/potm/potm.module.js",
	    
	"./src/main/webapp/scripts/forum/forum.module.js",
	    
	"./src/main/webapp/scripts/modal/modal.service.js",
	    
	"./src/main/webapp/scripts/modal/modal.controller.js",
	    
	"./src/main/webapp/scripts/lookups/lookups.service.js",
	    
	"./src/main/webapp/scripts/interceptor/interceptor.service.js",
	    
	"./src/main/webapp/scripts/forum/forum.service.js",
	    
	"./src/main/webapp/scripts/forum/forum.controller.js",
	    
	"./src/main/webapp/scripts/error/error.module.js",
	    
	"./src/main/webapp/scripts/app.js",
	    
	"./src/main/webapp/scripts/app.config.js",
	    
	"./src/main/webapp/scripts/error/internalServerError.html",
	    
	"./src/main/webapp/scripts/error/notFound.html",
	    
	"./src/main/webapp/scripts/forum/forum.html",
	    
	"./src/main/webapp/scripts/header/header.html",
	    
	"./src/main/webapp/scripts/users/registration.html",
	    
	"./src/main/webapp/scripts/users/users.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalGeneralError.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalValidationError.html"
	    
	],


    // list of files to exclude
    exclude: [],

    plugins: [
      'karma-jasmine', 'karma-phantomjs-launcher', 'karma-ng-html2js-preprocessor',
      'karma-junit-reporter', 'karma-mocha-reporter', 'karma-beep-reporter', 'karma-super-dots-reporter'
    ],

    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    	'**/*.html': ['ng-html2js']
    },
    
    ngHtml2JsPreprocessor: {
        // strip this from the file path
        stripPrefix: 'src/main/webapp/',

        // - setting this option will create a single module that contains templates
        moduleName: 'templates'
    },

    

    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['mocha','super-dots','beep', 'junit'],

    junitReporter: {
    	outputFile: 'test-results.xml'
    },

    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['PhantomJS'],
    
    mochaReporter: {
        output: 'minimal'
    },       
    
    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: true
  });
};