angular.module('zfgc.pm',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'users';
		$stateProvider
			.state('sendPm', {
				url: '/sendPm',
				templateUrl: basePath + '/newPm.html'
			});
}]);