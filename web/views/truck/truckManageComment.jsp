<%@page import="truck.vo.Truck"%>
<%@page import="member.model.vo.Member"%>
<%@page import="truck.vo.TruckReviewComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/foodTruckReview.css">
<script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>

<%List<TruckReviewComment> reviewList=(ArrayList<TruckReviewComment>)request.getAttribute("reviewList");%>
<%Truck truck=(Truck)(request.getAttribute("truck"));%>
<%Member member=(Member)(request.getAttribute("member"));%>

<!--중복되서-->
<style>
ul#comment-main button.btn-reply {
	display: none;
}

ul#comment-main button.btn-delete {
	display: none;
}

ul#comment-main li:hover button.btn-reply {
	display: inline;
}

ul#comment-main li:hover button.btn-delete {
	display: inline;
}
</style>

<div class="page-header">
	<p style="font-size: 14pt; font-weight: bold;">&nbsp;&nbsp;&nbsp;리뷰</p>
</div>

<%for(int i=0; i<reviewList.size(); i++){ %>
<%if(reviewList.get(i).getReviewCommentLevel()==1){ %>
<ul id='comment-main' class='level1'>
	<li id='review-view<%=i%>' class='comment-reply level1'>
		<!--댓글보기-->
		<div class='row'>
			<div class="col-xs-8">
				<div class="row">
					<div class="col-md-6 ">
						<span class='panel-2-body-font'>아이디: <%=reviewList.get(i).getReviewCommnetWriter()%></span>
						<!--아이디부여-->
					</div>
					<div class="col-md-6 date-padding">
						<span class='panel-2-body-font'>작성일:<%=reviewList.get(i).getReivewCommentDate()%></span><br>
						<!--date 부여 -->
					</div>
				</div>
				<span class="rating"> <label> <span class="icon">평점:
							<%=reviewList.get(i).getReviewStar()%></span>

				</label>
				</span>
				
				
					</div>
			<div class='col-xs-4 col-md-3-body-center'>
			</div>
			 <%if(reviewList.get(i).getReviewCommentRimage()!=null){ %>
			 	<div class="col-xs-12">
			<a id="menu-modal" data-toggle="modal" data-target=".pop-up-3" >       
             <img class='comment-check-img' src="images/truckReview/<%=reviewList.get(i).getReviewCommentRimage()%>" alt="Card image cap"onclick="fn_modal_review('images/truckReview/<%=reviewList.get(i).getReviewCommentRimage()%>');"></a><br>
			</div>
			<%} %> 
			<div class="col-xs-12">
				<%=reviewList.get(i).getReviewCommnetContent()%>
			</div>
		</div>
				
				
				
				
				<div class="row">
			<div class="col-xs-8"></div>
			<div class="col-xs-4 result-btn-positon">
				<br>
				<button id="delete-button" class='btn btn-success btn-delete'
					type="button"
					onclick="fn_commentDelete(<%=i%>,<%=reviewList.get(i).getReviewCommentPk()%>)">삭제</button>
				<button id='addComment<%=i%>' type="button"
					class="btn btn-success btn-reply ">답글</button>

			</div>
		</div> 
		
			<script type="text/javascript">
                            $("#addComment<%=i%>").one('click', function() {
                            	   var li = $('<li id></li>'); //태그생성
                                   var html = "<br><div class='col-xs-12' align='right'>";
                                   html += "<form action='<%=request.getContextPath()%>/truckReviewCommentEnd' method='post'>";
                                   html += "<input type='hidden' name='reviewCommentLevel' value='2'/>";
                                   html += "<input type='hidden' name='reivewCommentWriter' value='<%=member.getMemberId()%>'/>";
                                   html += "<input type='hidden' name='reviewCommentRef' value='<%=reviewList.get(i).getReviewCommentPk()%>'/>";
                                   html += "<input type='hidden' name='memberPk' value='<%=member.getMemberPk()%>'/>";
                                   html += "<input type='hidden' name='truckPk' value='<%=reviewList.get(i).getTruckPk()%>'/>"; 
                                   html += " <textarea name='truckCommentContent' class='form-control' style='resize: none;' required='required' autofocus='autofocus' ></textarea>";
                                   html += "<button type='submit' class='btn btn-success'>등록</button>&nbsp;";
                                   html += "<button type='reset' class='btn btn-success'>취소</button>";
                                   html += "<br><hr></form></div>";
                                   li.html(html);
                                   li.insertAfter($(this).parent().parent().parent().parent().children(".level2")).slideDown(100);

                          	  return li;
							});
       </script>
		
		
		
		<hr>
	</li>
	<ul id="comment-reply" class="level2">
		<%for(int k=0; k<reviewList.size(); k++){ %>
		<%if(reviewList.get(k).getReviewCommentLevel()==2&&reviewList.get(k).getReviewCommentRef()==reviewList.get(i).getReviewCommentPk()) {%>
		<li class='review-comment-view<%=k%>' textalign="right">
			<div class='row'>
				<div class="col-xs-2"></div>
				<div class="col-xs-10" id="review-list">
					<div class="row">
						<div class="col-xs-6 ">
							<span class='panel-2-body-font'>아이디: <%=reviewList.get(k).getReviewCommnetWriter() %></span>
							<!--아이디부여-->
						</div>
						<div class="col-md-6 date-padding">
							<span class='panel-2-body-font'>작성일:<%=reviewList.get(k).getReivewCommentDate() %></span><br>
							<!--date 부여 -->
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<span><%=reviewList.get(k).getReviewCommnetContent() %></span>
						</div>
						<br>
					</div>
					<div class="row">
						<div class="col-xs-12" align="right">
							<button class='btn btn-success btn-delete' type="button"
								onclick="fn_commentDelete(<%=k%>,<%=reviewList.get(k).getReviewCommentPk()%>)">삭제</button>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</li>
		<%}
                   }%>
	</ul>
</ul>
<%} 
	}if(!reviewList.isEmpty()) {%>

<div class="row">
	<div class="col-xs-12 result-btn-positon">
		<button id="load-review-button" class='btn btn-success' type="button">더보기</button>
	</div>
	<br> <br>
</div>
<%
	}
