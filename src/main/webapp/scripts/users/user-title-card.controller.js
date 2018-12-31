(function(){
	
	function UserTitleCardCtrl(params){
		var vm = this;
		vm.user = params.user;
	};
	
	angular.module('zfgc.users')
		   .controller('UserTitleCardCtrl', ['params',UserTitleCardCtrl]);
	
})();