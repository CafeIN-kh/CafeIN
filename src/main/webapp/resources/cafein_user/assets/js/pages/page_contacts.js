var ContactPage = function () {

    return {
        
    	//Basic Map
        initMap: function () {
			var map;
			$(document).ready(function(){
			  map = new GMaps({
				div: '#map',
				scrollwheel: false,				
				lat: 37.498503,
				lng: 127.032623
			  });
			  
			  var marker = map.addMarker({
				lat: 37.498503,
				lng: 127.032623,
	            title: 'Company, Inc.'
		       });
			});
        },

        //Panorama Map
        initPanorama: function () {
		    var panorama;
		    $(document).ready(function(){
		      panorama = GMaps.createPanorama({
		        el: '#panorama',
		        lat : 37.498503,
		        lng : 127.032623
		      });
		    });
		}        

    };
}();