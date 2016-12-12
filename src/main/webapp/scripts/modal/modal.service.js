(function(){
	'use strict';
	
	function ModalService(ngDialog){
		var ModalService = {};
		
		ModalService.requiredFieldsErrors = [];
		ModalService.validationErrors = [];
		ModalService.ruleCheckErrors = [];
		
		ModalService.currentDialog = null;
		
		ModalService.createGeneralErrorPopup = function(){
			ModalService.currentDialog = ngDialog.open({ template: 'scripts/modal/templates/modalGeneralError.html', 
				                         className: 'ngdialog-theme-default',
				                         closeByNavigation : true});
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
			
			
			ModalService.currentDialog = ngDialog.open({ template: 'scripts/modal/templates/modalValidationError.html', 
                						 className: 'ngdialog-theme-default',
                						 controller: 'ModalCtrl',
                						 closeByNavigation : true,
                						 preCloseCallback: ModalService.closeValidationErrors});
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
	.service('ModalService',['ngDialog',ModalService])
})();