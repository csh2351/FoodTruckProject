<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
<section>
	<div class='container'>
		<div class="panel">

			<ul class="nav nav-tabs">
				<li class="active" role="presentation"><a
					href="MyPage_Event.html">이벤트</a></li>
				<li role="presentation"><a href="MyPage_Coupon.html">쿠폰</a></li>
				<li role="presentation"><a href="MyPage_InfoChange.html">회원정보수정</a></li>
				<li role="presentation"><a href="MyPage_Question.html">문의내역</a></li>
			</ul>

			<div class="panel-body">
				<br>
				<h3>이벤트 참여내역</h3>
				<br>
				<table class="table">
					<thead id='tablehead'>
						<tr>
							<td>제목</td>
							<td>이벤트기간</td>
							<td>당첨여부</td>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td>제목</td>
							<td>이벤트기간</td>
							<td>당첨여부</td>

						</tr>
						<tr>
							<td>제목</td>
							<td>이벤트기간</td>
							<td>당첨여부</td>

						</tr>
						<tr>
							<td>제목</td>
							<td>이벤트기간</td>
							<td>당첨여부</td>

						</tr>
					</tbody>
				</table>

				<div class="row">
					<nav>
						<ul class="pagination">
							<li><a href="#"><span aria-hidden="true">«</span><span
									class="sr-only">Previous</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#"><span aria-hidden="true">»</span><span
									class="sr-only">Next</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>