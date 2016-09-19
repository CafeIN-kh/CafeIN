
function googleapisView() {
	//private_cafe_detail에서 개인카페의 주소값 가져오기
	var pcafe_address = $('#pcafe_address').val();
	
    var address = encodeURIComponent(pcafe_address);
    //주소->위도,경도 값으로 변환해줌(구글 지오코딩 api 이용)
    var geocode = "http://maps.googleapis.com/maps/api/geocode/json?address="+address+"&sensor=false";
    jQuery.ajax({
        url: geocode,
        type: 'POST',
           success: function(myJSONResult){
                    if(myJSONResult.status == 'OK') {
                        var tag = "";
                        var i;
                        for (i = 0; i < myJSONResult.results.length; i++) {
                          tag += '<input type="hidden" id="address" value="'+myJSONResult.results[i].formatted_address+'" >';
                          tag += '<input type="hidden" id="lat" value="'+myJSONResult.results[i].geometry.location.lat+'" >';
                          tag += '<input type="hidden" id="lng" value="'+myJSONResult.results[i].geometry.location.lng+'" >';
                        }
                        //alert("tag : " + tag);
                        //initCafeINMap에서 위도 경도값 불러오기 위해 html에 값을 붙여줌
                        document.getElementById("map_tag").innerHTML = tag;
                    } else if(myJSONResult.status == 'ZERO_RESULTS') {
                        alert("지오코딩이 성공했지만 반환된 결과가 없음을 나타냅니다.\n\n이는 지오코딩이 존재하지 않는 address 또는 원격 지역의 latlng을 전달받는 경우 발생할 수 있습니다.")
                    } else if(myJSONResult.status == 'OVER_QUERY_LIMIT') {
                        alert("할당량이 초과되었습니다.");
                    } else if(myJSONResult.status == 'REQUEST_DENIED') {
                        alert("요청이 거부되었습니다.\n\n대부분의 경우 sensor 매개변수가 없기 때문입니다.");
                    } else if(myJSONResult.status == 'INVALID_REQUEST') {
                        alert("일반적으로 쿼리(address 또는 latlng)가 누락되었음을 나타냅니다.");
                    }
            }
    });
}
googleapisView();

//구글 map api 이용
function initCafeINMap() {
	
	var cafe_lat = $('#lat').val();
	//String->float 형으로 파싱해줌
	cafe_lat = parseFloat(cafe_lat);
	var cafe_lng = $('#lng').val();
	//String->float 형으로 파싱해줌
	cafe_lng = parseFloat(cafe_lng);
	
	//cafe_lat,cafe_lng은 number 형으로 들어가야함.
    var myLatLng = {lat: cafe_lat, lng: cafe_lng};
    //alert("myLatLng.lat : " + myLatLng.lat + ", myLatLng.lng : " + myLatLng.lng);
    
    // Create a map object and specify the DOM element for display.
    var map = new google.maps.Map(document.getElementById('map'), {
      center: myLatLng,
      scrollwheel: false,
      zoom: 17
    });

    // Create a marker and set its position.
    var marker = new google.maps.Marker({
      map: map,
      position: myLatLng,
      title: 'Private Cafe Info!'
    });
}
