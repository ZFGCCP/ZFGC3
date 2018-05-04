(function(){
	'use strict';
	
	function ModalService($uibModal, ngDialog){
		var ModalService = {};
		
		ModalService.requiredFieldsErrors = [];
		ModalService.validationErrors = [];
		ModalService.ruleCheckErrors = [];
		
		ModalService.currentDialog = null;
		
		ModalService.createTemplatedPopup = function(controller,templateUrl,windowClass){
			ModalService.currentDialog = $uibModal.open({'controller' : controller,
														 'controllerAs' : 'vm',
														 'templateUrl' : templateUrl,
														 'windowClass' : windowClass
														});
		};
		
		ModalService.createGeneralErrorPopup = function(){
			ModalService.currentDialog = $uibModal.open({ templateUrl: 'scripts/modal/templates/modalGeneralError.html', 
				                         windowClass: 'ngdialog-theme-default'});
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
                						 controller: 'ModalCtrl',
                						 controllerAs : 'vm'});
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