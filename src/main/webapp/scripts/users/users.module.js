angular.module('zfgc.users',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'users';
		var baseRouter = config.routerPaths;
		$stateProvider
			.state('users', {
				url: baseRouter + '/users',
				templateUrl: basePath + '/users.html'
			})
			.state('user-profile', {
				url: baseRouter + '/userprofile?:userId',
				templateUrl: basePath + '/user-profile/user-profile.html'
			})
			.state('registration', {
				url: baseRouter + '/registration',
				templateUrl: basePath + '/registration.html'
			});
		
		$stateProvider
			.state('members', {
				url : baseRouter + '/members',
				templateUrl: basePath + '/member-search/member-listing.html'
			});
}]);