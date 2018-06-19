<%@page import="event.model.vo.Event"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%
	Event event=(Event)request.getAttribute("event");
%>

  <!--이벤트 상세 내용-->
  <section>
      <br><br><br>
    <div class='container'>
        <div class="panel">
              <ul class="nav nav-tabs">
                <li class="active" role="presentation"><a href="<%=request.getContextPath()%>/eventForm.do">이벤트</a></li>
                
              </ul>

              <div class="panel-body">
                 
                  <br>
                  
                    
                      <style>
                      .table{
                        border-top: 3px solid rgba(128, 128, 128, 0.452);
                        border-bottom: 2px solid rgba(128, 128, 128, 0.452);
                        
                      }
                      tr>td:first-child{
                        background-color: #b1ddab2c;
                        width:150px;
                        text-align: center;
                      }
                      tr:last-child>td:nth-child(3){
                        background-color: #b1ddab2c;
                        width:150px;
                        text-align: center;
                      }
                      .panel{
                        margin-top: 70px;
                      }
                      .row>p{
                        width: 80%;
                      }
                      </style>
  
  
  
                      <table class="table">
                        <tr>
                          <td>
                       		제목
                          </td>
                          <td colspan="5">
                           <%=event.getEventTitle() %>
                          </td>
                        </tr>
                        <tr>
                          <td>작성자</td>
                          <td colspan="5">관리자</td>
                        </tr>
                        <tr>
                          <td>이벤트기간</td>
                          <td colspan="5"><%=event.getEventDate() %>~<%=event.getEventEndDate() %></td>
                        
                        </tr>
                      </table>
                      <br><br>
                      <div class="row">
                        <h2 class="text-center"><%= event.getEventTitle()%></h2>
                      </div>
                     <div class="row">
                        <br><br>
                        <div class='col-xs-1'></div>
                          <div class="col-xs-10">
                        <img class="card-img-top img-responsive center-block" src="<%=request.getContextPath() %>/uploadFiles/event/<%=event.getRenameFileName() %>" alt="Card image cap" >
                        <br><br>
                        </div>
                        <div class='col-xs-1'></div>
                        </div>
                        
                        <div class="row">
                        	<div class="col-xs-2"></div>
                        	<div class="col-xs-8">
                        <div class="center-block" style="display: auto;"><%=event.getEventContent() %></div>
                        	</div>
                        	<div class="col-xs-2"></div>
                        </div>
                      </div>
                      <hr>
                      
                      
                        <%if(memberLoggedIn==null) {%>
                                <%}else{
  
                        if(memberLoggedIn.getMemberLevel().equals("1")){ %>
                      <div class="row">
                                      <div class="col-sm-3"></div>
                                      <div class="col-sm-8 text-right">
                                        <button class="btn btn-success" type="button" onclick="location.href='<%=request.getContextPath()%>/eventUpdateForm.do?eventPk=<%=event.getEventPk()%>'">수정<i class="fa fa-check spaceLeft"></i></button>
                                        <button class="btn btn-danger" type="button" onclick="fn_deleteEvent();">삭제<i class="fa fa-times spaceLeft"></i></button>
                                      </div>
                                      <div class="col-sm-1"></div>
                                  </div>
                                  
                                <%}} %>
                      		<script>
									function fn_deleteEvent(){
										var check=confirm("삭제하시겠습니까?");
										if(check){
											location.href="<%=request.getContextPath()%>/eventDeleteForm.do?eventPk=<%=event.getEventPk()%>";
										}	
									}
								</script>
                    
                    
                        <form class="navbar-form navbar-center">
                            <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/eventForm.do">목록으로</a></button>
                    </form>
          </div>
          
        
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp"%>