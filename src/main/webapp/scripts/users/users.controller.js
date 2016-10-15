(function(){
	'use strict';
	
	function UsersCtrl(){
		var vm = this;
		vm.somevalue = 'swipe all day';
		
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', [UsersCtrl])
})();