module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: './',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
	    
	"./src/main/webapp/node_modules/angular/angular.js",
	    
	"./src/main/webapp/node_modules/angular-animate/angular-animate.js",
	    
	"./src/main/webapp/node_modules/angular-file-upload/dist/angular-file-upload.min.js",
	    
	"./src/main/webapp/node_modules/angular-local-storage/dist/angular-local-storage.js",
	    
	"./src/main/webapp/node_modules/angular-recaptcha/release/angular-recaptcha.js",
	    
	"./src/main/webapp/node_modules/angular-resource/angular-resource.js",
	    
	"./src/main/webapp/node_modules/angular-sanitize/angular-sanitize.js",
	    
	"./src/main/webapp/node_modules/angular-ui-bootstrap/dist/ui-bootstrap-tpls.js",
	    
	"./src/main/webapp/node_modules/angular-ui-router/release/angular-ui-router.js",
	    
	"./src/main/webapp/node_modules/angularjs-datepicker/dist/angular-datepicker.js",
	    
	"./src/main/webapp/node_modules/jquery/dist/jquery.js",
	    
	"./src/main/webapp/node_modules/ng-dialog/js/ngDialog.js",
	    
	"./src/main/webapp/node_modules/ng-infinite-scroll/build/ng-infinite-scroll.js",
	    
	"./src/main/webapp/node_modules/sockjs-client/dist/sockjs.min.js",
	    
	"./src/main/webapp/node_modules/stomp-websocket/lib/stomp.min.js",
	    
	"./src/main/webapp/node_modules/tether/dist/js/tether.js",
	    
	"./src/main/webapp/scripts/forum/forum.module.js",
	    
	"./src/main/webapp/scripts/directives/forms/user-search/user-search.directive.js",
	    
	"./src/main/webapp/scripts/directives/forms/message-editor/message-editor.directive.js",
	    
	"./src/main/webapp/scripts/directives/forms/date-selector/date-selector.directive.js",
	    
	"./src/main/webapp/scripts/vendor/jstz/jstz.min.js",
	    
	"./src/main/webapp/scripts/users/whos-online/whos-online.service.js",
	    
	"./src/main/webapp/scripts/users/users.module.js",
	    
	"./src/main/webapp/scripts/users/member-search/member-listing.controller.js",
	    
	"./src/main/webapp/scripts/users/password-reset/password-reset.service.js",
	    
	"./src/main/webapp/scripts/users/password-reset/password-reset.controller.js",
	    
	"./src/main/webapp/scripts/users/password-reset/password-reset-request.controller.js",
	    
	"./src/main/webapp/scripts/pm/pm.module.js",
	    
	"./src/main/webapp/scripts/pm/pmTwoFactor/pm-two-factor.controller.js",
	    
	"./src/main/webapp/scripts/pm/convobox/convoBox.service.js",
	    
	"./src/main/webapp/scripts/pm/convobox/convoBox.controller.js",
	    
	"./src/main/webapp/scripts/pm/conversation/remove-user-modal.controller.js",
	    
	"./src/main/webapp/scripts/pm/conversation/prune-convo-modal.controller.js",
	    
	"./src/main/webapp/scripts/pm/conversation/conversation.controller.js",
	    
	"./src/main/webapp/scripts/pm/conversation/add-user-modal.controller.js",
	    
	"./src/main/webapp/scripts/directives/whos-online/whos-online.directive.js",
	    
	"./src/main/webapp/scripts/directives/user-sidebar/user-sidebar.directive.js",
	    
	"./src/main/webapp/scripts/directives/user-name-icon/user-name-icon.directive.js",
	    
	"./src/main/webapp/scripts/directives/user-details/user-details.directive.js",
	    
	"./src/main/webapp/scripts/directives/paginator/paginator.directive.js",
	    
	"./src/main/webapp/scripts/directives/list-view/list-view.directive.js",
	    
	"./src/main/webapp/scripts/directives/left-panel/left-panel.directive.js",
	    
	"./src/main/webapp/scripts/calendar/calendar.module.js",
	    
	"./src/main/webapp/scripts/directives/event-list/event-list.directive.js",
	    
	"./src/main/webapp/scripts/directives/collapsible-widget/collapsible-widget.directive.js",
	    
	"./src/main/webapp/scripts/directives/avatar-gallery/avatar-gallery.directive.js",
	    
	"./src/main/webapp/scripts/common/header/zfgc-header.directive.js",
	    
	"./src/main/webapp/scripts/whos-online/online.module.js",
	    
	"./src/main/webapp/scripts/users/users.service.js",
	    
	"./src/main/webapp/scripts/users/users.controller.js",
	    
	"./src/main/webapp/scripts/users/user-title-card.controller.js",
	    
	"./src/main/webapp/scripts/users/registration.controller.js",
	    
	"./src/main/webapp/scripts/users/activation.controller.js",
	    
	"./src/main/webapp/scripts/sockets/web-socket.service.js",
	    
	"./src/main/webapp/scripts/searches/userSearches.service.js",
	    
	"./src/main/webapp/scripts/searches/searches.controller.js",
	    
	"./src/main/webapp/scripts/potm/potm.module.js",
	    
	"./src/main/webapp/scripts/pm/pmSend.controller.js",
	    
	"./src/main/webapp/scripts/pm/pmComparator.service.js",
	    
	"./src/main/webapp/scripts/pm/pm.service.js",
	    
	"./src/main/webapp/scripts/notifications/notifications.module.js",
	    
	"./src/main/webapp/scripts/notifications/notifications.service.js",
	    
	"./src/main/webapp/scripts/notifications/notifications.controller.js",
	    
	"./src/main/webapp/scripts/modal/modal.service.js",
	    
	"./src/main/webapp/scripts/modal/modal.controller.js",
	    
	"./src/main/webapp/scripts/lookups/lookups.service.js",
	    
	"./src/main/webapp/scripts/interceptor/interceptor.service.js",
	    
	"./src/main/webapp/scripts/forum/forum.service.js",
	    
	"./src/main/webapp/scripts/forum/forum.controller.js",
	    
	"./src/main/webapp/scripts/forum/forum-post.service.js",
	    
	"./src/main/webapp/scripts/forms/forms.controller.js",
	    
	"./src/main/webapp/scripts/filters/range.filter.js",
	    
	"./src/main/webapp/scripts/error/error.module.js",
	    
	"./src/main/webapp/scripts/common/server-config.service.js",
	    
	"./src/main/webapp/scripts/common/main.controller.js",
	    
	"./src/main/webapp/scripts/calendar/calendar.service.js",
	    
	"./src/main/webapp/scripts/calendar/calendar-view.controller.js",
	    
	"./src/main/webapp/scripts/ui-bootstrap-tpls.js",
	    
	"./src/main/webapp/scripts/app.js",
	    
	"./src/main/webapp/scripts/app.config.js",
	    
	"./src/main/webapp/scripts/calendar/calendar.html",
	    
	"./src/main/webapp/scripts/error/internalServerError.html",
	    
	"./src/main/webapp/scripts/error/notFound.html",
	    
	"./src/main/webapp/scripts/forum/forum.html",
	    
	"./src/main/webapp/scripts/pm/sendPm.html",
	    
	"./src/main/webapp/scripts/users/activation.html",
	    
	"./src/main/webapp/scripts/users/registration.html",
	    
	"./src/main/webapp/scripts/users/users.html",
	    
	"./src/main/webapp/scripts/whos-online/online.html",
	    
	"./src/main/webapp/scripts/common/header/zfgc-header.html",
	    
	"./src/main/webapp/scripts/directives/avatar-gallery/avatar-gallery.html",
	    
	"./src/main/webapp/scripts/directives/collapsible-widget/collapsible-widget.html",
	    
	"./src/main/webapp/scripts/directives/event-list/event-list.directive.html",
	    
	"./src/main/webapp/scripts/directives/left-panel/left-panel.directive.html",
	    
	"./src/main/webapp/scripts/directives/list-view/list-view.directive.html",
	    
	"./src/main/webapp/scripts/directives/paginator/paginator.html",
	    
	"./src/main/webapp/scripts/directives/user-details/user-details.directive.html",
	    
	"./src/main/webapp/scripts/directives/user-name-icon/user-name-icon.directive.html",
	    
	"./src/main/webapp/scripts/directives/user-sidebar/user-sidebar.directive.html",
	    
	"./src/main/webapp/scripts/directives/whos-online/whos-online.directive.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalAddUserToConvo.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalAvatarGallery.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalConfirm.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalConvoPrune.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalGeneralError.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalRemoveUserFromConvo.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalUserTitleCard.html",
	    
	"./src/main/webapp/scripts/modal/templates/modalValidationError.html",
	    
	"./src/main/webapp/scripts/notifications/templates/alert-template.html",
	    
	"./src/main/webapp/scripts/pm/conversation/conversation.html",
	    
	"./src/main/webapp/scripts/pm/convobox/convoBox.html",
	    
	"./src/main/webapp/scripts/pm/convobox/prune-convos.html",
	    
	"./src/main/webapp/scripts/pm/pmTwoFactor/pmTwoFactor.html",
	    
	"./src/main/webapp/scripts/popover/templates/popoverMemberGroups.html",
	    
	"./src/main/webapp/scripts/popover/templates/popoverUserDetails.html",
	    
	"./src/main/webapp/scripts/users/password-reset/password-reset-request.html",
	    
	"./src/main/webapp/scripts/users/password-reset/reset.html",
	    
	"./src/main/webapp/scripts/users/member-search/member-listing.html",
	    
	"./src/main/webapp/scripts/users/user-profile/account-settings.html",
	    
	"./src/main/webapp/scripts/users/user-profile/buddy-ignore.html",
	    
	"./src/main/webapp/scripts/users/user-profile/modify-profile.html",
	    
	"./src/main/webapp/scripts/users/user-profile/notification-settings.html",
	    
	"./src/main/webapp/scripts/users/user-profile/permissions-view.html",
	    
	"./src/main/webapp/scripts/users/user-profile/pm-settings.html",
	    
	"./src/main/webapp/scripts/users/user-profile/user-profile.html",
	    
	"./src/main/webapp/scripts/users/user-profile/user-sidebar.html",
	    
	"./src/main/webapp/scripts/users/user-profile/user-summary.html",
	    
	"./src/main/webapp/scripts/widget-templates/user-profile/contact-data.html",
	    
	"./src/main/webapp/scripts/widget-templates/user-profile/summary.html",
	    
	"./src/main/webapp/scripts/directives/forms/date-selector/date-selector.directive.html",
	    
	"./src/main/webapp/scripts/directives/forms/message-editor/message-editor.directive.html",
	    
	"./src/main/webapp/scripts/directives/forms/user-search/user-search.directive.html",
	    
	"./src/main/webapp/scripts/users/user-profile/mobile/user-profile-mobile-nav.html"
	    
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