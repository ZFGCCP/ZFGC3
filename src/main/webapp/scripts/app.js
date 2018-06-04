angular.module('zfgc', ['zfgc.config', 'ui.router', 'ngResource', 'ngDialog', 'datePicker','ui.bootstrap','ngAnimate','ngSanitize','infinite-scroll','LocalStorageModule','zfgc.modules'
        ])
	.config(['$resourceProvider','$urlRouterProvider','$httpProvider','$locationProvider','localStorageServiceProvider',
	         function($resourceProvider,$urlRouterProvider,$httpProvider,$locationProvider,localStorageServiceProvider) {
		//Don't strip trailing slashes from calculated URLs
		$resourceProvider.defaults.stripTrailingSlashes = false;
		//Set default route
		$urlRouterProvider.otherwise('/notFound');
		
		//this is required for SAML to redirect properly
		$locationProvider.html5Mode(true);
		//interceptor
		$httpProvider.interceptors.push('InterceptorService');
		
		//setup localstorage
		localStorageServiceProvider.setPrefix('zfgc3');
		localStorageServiceProvider.setDefaultToCookie(false);
		localStorageServiceProvider.setNotify(false,false);
		
		
		
	}])
	.run(['$rootScope', '$transitions', function($rootScope,$transitions){
		$transitions.onSuccess({}, function($transition){
			$rootScope.previousStateObject = $transition.$from();
			$rootScope.previousState = $transition.$from().name;
			
			$rootScope.previousStateParams = $rootScope.currentStateParams;
			$rootScope.currentStateParams = $transition.params();
	    });
    }]);

angular.module('zfgc.modules', [
    'zfgc.users',
    'zfgc.forum',
    'zfgc.error',
    'zfgc.notifications',
    'zfgc.pm'
]);