(function(){
	'use strict';
	
	function ModalService($uibModal, ngDialog){
		var ModalService = {};
		
		ModalService.requiredFieldsErrors = [];
		ModalService.validationErrors = [];
		ModalService.ruleCheckErrors = [];
		
		ModalService.currentDialog = null;
		
		ModalService.createTemplatedPopup = function(controller,templateUrl,windowClass,params){
			if(!params || params === null){
				params = {};
			}
			
			params.modal = $uibModal.open({'controller' : controller + ' as vm',
														 'templateUrl' : templateUrl,
														 'windowClass' : windowClass,
														 'resolve' : {
															 'params' : params
														 }
													});
		};
		
		ModalService.createGeneralErrorPopup = function(){
			ModalService.currentDialog = $uibModal.open({ templateUrl: 'scripts/modal/templates/modalGeneralError.html', 
				                         windowClass: 'ngdialog-theme-default'});
		};
		
		ModalService.createConfirmDialog = function(confirmationTitle, confirmationMessage, confirmBehavior,params){
			if(confirmationTitle === null){
				confirmationTitle = "Are you sure?";
			}
			
			if(confirmationMessage === null){
				confirmationMessage ="Any unsaved changes will be lost.";
			}
			
			if(params === null){
				params = {};
			}
			
			params.confirmationTitle = confirmationTitle;
			params.confirmationMessage = confirmationMessage;
			params.confirmBehavior = confirmBehavior;

			params.modal = $uibModal.open({
				templateUrl : 'scripts/modal/templates/modalConfirm.html',
				controller : 'ModalCtrl as vm',
				resolve : {
					params : params
				}
			});
			
			return params.modal;
		};
		
		ModalService.createValidationErrorPopup = function(errorResponse){
			if(errorResponse.requiredFieldsErrors.length > 0){
				ModalService.requiredFieldsErrors = errorResponse.requiredFieldsErrors;
			}
			else if(errorResponse.validationErrors.length > 0){
				ModalService.validationErrors = errorResponse.validationErrors;
			}
			else if(errorResponse.ruleErrors.length > 0){
				ModalService.ruleCheckErrors = errorResponse.ruleErrors;
			}
			
			
			ModalService.currentDialog = $uibModal.open({ templateUrl: 'scripts/modal/templates/modalValidationError.html', 
                						 windowClass: 'ngdialog-theme-default',
                						 controller: 'ModalCtrl as vm'});
		}
		
		ModalService.closeValidationErrors = function(){
			ModalService.requiredFieldsErrors = [];
			ModalService.validationErrors = [];
			ModalService.ruleCheckErrors = [];
		};
		
		return ModalService;
	}
	
	angular
	.module('zfgc.forum')
	.service('ModalService',['$uibModal','ngDialog',ModalService])
})();