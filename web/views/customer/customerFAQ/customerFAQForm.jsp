<%@page import="customerFAQ.model.vo.CustomerFAQ"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int cPage = (int) request.getAttribute("cPage");
	int numPerPage = (int) request.getAttribute("numPerPage");
	String pageBar = (String) request.getAttribute("pageBar");
	List<CustomerFAQ> customerFAQList = (List) request.getAttribute("customerFAQList");
%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/nav-tabs.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/customer.css">


<section>
	<div class='container'>
		<div class="panel">

			<ul class="nav nav-tabs">
				<li role="presentation"><a href="<%=request.getContextPath()%>/customer.do">공지사항</a></li>
				<li class="active" role="presentation"><a href="<%=request.getContextPath()%>/customerFAQForm.do">자주묻는 질문</a></li>
				<li role="presentation"><a href="<%=request.getContextPath()%>/customerStoreSignup.do">점포가입신청</a></li>
			</ul>


			<div class="panel-body">
				<br>
				<h2>자주 묻는 질문</h2>
				<br>
				<table class="table">
					<thead id='tablehead'>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성 시간</td>
						</tr>
					</thead>
					<tbody>
						<%
							if (customerFAQList == null) {
						%>
						<p>검색 결과가 없습니다.</p>
						<%
							} else {
								for (CustomerFAQ c : customerFAQList) {
						%>
						<tr>
							<td><%=c.getFAQPK()%></td>
							<td><a
								href="<%=request.getContextPath()%>/customerFAQContent.do?FAQPK=<%=c.getFAQPK()%>"><%=c.getFAQTitle()%></a></td>
							<td>관리자</td>
							<td><%=c.getFAQDate() %></td>

						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
				<%
					if (memberLoggedIn == null) {
				%>
				<%
					} else if (memberLoggedIn != null) {
						if (memberLoggedIn.getMemberLevel().equals("1")) {
				%>
				<div class="row">
					<div class="form-group">
						<div class="col-sm-12 text-right">
							<button class="btn btn-primary" type="button"
								onclick="location.href='<%=request.getContextPath()%>/customerNewFAQForm.do'">
								등록<i class="fa fa-check spaceLeft"></i>
							</button>

						</div>
					</div>
				</div>
				<%
					}
					}
				%>
				<div class="row">
					<nav>
						<ul class="pagination">
							<%=pageBar%>
						</ul>
					</nav>
				</div>
			</div>


		</div>
	</div>
</section>


<%@ include file="/views/common/footer.jsp"%>
