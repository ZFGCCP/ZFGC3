angular.module('zfgc', ['zfgc.config', 'ui.router', 'ngResource', 'ngDialog', 'datePicker','ui.bootstrap','ngAnimate','ngSanitize','zfgc.modules'
        ])
	.config(['$resourceProvider','$urlRouterProvider','$httpProvider','$locationProvider',
	         function($resourceProvider,$urlRouterProvider,$httpProvider,$locationProvider) {
		//Don't strip trailing slashes from calculated URLs
		$resourceProvider.defaults.stripTrailingSlashes = false;
		//Set default route
		$urlRouterProvider.otherwise('/notFound');
		
		
		//interceptor
		$httpProvider.interceptors.push('InterceptorService');
		
	}]);

angular.module('zfgc.modules', [
    'zfgc.users',
    'zfgc.forum',
    'zfgc.error',
    'zfgc.notifications'
]);