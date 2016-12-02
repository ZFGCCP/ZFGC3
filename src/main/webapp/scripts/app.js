angular.module('zfgc', ['zfgc.config', 'ui.router', 'ngResource', 'zfgc.modules'
        ])
	.config(['$resourceProvider','$urlRouterProvider',
	         function($resourceProvider,$urlRouterProvider) {
		//Don't strip trailing slashes from calculated URLs
		$resourceProvider.defaults.stripTrailingSlashes = false;
		//Set default route
		$urlRouterProvider.otherwise('/');
	}]);

angular.module('zfgc.modules', [
    'zfgc.users',
    'zfgc.forum',
    'zfgc.potm',
    '720kb.datepicker'
]);