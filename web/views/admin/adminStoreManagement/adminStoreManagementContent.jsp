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
                        <br>
                        <h2>점주 정보</h2>
                        <br>
                       

                        
                        <div class="row">
                                <div class="col-xs-3">
                                   <p>사업자 번호  </p> 
                                </div>
                                <div class="col-xs-9">
                                    <p>받아온 사업자 번호</p>
                                </div>
                            </div>
                            <hr> 
                            <div class="row">
                                <div class="col-xs-3">
                                    <p>대표자 이름  </p>
                                </div>
                                <div class="col-xs-9">
                                    <p>받아온 대표자 이름</p>
                                </div>
                            </div>  
                            <hr>
                            <div class="row">
                                <div class="col-xs-3">
                                    <p>휴대폰 번호  </p>
                                </div>
                                <div class="col-xs-9">
                                    <p>받아온 휴대폰 번호</p>
                                </div>
                            </div>
                            <hr>
    
                            <div class="row">
                                <div class="col-xs-3">
                                    <p>상호명  </p>
                                </div>
                                <div class="col-xs-9">
                                    <p>받아온 상호명</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-xs-3">
                                    <p>업종카테고리  </p>
                                </div>
                                <div class="col-xs-9">      
                                     <p>받아온 업종 카테고리</p>   
                                </div>
                            </div>  
                            <br><br>
                </div>
                <div class="row">
                        <div class="form-group">
                                <div class="col-sm-12 text-center">
                                  
                                  <button class="btn btn-danger" type="submit">삭제<i class="fa fa-times spaceLeft"></i></button>
                                </div>
                              </div>
             </div>
             <br>
             <div class='row'>   
                    
                    <div class="col-xs-3">
                    <button class="btn btn-default center-block"><a href="Admin_StoreOwner_Management.html">목록</a></button>          
                </div>
                <div class="col-xs-9"></div>
             </div>
             <br><br>
            </div>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp"%>