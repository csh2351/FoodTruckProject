<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%
   String memberEmail = request.getParameter("memberEmail");
%>



<section>
   <article class="container">
   <form action="<%=request.getContextPath()%>/" name="emailCheckFrm" method="post">
      <div class="form-group" style="text-align:center;">
         <input type="text" class="form-control" name="emailCode" id="emailCode" placeholder="인증번호를 입력하세요">&nbsp;&nbsp;
         <button type="button" onclick="fn_emailcheck();">인증확인</button>      
      </div>
         
   </form>      
   </article>
</section>
 <script>
 var code = "";
  $(function(){
   $.ajax({
      url:'<%=request.getContextPath()%>/emailServlet.do',   //서블릿
      type : 'post',//타입
      data : {
         memberEmail : "<%=memberEmail%>"
      },
      dataType : 'text', // 
      success: function(data) {
         
         code=data;
      }
   });
  });
  
   function fn_emailcheck(){
      localStorage.setItem("result",false);
      var e1 = $("#emailCode").val();
      var e2 = code;
      
      if(e1==e2&&!(e1.length==0)){
         alert("이메일인증성공");
         localStorage.setItem("result",true);
         window.close();
      }else {
         alert("이메일인증실패");
      }
   }
</script>