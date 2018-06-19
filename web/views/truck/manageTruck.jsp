<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<%@ page import="truck.vo.Truck"%>
<%
	Truck truck = (Truck) request.getAttribute("truck");
%>
<%String serlvet=(String)request.getAttribute("truckChoice"); %>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/foodTruckMenu.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/manageTruck.css">

<script type="text/javascript">
$(function() {
		$.ajax({
		url:"<%=request.getContextPath()%>/<%=serlvet%>",
		data:{truckPk :<%=truck.getTruckPk()%>},
		type : "POST",
		success : function(data){ 
		$("#choice-body").html(data);
		}, 
		error : function(request,status,error) { 
		alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
		}
})
})
	

</script>


  
<br>
<section>
	<div class="container">

		<div class='row'>
			<div class="col-md-7 ">
				<div class="panel-group">

					<div class='row'>
						<div class='panel panel-default'>
							<div class='panel-heading'>
								<h3 class='panel-title truck-panel-header'>기본정보</h3>
							</div>
							<div class='panel-body pannel-basic'>
								<form name="truckBasicInsert" action="<%=request.getContextPath()%>/truckUpdate" method="post" enctype="multipart/form-data">
									<input type="hidden" value="<%=truck.getTruckPk()%>"name="truck-pk">
									<div class="row">
										<div class="col-md-4">
											<div align="center">
												<input id="basic-input" type="text" name="truck-name"
													placeholder="<%=truck.getTruckName()%>"
													class="form-control">

											</div>
											<br>
											<!-- <div class='col-md-3-body-center'> -->

											<img id='truck-check-img'
												src="images/truck/<%=truck.getTruckRenameImage()%>"
												alt="Card image cap" width=100% height=100> <br>

											<div class=""></div>
											<button class="truck-img-replace">사진등록</button>
											<input id='truck-input-img' type="file" value="사진등록"
												class="upload" accept="image/gif, image/jpeg, image/png"
												name='truck-img'> <br> <br>
										</div>

										<div class="col-md-6">
											<p class='truck-basic-font'>
												주소:<%=truck.getTrucklocation()%></p>
											<span class='truck-basic-font'>평점:</span>
											<div class="ratings">
												<div class="empty-stars"></div>
												<div class="full-stars"
													style="width:<%=truck.getTruckStar() * 20%>%"></div>
											</div>
											<!--갯수를 입력받아야함.-->
											<br> <span class='truck-basic-font'>최소금액: <input
												id="basic-input" type="number" name="min-price" value=""
												placeholder="ex)2000원~" size="10" class="form-control">
											</span> <br>
											<p class='truck-basic-font'>
												사업자정보 :
												<%=truck.getTruckInfoName()%></p>
											<span class='truck-basic-font'>상호명: <%=truck.getTruckName()%></span>
											<br>
											<span class='truck-basic-font'>사업자등록번호: <%=truck.getTruckInfoRegisterNumber()%></span>

										</div>
										<!--ajax처리....-->


										<div class="col-md-2" align="center">
											<br>
											<div class="onoffswitch">
												<input type="checkbox" name="onoffswitch"
													class="onoffswitch-checkbox" id="myonoffswitch"
													<%=truck.getTruckStatus().equals("t") ? "checked" : ""%>>
												<label class="onoffswitch-label" for="myonoffswitch"
													align="left"> <span class="onoffswitch-inner"></span>
													<span class="onoffswitch-switch"></span>
												</label>
												<!--클릭이벤트제거-->
											</div>
										</div>

									</div>
									<div align="center">
										<br>
										<button id="basic-submit" class="btn btn-success basic-btn"
											type="submit">완료</button>
										<button class="btn btn-success basic-btn reset-button"
											type="reset">취소</button>
									</div>
							</div>
							</form>
						</div>
					</div>
					<br> <br>
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<ul class="nav nav-pills nav-justified">
										<li role="presentation"><a id="choiceUpdateMenu" class='truck-panel-header'>메뉴</a></li>
										<li role="presentation"><a id="choiceUpdateReview" class='truck-panel-header'>리뷰(<%=truck.getReviewCount()%>개)</a></li>
										<li role="presentation"><a id="choiceEvent" class='truck-panel-header'>이벤트</a></li>
									</ul>
								</div>
							</div>
							
							<script type="text/javascript">

							   $("#choiceUpdateMenu").on("click", function() {
									$.ajax({
										url:"<%=request.getContextPath()%>/truckMenuUpdate",
										type : "POST",
										data:{truckPk :<%=truck.getTruckPk()%>},
										success : function(data){ 
											$("#choice-body").html(data);
										}, 
										error : function(request,status,error) { 
											alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
										}
									})
								})
								
								
				                $("#choiceUpdateReview").on("click", function() {
										$.ajax({
											url:"<%=request.getContextPath()%>/truckReviewComment",
											type : "POST",
											data:{truckPk :<%=truck.getTruckPk()%>},
											success : function(data){ 
												$("#choice-body").html(data);
											}, 
											error : function(request,status,error) { 
												alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
											}
										})
									})
									
									$("#choiceEvent").on("click", function() {
										$.ajax({
											url:"<%=request.getContextPath()%>/truckChoiceEvent",
											type : "POST",
											data:{truckPk :<%=truck.getTruckPk()%>},
											success : function(data){ 
												$("#choice-body").html(data);
											}, 
											error : function(request,status,error) { 
												alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
											}
										})
									})
							
							</script>

							<div id="choice-body" class="panel-body">
						
							</div>

						</div>
					</div>

				</div>
			</div>


			<div class="col-md-4 col-md-offset-1">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
						</div>
						<div class="panel-body">
						<form action="<%=request.getContextPath()%>/truckUpdate" enctype="multipart/form-data" name="truck-detail-insert" method="post">
				<input name="truck-pk" type="hidden" value="<%=truck.getTruckPk()%>">
				<input name="truck-name" type="hidden" value="detail">
				<input id="truckLatitude" name="truck-latitude" type="hidden" value="<%=truck.getLatitude()%>"> <input id="truckLogitude" name="truck-logitude" type="hidden" value="<%=truck.getLogitude()%>">
						
						<!--크기...최선..-->
						<div align="center">
						<div id="truck-location">
						</div>
						</div>
								<!-- 주소 입력 위치 확인 -->
								<br>
								
								<input type="button" class='btn btn-warning	'onclick="findCurrentLocation()" value="현재 위치 확인">
								<br>
								<br> 직접입력:&nbsp;<input type="button" class="btn btn-warning" onclick="Postcode()" value="주소찾기" >
									<input type="button" class="btn btn-info" onclick="findL()"value="확인" style="display:inline-block;">
									<br><br>    
									<input type="text" class="form-control" id="Address" placeholder="주소" value="<%=truck.getTrucklocation() %>" required> 
									<input type="text" class="form-control" id="AddressDetail" placeholder="상세주소"><br> 
									<input type="hidden" name="truck-address" id='truck-address' value="<%=truck.getTrucklocation() %>">
								<p>
									오픈시간 : <input type="time" id="truck-open-date" class="form-control" name="truck-open-date" style="display:inline-block;" value=<%=request.getAttribute("openTime")%> required>
								</p>
								<br>
								<p>
									마감시간 : <input type="time" id="truck-close-date" class="form-control" name="truck-close-date" style="display:inline-block;" value=<%=request.getAttribute("closeTime")%> required>
								</p>
								<br>
								<p>
									휴무일 : <input type="text" id="truck-holiday" class="form-control" name="truck-holiday" style="display:inline-block;" value=<%=truck.getTruckHoliday() %> required>
								</p>
								<div align="center">
									<br>
									<button class="btn btn-success basic-btn" type="submit"
										id="detailsubmit">완료</button>
									<button class="btn btn-success basic-btn reset-button"
										type="reset">취소</button>
								</div>

						</form>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
  //영업,종료 ajax
  	$("#myonoffswitch").on("click", function() {
  	    var onoffswitch = $("#myonoffswitch");
  	    
  		if(onoffswitch.is(":checked")) {
	        onoffswitch.val("t")
	        console.log(onoffswitch.val());
	      } else {
	        onoffswitch.val("f")
	        console.log(onoffswitch.val());
	      }

		$.ajax({
			url:"<%=request.getContextPath()%>/truckOnOff",
					type : "POST",
					data : {onoffswitch : onoffswitch.val(), truckPk : <%=truck.getTruckPk()%>},
					success : function(data) {
						alert(data.truckStatus);
					},
					error : function(request, status, error) {
						alert("code:" + request.status + "\n" + "message:"
								+ request.responseText + "\n" + "error:"
								+ error);
					}
				})

			})

	//트럭 사진 미리보기 스크립트.

	$(function() {
		$("#truck-input-img").on('change', function() {
			console.log(this.files);
			readURL_truck_img(this);
			console.log(this);
		});
	});

	function readURL_truck_img(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#truck-check-img').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$(function() {
		$("#reset-button").click(
				function() {
					$('#truck-check-img').attr('src',
							"http://proxyprivat.com/images/noimage.jpeg");
				})
	})
	
