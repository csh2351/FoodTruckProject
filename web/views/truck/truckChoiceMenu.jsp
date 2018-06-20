<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="truck.vo.TruckMenu"%>
<%@page import="truck.vo.Truck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%ArrayList<TruckMenu>menuList=(ArrayList<TruckMenu>)request.getAttribute("menuList");%>	
	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/foodTruckMenu.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckReview.css">
<link rel="stylesheet"  href="<%=request.getContextPath() %>/css/bootstrap.min.css">


  						
 
			<div class="page-header">
					<p style="font-size: 14pt; font-weight: bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
			</div>
                  <ul class='menu-ul-main'>

                    <!--메뉴시작-->
                    <%for(int i=0; i<menuList.size(); i++){ %>
                 <div class="more-menu" style="display: none;"> 
                    <li>
                      <div class="row">
                      <div class="col-xs-1" ></div>
                        <div class="col-xs-5  col-xs-7-pading">
                          <ul class='menu-ul'>
                            <div class="menuName">
                              <br>
                              <span class='panel-2-body-font'>메뉴명 : <%=menuList.get(i).getMenuName() %></span>
                              <br>
                              <br>
                              <span class='panel-2-body-font'>가격 : <%=menuList.get(i).getMenuPrice() %> </span>
                            </div>
                          </ul>
                        </div>
                        <div class="col-xs-6" align="center">
                          <a href="#" id="menu-modal" data-toggle="modal" data-target=".pop-up-2" >
                                <br>
                                <%if(menuList.get(i).getMenuRimage()!=null){ %>
                                <img src="images/truckMenu/<%=menuList.get(i).getMenuRimage()%>" alt="" width=150 height=100 onclick="fn_modal_menu('images/truckMenu/<%=menuList.get(i).getMenuRimage()%>');"></a>
	                          <%} %>
                        </div>
                        
                      </div>
                      <hr>
                    </li>
                  </div>
      <%} %>
      
      <%if(!menuList.isEmpty()){%>
          <div class="row">
             <div class="col-xs-12 more-btn-positon">
				<br>
               <button id="load-menu-button" class='btn btn-success ' type="button">더보기</button>
             </div>
          </div>
	<%} %>
	<!-- test Modal -->
	
	
	
<!-- <div class="modal fade pop-up-2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
       	<h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
          <span aria-hidden="true">&times;</span>
      </div>
      <div class="modal-body">
        <img id="modal-menu-img"class="img-responsive img-rounded center-block" src="" alt="" width="800" height="800">
      </div>
     
    </div>
  </div>
</div> 
 -->
                      
	<!--모달 틀-->
        <div   class="modal fade pop-up-2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true" data-backdrop="false">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
              </div>
              <div class="modal-body">
                 <img id="modal-menu-img"class="img-responsive img-rounded center-block" alt="" width="500" height="500">
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal mixer image -->
     
                    
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>

    






        <div id="truckDetail" class="col-md-4 col-md-offset-1">
      		<!--ajax-->
        </div>
      </div>
    </div>
  </section>
  
     <script type="text/javascript">
			 function fn_modal_menu(rimage) {
				console.log(rimage);
				$("#modal-menu-img").attr("src",rimage);
			}
			 
			 $(function(){
					$(".more-menu").slice(0, 5).show(); // 최초 10개 선택
					$("#load-menu-button").click(function(e){ // Load More를 위한 클릭 이벤트e
					e.preventDefault();
					$(".more-menu:hidden").slice(0, 5).show(); // 숨김 설정된 다음 10개를 선택하여 표시
					
					/* if($(".more-menu:hidden").length == 0){ // 숨겨진 DIV가 있는지 체크
					alert("더 이상 항목이 없습니다"); // 더 이상 로드할 항목이 없는 경우 경고
					} */
					
					});
				});
			 
			 /* $('#menu-modal').on('click',function(){
				 $('.modal').addClass('show');
			 });
			 $(".modal").on("hidden.bs.modal", function () {
				    // put your default event here
				}); */
		</script>
  
	

  
  