angular.module('zfgc.pm',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'pm';
		$stateProvider
			.state('sendPm', {
				url: '/sendPm?senderId',
				templateUrl: basePath + '/sendPm.html'
			});
		
		$stateProvider
			.state('convoBox',{
					url: '/mailBox',
					templateUrl: basePath + '/convobox/convoBox.html'
			})
			.state('convo',{
				url : '/mailBox/conversation?:conversationId',
				templateUrl: basePath +'/conversation/conversation.html'
			})
			.state('prune',{
				url : '/mailBox/prune',
				templateUrl : basePath + '/convobox/prune-convos.html'
			});
		
		$stateProvider
			.state('pmAuth',{
				url : '/pmAuth',
				templateUrl : basePath + '/pmTwoFactor/pmTwoFactor.html'
			});
}]);