<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>
    var latitude = null;
    var longitude = null;
    var accuracy = null;

    // 변수 초기화
    var address = '대전광역시 중구 한밭도서관길 222';
    // DB에서 주소 가져와서 검색하거나 주소를 바로 코딩.
    var mapOptions = {
      zoom: 17
    };

    var map = new google.maps.Map(document.getElementById('map'), mapOptions);
    //map div에 구글 맵을 붙여쥼

    var geocoder = new google.maps.Geocoder;
    var infowindow = new google.maps.InfoWindow;
    // 주소 찾기위한 변수 set
    document.getElementById('findMapAddress').addEventListener('click',
      function() {
        geocodeLatLng(geocoder, map, infowindow);
      })
    document.getElementById('findMap').addEventListener('click',
      function() {
        findMap();
      })
      document.getElementById('findL').addEventListener('click',
          function() {
            findL(address,map,geocoder);
          })
    //button 에 addEventListener 추가

    function findMap() {
      $("#findMap").value = "위치 재설정";
      if (navigator.geolocation) {
        document.getElementById("support").innerHTML = "현재 위치 확인 가능";
        navigator.geolocation.getCurrentPosition(function updateLocation(position) {

          latitude = position.coords.latitude;
          longitude = position.coords.longitude;
          accuracy = position.coords.accuracy;
          // 위도 경도 정확도 불러옴
          map.setCenter(new google.maps.LatLng(latitude, longitude));
          // 가져온 위치를 기반으로 map의 center부분 set
          document.getElementById('ire').innerHTML = "위도 / 경도 : " + latitude + "," + longitude;
          // 직접적으로 위도와 경도를 구함
        }, function handlerLocationError(error) {
          alert(error.code);
        });
      } // 현재 위치 확인하는 위도와 경도를 구하는 시작점
    }

    // 주소 찾기
    function geocodeLatLng(geocoder, map, infowindow) {
      var latlngStr = latitude + "," + longitude;
      var latlng = {
        lat: latitude,
        lng: longitude
      };
      geocoder.geocode({
        'location': latlng
      }, function(results, status) {
        if (status === 'OK') {
          if (results[1]) {
            map.setZoom(18);
            var marker = new google.maps.Marker({
              position: latlng,
              map: map
            });
            map.setCenter(new google.maps.LatLng(latitude, longitude))
            //  results[1].formatted_address = 위도,경도로 구한 주소
            infowindow.setContent(results[1].formatted_address);
            document.getElementById("address").innerHTML += results[1].formatted_address;
            infowindow.open(map, marker);
          }
        } else {
          window.alert('No results found');
          window.alert('Geocoder failed due to: ' + status);
        } //  오류표시
      });
    }

    function findL(address,map,geocoder){


        var marker = null;

        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                marker = new google.maps.Marker({
                                map: map,
                                // icon: image, // 마커로 사용할 이미지(변수)
                                title: '한밭도서관', // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
                                position: results[0].geometry.location

                            });
    }  infowindow.open(map, marker); // 마커에 정보표시
      alert(results[0].geometry.location);

    // if 문 마무리
  }); // 주소값 마커 찍어주기
  }
  </script>
 <div class="row">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
              </div>
              <div class="panel-body">
                <div id = "map"></div>
                <br>
                <br>
                <br>
                <br>
                <p id ="address">상세 위치 : </p>
                <br>
                <p id="oponTime">오픈시간 : </p>
                <br>
                <p id="holiday">휴무일 : </p>

              </div>
            </div>
          </div>