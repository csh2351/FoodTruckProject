<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="customerStoreSignup.model.vo.Signup"%>
<%@ include file="/views/common/header.jsp"%>
<%

Signup signup = (Signup)request.getAttribute("signup");
%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/nav-tabs.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/customer.css">
<script>
function fn_accept(){
	location.href="<%=request.getContextPath()%>/acceptStroreEnroll.do?memberPk=<%=signup.getMemberPk()%>&truckApprove=<%=signup.getTruckApprove()%>";
}

function fn_refuse(){
	location.href="<%=request.getContextPath()%>/refuseStroreEnroll.do?memberPk=<%=signup.getMemberPk()%>&truckApprove=<%=signup.getTruckApprove()%>";
}

</script>
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
				<h2>점포가입신청내용</h2>
				<br>
				
				<div class="row">
					<label for="" class="col-sm-2 control-label">신청자</label>
					<div class="col-sm-3">
						<p><%=signup.getMemberId()%></p>
					</div>
				</div>
				<hr>
				
				<div class="row">
					<label for="" class="col-sm-2 control-label">사업자번호</label>
					<div class="col-sm-3">
						<p><%=signup.getTruckInfoRegisterNumber()%></p>
					</div>
				</div>
				<hr>
				<div class="row">
					<label for="" class="col-sm-2 control-label">상호명</label>
					<div class="col-sm-3">
						<p><%=signup.getTruckInfoName()%></p>
					</div>
				</div>
				<hr>
				<div class="row">
					<label for="" class="col-sm-2 control-label">푸드트럭주소</label>
					<div class="col-sm-9">
						<p><%=signup.getTruckLocation()%></p>
					</div>
				</div>


				<br>
				<div class="row">
					<div class="form-group">
						<div class="col-sm-12 text-center">
							<button class="btn btn-primary" type="button" onclick="fn_accept();">
								승인<i class="fa fa-check spaceLeft"></i>
							</button>
							<button class="btn btn-danger" type="button" onclick="fn_refuse();">
								승인거부<i class="fa fa-times spaceLeft"></i>
							</button>
						</div>
					</div>
				</div>
			</div>



		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>
