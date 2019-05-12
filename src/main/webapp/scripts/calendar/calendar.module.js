angular.module('zfgc.calendar',['zfgc.config'])
	   .config(['$stateProvider','zfgc.config',function($stateProvider, config){
		   var basePath = config.scriptsPath+'calendar';
		   var baseRouter = config.routerPaths;
		   
		   $stateProvider
		   	.state('calendar', {
		   		url: baseRouter + '/calendar',
		   		templateUrl: basePath + '/calendar.html'
		   	});
	   }]);