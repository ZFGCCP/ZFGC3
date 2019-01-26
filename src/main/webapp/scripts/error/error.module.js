angular.module('zfgc.error',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'error';
		var baseRouter = config.routerPaths;
		$stateProvider
			.state('NotFound', {
				url: baseRouter + '/notFound',
				templateUrl: basePath + '/notFound.html'
			})
			.state('internalServer',{
				url: baseRouter + '/internalServer',
				templateUrl: basePath + '/internalServerError.html'
			});
		
}]);