<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<%@ page import="truck.vo.Truck"%>
<% Truck truck = (Truck)request.getAttribute("truck"); %>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckMenu.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/manageTruck.css">

  <style>

  </style>
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
                  <form name="truckUpdateFrm" action="<%=request.getContextPath() %>/truckUpdate" method="post" enctype="multipart/form-data">

                    <div class="row">
                      <div class="col-md-4">
                        <div align="center">
                          <input id="basic-input" type="text" name="truckName" placeholder="<%=truck.getTruckName() %>" class="form-control">
                        </div>
                        <br>
                        <!-- <div class='col-md-3-body-center'> -->

                        <img id='truck-check-img' src="images/truck/<%=truck.getTruckRenameImage() %>" alt="Card image cap" width=100% height=100>
                        <br>

                        <div class="">

                        </div>
                        <button class="truck-img-replace">사진등록</button>
                        <input id='truck-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='truckOriginalImage'>
						
                        <br>
                        <br>
                      </div>

                      <div class="col-md-6">
						<p class='truck-basic-font'>주소:<%=truck.getTrucklocation() %></p>                        <span class='truck-basic-font'>평점:</span>
                      <div class="ratings">
      							<div class="empty-stars"></div>
      								<div class="full-stars" style="width:<%=truck.getTruckStar()*20%>%"></div>
    							</div>
                        <!--갯수를 입력받아야함.-->
                        <br>
                        <span class='truck-basic-font'>최소금액: <input id="basic-input" type="text" name="truckPrice" value="" placeholder="ex)2000원~" size="10" class="form-control"> </span>
                        <br>
                       <p class='truck-basic-font'>사업자정보 : <%=truck.getTruckInfoName() %></p>
                        <span class='truck-basic-font'>상호명: <%=truck.getTruckName() %></span>
                        <br><span class='truck-basic-font'>사업자등록번호: <%=truck.getTruckInfoRegisterNumber() %></span>

                      </div>
                      <!--ajax처리....-->


                      <div class="col-md-2" align="center">
                        <br>
                        <div class="onoffswitch" >
                          <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" <%=truck.getTruckStatus().equals("t")?"checked":"" %>>
                          <label class="onoffswitch-label" for="myonoffswitch" align="left">
                              <span class="onoffswitch-inner"></span>
                              <span class="onoffswitch-switch"></span>
                            </label>
                          <!--클릭이벤트제거-->
                        </div>
                      </div>
                      
					<script type="text/javascript">
						
						
						</script> 

                    </div>
                    <div align="center">
                      <br>
                      <button class="btn btn-success basic-btn" type="submit">완료</button>
                      <button class="btn btn-success basic-btn reset-button" type="reset">취소</button>
                    </div>
                </div>

                </form>
              </div>
            </div>

            <br>
            <br>


            <div class="row">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <div class="row">
                    <ul class="nav nav-pills nav-justified">
                      <li role="presentation"><a class='truck-panel-header' href="점포관리-메뉴.html">메뉴</a></li>
                      <li role="presentation"><a class='truck-panel-header' href="점포관리-리뷰.html">리뷰</a></li>
                      <li role="presentation"><a class='truck-panel-header' href="점포관리-이벤트.html">이벤트</a></li>
                      <li role="presentation"><a class='truck-panel-header' href="점포관리-관리자문의.html">관리자문의</a></li>
                    </ul>
                  </div>
                </div>


                <div class="panel-body">
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
                  </div>

                  <ul id='comment-main'>
                    <li id="addr0">
                      <form action="#" method="get">
                        <div clas="row">
                          <div class="col-xs-9"><br>
                            <div class="row">
                              <div class="col-xs-12">
                                <div class="form-group"><input name="menu-name" class="form-control" type="text" placeholder="메뉴입력"><br><input name="menu-price" class="form-control" type="text" placeholder="가격입력"></div>
                              </div>
                            </div>
                          </div>
                          <div class="col-xs-3 col-md-3-body-center"><img id="menu-check-img0" class="menu-check-img" src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br><button class="btn-success menu-img-replace">사진등록</button>
                            <div class="test"><input id="menu-input-img0" type="file" value="사진등록" class="upload menu-input-img" accept="image/gif, image/jpeg, image/png" name="menu-img" onclick="view_img(this)"></div>


                            <br>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-xs-12 result-btn-positon"><button id="result-button" class="btn btn-success result-btn" type="submit">완료</button>
                            <button id="menu-reset-btn0" class="btn btn-success result-btn" type="reset" onclick="reset_img(this)">취소</button>
                            <hr>
                          </div>
                        </div>
                      </form>
                    </li>

                  </ul>

                  <div align="center">
                    <button id="addBtn" type="button" class='btn' name "button">+</button>
                    <button id="addBtnRemove" type="button" class='btn ' name="button">-</button>

                  </div>

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
                <img id="truck-location" class="card-img-top img-responsive center-block" src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=300 height=300>
                <br>
                <br>
                <br>
                <br>
                <p>상세 위치 : </p>
                <br>
                <p>오픈시간 : </p>
                <br>
                <p>주요 동선 : </p>
                <br>
                <p>휴무일 : </p>

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
  // 스위치토글
