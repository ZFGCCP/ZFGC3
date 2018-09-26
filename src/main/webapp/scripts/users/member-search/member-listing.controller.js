(function(){
	
	function MemberListingCtrl($scope,UserService){
		var vm = this;
		vm.pageNo = 1;
		vm.memberRange = 20;
		vm.memberList = [];
		
		vm.getMemberListing = function(){
			UserService.getMemberListing(vm,vm.pageNo,vm.memberRange);
		};
		
		//vm.getMemberListing();
	}
	
	angular.module('zfgc.users')
		   .controller('MemberListingCtrl',['$scope','UserService',MemberListingCtrl]);
	
})();