<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nav-tabs.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">       
<section>
    <div class='container'>
      <div class="panel">

        <ul class="nav nav-tabs">
          <li class="active" role="presentation"><a href="Customer.html">공지사항</a></li>
          <li role="presentation"><a href="Customer_FAQ.html">자주묻는 질문</a></li>
          <li role="presentation"><a href="Customer_One.html">1대1문의</a></li>
          <li role="presentation"><a href="Customer_Store_SignUp.html">점포가입신청</a></li>
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
                <td>작성자</td>
                <td>조회수</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td><a href="Customer_Notice_content.html">안녕하세요</a></td>
                <td><a href="Customer_Notice_content.html">홍길동</a></td>
                <td>20</td>
              </tr>
              <tr>
                <td>2</td>
                <td><a href="Customer_Notice_content.html">안녕하세요</a></td>
                <td><a href="Customer_Notice_content.html">홍길동</a></td>
                <td>30</td>
              </tr>
              <tr>
                <td>3</td>
                <td><a href="Customer_Notice_content.html">안녕하세요</a></td>
                <td><a href="Customer_Notice_content.html">홍길동</a></td>
                <td>40</td>
              </tr>
              <tr>
                <td>3</td>
                <td><a href="Customer_Notice_content.html">안녕하세요</a></td>
                <td><a href="Customer_Notice_content.html">홍길동</a></td>
                <td>40</td>
              </tr>
              <tr>
                <td>3</td>
                <td><a href="Customer_Notice_content.html">안녕하세요</a></td>
                <td><a href="Customer_Notice_content.html">홍길동</a></td>
                <td>40</td>
              </tr>
            </tbody>
          </table>
          <div class="row">
            <div class="form-group">
              <div class="col-sm-12 text-right">
                <button class="btn btn-primary" type="submit"><a href="Customer_Notice_Write.html">등록</a><i class="fa fa-check spaceLeft"></i></button>

              </div>
            </div>
          </div>
          <div class="row">
            <nav>
              <ul class="pagination">
                <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
              </ul>
            </nav>
          </div>
        </div>


      </div>
    </div>
  </section>
 <%@ include file="/views/common/footer.jsp"%>