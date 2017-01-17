angular.module('zfgc.users',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'users';
		$stateProvider
			.state('users', {
				url: '/users',
				templateUrl: basePath + '/users.html'
			})
			.state('user-profile', {
				url: '/userprofile',
				templateUrl: basePath + '/user-profile/user-profile.html'
			})
			.state('registration', {
				url: '/registration',
				templateUrl: basePath + '/registration.html'
			})
			;
}]);