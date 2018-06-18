<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<%@ page import="truck.vo.Truck"%>

<%
	Truck truck = (Truck) request.getAttribute("truck");
%>
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
								<!-- 베이직단 폼 전송 -->
								<form name="truckBasicInsert" enctype="multipart/form-data"
									action="<%=request.getContextPath()%>/truckUpdate"
									method="post">
									<input type="hidden" value="<%=truck.getTruckPk()%>"
										name="truck-pk">
									<!--  트럭 pk 히든 input 으로 넣어줌 -->
									<div class="row">
										<div class="col-md-4">
											<div align="center">

												점포명 입력 : <input id="truck-name" type="text"
													name="truck-name" value="<%=truck.getTruckName()%>"
													placeholder="점포명" class="form-control">
												</p>
											</div>
											<!-- 점포명 입력 -->
											<br> <img id='truck-check-img'
													src="images/truck/<%=truck.getTruckOriginalImage()%>" alt="Card image cap"
												width=100% height=100> <br>
											<!--  기본 이미지 ( 트럭 이미지가 있을 경우 트럭 이미지 ) -->

											<div class=""></div>


											<input id='truck-input-img' type="file" value="사진등록"
												class="upload" accept="image/gif, image/jpeg, image/png"
												name='truck-img'>
											<!--  트럭 메인 사진 등록 -->
											<br> <br>
										</div>

										<div class="col-md-6">
											트럭 컨텐츠 입력 : <br>
											<textarea name="truck-content">
											<%=truck.getTruckContent()%>
											</textarea>
											</br>
											<!--  트럭 컨텐츠  -->
											<span class='truck-basic-font'>평점:<%=truck.getTruckStar()%></span>
											<!-- 평점은 star bar api 적용되면 그때 적용 -->

											s <br> <span class='truck-basic-font'>최소금액:&nbsp;</span><input
												id="basic-input" type="text" name="min-price"
												value="<%=truck.getTruckPrice()%>" placeholder="ex)2000원~"
												size="7" class="form-control"> <br> <br>
											<p class='truck-basic-font'>사업자정보</p>
											<span class='truck-basic-font'>상호명: <span
												class='truck-basic-font'><%=truck.getTruckInfoName()%></span></span>
											<br> <span class='truck-basic-font'>사업자등록번호: <span
												class='truck-basic-font'><%=truck.getTruckInfoRegisterNumber()%></span></span>

										</div>

										<div class="col-md-2" align="center">
											<br>
											<div class="onoffswitch">
												<input type="checkbox" name="onoffswitch"
													class="onoffswitch-checkbox" id="myonoffswitch" checked>
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
										<button class="btn btn-success basic-btn" type="submit">완료</button>
										<button class="btn btn-success basic-btn reset-button"
											type="reset">취소</button>
									</div>


								</form>
							</div>
						</div>
					</div>

					<br> <br>


					<div id="menurow" class="row">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<ul class="nav nav-pills nav-justified">
										<li role="presentation"><a>메뉴</a></li>
										<li role="presentation"><a>리뷰</a></li>
										<li role="presentation"><a>이벤트</a></li>
										<!--  아이디값 추가 필요 -->
									</ul>
								</div>
							</div>


							<div class="panel-body">
								<div class="page-header">
									<p style="font-size: 14pt; font-weight: bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
								</div>

								<ul id='comment-main'>
									<!--  reviewInsert.jsp로 이동 -->
									<li id="addr0">
										<!--  메뉴단 AJAX 삽입 -->
										<form action="#" method="post">
											<div clas="row">
												<div class="col-xs-9">
													<br>
													<div class="row">
														<div class="col-xs-12">
															<div class="form-group">
																<input name="menu-name" class="form-control" type="text"
																	placeholder="메뉴입력"> <br> <input
																	name="menu-price" class="form-control" type="text"
																	placeholder="가격입력">
															</div>
														</div>
													</div>
												</div>
												<div class="col-xs-3 col-md-3-body-center">
													<img id="menu-check-img0" class="menu-check-img"
														src="http://proxyprivat.com/images/noimage.jpeg"
														alt="Card image cap" width=100% height=100> <br>
													<button class="btn-success menu-img-replace">사진등록</button>
													<div class="test">
														<input id="menu-input-img0" type="file" value="사진등록"
															class="upload menu-input-img"
															accept="image/gif, image/jpeg, image/png" name="menu-img"
															onclick="view-img(this)">
													</div>


													<br>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-12 result-btn-positon">
													<button id="result-button"
														class="btn btn-success result-btn" type="submit">완료</button>
													<button id="menu-reset-btn0"
														class="btn btn-success result-btn" type="reset"
														onclick="reset-img(this)">취소</button>
													<hr>
												</div>
											</div>
										</form>
									</li>

								</ul>

								<div align="center">
									<button id="addBtn" type="button" class='btn' name="button">+</button>
									<button id="addBtnRemove" type="button" class='btn '
										name="button">-</button>

								</div>

							</div>

						</div>
					</div>

				</div>
			</div>
			<!--  디테일 단 폼작성 -->
			<form action="<%=request.getContextPath()%>/truckUpdate"
				enctype="multipart/form-data" name="truck-detail-insert"
				method="post">
				<input name="truck-pk" type="hidden" value="<%=truck.getTruckPk()%>">
				<input name="truck-name" type="hidden" value="detail"> <input
					id="truckLatitude" name="truck-latitude" type="hidden"
					value="<%=truck.getLatitude()%>"> <input id="truckLogitude"
					name="truck-logitude" type="hidden"
					value="<%=truck.getLogitude()%>">
				<!--  트럭 pk,name,위도 ,경도 히든 input 으로 넣어줌 -->
				<div class="col-md-4 col-md-offset-1">
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
							</div>
							<div class="panel-body">
								<div id="truck-location"
									style="height:300px; width:300px"></div>
								<br> <br><input type="button" onclick="findL()" value="test"><br> <br> 
								상세 위치 : <input
									type="button" class="btn btn-warning" onclick="Postcode()"
									value="주소찾기"> <input type="text" class="form-control"
									id="Address" placeholder="주소" value ="<%=truck.getTrucklocation() %>"
									required> <input type="text" class="form-control"
									id="AddressDetail" placeholder="상세주소"> <br>
								<br>
								<input type ="hidden" name = "truck-address" id ='truck-address' value ="<%=truck.getTrucklocation() %>">
								<p>
									오픈시간 : <input type="time" id="truck-open-date"
										name="truck-open-date"
										value=<%=request.getAttribute("openTime")%>>
								</p>
								<br>
								<p>
									마감시간 : <input type="time" id="truck-close-date"
										name="truck-close-date"
										value=<%=request.getAttribute("closeTime")%>>
								</p>
								<br>
								<p>
									휴무일 : <input type="text" id="truck-holiday"
										name="truck-holiday"
										value=<%=truck.getTruckHoliday() %>>
								</p>
								<div align="center">
									<br>
									<button class="btn btn-success basic-btn" type="submit"
										id="detailsubmit">완료</button>
									<button class="btn btn-success basic-btn reset-button"
										type="reset">취소</button>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</section>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
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
				});
	})

	

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
	})// 확인버튼 누르면 자동으로 위도,경도값 구함
</script>
<%@ include file="/views/common/footer.jsp"%>
