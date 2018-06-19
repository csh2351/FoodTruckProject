<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="css/nav-tabs.css">
<link rel="stylesheet" href="css/customer.css">


<section>
	<div class='container'>
		<div class="panel">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageInfoChange.do">회원정보수정</a></li>
				<%if(memberLoggedIn!=null&&memberLoggedIn.getMemberId().equals("admin")){ %>
            	<%}else{ %>
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionWrite.do">1대1문의</a></li>
				<li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionForm.do">문의내역</a></li>
				<%} %>
				<li class="active" role="presentation"><a href="<%=request.getContextPath()%>/mypageMemberDelete.do">탈퇴</a></li>
			</ul>

			<div class="panel-body">
				<div class="page-header">
					<h1>탈퇴</h1>
				</div>
			</div>

			<form action="<%=request.getContextPath()%>/delete.do?id=<%=memberLoggedIn.getMemberId()%>" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="memberPw"><span class="text-danger">*</span>비밀번호</label>
					<div class="col-sm-6">
						<input class="form-control" id="memberPw" name="memberPw" type="password" placeholder="비밀번호" required>
					</div>
		
						<div class="col-sm-3">
							<input class="btn btn-primary" type="submit" value="회원탈퇴">
						</div>
			
					</div>
		
			</form>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>