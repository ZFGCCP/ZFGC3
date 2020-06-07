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
		})
		.state('new-thread', {
			url: baseRouter + '/board/thread/new?boardId',
			templateUrl: basePath + '/thread/new-thread.html'
		})
		.state('move-threads', {
			url: baseRouter + '/board/thread/move?fromBoardId',
			templateUrl: basePath + '/thread/move/move-thread.html'
		});
}]);