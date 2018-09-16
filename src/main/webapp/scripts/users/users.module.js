angular.module('zfgc.users',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'users';
		$stateProvider
			.state('users', {
				url: '/users',
				templateUrl: basePath + '/users.html'
			})
			.state('user-profile', {
				url: '/userprofile?:userId',
				templateUrl: basePath + '/user-profile/user-profile.html'
			})
			.state('registration', {
				url: '/registration',
				templateUrl: basePath + '/registration.html'
			});
		
		$stateProvider
			.state('members', {
				url : '/members',
				templateUrl: basePath + '/member-search/member-listing.html'
			});
}]);