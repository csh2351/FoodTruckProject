<%@page import="truck.vo.TruckReviewComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckReview.css">
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>

 <%List<TruckReviewComment> reviewList=(ArrayList<TruckReviewComment>)request.getAttribute("reviewList");%>
 <%int truckPk=(int)(request.getAttribute("truckPk"));%>

 		
           <ul id='comment-main level1'>
			<%for(int i=0; i<reviewList.size(); i++){ %>
             
                    <%if(reviewList.get(i).getReviewCommentLevel()==1){ %>
                    <li id='comment-modify-list'>
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
                            <img class='comment-check-img' src="images/truckReview/<%=reviewList.get(i).getReviewCommentRimage()%>" alt="Card image cap" width=150px height=150%><br>
                          <%} %>
                          </div>
                        </div>
                       <hr>
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
                    <%} %>
                    
                  
                   
                    
              <!--       <li id='comment-modify-list'>
                      댓글수정
                      <form>
                        form클래스 아이디부여
                        <div clas='row'>
                          <div class="col-xs-9">
                            <div class="row">
                            <div class="col-md-6 ">
                                <span class='panel-2-body-font'>아이디: jazzhong111111</span> 
                                아이디부여
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성날짜: 2012/12/11</span><br>
                                date 부여
                              </div>
                            </div>

                            <span class="rating">
                            <label>
                                    <input type="radio" name="stars" value="1" />
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="2" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="3" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="4" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="5" />
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

                                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;"></textarea>



                              </div>

                            </div>



                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>

                            <img id='comment-modify-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br>

                            <button class="btn-success replace">사진등록</button>
                            <div class='test'>
                              <input id='comment-modify-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='comment-img'>
                            </div>
                          </div>
                        </div>

                        <div class="row">
                          <div class="col-xs-12 result-btn-positon">
							<br>
                            <button id="modify-button" class='btn btn-success result-btn' type="submit">수정</button>
                             <button id="reset-modify-button" class='btn btn-success result-btn' type="reset">취소</button>
							<hr>
                          </div>

                        </div>

                      </form>

                    </li>
 -->
                    <!--댓글달기-->
                    
                    <li id='comment-list'>
                      <form name="TruckCommentFrm" action="<%=request.getContextPath()%>/truckCommentInsert" method="post" enctype="multipart/form-data">
                        <!--form클래스 아이디부여-->
                        <div class='row'>
                          <div class="col-xs-9">
                            <div class="row">
                              <div class="col-md-6 ">
                               <input type="hidden" name="truckPk" value="<%=truckPk%>"/>                               
          				      	<input type="hidden" name="reviewCommentWriter" value="admin" />                         
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
                                <textarea class="form-control" id="content" name="reviewCommentContent" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;"></textarea>
                              </div>

                            </div>



                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>

                            <img id='comment-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br>
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

    //미리보기 수정  스크립트
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
  </script>

</html>