/*   $(document).ready(function() {
    var onoffswitch = $("#myonoffswitch");
    onoffswitch.click(function() {
      if (onoffswitch.is(":checked")) {
        onoffswitch.val("on")
        console.log(onoffswitch.val());
      } else {
        onoffswitch.val("off")
        console.log(onoffswitch.val());

      }
    })
  }); */
  // 스위치토글
  
  	$("#myonoffswitch").on("click", function() {
  	    var onoffswitch = $("#myonoffswitch");
  	    
  		if(onoffswitch.is(":checked")) {
	        onoffswitch.val("t")
	        console.log(onoffswitch.val());
	      } else {
	        onoffswitch.val("f")
	        console.log(onoffswitch.val());
	      }
  		
  		var value=onoffswitch.val();

		$.ajax({
			url:"<%=request.getContextPath()%>/truckOnOff",
			type:"POST",
			data:{onoffswitch:value},
			success : function(data){
					alert("영업시작");
			},
			error : function(request,status,error) {
					alert("code:"+request.status+"\n"+ "message:"+request.responseText
							+"\n"+"error:"+error); }
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
    $("#reset-button").click(function() {
      $('#truck-check-img').attr('src', "http://proxyprivat.com/images/noimage.jpeg");
    })
  })



  //메뉴 사진 미리보기 스크립트.

  function view_img(input) {

    var id = $(input).attr('id');
    var idIndex = id.charAt(id.length - 1);
    var checkimg = "menu-check-img" + idIndex;

    var menu_check_img = document.getElementById(checkimg); //menu_check_img
    var menu_input_img = document.getElementById(id); //menu_input_img

    console.log(menu_check_img);
    console.log(menu_input_img);
    console.log(menu_input_img.files);
    //여기도 잘찍힘.ㅎㅎ

    $(menu_input_img).on('change', function() {
      console.log(this.files);
      readURL_menu_img(this, menu_check_img);
      console.log(this);
    });
  }

  function readURL_menu_img(input, menu_check_img) {
    console.log(menu_check_img);
    if (input.files && input.files[0]) {
      var reader = new FileReader();

      reader.onload = function(e) {
        menu_check_img.setAttribute('src', e.target.result);
      }

      reader.readAsDataURL(input.files[0]);
    }
  }
  //메뉴 사진 미리보기 스크립트.




  function reset_img(reset_btn) {

    var id = $(reset_btn).attr('id');
    var idIndex = id.charAt(id.length - 1);
    var checkimg = "menu-check-img" + idIndex;

    var menu_check_img = document.getElementById(checkimg); //menu_check_img
    var reset_btn = document.getElementById(id); //menu_input_img


    console.log(menu_check_img);
    console.log(reset_btn);



    menu_check_img.setAttribute("src", "http://proxyprivat.com/images/noimage.jpeg");

  }


  //메뉴 사진 미리보기 스크립트.




  //누르면추가
  $(function() {
    var i = 0;
    var list;
    $("#addBtn").click(function() {
      list = $('<li id=' + "addr" + (i + 1) +
        '><form action="#" method="get"><div clas="row"><div class="col-xs-9"><br><div class="row"><div class="col-xs-12"><div class="form-group"><input name="menu-name"class="form-control" type="text" placeholder="메뉴입력"><br><input name="menu-price" class="form-control" type="text" placeholder="가격입력"></div></div></div></div><div class="col-xs-3 col-md-3-body-center"><img id=' +
        "menu-check-img" + (i + 1) + ' class="menu-check-img" src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br><button class="btn-success menu-img-replace">사진등록</button><div class="test"><input id=' +
        "menu-input-img" + (i + 1) +
        ' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name="menu-img" onclick="view_img(this)"></div></div></div><div class="row"><div class="col-xs-12 result-btn-positon"><button id="result-button" class="btn btn-success result-btn" type="submit">완료</button> <button id=' +
        "menu-reset-btn" + (i + 1) +
        ' class="btn btn-success result-btn" type="reset" onclick="reset_img(this)">취소</button><hr></div></div></form></li>'
      );
      $('#comment-main').append(list);
      i++;
    });

    $('#addBtnRemove').click(function() {
      $("#addr" + (i)).remove();
      i--;
    })

  });
  //누르면추가
</script>


<%@ include file="/views/common/footer.jsp"%>
  