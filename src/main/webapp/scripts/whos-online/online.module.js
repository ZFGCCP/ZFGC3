angular.module('zfgc.online',['zfgc.config'])
	   .config(['$stateProvider','zfgc.config',function($stateProvider, config){
		   var basePath = config.scriptsPath+'whos-online';
		   var baseRouter = config.routerPaths;
		   
		   $stateProvider
		   	.state('whosOnline', {
		   		url: baseRouter + '/whosOnline',
		   		templateUrl: basePath + '/online.html'
		   	});
	   }]);