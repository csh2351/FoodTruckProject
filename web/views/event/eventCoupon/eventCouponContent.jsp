<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/event.css">
 
  <!--이벤트 목록-->
  <section>
      <br><br><br>
    <div class='container'>

        <div class="panel">
          
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="<%=request.getContextPath()%>/eventForm.do">이벤트</a></li>
                <li class="active" role="presentation"><a href="<%=request.getContextPath()%>/eventCouponForm.do">쿠폰</a></li>
               
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
                          쿠폰 내용
                        </td>
                        <td colspan="5">
                          아아아아아아아아아
                        </td>
                      </tr>
                      <tr>
                        <td>쿠폰 사용 기간</td>
                        <td colspan="5">2018-05-05</td>
                      </tr>
                      <tr>
                        <td>점포명</td>
                        <td colspan="2"></td>
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
                  
                      <form class="navbar-form navbar-center">
                          <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/eventCouponForm.do">목록으로</a></button>
                  </form>
        </div>
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp"%>