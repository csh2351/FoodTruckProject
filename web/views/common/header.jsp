<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="member.model.vo.Member"%>
<%
	Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");

%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">
  <!-- 푸터아이콘에 필요한것 -->
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/navbar.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/truckStar.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
  <script src='js/bootstrap.js'></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDmfjiMcgfcCVI6QKs42Kk4AvHUVdOQtso"></script>
	
  <title>Main</title>

</head>

<body>


  <nav class="navbar">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
         </button>
        <div class="logo">
          <a class="navbar-brand" href="<%=request.getContextPath() %>/">HOME</a>
        </div>
      </div>

	
      <div class="collapse navbar-collapse" id='bs-example-navbar-collapse-1'>
        <ul class="nav navbar-nav">
          <li><a href="<%=request.getContextPath() %>/intro.do">소개<span class='sr-only'></span></a></li>
          <li><a href="<%=request.getContextPath() %>/truckStore.do">STORE</a></li>
          <li><a href="<%=request.getContextPath() %>/eventForm.do">EVENT</a></li>
          <li><a href="<%=request.getContextPath() %>/customer.do">고객센터</a></li>
          <%if (memberLoggedIn!=null) {%>
          
          <%if(memberLoggedIn.getMemberLevel().equals("1")) {%>
          <li><a href="<%=request.getContextPath() %>/adminStoreManagementForm.do">개발자영역</a></li>
          <%}if(memberLoggedIn.getMemberLevel().equals("1")||memberLoggedIn.getMemberLevel().equals("2")) {%>
          <li><a href="<%=request.getContextPath() %>/managestore.do">점포관리</a></li>
          <%} }%>
        </ul>
        
        <form action="<%=request.getContextPath() %>/" method="post" class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <select class="form-control" name="">
              <option value="">지역명</option>
              <option value="">상호명</option>
            </select>
          </div>
          <div class="form-group">
            <input type="text" name="search" class="form-control" placeholder="음식명/상호명을 입력하세요">
          </div>
          <button type="submit" class="btn btn-default">검색</button>
        </form>

<% if(memberLoggedIn==null) { %>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="<%=request.getContextPath() %>/join.do"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
          <li><a href="<%=request.getContextPath() %>/login.do"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
        </ul>
 <% }
else if(memberLoggedIn.getMemberLevel().equals("3")){
	%>
	<ul class="nav navbar-nav navbar-right">
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do"><span class="glyphicon glyphicon-user"></span><%= memberLoggedIn.getMemberName() %>님</a></li>
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do">마이페이지</a></li>
          <li><a href="<%=request.getContextPath() %>/logout.do"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
     </ul>
	<% }
else if(memberLoggedIn.getMemberLevel().equals("1")){
	%>
	<ul class="nav navbar-nav navbar-right">
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do"><span class="glyphicon glyphicon-user"></span><%= memberLoggedIn.getMemberName() %>관리자님</a></li>
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do">마이페이지</a></li>
          <li><a href="<%=request.getContextPath() %>/logout.do"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
     </ul>
	<% }
	else if(memberLoggedIn.getMemberLevel().equals("2")) {%>
		<ul class="nav navbar-nav navbar-right">
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do"><span class="glyphicon glyphicon-user"></span><%= memberLoggedIn.getMemberName() %>점주님</a></li>
		  <li><a href="<%=request.getContextPath() %>/mypageInfoChange.do">마이페이지</a></li>
          <li><a href="<%=request.getContextPath() %>/logout.do"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
     </ul>
     <% } %>
      </div>
    </div>
  </nav>