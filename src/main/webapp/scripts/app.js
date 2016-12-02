angular.module('zfgc', ['zfgc.config', 'ui.router', 'ngResource', 'zfgc.modules'
        ])
	.config(['$resourceProvider','$urlRouterProvider','$httpProvider',
	         function($resourceProvider,$urlRouterProvider,$httpProvider) {
		//Don't strip trailing slashes from calculated URLs
		$resourceProvider.defaults.stripTrailingSlashes = false;
		//Set default route
		$urlRouterProvider.otherwise('/notFound');
		
		
		//interceptor
		$httpProvider.interceptors.push(function() {
		    return {
		      response: function(res) {
		        /* This is the code that transforms the response. `res.data` is the
		         * response body */
		        /*res.data = { data: data };
		        res.data.meta = { status: res.status };*/
		    	  	return res;
		      },
		    
		      request: function(req){
			    	if(!angular.isUndefined(window.localStorage["zfgc-auth-token"])){
			    		res.headers.authorization = window.localStorage["zfgc-auth-token"];
			    	}  
		    	
			    	return req;
		      },
		      
		      responseError: function(resE){
		    	  	if(resE.status === 409){
		    	  		
		    	  	}
		    	  	else if(resE.status === 404){
		    	  		window.location = "/forum/#/notFound"
		    	  	}
		    	  	else if(resE.status === 500){
		    	  		window.location = "/forum/#/internalServer"
		    	  	}
		    	  
		    	  	return resE;
		      }
		    };
		  });
		
	}]);

angular.module('zfgc.modules', [
    'zfgc.users',
    'zfgc.forum',
    'zfgc.potm',
    'zfgc.error'
]);