angular.module('zfgc.forum',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'forum';
		$stateProvider
		.state('forum', {
			url: '/bbs/index',
			templateUrl: basePath + '/forum.html'
		});
}]);