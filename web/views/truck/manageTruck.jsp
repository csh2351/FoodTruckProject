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
								<form name="truckUpdateFrm" action="<%=request.getContextPath()%>/truckBasicUpdate" method="post">

									<div class="row">
										<div class="col-md-4">
											<div align="center">
												<input id="basic-input" type="text" name="truckName"
													placeholder="<%=truck.getTruckName()%>"
													class="form-control"> <input type="hidden"
													name="truckPk" value="<%=truck.getTruckPk()%>"
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
												name='truckOriginalImage'> <br> <br>
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
												id="basic-input" type="number" name="truckPrice" value=""
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
							<img id="truck-location"
								class="card-img-top img-responsive center-block"
								src="http://proxyprivat.com/images/noimage.jpeg"
								alt="Card image cap" width=300 height=300> <br> <br>
							<br> <br>
							<p>상세 위치 :</p>
							<br>
							<p>오픈시간 :</p>
							<br>
							<p>주요 동선 :</p>
							<br>
							<p>휴무일 :</p>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
<script src='js/bootstrap.js'></script>
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


<%@ include file="/views/common/footer.jsp"%>
