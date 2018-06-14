<%@page import="truck.vo.Truck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<%Truck truck=(Truck)request.getAttribute("truck");
	String star="";%>
  <div class='panel panel-default'>
                <div class='panel-heading'>
                  <h3 class='panel-title truck-panel-header'>기본정보</h3>
                </div>
                <div class='panel-body pannel-basic'>
                  <div class="row">
                    <div class="col-md-4 panel-1">
                      <p id='truck-title-p'>점포명:<%=truck.getTruckName() %></p>
                      <a href="#" data-toggle="modal" data-target=".pop-up-1"><img class='trcuk-img img-responsive center-block' src="images/truck/<%=truck.getTruckOriginalImage()%>" alt="" width="200" height="200"></a>
                      <br>
                      <br>
                    </div>

                    <!--모달 틀-->
                    <div class="modal fade pop-up-1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
                          </div>
                          <div class="modal-body">
                            <img src="images/truck/<%=truck.getTruckOriginalImage()%>" class="img-responsive img-rounded center-block" alt="" width="800" height="800">
                          </div>
                        </div>
                        <!-- /.modal-content -->
                      </div>
                      <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal mixer image -->

                    <div class="col-md-6">
                      <p class='truck-basic-font'>주소: <%=truck.getTrucklocation() %></p>
                     
                      <span class='truck-basic-font'>평점 : <%=star%> </span>
                      
                      <br>
                      <span class='truck-basic-font'>최소금액: <%=truck.getTruckPrice() %></span>
                      <br><br><br>
                      <p class='truck-basic-font'>사업자정보 : <%=truck.getTruckInfoName() %></p>
                      <span class='truck-basic-font'>상호명: <%=truck.getTruckName() %></span>
                      <br>
                      <span class='truck-basic-font'>사업자등록번호: <%=truck.getTruckInfoRegisterNumber() %></span>

                    </div>

                    <div class="col-md-2" align="center">
                      <br>
                      <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" <%=truck.getTruckStatus().equals("t")?"checked":"" %>>
                        <label class="onoffswitch-label" for="myonoffswitch" align="left">
                              <span class="onoffswitch-inner"></span>
                              <span class="onoffswitch-switch"></span>
                            </label>
                        <!--클릭이벤트제거-->
                      </div>
                    </div>

                  </div>
                </div>
             </div>
             <script type="text/javascript">
             $("#myonoffswitch").on('click', function(e) {
            	    e.preventDefault();
            	  });

             </script>
          
             
            