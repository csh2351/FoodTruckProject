
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
  
<%
int cPage=(int)request.getAttribute("cPage");
int numPerPage=(int)request.getAttribute("numPerPage");
String pageBar=(String)request.getAttribute("pageBar");
List<Member> memberList=(List)request.getAttribute("memberList");

%>


<section>
        <div class='container'>
            <div class="panel">
              
                <ul class="nav nav-tabs">
                  <li   role="presentation"><a href="<%=request.getContextPath() %>/adminStoreManagementForm.do">점주관리</a></li>
                  <li role="presentation"><a href="<%=request.getContextPath()%>/adminStoreEnrollList.do">점포가입신청</a></li>
                  <li role="presentation"><a href="<%=request.getContextPath() %>/adminOneForm.do">1대1문의</a></li>
                  <li class="active" role="presentation"><a href="<%=request.getContextPath() %>/adminMemberManagementList.do">회원관리</a></li>
                </ul>

                <div class="panel-body">
                        <br>
                        <h2>회원관리</h2>
                        <br>
                        <table class="table">
                                <thead id='tablehead'>
                                        <tr>
                                            <td>번호</td>
                                            <td>아이디</td>
                                            <td>이름</td>
                                            <td>구분</td>  
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%if(memberList==null){ %>
            								<tr>
            								<td colspan='4'>검색 결과가 없습니다.</td>
            								</tr>
            							<%}else{
            								for(Member m: memberList){
            									%>
                                        <tr>
                                            <td><%=m.getMemberPk()%></td>
                                            <td><a href="<%=request.getContextPath() %>/adminMemberContent.do?memberPk=<%=m.getMemberPk() %>"><%=m.getMemberId()%></a></td>
                                            <td><a href="<%=request.getContextPath() %>/adminMemberContent.do?memberPk=<%=m.getMemberPk() %>"><%=m.getMemberName()%></a></td>
                                            <td><a href="<%=request.getContextPath() %>/adminMemberContent.do?memberPk=<%=m.getMemberPk() %>"><%if(m.getMemberLevel().equals("1")){%>관리자<%}else if(m.getMemberLevel().equals("2")){ %>점주<%}else{ %>일반 사용자<%} %></a></td> 
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