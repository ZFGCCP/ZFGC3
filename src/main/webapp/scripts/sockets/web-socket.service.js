(function(){
	
	function websocketService($q){
		var service = {};
		
		var socket = {
				client: null,
				stomp: null
		};
		
		service.openWebsocket = function(socketEndpoint, connectSuccessCallback){
			socket.client = new SockJS(socketEndpoint, null, {transports:'websocket'});
			socket.stomp = Stomp.over(socket.client);
			socket.stomp.connect({}, connectSuccessCallback);
		};
		
		service.subscribe = function(subscription, responseCallback){
			socket.stomp.subscribe(subscription, responseCallback);
		};
		
		service.send = function(destination,headers,body){
			socket.stomp.send(destination,headers,body);
		};
		
		return service;
	}
	
	angular.module('zfgc.forum')
		   .service('WebsocketService', ['$q', websocketService]);
	
})();