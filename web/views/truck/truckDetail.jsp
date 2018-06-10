  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="truck.vo.Truck"%>
<% Truck truck =(Truck)request.getAttribute("truckSelectOne");%>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDmfjiMcgfcCVI6QKs42Kk4AvHUVdOQtso"></script>

<script>
    // 맵에 찍어주기
   $(function geocodeLatLng() {
		  	 var map = new google.maps.Map(document.getElementById('googlemap'), mapOptions);
	 //googlemap div에 구글 맵을 붙여쥼

 			 var geocoder = new google.maps.Geocoder;
  			 var infowindow = new google.maps.InfoWindow;
    	
    		 var latitude = <%=truck.getLatitude()%>;
    		 var logitude = <%=truck.getLogitude()%>;
    		 
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
		            infowindow.open(map, marker);
		          }
		        } else {
		          window.alert('No results found');
		          window.alert('Geocoder failed due to: ' + status);
		        } //  오류표시
      });
    });

  </script>


<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
		</div>
		<div class="panel-body">
			<div id="googlemap"></div>
			<br> <br> <br> <br>
			<p id="address">
				상세 위치 : <%=truck.getTrucklocation() %></p>
			<br>
			<p id="oponTime">
				오픈시간 : <%=truck.getTruckOpenTime()%></p>
			<br>
			<p id="holiday">
				휴무일 : </p>

		</div>
	</div>
</div>