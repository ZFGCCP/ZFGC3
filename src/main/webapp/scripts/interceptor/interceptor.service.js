(function(){
	'use strict';
	
	function InterceptorService($q,$injector){
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
	    	    var state = $injector.get('$state');
	    	    var modalService = $injector.get('ModalService');
	    	  	if(resE.status === 404){
	    	  		state.go('notFound');
	    	  	}
	    	  	else if(resE.status === 422){
	    	  		modalService.createValidationErrorPopup(resE.data);
	    	  	}
	    	  	else if(resE.status === 500){
	    	  		modalService.createGeneralErrorPopup();
	    	  	}
	    	  
	    	  	return resE;
	      }
		
		return InterceptorService;
		
	}
	
	angular
		.module('zfgc.forum')
		.service('InterceptorService', ['$q','$injector',InterceptorService])
})();