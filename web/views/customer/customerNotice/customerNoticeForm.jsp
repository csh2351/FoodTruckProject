<%@page import="customerNotice.model.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int cPage=(int)request.getAttribute("cPage");
int numPerPage=(int)request.getAttribute("numPerPage");
String pageBar=(String)request.getAttribute("pageBar");
List<Notice> noticeList=(List)request.getAttribute("noticeList");

%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">       
<section>
    <div class='container'>
      <div class="panel">
		<script>
		function fn_log(){
			alert("점주 가입신청은 로그인후 이용가능합니다.");
		}
		</script>
        <ul class="nav nav-tabs">
          <li class="active" role="presentation"><a href="<%=request.getContextPath() %>/customer.do">공지사항</a></li>
          <li role="presentation"><a href="<%=request.getContextPath()%>/customerFAQForm.do">자주묻는 질문</a></li>
          <%if(memberLoggedIn==null){ %>
          	<li role="presentation"><a href="<%=request.getContextPath()%>/customer.do" onclick="fn_log();">점포가입신청</a></li>
          <%}else{ %>
          	<li role="presentation"><a href="<%=request.getContextPath()%>/customerStoreSignup.do">점포가입신청</a></li>
          <%} %>
        </ul>
        <div class="panel-body">
          <br>
          <h2>공지사항</h2>
          <br>

          <table class="table">
            <thead id='tablehead'>
              <tr>
                <td>번호</td>
                <td>제목</td>
                <td>등록 날짜</td>
               
              </tr>
            </thead>
            <tbody>
            	<%if(noticeList==null){ %>
            		<p>검색 결과가 없습니다.</p>
            	<%}else{
            		for(Notice n: noticeList){%>		
              <tr>
                <td><%=n.getNoticePk() %></td>
                <td><a href="<%=request.getContextPath()%>/customerNoticeContent.do?noticePk=<%=n.getNoticePk()%>"><%=n.getNoticeTitle() %></a></td>
                <td><%=n.getNoticeDate()%></td>
             
               
              </tr>
            <%}} %>
             
            </tbody>
          </table>
          <%if(memberLoggedIn==null) {%>
          <%}else if(memberLoggedIn!=null){
          	if(memberLoggedIn.getMemberLevel().equals("1")){ %>
          <div class="row">
            <div class="form-group">
              <div class="col-sm-12 text-right">
                <button class="btn btn-primary" type="button" onclick="location.href='<%=request.getContextPath()%>/customerNoticeWrite.do'">등록<i class="fa fa-check spaceLeft"></i></button>

              </div>
            </div>
          </div>
          <%}} %>
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