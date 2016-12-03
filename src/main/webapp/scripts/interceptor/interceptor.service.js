(function(){
	'use strict';
	
	function InterceptorService(LookupsService){
		var InterceptorService = {};
		InterceptorService.response = function(res) {
	        /* This is the code that transforms the response. `res.data` is the
	         * response body */
	        /*res.data = { data: data };
	        res.data.meta = { status: res.status };*/
	    	  	return res;
	      },
	    
	      InterceptorService.request = function(req){
		    	if(!angular.isUndefined(window.localStorage["zfgc-auth-token"])){
		    		res.headers.authorization = window.localStorage["zfgc-auth-token"];
		    	}  
	    	
		    	return req;
	      },
	      
	      InterceptorService.responseError = function(resE){
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
		
		return InterceptorService;
		
	}
	
	angular
		.module('zfgc.users')
		.service('InterceptorService', ['LookupsService',InterceptorService])
})();