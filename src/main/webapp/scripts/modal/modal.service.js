(function(){
	'use strict';
	
	function ModalService(ngDialog){
		var ModalService = {};
		
		ModalService.currentDialog = null;
		
		ModalService.createGeneralErrorPopup = function(){
			ModalService.currentDialog = ngDialog.open({ template: 'scripts/modal/templates/modalGeneralError.html', 
				                         className: 'ngdialog-theme-default',
				                         closeByNavigation : true});
		};
		
		return ModalService;
	}
	
	angular
	.module('zfgc.forum')
	.service('ModalService',['ngDialog',ModalService])
})();