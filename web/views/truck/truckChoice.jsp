<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="truck.vo.TruckMenu"%>
<%@page import="truck.vo.Truck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
<%Truck truck=(Truck)request.getAttribute("truck");%>
<%String serlvet=(String)request.getAttribute("truckChoice"); %>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckMenu.css">
  
 

<script type="text/javascript">

$(function() {
	$.ajax({		
		url:"<%=request.getContextPath()%>/truckDetail",
		data:{truckPk:<%=truck.getTruckPk()%>},	//쏴주기 
		// truck_Pk 에서  truckPk로 통일
		type : "get", 
		success: function(data) {
			$("#truckDetail").html(data);
		},
		error : function(request,status,error) { 
			alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
			}
		
	});
})

$(function() {
	$.ajax({
		url:"<%=request.getContextPath()%>/truckBasic",
		data:{truckPk:<%=truck.getTruckPk()%>},	//쏴주기
		type : "post", 
		success: function(data) {
			$("#truckBasic").html(data);
		},
		error : function(request,status,error) { 
			alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
			}
	});
})


	$(function() {
	$.ajax({
			url:"<%=request.getContextPath()%>/<%=serlvet%>",
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

   	<br>
  <section>
    <div class="container" >

      <div class='row'>
        <div class="col-md-7 ">
          <div class="panel-group">

            <div id="truckBasic" class='row'>
         		<!--truckBasic.jsp ajax-->
            </div>

            <br>
            <br>

            <div class="row">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <div class="row">
                    <ul class="nav nav-pills nav-justified">
                      <li role="presentation"><a id="choiceMenu"  class='truck-panel-header' >메뉴</a></li>
                      <li role="presentation"><a id="choiceReview"class='truck-panel-header'>리뷰</a></li>
                      <li role="presentation"><a id="choiceEvent" class='truck-panel-header'>이벤트</a></li>
                    </ul>
                  </div>
                </div>
                <script type="text/javascript">
                
                $("#choiceMenu").on("click", function() {
					$.ajax({
						url:"<%=request.getContextPath()%>/truckChoiceMenu",
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
				
				
                $("#choiceReview").on("click", function() {
						$.ajax({
							url:"<%=request.getContextPath()%>/truckChoiceReview",
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
  
  	<%@ include file="/views/common/footer.jsp" %>
  