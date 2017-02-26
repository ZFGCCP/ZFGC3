/* 
 * Creates a range
 * Usage example: <option ng-repeat="y in [] | range:1998:1900">{{y}}</option>
 * source: http://corpus.hubwiz.com/2/angularjs/11160513.html
 */
(function(){

	function Range() {
		  return function(input, min, max) {
		    min = parseInt(min);
		    max = parseInt(max);
		    for (var i=min; i<=max; i++)
		      input.push(i);
		    return input;
		  };
		}
	
	angular.module('zfgc.forum')
	.filter('range', Range);
})();