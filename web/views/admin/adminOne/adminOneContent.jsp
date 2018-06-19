<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="mypageQuestion.model.vo.Qna"%>
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
                 <li role="presentation"><a href="<%=request.getContextPath()%>/adminStoreManagementForm.do">점주관리</a></li>
                  <li  role="presentation"><a href="<%=request.getContextPath() %>/adminStoreEnrollList.do">점포가입신청</a></li>
                  <li class="active" role="presentation"><a href="<%=request.getContextPath() %>/adminOneForm.do">1대1문의</a></li>
           		  <li role="presentation"><a href="<%=request.getContextPath() %>/adminMemberManagementList.do">회원관리</a></li>
			</ul>

                    <div class="panel-body">
                            <br>
                            <h2>1대1 문의 내용</h2>
                            <br>

                            <div class="row">
                                    <div class="col-xs-3"> 작성자</div>
                                    <div class="col-xs-6"><p><%=qna.getQnaWriter() %></p></div>
                            </div>
                            <hr>
                            <div class="row">
                                    <div class="col-xs-3"><p>작성일자</p></div>
                                    <div class="col-xs-3"><p><%=qna.getQnaDate() %></p></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-xs-3"> 제목</div>
                                    <div class="col-xs-9"><%=qna.getQnaTitle() %></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-xs-3"> 내용</div>
                                    <div class="col-xs-9">
                                     	<%=qna.getQnaContent() %>   
                                    </div>
                                </div>
                                <hr>
                               
                                <form class="form-group" action="<%=request.getContextPath()%>/adminOneAnswerComplete.do?qnaPk=<%=qna.getQnaPk()%>" method="post">
                                	<div class="row">
                                        	<label for="answerTitle" class="col-sm-3 control-label">답변 제목</label>
                                    	<div class="col-sm-6">
                                       		<input type='text' class='form-control' id='answerTitle' name='answerTitle' <%if(!(qna.getAnswerTitle().equals("답변 대기중"))){%> value="<%=qna.getAnswerTitle()%>" <%}else{ %> value="" <%} %>>
                                      	</div>
                                     	<div class="col-sm-3"></div>
                                    </div>
                                    <hr>
                                	
                                    <div class="row">
                                        <label for="answerContent" class="col-sm-3 control-label">답변 내용</label>
                                      <div class="col-sm-6">
                                        <textarea class="form-control" rows="13" style="resize: none;" id='answerContent' name='answerContent'><%if(!(qna.getAnswerContent().equals("답변까지 1~2일이 소요될 수 있습니다."))){%> <%=qna.getAnswerContent()%> <%}else{ %>  <%} %></textarea>
                                      </div>
                                      <div class="col-sm-3"></div>
                                    </div>
                                    <br><br>
                                    <div class="row">
                                      <button type="submit" class="btn btn-default center-block" onclick="fn_adminOneCheck();">답변완료</button>
                                    </div>
                                </form>
                                
                               
                                <script>
                                function fn_adminOneCheck(){
                              	  var title=$("#answerTitle").val();
                                    var content=$("#answerContent").val();
              						
                                    title=$.trim(title);
                                    content=$.trim(content);
                              	
                              if(title.length==0||title==null){
                                alert("제목을 입력하세요")
                                $("#answerTitle").focus();
                                return false;
                              }
                              
                              if(content.length==0||content==null){
                                alert("내용을 입력하세요");
                                $("#answerContent").focus();
                                 return false;
                              }
                                return true;
                              }
                                </script>
								
                    </div>
                    
                    <form class="navbar-form navbar-center">
                            <button type="submit" class="btn btn-default"><a href="<%=request.getContextPath() %>/adminOneForm.do">목록으로</a></button>
                    </form>
                </div>
    </div>
</section>


<%@ include file="/views/common/footer.jsp"%>