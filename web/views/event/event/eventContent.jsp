<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>


  <!--이벤트 상세 내용-->
  <section>
      <br><br><br>
    <div class='container'>
        <div class="panel">
              <ul class="nav nav-tabs">
                <li class="active" role="presentation"><a href="<%=request.getContextPath()%>/eventForm.do">이벤트</a></li>
                <li role="presentation"><a href="<%=request.getContextPath()%>/eventCouponForm.do">쿠폰</a></li>
              </ul>

              <div class="panel-body">
                 
                  <br>
                  
                    
                      <style>
                      .table{
                        border-top: 3px solid rgba(128, 128, 128, 0.452);
                        border-bottom: 2px solid rgba(128, 128, 128, 0.452);
                        
                      }
                      tr>td:first-child{
                        background-color: #b1ddab2c;
                        width:150px;
                        text-align: center;
                      }
                      tr:last-child>td:nth-child(3){
                        background-color: #b1ddab2c;
                        width:150px;
                        text-align: center;
                      }
                      .panel{
                        margin-top: 70px;
                      }
                      .row>p{
                        width: 80%;
                      }
                      </style>
  
  
  
                      <table class="table">
                        <tr>
                          <td>
                               	제목
                          </td>
                          <td colspan="5">
                          	아아아아아아아아아
                          </td>
                        </tr>
                        <tr>
                          <td>작성자</td>
                          <td colspan="5"></td>
                        </tr>
                        <tr>
                          <td>작성일자</td>
                          <td colspan="2">2018-05-05</td>
                          <td>조회수</td>
                          <td colspan="2">213</td>
                        </tr>
                      </table>
                      <br><br>
                      <div class="row">
                        <h2 class="text-center">제목 받아오기</h2>
                      </div>
                      <div class="row">
                        <br><br>
                        <img class="card-img-top img-responsive center-block" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg" alt="Card image cap" width="400" height="400">
                        <br><br>
                        <p class="center-block" style="display: block;">아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ</p>
                      </div>
                      <hr>
                      <div class="row">
                                      <div class="col-sm-3"></div>
                                      <div class="col-sm-8 text-right">
                                        <button class="btn btn-success" type="button" onclick="location.href='<%=request.getContextPath()%>/eventUpdateForm.do'">수정<i class="fa fa-check spaceLeft"></i></button>
                                        <button class="btn btn-danger" type="button" onclick="fn_deleteNotice();">삭제<i class="fa fa-times spaceLeft"></i></button>
                                      </div>
                                      <div class="col-sm-1"></div>
                                  </div>
                    
                        <form class="navbar-form navbar-center">
                            <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/eventForm.do">목록으로</a></button>
                    </form>
          </div>
        
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp"%>