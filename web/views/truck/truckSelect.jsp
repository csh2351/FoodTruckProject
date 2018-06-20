<%@page import="truck.vo.Truck"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
 <style>
     @media(max-width:1199px) {
        .truck_img_size{
          width: 110px;
          height: 160px;
        }
      }
      
       @media(max-width:768px) {
        .truck_img_size{
          width: 100%;
          height: 160px;
        }
          #select_sort{
        margin-left: 15px;
        }
      }
      
      
        @media(max-width:480px) {
        .truck_img_size{
          width: 100%;
          height: 160px;
        }
      }
</style> 
    
    
<% ArrayList<Truck> list=(ArrayList<Truck>)request.getAttribute("List");

%>
  
  <%//String saveDir=application.getRealPath("/uploadFiles/truck"); %>
 
  
  <section>
	<div class="container">
	<%if(list.size()!=0){%>
		<div class="row" id='row_padding'>
			<div class="col-md-12">
				<div class="form-group nav navbar-nav">
					<form name="sort_group" id="sort_group" action=	"#">
					<input type="hidden" name="sort_option" value="">
					<select name="selectSort" id="select_sort">
						<option value='basic' >기본</option>
						<option value='grade' >평점순</option>
						<option value='onOff'>영업순</option>
						<option value='review'>리뷰순</option>
					</select>
				</form>
				</div>
			</div>
		</div>
		
		<div class='row'>
		<ul id='store_ul' class='store_ul'>
		
		<% for(int i=0; i<list.size(); i++){%>
				<!--클릭리스너 만들기-->


                 <div class="more-list" style="display: none;"> 
				<li class='store-list' value=<%=list.get(i).getTruckPk() %>>
					<div class="col-sm-6 col-md-4 padding">
						<div class="thumbnail thumnail-botton">
							<div class="col-xs-12">
								<br>
							</div>

							<div class="col-xs-8" align="left">
								<span class='truck_name'><%=list.get(i).getTruckName()%></span>
							</div>
							<div class="col-xs-4">
								<!--고정값으로 할수있는 checkd찾기-->
								<div class="onoffswitch">
									<input type="checkbox" name="onoffswitch"
										class="onoffswitch-checkbox" id="myonoffswitch" <%=(list.get(i).getTruckStatus()).equals("t")?"CHECKED":""%>>
																								<!--checked  -->
									<label class="onoffswitch-label" for="myonoffswitch"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
									<!--클릭이벤트제거-->
								</div>
								<!--고정값으로 할수있는 checkd찾기-->
							</div>
							<div class="col-xs-5">
								<br> <img class="truck_img_size"src="images/truck/<%=list.get(i).getTruckRenameImage()%>"
									alt=""  width=130px; height=160px;>
									
							</div>
							
    
                    
							<div class="col-xs-7">
								<br>
								<p><%=list.get(i).getTrucklocation()%></p>
								<div class="ratings">
     								 <div class="empty-stars"></div>
      								 평점:<div class="full-stars" style="width:<%=list.get(i).getTruckStar()*20%>%"></div>
    						  </div>
								<p>최소금액: <%=list.get(i).getTruckPrice() %>원</p>
								<p>리뷰: <%=list .get(i).getReviewCount()%>개</p>
							</div>
							<div class='col-xs-4'></div>
							<div class='col-xs-4'></div>
							<div class='col-xs-4'></div>
							<!--지우지마셈 꺠짐-->
							
							<div>
								<a>&nbsp;</a>
							</div>
						</div>
					</div>
				</li>
				</div>
				<%} %>
				
			
				
				   <div class="row">
             <div class="col-xs-12 more-btn-positon">
				<br>
               <button id="load-list-button" class='btn btn-success more-btn' type="button">더보기</button>
             </div>
          </div>
          
          	<%}else{ %>
          <div class='container' style="height:200px;">
          <br><br>
          	<div class="text-center center-block" >
          		검색 결과가 없습니다.
          	</div>
          </div>
          <%} %>
        
<script>
	//on/off스위치
	$("#myonoffswitch").on('click', function(e) {
		e.preventDefault();
	})
	// 눌럿을떄 바로 이동
	$(".store-list").on('click', function(e) {
		
		var truck_no=$(this).val();
		console.log(truck_no);
		//location.href = "서블릿으로보내고?truck_pk="+truck_no;	
		location.href = "<%=request.getContextPath()%>/truckSelectOne?truckPk="+truck_no;	

	});
	
	 $(function(){
			$(".more-list").slice(0, 8).show(); // 최초 10개 선택
			$("#load-list-button").click(function(e){ // Load More를 위한 클릭 이벤트e
			e.preventDefault();
			$(".more-list:hidden").slice(0, 8).show(); // 숨김 설정된 다음 10개를 선택하여 표시
			
			/* if($(".more-menu:hidden").length == 0){ // 숨겨진 DIV가 있는지 체크
			alert("더 이상 항목이 없습니다"); // 더 이상 로드할 항목이 없는 경우 경고
			} */
			
			});
		});
</script>
		
		</ul>
		  
		
		</div>
</section>
			
    

<%@ include file="/views/common/footer.jsp" %>