<%@page import="mypageQuestion.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%
	Qna qna=(Qna)request.getAttribute("qna");
%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
    
      <section>
        <div class='container'>
            <div class="panel">  
              <ul class="nav nav-tabs">
             	
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageInfoChange.do">회원정보수정</a></li>
				<%if(memberLoggedIn!=null&&memberLoggedIn.getMemberId().equals("admin")){ %>
            	<%}else{ %>
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionWrite.do">1대1문의</a></li>
				<li class="active"  role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionForm.do">문의내역</a></li>
				<%} %>
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageMemberDelete.do">탈퇴</a></li>
               </ul>
             <div class="panel-body">
                                <br>
                                <h2>1대1 문의 내용</h2>
                                <br>
                                <div class="row">
                                  <label for="" class="col-sm-2 control-label">작성자</label>
                                  <div class="col-sm-3"><p><%=qna.getQnaWriter() %></p></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <label for="" class="col-sm-2 control-label">작성일자</label>
                                    <div class="col-sm-3"><p><%=qna.getQnaDate() %></p></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <label for="" class="col-sm-2 control-label">제 목</label>
                                  <div class="col-sm-3"><%=qna.getQnaTitle() %></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <label for="" class="col-sm-2 control-label">내 용</label>
                                  <div class="col-sm-9"><%=qna.getQnaContent() %></div>
                                </div>
                                <hr>
                                 <div class="row">
                               		   <label for="" class="col-sm-2 control-label">답변 제목</label>
                                  <div class="col-sm-4"><%=qna.getAnswerTitle() %></div>
                                    <label for="" class="col-sm-2 control-label">답변 일자</label>
                                  <div class="col-sm-4">
                                  <%if(qna.getQnaAnswerDate()!=null){ %>
                                  <span><%=qna.getQnaAnswerDate() %></span>
                                  <%} %>
                                  </div>
                                  
                                  </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <label for="" class="col-sm-2 control-label">답변 내용 </label>
                                  <div class="col-sm-6">
                                    <textarea class="form-control" rows="13" style="resize: none;" readonly><%=qna.getAnswerContent() %></textarea>
                                  </div>
                                </div>
                                <br>
                        </div>

                        <form class="navbar-form navbar-center">
                                <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/mypageQuestionForm.do">목록으로</a></button>
                        </form>
                    </div>
        </div>
    </section>    
<%@ include file="/views/common/footer.jsp"%>