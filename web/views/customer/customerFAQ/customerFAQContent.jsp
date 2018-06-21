<%@page import="customerFAQ.model.vo.CustomerFAQ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/nav-tabs.css">
<%
	CustomerFAQ customerFAQ=(CustomerFAQ)request.getAttribute("customerFAQ");
%>

<style>
	.table
	{
    	border-top: 3px solid rgba(128, 128, 128, 0.452);
        border-bottom: 2px solid rgba(128, 128, 128, 0.452);
    }
	tr>td:first-child
	{
		background-color: #b1ddab2c;
        width:150px;
        text-align: center;
	}
    tr:last-child>td:nth-child(3)
    {
    	background-color: #b1ddab2c;
        width:150px;
        text-align: center;
    }
    .panel
    {
    	margin-top: 70px;
    }
    .row>p
    {
        width: 80%;
    }
</style>

<section>
	<div class='container'>
		<div class="panel">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="<%=request.getContextPath() %>/customer.do">공지사항</a></li>
                <li class="active" role="presentation"><a href="<%=request.getContextPath() %>/customerFAQForm.do">자주묻는 질문</a></li>
                <li role="presentation"><a href="<%=request.getContextPath() %>/customerStoreSignup.do">점포가입신청</a></li>
            </ul>
        <div class="panel-body">
	            <br>
	            <h2>공지사항</h2>
	            <br>
				<table class="table">
					<tr>
						<td>제목</td>
						<td colspan="5"><%=customerFAQ.getFAQTitle() %></td>
	                </tr>
	                <tr>
	                    <td>작성자</td>
	                    <td colspan="5">관리자</td>
	                </tr>
	                <tr>
	                    <td>작성일자</td>
	                    <td colspan="2"><%=customerFAQ.getFAQDate() %></td>
	                  
	                </tr>
				</table>
				<br><br>
				<div class="row">
					<h2 class="text-center"><%=customerFAQ.getFAQTitle() %></h2>
				</div>
				<div class="row">
				<br><br>
                  <div class="col-xs-2"></div>
                  <div class="col-xs-8">
                       <div class="center-block" style="display: block;"><%=customerFAQ.getFAQContent() %></div>
                  </div>
                  <div class="col-xs-2"></div>
                </div>
				
				
				<hr>
			<%if(memberLoggedIn!=null&&memberLoggedIn.getMemberLevel().equals("1")) { %>				
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-8 text-right">
						<button class="btn btn-success" type="button" onclick="location.href='<%=request.getContextPath()%>/customerFAQUpdateForm.do?FAQPK=<%=customerFAQ.getFAQPK()%>'">수정<i class="fa fa-check spaceLeft"></i></button>
	  					<button class="btn btn-danger" type="reset" onclick="fn_deleteCustomerFAQ();">삭제<i class="fa fa-times spaceLeft"></i></button>
					</div>
					<div class="col-sm-1"></div>
				</div>
				<script>
					function fn_deleteCustomerFAQ() {
						var check=confirm("삭제하시겠습니까?");
						if(check){
							location.href="<%=request.getContextPath()%>/customerFAQDelete.do?FAQPK=<%=customerFAQ.getFAQPK()%>";
							}	
						}
				</script>
				<%} %>
				<form class="navbar-form navbar-center" action="<%=request.getContextPath()%>/customerFAQForm.do" method="post">
					<button type="submit" class="btn btn-default">목록으로</button>
				</form>
			</div>
        
      
    </div>
        </div>
    </section>
    

 <%@ include file="/views/common/footer.jsp"%>   