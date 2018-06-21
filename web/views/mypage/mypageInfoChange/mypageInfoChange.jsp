
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% 
	Member member=(Member)request.getAttribute("member");
%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="css/nav-tabs.css">
<link rel="stylesheet" href="css/customer.css">
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
//현재비밀번호 확인용 ajax
var checkInput=true;

$(function(){
$('#memberPw').blur(function(){
       $.ajax({
          url: "<%=request.getContextPath()%>/mypagePwCheck.do",
            type:"post",
            data:{memberId:$('#memberId').val(), memberPw:$('#memberPw').val()},
            success : function(data){
                  var p1=$("#memberPw").val();
                  if(data=='false'&&p1.length!=0){
                     alert('현재비밀번호와 일치하지 않습니다. 다시입력해주세요');
                      //$("#memberPw").focus();
                     checkInput=true;
                     $("#memberPw").val("");
                  }else{
                     checkInput=false;
                  }       
            }
          });
      });
});
//새비밀번호와 현재비밀번호 일치여부
function fn_pwCheck(){
   var p1=$("#memberPw").val();
   var p2=$("#memberPwNew").val();
   
   if(p1==p2){
   
     $("#pwcheck").css("color","red");
     
      $('#pwcheck').html('현재비밀번호와 일치합니다. 다시입력해주세요');
   }else{
      $('#pwcheck').html('');
   }

}

function fn_pwCheck2(){
      var p1=$("#memberPwNew").val();
      var p2=$("#memberPwNew_2").val();
      
      if(p1==p2){
      
        $("#pwcheck2").css("color","green");
        
         $('#pwcheck2').html('새비밀번호와 일치합니다.');
      }else{
         $('#pwcheck2').html('');
      }

   }


$(function(){
   $("#memberPwNew").blur(function(){
         var p1=$("#memberPw").val();
         var p2=$("#memberPwNew").val();
         var check=false;
         if(p2.length!=0 &&p1==p2){
            $("#memberPwNew").val("");
            $("#memberPwNew").focus();
            check=true;
            alert("현재비밀번호와 일치합니다 다른 비밀번호를 입력해주세요.");
         }
         
         var num = p2.search(/[0-9]/g);

         var eng = p2.search(/[a-z]/ig);

         var spe = p2.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

        if(check==false&&p2.length!=0&&p2.search(/\s/) != -1){
           $("#memberPwNew").val("");
           $("#memberPwNew").focus();
           alert("비밀번호는 공백없이 영문,숫자,특수문자를 조합한 8자 이상 15이상이어야 합니다.");

         }else if(check==false&&p2.length!=0&&(p2.length < 8 || p2.length > 15)){
            $("#memberPwNew").val("");
            $("#memberPwNew").focus();
            alert("비밀번호는 공백없이 영문,숫자,특수문자를 조합한 8자 이상 15이상이어야 합니다.");

         }else if(check==false&&p2.length!=0&&(num < 0 || eng < 0 || spe < 0) ){
            $("#memberPwNew").val("");
            $("#memberPwNew").focus();
            alert("비밀번호는 공백없이 영문,숫자,특수문자를 조합한 8자 이상 15이상이어야 합니다.");

         }else{
 
         }
   });
});

$(function(){
$("#memberPwNew_2").blur(function(){
   var p1=$("#memberPw").val();
   var p2=$("#memberPwNew").val();
   var p3=$("#memberPwNew_2").val();
   
   if(checkInput==true){
      alert("현재 비밀번호를 입력하세요.")
      $("#memberPw").val("");
      $("#memberPwNew_2").val("");
       $("#memberPwNew").val("");
      $("#memberPw").focus();
   }
   
   if(p3.length!=0&&p2!=p3)
   {
      alert("새비밀번호와 일치하지 않습니다.");
      $("#memberPwNew_2").val("");
      $("#memberPwNew").val("");
   }
});

});



//주소찾기 스크립트
function Postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('post').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('memberAddress').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('memberAddressDetail').focus();
        }
    }).open(); 
}
</script>

