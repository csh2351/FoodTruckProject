<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
<section>
        <div class='container'>
            <div class="panel">
                  
                <ul class="nav nav-tabs">
                        <li role="presentation"><a href="<%=request.getContextPath()%>/mypageInfoChange.do">회원정보수정</a></li>
                        <%if(memberLoggedIn!=null&&memberLoggedIn.getMemberId().equals("admin")){ %>
            			<%}else{ %>
						<li class="active" role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionWrite.do">1대1문의</a></li>
						<li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionForm.do">문의내역</a></li>
						<%} %>
						<li role="presentation"><a href="<%=request.getContextPath()%>/mypageMemberDelete.do">탈퇴</a></li>
                </ul>
        
                <div class="panel-body">
                        <div class="page-header">
                                <h2> 1대1 문의 내용</h2>
                        </div>
                        <form class="form-horizontal" action="<%=request.getContextPath()%>/mypageQuestionWriteEnd.do?qnaWriter=<%=memberLoggedIn.getMemberId()%>" method="post">
                                
                                <div class="form-group">
                                  <label class="col-sm-3 control-label" for="">아이디 </label>
                                <div class="col-sm-6">
                                  <input class="form-control" type="text" width="100" value="<%=memberLoggedIn.getMemberId()%>" readonly>
                                </div>
                                </div>
    
                                
                              <div class="form-group">
                                    <label class="col-sm-3 control-label" for="qnaTitle">제목 </label>
                                  <div class="col-sm-6">
                                    <input class="form-control" type="text" id="qnaTitle" name="qnaTitle" placeholder="제목을 입력하세요.">
                                  </div>
                                </div>
    
                                <div class="form-group">
                                   
                                    <label for="qnaContent" class="col-sm-3 control-label">내 용 </label>
                                    <div class="col-sm-6">
                                            <textarea class="form-control" id="qnaContent" name="qnaContent" rows="13" style="resize: none;"></textarea>
                                    </div>
                                
                                </div>
                                <div class="row">
                                  <div class="form-group">
                                    <div class="col-sm-12 text-center">
                                      <button class="btn btn-primary" type="submit" onclick="return fn_OneCheck();">제출하기<i class="fa fa-check spaceLeft"></i></button>
                                      <button class="btn btn-danger" type="reset">취소<i class="fa fa-times spaceLeft"></i></button>
                                    </div>
                                  </div>
                                </div>
                        </form>


                     
                        <script>
                      
                        
                        function fn_OneCheck(){
                        	  var title=$("#qnaTitle").val();
                              var content=$("#qnaContent").val();
      						
                              title=$.trim(title);
                              content=$.trim(content);
                        	
                        if(title.length==0||title==null){
                          alert("제목을 입력하세요")
                          $("#qnaTitle").focus();
                          return false;
                        }
                        
                        if(content.length==0||content==null){
                          alert("내용을 입력하세요");
                          $("#qnaContent").focus();
                           return false;
                        }
                          return true;
                        }
                        </script>
                        


                    </div>
                   
                </div>
            </div>
        </section>
    


 <%@ include file="/views/common/footer.jsp"%>   