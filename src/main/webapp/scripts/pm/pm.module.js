angular.module('zfgc.pm',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'pm';
		var baseRouter = config.routerPaths;
		$stateProvider
			.state('sendPm', {
				url: baseRouter + '/sendPm?senderId',
				templateUrl: basePath + '/sendPm.html'
			});
		
		$stateProvider
			.state('convoBox',{
					url: baseRouter + '/mailBox',
					templateUrl: basePath + '/convobox/convoBox.html'
			})
			.state('convo',{
				url : baseRouter + '/mailBox/conversation?:conversationId',
				templateUrl: basePath +'/conversation/conversation.html'
			})
			.state('prune',{
				url : baseRouter + '/mailBox/prune',
				templateUrl : basePath + '/convobox/prune-convos.html'
			});
		
		$stateProvider
			.state('pmAuth',{
				url : baseRouter + '/pmAuth',
				templateUrl : basePath + '/pmTwoFactor/pmTwoFactor.html'
			});
}]);