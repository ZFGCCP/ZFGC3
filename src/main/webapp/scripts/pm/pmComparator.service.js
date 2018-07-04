(function(){
	
	function PmComparatorService(){
		var service = {};
		
		service.compareByLastSentTime = function(a,b){
			if(a.sentDt < b.sentDt){
				return -1;
			}
			
			if(a.sentDt > b.sentDt){
				return 1;
			}
			
			return 0;
		};
		
		service.compareByStartedDt = function(a,b){
			if(a.startDt < b.startDt){
				return -1;
			}
			
			if(a.startDt > b.startDt){
				return 1;
			}
			
			return 0;
		};
		
		service.compareByStartingUser = function(a,b){
			if(a.initiatorName < b.initiatorName){
				return -1;
			}
			
			if(a.iniatorName > b.initatorName){
				return 1;
			}
			
			return 0;
		};
		
		service.compareByLastSentUser = function(a,b){
			
		};
		
		service.compareBySubject = function(a,b){
			if(a.subject < b.subject){
				return -1;
			}
			
			if(a.subject > b.subject){
				return 1;
			}
			
			return 0;
		};
		
		return service;
	}
	
	angular.module('zfgc.forum')
		   .service('PmComparatorService',[PmComparatorService]);
	
})();