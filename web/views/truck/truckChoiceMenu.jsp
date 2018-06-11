<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="truck.vo.TruckMenu"%>
<%@page import="truck.vo.Truck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%ArrayList<TruckMenu>menuList=(ArrayList<TruckMenu>)request.getAttribute("menuList");%>	
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckMenu.css">
  
 

                  <ul class='menu-ul-main'>

                    <!--메뉴시작-->
                    <%for(int i=0; i<menuList.size(); i++){ %>
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
                          <a id="menu-modal" href="javascript:fn_modal('<%= menuList.get(i).getMenuImage()%>');" data-toggle="modal" data-target=".pop-up-2" >
                            
                                <br>
                                <img src="images/truckMenu/<%=menuList.get(i).getMenuImage()%>" alt="" width=120 height=100></a>
                        </div>
                        
                      </div>
                      <hr>
                    </li>
      <%} %>
                    <!--메뉴종료-->
                        <!--모달 틀-->
        <div  class="modal fade pop-up-2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
              </div>
              <div class="modal-body">
                 <img id="modal-img" src="" class="img-responsive img-rounded center-block" alt="" width="800" height="800">
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
  
  
	 	function fn_modal(oriName) {
	 		oName=encodeURIComponent(oriName);
	 		//console.log(oName);
	  		var menu_modal=$("#modal-img");	
	  		menu_modal.attr("src","/images/truckMenu/"+oriName);
	  		console.log("src","/images/truckMenu/"+oriName); 
		}
 
</script>
  
  