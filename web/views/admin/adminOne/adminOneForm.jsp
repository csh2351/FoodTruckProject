
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
  <%@page import="mypageQuestion.model.vo.Qna"%>
<%

int cPage=(int)request.getAttribute("cPage");
int numPerPage=(int)request.getAttribute("numPerPage");
String pageBar=(String)request.getAttribute("pageBar");
List<Qna> qnaList=(List)request.getAttribute("qnaList");

%>


<section>
        <div class='container'>
            <div class="panel">
              
                <ul class="nav nav-tabs">
                  <li role="presentation"><a href="<%=request.getContextPath()%>/adminStoreManagementForm.do">점주관리</a></li>
                  <li  role="presentation"><a href="<%=request.getContextPath() %>/adminStoreEnrollList.do">점포가입신청</a></li>
                  <li class="active" role="presentation"><a href="<%=request.getContextPath() %>/adminOneForm.do">1대1문의</a></li>
                </ul>

                <div class="panel-body">
                        <br>
                        <h2>1대1 문의</h2>
                        <br>
                        <table class="table">
                                <thead id='tablehead'>
                                        <tr>
                                            <td>번호</td>
                                            <td>제목</td>
                                            <td>작성자</td>
                                            <td>작성일자</td>
                                            <td>답변 여부</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%if(qnaList==null){ %>
            								<tr>
            								<td><p>검색 결과가 없습니다.</p></td>
            								</tr>
            							<%}else{
            								for(Qna qna: qnaList){
            									%>
                                        <tr>
                                        	
                                            <td><%=qna.getQnaPk() %></td>
                                            <td><a href="<%=request.getContextPath() %>/adminOneContent.do?qnaPk=<%=qna.getQnaPk() %>"><%=qna.getQnaTitle() %></a></td>
                                            <td><a href="<%=request.getContextPath() %>/adminOneContent.do?qnaPk=<%=qna.getQnaPk() %>"><%=qna.getQnaWriter() %></a></td>
                                            <td><%=qna.getQnaDate() %></td>
                                            <td><%=qna.getQnaAnswerCheck() %></td>
                                        </tr>
                                        <%}} %>
                                      
                                </tbody>
                            </table>
                </div>
                <div class="row">
                    <nav>
                        <ul class="pagination">
                            <%=pageBar %>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp"%>