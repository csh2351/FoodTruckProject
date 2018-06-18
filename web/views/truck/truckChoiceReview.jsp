<%@page import="member.model.vo.Member"%>
<%@page import="truck.vo.TruckReviewComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckReview.css">
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>

 <%List<TruckReviewComment> reviewList=(ArrayList<TruckReviewComment>)request.getAttribute("reviewList");%>
 <%int truckPk=(int)(request.getAttribute("truckPk"));%>
 <%String memberId=(String)request.getAttribute("memberId");%>
	
	<!-- 지우지마셈... -->
	
	
 		
           <ul id='comment-main level1'>
			<%for(int i=0; i<reviewList.size(); i++){ %>
                   <div id='comment-modify-list<%=i%>' class="more-comment" style="display: none;"> 
                    <%if(reviewList.get(i).getReviewCommentLevel()==1){ %>
               
                    <li>
                      <!--댓글보기-->
                        <div class='row'>
                          <div class="col-xs-8">
                            <div class="row">
                              <div class="col-md-6 ">
                                <span class='panel-2-body-font'>아이디: <%=reviewList.get(i).getReviewCommnetWriter() %></span> 
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성일:<%=reviewList.get(i).getReivewCommentDate() %></span><br>
                                <!--date 부여 -->
                              </div>
                            </div>
                            <span class="rating">
                            <label>
                             <span class="icon">평점: <%=reviewList.get(i).getReviewStar() %></span>
                            </label>
                            </span>
                            <div class="row">
                              <div class="col-xs-12">
								<span><%=reviewList.get(i).getReviewCommnetContent() %></span>
                              </div>
                            </div>

                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>
                          <%if(reviewList.get(i).getReviewCommentRimage()!=null){ %>
                     <a id="menu-modal" data-toggle="modal" data-target=".pop-up-3" >       
                            <img class='comment-check-img' src="images/truckReview/<%=reviewList.get(i).getReviewCommentRimage()%>" alt="Card image cap" width=150px height=150px onclick="fn_modal_review('images/truckReview/<%=reviewList.get(i).getReviewCommentRimage()%>');"></a><br>
                          <%} %>
                          </div>
                        </div>
                           <%if((reviewList.get(i).getReviewCommnetWriter()).equals(memberId)){ %>
                    
                    	
                         <div class="row">
                         <div class="col-xs-8">
                          </div>
                          <div class="col-xs-4 result-btn-positon">
                          	<br>
                             <button id="delete-button<%=i%>"  class='btn btn-success result-btn delete-button' type="button" >삭제</button>
                          </div>
                        </div>
                        
                        <!--댓글삭제 ajax-->
                        <script type="text/javascript">
						$("#delete-button<%=i%>").on("click", function() {
							$.ajax({
								url:"<%=request.getContextPath()%>/truckCommentDelete",
								type : "POST",
								data:{reviewCommentPk :<%=reviewList.get(i).getReviewCommentPk()%>,fileName:"<%=reviewList.get(i).getReviewCommentRimage()%>",truckPk:<%=reviewList.get(i).getTruckPk()%>},
								success : function(data){ 
									alert(data.msg);
									$("#comment-modify-list<%=i%>").remove();
								}, 
								error : function(request,status,error) { 
								alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
								}
						})
						})
                      </script>

                    
                       
                        
                          <%} %>
                    </li>
                    <%}if(reviewList.get(i).getReviewCommentLevel()==2) {%>
                    
                    <li class='comment-reply level2' textalign="right"> 
                     <div class='row'>
                     <div class="col-xs-2">	↘</div>
                          <div class="col-xs-10">
                            <div class="row">
                              <div class="col-xs-6 ">
                                <span class='panel-2-body-font'>사장님: <%=reviewList.get(i).getReviewCommnetWriter() %></span> 
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성일:<%=reviewList.get(i).getReivewCommentDate() %></span><br>
                                <!--date 부여 -->
                              </div>
                            </div>
                            <div class="row">
                              <div class="col-xs-12">
								<span><%=reviewList.get(i).getReviewCommnetContent() %></span>
                              </div>
                            </div>
                        	<hr>
                          </div>
                        </div>
                    </li>
                  	  <%} %>
                  	   <hr>
                  	   </div>
                    <%} %>
                    
                     <div class="row">
                          <div class="col-xs-12 result-btn-positon">
                            <button id="load-review-button" class='btn btn-success result-btn' type="button">더보기</button>
                          </div>
                          <br>
                          <br>
                        </div>
                      
                   
                    
                                     <!--모달 틀-->
        <div  class="modal fade pop-up-3" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true" data-backdrop="false">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
              </div>
              <div class="modal-body">
                 <img id="modal-review-img"class="img-responsive img-rounded center-block" alt="" width="500" height="500">
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal mixer image -->
                    
                    
                    
           
                  
                    
                  <!--댓글달기 --> 
					<%if(memberId.length()>0){ %>                   
                    <li id='comment-list'>
                      <form name="TruckCommentFrm" action="<%=request.getContextPath()%>/truckCommentInsert" method="post" enctype="multipart/form-data">
                        <!--form클래스 아이디부여-->
                        <div class='row'>
                          <div class="col-xs-8">
                            <div class="row">
                              <div class="col-md-6 ">
                               <input type="hidden" name="truckPk" value="<%=truckPk%>"/>                               
          				      	<input type="hidden" name="reviewCommentWriter" value="<%=memberId%>" />                         
          				      	<input type="hidden" name="reviewCommentRef" value="0" />                   
          				      	<input type="hidden" name="reviewCommentLevel" value="1" />
          				      	<input type="hidden" name="memberPk" value="1" />                    
                                
                                <span class='panel-2-body-font' name="reviewCommentWriter">아이디: 세션아이디~</span> 
                               
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span id="localTime" class='panel-2-body-font'></span><br>
                                <!--date 부여 -->
                              </div>
                            </div>

                            <span class="rating">
                            <label>
                                    <input type="radio" name="reviewStar" value="1" />
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="reviewStar" value="2" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="reviewStar" value="3" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="reviewStar" value="4" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="reviewStar" value="5" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                          </label>
                            </span>
                            <br>
                            <div class="row">
                              <div class="col-xs-12">
                                <textarea class="form-control" id="content" name="reviewCommentContent" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;" autofocus required="required"></textarea>
                              </div>

                            </div>



                          </div>
                          <div class='col-xs-4 col-md-3-body-center'>
                            <img id='comment-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=90% height=100><br>
                            <button class="btn-success replace">사진등록</button>
                            <div class='test'>
                              <input id='comment-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='up_file'>
                            </div>
                          </div>
                        </div>

                        <div class="row">
                          <div class="col-xs-12 result-btn-positon">
							<br>
                            <button id="result-button" class='btn btn-success result-btn' type="submit">완료</button>

                            <button id="reset-button" class='btn btn-success result-btn' type="reset">취소</button>
                            <hr>
                          </div>

                        </div>

                      </form>

                    </li>
                    <%} %>
                  </ul>
  
  