</script>
<script>
// 구글 맵 부분
	// 현재 위치 확인
function findCurrentLocation(){
		var latitude = 0;
		var longitude = 0;
		var mapOptions = {
				zoom : 17
			};
		var map = new google.maps.Map(document.getElementById('truck-location'),
				mapOptions);
		//map div에 구글 맵을 붙여쥼
		var contentString = '<div id="content">'+
	      '푸드트럭 : <%=truck.getTruckName()%>'+
	      '</div>'+
	      '<div id="content">' +
	      '상세 설명 : <%=truck.getTruckContent()%>'+
	      '</div>';
		var geocoder = new google.maps.Geocoder;
		var infowindow = new google.maps.InfoWindow({
			content: contentString
		});
		var address = document.getElementById("truck-address").value;
		// 기본 세팅
		
		// 현재 위치 확인하는 위도와 경도를 구하는 시작점
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function updateLocation(position) {

          latitude = position.coords.latitude;
          longitude = position.coords.longitude;
          accuracy = position.coords.accuracy;
          // 위도 경도 정확도 불러옴
          map.setCenter(new google.maps.LatLng(latitude, longitude));
          // 가져온 위치를 기반으로 map의 center부분 set
         //히든 인풋값에 위도,경도 추가해줌
			document.getElementById("truckLatitude").value = latitude;
			document.getElementById("truckLogitude").value = longitude;
		      // 현재 위치의 주소 구함
			  var latlngStr = latitude + "," + longitude;
		      var latlng = {
		        lat: latitude,
		        lng: longitude
		      };
		      console.log(latlng);
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
		            
		            document.getElementById("Address").value = results[1].formatted_address;
		            document.getElementById("truck-address").value = results[1].formatted_address;
		            // 찾은 주소경로 value 에 입력
		            infowindow.open(map, marker);
		          }
		        } else {
		          window.alert('No results found');
		          window.alert('Geocoder failed due to: ' + status);
		        } //  오류표시
		      });

        }, function handlerLocationError(error) {
          alert(error.code);
        });
      } 
      }

	// 주소값으로 위도 경도 구하기
	function findL() {
		var latitude = null;
		var longitude = null;
		var mapOptions = {
				zoom : 17
			};
		var map = new google.maps.Map(document.getElementById('truck-location'),
				mapOptions);
		//map div에 구글 맵을 붙여쥼
		var contentString = '<div id="content">'+
	      '푸드트럭 : <%=truck.getTruckName()%>'+
	      '</div>'+
	      '<div id="content">' +
	      '상세 설명 : <%=truck.getTruckContent()%>'+
	      '</div>';
		var geocoder = new google.maps.Geocoder;
		var infowindow = new google.maps.InfoWindow({
			content: contentString
		});
		var marker = null;
		var address = document.getElementById("truck-address").value;
		var LatLng ="";
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				marker = new google.maps.Marker({
					map : map,
					// icon: image, // 마커로 사용할 이미지(변수)
					title :'<%=truck.getTruckName()%>',
	// 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
					position : results[0].geometry.location
				});
				LatLng = ""+ results[0].geometry.location;
			}
			infowindow.open(map, marker); // 마커에 정보표시

			  var latitude = LatLng.substring(1,LatLng.indexOf(','));
			  var longitude = LatLng.substring(LatLng.indexOf(',')+2,LatLng.indexOf(')'));
		
			//히든 인풋값에 위도,경도 추가해줌
			document.getElementById("truckLatitude").value = latitude;
			document.getElementById("truckLogitude").value = longitude;
			// if 문 마무리
		}); // 주소값 마커 찍어주기
	}

	
	//주소찾기 스크립트
	function Postcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수
						var address ='';// 전송되는 변수
						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;
							address=fullAddr;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
							address=fullAddr;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.

						document.getElementById('Address').value = fullAddr;
						document.getElementById('truck-address').value = address;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('AddressDetail').focus();
					}
				}).open();
	}
	$(function() {
		$('#detailsubmit').on('click', function() {
			findL();
		});
	})
	// 확인버튼 누르면 자동으로 위도,경도값 구함
</script>


<%@ include file="/views/common/footer.jsp"%>
