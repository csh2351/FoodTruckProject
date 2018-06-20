<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="customerStoreSignup.model.vo.Signup"%>    
<% 
int cPage=(int)request.getAttribute("cPage");
int numPerPage=(int)request.getAttribute("numPerPage");
String pageBar=(String)request.getAttribute("pageBar");
List<Signup> signupList = (List)request.getAttribute("signupList");
%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">

<section>
        <div class='container'>
            <div class="panel">
              
               <ul class="nav nav-tabs">
				<li role="presentation"><a
					href="<%=request.getContextPath()%>/adminStoreManagementForm.do">점주관리</a></li>
				<li class="active" role="presentation"><a
					href="<%=request.getContextPath()%>/adminStoreEnrollList.do">점포가입신청</a></li>
				<li role="presentation"><a
					href="<%=request.getContextPath() %>/adminOneForm.do">1대1문의</a></li>
			</ul>
                <div class="panel-body">
                        <br>
                        <h3>점포 가입 신청</h3>
                        <br>
                        <table class="table">
                                <thead id='tablehead'>
                                    <tr>
                                        <td>번호</td>
                                        <td>아이디</td>
                                        <td>상호명</td>
                                        <td>승인여부</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <%if(memberLoggedIn==null) {
                     		}else{
                     			for(Signup s : signupList){
                           				%>
                                  	<tr>
                  
           								<td><%=s.getTruckPk()%></td>
                            			<td><a href="<%=request.getContextPath()%>/adminStoreEnrollContent.do?memberPk=<%=s.getMemberPk()%>"><%=s.getMemberId() %></a></td>
                            			<td><a href="<%=request.getContextPath()%>/adminStoreEnrollContent.do?memberPk=<%=s.getMemberPk()%>"><%=s.getTruckInfoName() %></a></td>     
                            			<td><%=s.getTruckApprove() %> </td>
                           			</tr>
                           			<%}
                     			}
                     				%>
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