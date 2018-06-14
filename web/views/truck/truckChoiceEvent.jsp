<%@page import="event.model.vo.Event"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckEvent.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/event.css">
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">


  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
 
 
 
<%
	int cPage = (int) request.getAttribute("cPage");
	int numPerPage = (int) request.getAttribute("numPerPage");
	String pageBar = (String) request.getAttribute("pageBar");
	List<Event> eventList=(List)request.getAttribute("eventList");
	Event event = (Event)request.getAttribute("event");
	int truckPk = (int) request.getAttribute("truckPk");

	
%>
 
 	
 
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;이벤트</p>
                  </div>
                  <table class="table">
                                <thead id='tablehead'>
                                        <tr>
                                            <td style="color: black;">이벤트번호</td>
											<td style="color: black;">제목</td>
                                            <td style="color: black;">종료기간</td>
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%if(eventList==null){%>
                                    	<p>검색결과가 없습니다.
                                    	<%}else{
                                    		for(Event e: eventList){
                                    	%>
                                        <tr>
                                            <td><%=e.getEventPk() %></td>
                                            <td><a href="<%=request.getContextPath()%>/eventContent.do?truckPk=<%=truckPk%>"><%=e.getEventTitle() %></a></td>
                                            <td><%=e.getEventDate()%></td>
                                            <!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                        </tr>
                                        <%}
                                    		}%>
                                </tbody>
                            </table><div class="row">
					<nav>
						<ul class="pagination">
							<%=pageBar %>
						</ul>
					</nav>
				</div>



