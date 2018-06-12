  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="truck.vo.Truck"%>
<% Truck truck =(Truck)request.getAttribute("truckSelectOne");%>


<script>
//맵에 찍어주기
$(function geocodeLatLng() {
	   		var mapOptions = {
	   			      zoom: 17
	   		};
		  	 var map = new google.maps.Map(document.getElementById('googlemap'), mapOptions);
	 //googlemap div에 구글 맵을 붙여쥼

			 var geocoder = new google.maps.Geocoder;
			 var infowindow = new google.maps.InfoWindow;
 	
 		 var latitude = <%=truck.getLatitude()%>;
 		 var longitude = <%=truck.getLogitude()%>;
 		  var latlngStr = latitude + "," + longitude;
 			$('#holiday').html(<%=truck.getLatitude()%>);
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
	s
  </script>


<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
		</div>
		<div class="panel-body">
			<div id="googlemap"></div>
			<br> <br> <br> <br>
			<p id="truck_address">
				상세 위치 : <%=truck.getTrucklocation() %></p>
			<br>
			<p id="truck_oponTime">
				오픈시간 : <%=truck.getTruckOpenTime()%></p>
			<br>
			<p id="truck_holiday">휴일 : <%=truck.getTruckHoliday() %></p>

		</div>
	</div>
</div>