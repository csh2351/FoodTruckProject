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
                    <h3>&nbsp;&nbsp;Coupon</h3>
                    <br>
                    <table class="table">
                        <thead id='tablehead'>
                                <tr>
                                    <td>점포명</td>
                                    <td>쿠폰 내용</td>
                                    <td>사용기간</td>
                                   
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>점포명</td>
                                    <td><a href="<%=request.getContextPath()%>/eventCouponContent.do">쿠폰내용</a></td>
                                    <td>사용기간</td>
                                    
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><a href="<%=request.getContextPath()%>/eventCouponContent.do">쿠폰내용</a></td>
                                    <td>사용기간</td>
                                   
                                </tr>
                                <tr>
                                    <td></a></td>
                                    <td><a href="<%=request.getContextPath()%>/eventCouponContent.do">쿠폰내용</a></td>
                                    <td>사용기간</td>
                                    
                                </tr>
                        </tbody>
                    </table>
                      <div class="row">
                        <nav>
                                <ul class="pagination">
                                    <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
                                </ul>
                            </nav>
                          </div>
            </div>
        </div>
    </div>
</section>
  
  
<%@ include file="/views/common/footer.jsp"%>