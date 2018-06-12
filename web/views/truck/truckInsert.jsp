<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="views/common/header.jsp" %>
<%@ page import = "truck.vo.Truck" %>
<% Truck truck = (Truck)request.getParameter("truck") %>
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
                  <form name="truckBasicInsert" action="<%=request.getContextPath()%>/truckBasicInsert" method="post">
						<input type ="hidden" value="<%=truck.getTruckPk()%>">
						<!--  트럭 pk 히든 input 으로 넣어줌 -->
                    <div class="row">
                      <div class="col-md-4">
                        <div align="center">
                        	<p>점포명  : <%=truck.getTruckName() %></p>
                          <p>점포명 입력 : <input id="truck_name" type="text" name="truck_name" value="" placeholder="점포명" class="form-control"></p>
                        </div><!-- 점포명 입력 -->
                        <br>
                        

                        <img id='truck_check_img' src=<%=truck.getTruckOriginalImage()%> alt="Card image cap" width=100% height=100>
                        <br><!--  기본 이미지 ( 트럭 이미지가 있을 경우 트럭 이미지 ) -->

                        <div class="">

                        </div>
                        <button class="truck-img-replace">사진등록</button>
                        <input id='truck_img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='truck_img'>
						<!--  트럭 메인 사진 등록 -->
                        <br>
                        <br>
                      </div>

                      <div class="col-md-6">
                        <input id ="truck_contnet" placeholder="트럭 내용(설명) 입력" type="text" name='truck_content'>
                        <!--  트럭 컨텐츠 입력 현재 출력창 없음 -->
                        <span class='truck-basic-font'>평점:<%=truck.getTruckStar()%></span>
                        <!-- 평점은 star bar api 적용되면 그때 적용 -->
                       
                        
                        <br>
                        <span class='truck-basic-font'>최소금액:&nbsp;</span><input id="basic-input" type="text" name="min_price" value="" placeholder="ex)2000원~" size="10" class="form-control">
                        <br><br>
                        <p class='truck-basic-font'>사업자정보</p>
                        <span class='truck-basic-font'>상호명: <span class='truck-basic-font'><%=truck.getTruckInfoName() %></span></span>
                        <br>
                        <span class='truck-basic-font'>사업자등록번호: <span class='truck-basic-font'><%=truck.getTruckInfoRegisterNumber() %></span></span>

                      </div>

                      <div class="col-md-2" align="center">
                        <br>
                        <div class="onoffswitch" >
                          <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
                          <label class="onoffswitch-label" for="myonoffswitch" align="left">
                              <span class="onoffswitch-inner"></span>
                              <span class="onoffswitch-switch"></span>
                            </label>
                          <!--클릭이벤트제거-->
                        </div>
                      </div>

                    </div>
                    <div align="center">
                      <br>
                      <button class="btn btn-success basic-btn" type="submit">완료</button>
                      <button class="btn btn-success basic-btn reset-button" type="reset">취소</button>
                    </div>
                

                </form>
                </div>
              </div>
            </div>

            <br>
            <br>


            <div id= "menurow" class="row">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <div class="row">
                    <ul class="nav nav-pills nav-justified">
                      <li role="presentation"><a>메뉴</a></li>
                      <li role="presentation"><a>리뷰</a></li>
                      <li role="presentation"><a>이벤트</a></li>
                      <li role="presentation"><a>관리자문의</a></li>
                      <!--  아이디값 추가 필요 -->
                    </ul>
                  </div>
                </div>


                <div class="panel-body">
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
                  </div>

                  <ul id='comment-main'><!--  reviewInsert.jsp로 이동 -->
                    <li id="addr0">
                      <form action="#" method="post">
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
                    <button id="addBtn" type="button" class='btn' name="button">+</button>
                    <button id="addBtnRemove" type="button" class='btn ' name="button">-</button>

                  </div>

                </div>

              </div>
            </div>

          </div>
        </div>

	<form action="<%=request.getContextPath()%>/truckDetailInsert" name="truck_detail_insert" method="post">
		<input type ="hidden" value="<%=truck.getTruckPk()%>">
						<!--  트럭 pk 히든 input 으로 넣어줌 -->
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
                <p>상세 위치 :               
             		    <input id ="truck_address" placeholder="주소 입력" name="truck_address">
                        <button >주소찾기</button>
                         <!--  주소찾기 api  -->
                </p>
                <br>
                <p>오픈시간 : 
                <input type ="time" id="truck_open_date" name="truck_open_date"> 
                </p>
                <br>
                <p>휴무일 : 
                <input type ="text" id="truck_holiday" name="truck_holiday">
                </p>

              </div>
            </div>
          </div>
        </div>
         </form>
         </div>
    </div>
 
  </section>
	
<%@ include file="views/common/footer.jsp" %>