<section>
   <div class='container'>
      <div class="panel">

         <ul class="nav nav-tabs">
            <li class="active" role="presentation">
            <a href="<%=request.getContextPath()%>/mypageInfoChange.do">회원정보수정</a></li>
            <%if(memberLoggedIn!=null&&memberLoggedIn.getMemberId().equals("admin")){ %>
            <%}else{ %>
            <li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionWrite.do">1대1문의</a></li>      
            <li role="presentation"><a href="<%=request.getContextPath()%>/mypageQuestionForm.do">문의내역</a></li>
            <%} %>
            <li role="presentation"><a href="<%=request.getContextPath()%>/mypageMemberDelete.do">탈퇴</a></li>
         </ul>

         <div class="panel-body">
            <div class="page-header">
               <h1>회원 정보 수정</h1>
            </div>
          
            
            <form class="form-horizontal"  id="memberfrm"  action="<%=request.getContextPath()%>/memberUpdate.do?orimemberPhone=<%=memberLoggedIn.getMemberPhone()%>&oriMemberEmail=<%=memberLoggedIn.getMemberEmail()%>&oriMemberAddress=<%=memberLoggedIn.getMemberAddress()%>" method="post" >
               <div class="form-group">
                  <label class="col-sm-3 control-label" for="memberId">아이디</label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberId" name="memberId" type="text" placeholder="아이디" 
                     value="<%if(member!=null){%><%=member.getMemberId()%><%}else{ %><%=memberLoggedIn.getMemberId() %><%}%>" title="아이디는 변경하실 수 없습니다." readonly>
                  </div>
               </div>


               <div class="form-group">
                  <label class="col-sm-3 control-label" for="memberPw">현재 비밀번호<span> *</span></label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberPw" name="memberPw" type="password" placeholder="비밀번호" required>
                  </div>
               </div>
               
               

               <div class="form-group">
                  <label class="col-sm-3 control-label" for="newmemberPw">새 비밀번호<span> *</span></label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberPwNew" name="memberPwNew" type="password" placeholder="공백없이 영문,숫자,특수문자를 조합한 8~15자의 비밀번호" required
                     oninput="fn_pwCheck();">
                     <p id="pwcheck"></p>
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-sm-3 control-label" for="newmemberPw_2">새 비밀번호 확인<span> *</span></label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberPwNew_2"
                        name="memberPwNew_2" type="password" placeholder="비밀번호 확인" required
                        oninput="fn_pwCheck2();">
                     <p id="pwcheck2"></p>

                  </div>
               </div>

               <div class="form-group">
                  <label class="col-sm-3 control-label" for="memberName">이름</label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberName" name="memberName"
                        type="text" placeholder="이름" value="<%if(member!=null){%><%=member.getMemberName()%><%}else{ %><%=memberLoggedIn.getMemberName() %><%}%>" title="이름은 변경하실 수 없습니다." readonly>
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-sm-3 control-label" for="memberPhone">휴대폰번호</label>
                  <div class="col-sm-6">
                     <input class="form-control" id="memberPhone" name="memberPhone"
                        type="text" placeholder="- 없이 입력해 주세요" value="<%if(member!=null){%><%=member.getMemberPhone()%><%}else{ %><%=memberLoggedIn.getMemberPhone() %><%}%>" required>
                  </div>
               </div>


               <div class="form-group">
                  <label class="col-sm-3 control-label" for="">이메일</label>
                  <div class="col-sm-6">

                     <input type="email" class="form-control" id="memberEmail"
                        name="memberEmail" placeholder="이메일을 입력해 주세요" value="<%if(member!=null){%><%=member.getMemberEmail()%><%}else{ %><%=memberLoggedIn.getMemberEmail() %><%}%>" required>

                  </div>
               </div>

               <div class="form-group">
                  <label class="col-sm-3 control-label" for="memberAddrress"> 주소</label>
                  <div class="col-sm-3">
                     <input type="text" class="form-control" id="post" placeholder="우편번호" value="">
                  </div>
                  <div class="col-sm-3">
                     <input type="button" class="btn btn-warning" onclick="Postcode()"
                        value="주소찾기" >
                  </div>
                  <div class="col-sm-6">
                        <input type="text" class="form-control" id="memberAddress" name="memberAddress" placeholder="주소" value="<%if(member!=null){%><%=member.getMemberAddress()%><%}else{ %><%=memberLoggedIn.getMemberAddress() %><%}%>" required> 
                        <input type="text" class="form-control" id="memberAddressDetail" placeholder="상세주소" value="">
                  </div>
                <br><br><br><br>
               <div class="form-group">
                  <div class="col-sm-12 text-center">
                     <input class="btn btn-primary" type="submit"  value="수정완료" onclick="fn_change_validate();">
                     <input class="btn btn-danger" type="reset" value="취소">
                  </div>
               </div>
            </form>
         
            

         </div>
      </div>
   </div>
</section>

<%@ include file="/views/common/footer.jsp"%>