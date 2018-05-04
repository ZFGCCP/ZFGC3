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
				url : '/mailBox/conversation?convoId',
				templateUrl: basePath +'/conversation/conversation.html'
			})
			.state('prune',{
				url : '/mailBox/prune',
				templateUrl : basePath + '/convobox/prune-convos.html'
			});
}]);