<script>
  $("#myonoffswitch").on('click', function(e) {
    e.preventDefault();
  });

    //별 스크립트
    $(':radio').change(function() {
      console.log('New star rating: ' + this.value);
    });

    //이미지파일 올리기 스크립트



    //미리보기 스크립트.

    $(function() {
      $("#comment-input-img").on('change', function() {
        readURL(this);
      });
    });

    function readURL(input) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
          $('#comment-check-img').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
      }
    }


    $(function() {
      $("#reset-button").click(function() {
          $('#comment-check-img').attr('src', "https://pingendo.com/assets/photos/wireframe/photo-1.jpg");

      })
    })

    //미리보기 스크립트.

    //미리보기 수정  스크립a트
 $(function() {
      $("#comment-modify-input-img").on('change', function() {
        readURL1(this);
      });
    });

    function readURL1(input) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
          $('#comment-modify-check-img').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
      }
    }

    $(function() {
      $("#reset-modify-button").click(function() {
          $('#comment-modify-check-img').attr('src', "https://pingendo.com/assets/photos/wireframe/photo-1.jpg");

      })
    })
	//미리보기 수정 스크립트
	

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
		/* if($(".more-comment:hidden").length == 0){ // 숨겨진 DIV가 있는지 체크
		alert("더 이상 항목이 없습니다"); // 더 이상 로드할 항목이 없는 경우 경고
		}*/
		}); 
	});
    	
  </script>

</html>

