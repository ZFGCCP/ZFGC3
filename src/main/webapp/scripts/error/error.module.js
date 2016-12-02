angular.module('zfgc.error',['zfgc.config'])
	.config(['$stateProvider','zfgc.config', function($stateProvider, config){
		var basePath = config.scriptsPath+'error';
		$stateProvider
			.state('NotFound', {
				url: '/notFound',
				templateUrl: basePath + '/notFound.html'
			})
			.state('internalServer',{
				url: '/internalServer',
				templateUrl: basePath + '/internalServerError.html'
			});
		
}]);