angular.module('zfgc.forum',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'forum';
		var baseRouter = config.routerPaths;
		$stateProvider
		.state('forum', {
			url: baseRouter + '/bbs/index',
			templateUrl: basePath + '/forum.html'
		})
		.state('board', {
			url: baseRouter + '/board?boardId',
			templateUrl: basePath + '/board.html'
		});
}]);