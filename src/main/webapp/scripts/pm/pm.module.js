angular.module('zfgc.pm',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'pm';
		$stateProvider
			.state('sendPm', {
				url: '/sendPm?senderId',
				templateUrl: basePath + '/sendPm.html'
			});
}]);