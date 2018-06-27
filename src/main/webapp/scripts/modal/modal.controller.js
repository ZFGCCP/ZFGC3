(function(){
	'use strict';
	
	function ModalCtrl(ModalService,params){
		var vm = this;
		
		vm.checkHasRequiredFields = function(){
			return ModalService.requiredFieldsErrors.length > 0;
		};
		
		vm.checkHasValidation = function(){
			return ModalService.validationErrors.length > 0;
		};
		
		vm.checkHasRules = function(){
			return ModalService.ruleCheckErrors.length > 0;
		};
		
		vm.requiredFields = function(){
			return ModalService.requiredFieldsErrors;
		};
		
		vm.validation = function(){
			return ModalService.validationErrors;
		};
		
		vm.rules = function(){
			return ModalService.ruleCheckErrors;
		};
		
		
	}
	
	angular
		.module('zfgc.forum')
		.controller('ModalCtrl',['ModalService','params',ModalCtrl])
	
})();