<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">


<div class="container">
	<div class="login-container">
		<div id="output"></div>
		<div class="avatar"></div>
		<div class="form-box">
			<form action="<%=request.getContextPath()%>/loginCheck.do" method="post">
				<input name="id" type="text" placeholder="username"> 
				<input name="pw" type="password" placeholder="password">
				<button class="btn btn-info btn-block login" type="submit" onclick='fn_submit();'>로그인</button>
			</form>

		</div>
	</div>
</div>

<script>
		function fn_submit() {
			$('#login').submit();
		}
</script>

<%@ include file="/views/common/footer.jsp"%>