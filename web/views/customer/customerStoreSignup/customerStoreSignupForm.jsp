<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<style>
/*폼 그룹 사이 벌려주는 것 (마진-바텀값으로 조절가능)*/
.form-horizontal .form-group {
   margin-bottom: 30px;
}
</style>

<link rel="stylesheet"
   href="<%=request.getContextPath()%>/css/nav-tabs.css">
<link rel="stylesheet"
   href="<%=request.getContextPath()%>/css/customer.css">
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>  
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
            document.getElementById('truckLocation').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('memberAddressDetail').focus();
        }
    }).open();
}



function fn_enroll_validate()
{
   var truckInfoRegisterNumber=$("#truckInfoRegisterNumber");
   if(truckInfoRegisterNumber.val().length>10)
   {
      alert("사업자번호는 최대9자리까지 입력가능합니다.");
      truckInfoRegisterNumber.focus();
      return false;
   }
   
   if(truckInfoRegisterNumber.val().length==0||truckInfoName.val().length==0||truckLocation.val().length==0){
      alert("공백없이 모두 입력해주세요");
      return false;
   }
   
   return true;
}

</script>
<section>
   <div class='container'>
      <div class="panel">
         <ul class="nav nav-tabs">
            <li role="presentation"><a href="<%=request.getContextPath()%>/customer.do">공지사항</a></li>
            <li role="presentation"><a href="<%=request.getContextPath()%>/customerFAQForm.do">자주묻는 질문</a></li>
            <li class="active" role="presentation"><a href="<%=request.getContextPath()%>/customerStoreSignup.do">점포가입신청</a></li>
         </ul>
         <div class="panel-body">
            <div class="page-header">
               <h2>점포 가입 신청</h2>
            </div>

            <form action="<%=request.getContextPath()%>/storeSignupWrite.do?memberPk=<%=memberLoggedIn.getMemberPk()%>" method="post" class="form-horizontal" onsubmit="return fn_enroll_validate();">
               <div class="form-group">
                  <label class="col-sm-3 control-label" for="">사업자 번호</label>
                  <div class="col-sm-6">
                     <input class="form-control" id="truckInfoRegisterNumber" name="truckInfoRegisterNumber" type="text" placeholder="사업자 번호(필수 입력아님)" onblur="chkNum();">
                     
                  </div>
               </div>
            
               <div class="form-group">
                  <label class="col-sm-3 control-label" for="">상호명</label>
                  <div class="col-sm-6">
                     <input class="form-control" id="truckInfoName " name="truckInfoName" type="text" placeholder="상호명">
                  </div>
               </div>
               
               <div class="form-group">
                  <label class="col-sm-3 control-label" for="truckAddress">푸드트럭 주소</label>
                  <div class="col-sm-3">
                     <input type="text"  class="form-control" id="post" placeholder="우편번호">
                  </div>
                  <div class="col-sm-3">
                     <input type="button" class="btn btn-warning" onclick="Postcode()" value="주소찾기">
                  </div>
                  <div class="col-sm-6">
                     <input type="text" class="form-control" id="truckLocation" name="truckLocation" placeholder="주소"> 
                     <input type="text" class="form-control" id="memberAddressDetail" placeholder="상세주소">
                  </div>
            
               <br> <br> <br> <br>
               <div class="form-group">
                  <div class="col-sm-12 text-center">
                     <input class="btn btn-primary" type="submit" onclick="fn_submit();" value="신청서제출">
                     <input class="btn btn-danger" type="reset" value="취소">
                  </div>
               </div>
            </form>
            
         
         </div>
      </div>
   </div>
</section>

<%@ include file="/views/common/footer.jsp"%>