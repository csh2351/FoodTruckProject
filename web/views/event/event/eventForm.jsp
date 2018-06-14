<%@page import="event.model.vo.Event"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%
	int cPage = (int) request.getAttribute("cPage");
	int numPerPage = (int) request.getAttribute("numPerPage");
	String pageBar = (String) request.getAttribute("pageBar");
	List<Event> eventList = (List)request.getAttribute("eventList");
	Event event = (Event)request.getAttribute("event");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/event.css">

<!--이벤트 목록-->
<section>
	<br>
	<br>
	<br>
	<div class='container'>
		<div class="panel">
			<ul class="nav nav-tabs">
				<li class="active" role="presentation"><a href="<%=request.getContextPath()%>/eventForm.do">이벤트</a></li>	
			</ul>
			<div class="panel-body">
				<br>
				<h3>&nbsp;&nbsp;event</h3>
				<br>
				<table class="table">
					<thead id='tablehead'>
						<tr>
							<td>번호</td>
							<td><a href="<%=request.getContextPath()%>/eventContent.do">점포명</a></td>
							<td><a href="<%=request.getContextPath()%>/eventContent.do">제목</a></td>
							<td>종료기간</td>
						</tr>
					</thead>
					<tbody>
						<%
							if (eventList == null) {
						%>
						<p>검색 결과가 없습니다.</p>
						<%
							} else {
								for (Event e : eventList) {
						%>
						<tr>
							<td><%=e.getEventPk()%></td>
							<td><a
								href="<%=request.getContextPath()%>/eventContent.do?eventPk=<%=e.getEventPk()%>"><%=e.getEventTitle()%></a></td>
							<td>관리자</td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
				<%if(member==null) {%>
				<%}else if(member!=null){
      		    	if(member.getMemberLevel()==1){ %>
				<div class="row">
					<div class="form-group">
						<div class="col-sm-12 text-right">
							<button class="btn btn-primary" type="button"
								onclick="location.href='<%=request.getContextPath()%>/eventNewWriteForm.do'">등록<i class="fa fa-check spaceLeft"></i>
							</button>
						</div>
					</div>
				</div>
				<%	}
      		    } %>
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