%>




<div class="modal fade pop-up-3" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel-1" aria-hidden="true"
	data-backdrop="false">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
			</div>
			<div class="modal-body">
				<img id="modal-review-img"
					class="img-responsive img-rounded center-block" alt="" width="500"
					height="500">
			</div>
		</div>
	</div>
</div>





<script>
	//삭제
function fn_commentDelete(index,pk) {
	$.ajax({
		url:"<%=request.getContextPath()%>/truckReviewCommentDelete",
		type : "POST",
		data:{reviewCommentPk :pk},
		success : function(data){ 
			alert(data.msg);
			var comment=$(".review-comment-view"+index);
			comment.remove();
		}, 
		error : function(request,status,error) { 
		alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
		}
})
}


	$(function() {
		function fn_localTime() {
			return new Date().toLocaleString(); 
		}
			$("#localTime").html(fn_localTime());
	})
    
    //모달주석
	 function fn_modal_review(rimage) {
		console.log(rimage);
		$("#modal-review-img").attr("src",rimage);
	}
    	
   //더보기
    $(function(){
		$(".more-comment").slice(0, 10).show(); // 최초 10개 선택
		$("#load-review-button").click(function(e){ // Load More를 위한 클릭 이벤트e
		e.preventDefault();
		$(".more-comment:hidden").slice(0, 10).show(); // 숨김 설정된 다음 10개를 선택하여 표시
		}); 
		 if($(".more-comment:hidden").length == 0){ // 숨겨진 DIV가 있는지 체크
			 $("#load-review-button").hide();
		}
	});
   

   
	

    /*   $(".btn-cancel").on('click', function(e) {
        $(".comment-reply").detach();
      }); */

    	
  </script>

</html>

