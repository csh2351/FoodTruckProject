<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="css/nav-tabs.css">
<link rel="stylesheet" href="css/customer.css">



 <section>
        <div class='container'>
            <div class="panel">
              
                <ul class="nav nav-tabs">
                  <li class="active"  role="presentation"><a href="<%=request.getContextPath()%>/adminStoreManagementForm.do">점주관리</a></li>
                  <li  role="presentation"><a href="<%=request.getContextPath()%>/adminStoreEnrollList.do">점포가입신청</a></li>
                  <li role="presentation"><a href="<%=request.getContextPath() %>/adminOneForm.do">1대1문의</a></li>
                </ul>

                <div class="panel-body">
                        <br>
                        <h2>점주관리</h2>
                        <br>
                        <table class="table">
                                <thead id='tablehead'>
                                    <tr>
                                        <td>점포명</td>
                                        <td>카테고리</td>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><a href="<%=request.getContextPath()%>/adminStoreManagementContent.do">(점포명)</a></td>
                                        <td></td>
                                       
                                    </tr>
                                    <tr>
                                        <td><a href="<%=request.getContextPath()%>/adminStoreManagementContent.do">(점포명)</a></td>
                                        <td></td>
                                        
                                    </tr>
                                    <tr>
                                        <td><a href="<%=request.getContextPath()%>/adminStoreManagementContent.do">(점포명)</a></td>
                                        <td></td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                </div>
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
    </section>
    
<%@ include file="/views/common/footer.jsp"%>