<%@page import="mypageQuestion.model.vo.Qna"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%
int cPage=(int)request.getAttribute("cPage");
int numPerPage=(int)request.getAttribute("numPerPage");
String pageBar=(String)request.getAttribute("pageBar");
List<Qna> qnaList=(List)request.getAttribute("qnaList");

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
                   <h3>문의내역</h3>
                   <br>
                     <table class="table">
                        <thead id='tablehead'>
                          <tr>
                            <td>제목</td>
                            <td>작성일자</td>
                            <td>답변여부</td>    
                          </tr>
                        </thead>
                     	<tbody>
                     		<%if(memberLoggedIn==null) {
                     		}else{
                     			for(Qna q:qnaList){
                     				String memberId=memberLoggedIn.getMemberId();
                     				if(memberId.equals(q.getQnaWriter())){%>
                     	   
                     	   <tr>
           						<td><a href="<%=request.getContextPath()%>/mypageQuestionContent.do?qnaPk=<%=q.getQnaPk()%>"><%=q.getQnaTitle()%></a></td>
                            	<td><%=q.getQnaDate() %></td>
                            	<td><%=q.getQnaAnswerCheck() %></td>      
                           </tr>
                           
                           <%}
                     			}
                     				}%>
                        </tbody>
                      </table>
               
                <div class="row">
                    <nav>
                        <ul class="pagination">
                           <%=pageBar %>
                        </ul>
                    </nav>
                </div>
            </div>
            </div>
        </div>
    </section>


<%@ include file="/views/common/footer.jsp"%>