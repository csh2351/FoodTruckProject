<%@page import="org.apache.catalina.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="truck.vo.TruckMenu"%>
<%@page import="truck.vo.Truck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ArrayList<TruckMenu>menuList=(ArrayList<TruckMenu>)request.getAttribute("menuList");
 int temp=0;
 int truckPk=(int)request.getAttribute("truckPk");%>	

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/manageTruck.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/foodTruckMenu.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/foodTruckReview.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/all.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<div class="page-header">
	<p style="font-size: 14pt; font-weight: bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
</div>




<ul id='comment-main'>
<%if(menuList.size()>0){ 
	for(int i=0; i<menuList.size(); i++){%>
	<li id="addr<%=i%>">
		<form action="<%=request.getContextPath()%>/truckMenuUpdateEnd" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-xs-9">
					<br>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
							    <input name="menuName" class="form-control" type="text" value="<%=menuList.get(i).getMenuName()%>"><br>
								<input name="menuPrice" class="form-control" type="number" value="<%=menuList.get(i).getMenuPrice()%>">
							    <input type="hidden" name="menuPk" value="<%=menuList.get(i).getMenuPk()%>" />
							    <input type="hidden" name="truckPk" value="<%=truckPk%>" />
								<input type="hidden" name="old_file" value="<%=menuList.get(i).getMenuRimage()%>" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-3 col-md-3-body-center">
				 <%if(menuList.get(i).getMenuRimage()!=null){ %>
					<img id="menu-check-img<%=i%>" class="menu-check-img"
						src="images/truckMenu/<%=menuList.get(i).getMenuRimage()%>"
						alt="Card image cap" style="width: 81%;height: 100px"><br>
				 <%}else{ %>
					<img id="menu-check-img<%=i%>" class="menu-check-img"
						src="http://proxyprivat.com/images/noimage.jpeg"
						alt="Card image cap" style="width: 81%;height: 100px"><br>
				 <%} %>
					<button class="btn-success menu-img-replace">사진등록</button>
					<div class="test">
						<input id="menu-input-img<%=i%>" type="file" value="사진등록"
							class="upload menu-input-img"
							accept="image/gif, image/jpeg, image/png" name="up_file" style="width: 82%; height: 33px;"
							onclick="view_img(this)">
					</div>
					<br>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 result-btn-positon">
					<button id="result-button<%=i%>" class="btn btn-success result-btn"
						type="submit">완료</button>
					<button id="menu-reset-btn<%=i%>" class="btn btn-success result-btn"
						type="reset" onclick="reset_img(this)">취소</button>
					<hr>
				</div>
			</div>
		</form>
	</li>
<%
	//마지막 인덱스 카운터변수
	temp=i;
	}
	}else{%>
	<li id="addr0">
		<form action="<%=request.getContextPath()%>/truckMenuInsertEnd" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-xs-9">
					<br>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<input name="menuName" class="form-control" type="text" placeholder="메뉴입력" required="required"><br> 
								<input name="menuPrice" class="form-control" type="number" placeholder="가격입력" required="required">
							 	<input type="hidden" name="truckPk" value="<%=truckPk%>" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-3 col-md-3-body-center">
					<img id="menu-check-img0" class="menu-check-img"
						src="http://proxyprivat.com/images/noimage.jpeg"
						alt="Card image cap" style="width: 81%;height: 100px"><br>
					<button class="btn-success menu-img-replace">사진등록</button>
					<div class="test">
						<input id="menu-input-img0" type="file" value="사진등록"
							class="upload menu-input-img"
							accept="image/gif, image/jpeg, image/png" name="up_file" style="width: 82%; height: 33px;"
							onclick="view_img(this)" required="required">
					</div>
					<br>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 result-btn-positon">
					<button id="result-button0" class="btn btn-success result-btn"
						type="submit">완료</button>
					<button id="menu-reset-btn0" class="btn btn-success result-btn"
						type="reset" onclick="reset_img(this)">취소</button>
					<hr>
				</div>
			</div>
		</form>
	</li>
<%} %>
</ul>


<div align="center">
	<button id="addBtn" type="button" class='btn'>+</button>
	<button id="addBtnRemove" type="button" class='btn'>-</button>
</div>

<script type="text/javascript">
	function view_img(input) {

		var id = $(input).attr('id');
		var idIndex = id.charAt(id.length - 1);
		var checkimg = "menu-check-img" + idIndex;

		var menu_check_img = document.getElementById(checkimg); //menu_check_img
		var menu_input_img = document.getElementById(id); //menu_input_img

		console.log(menu_check_img);
		console.log(menu_input_img);
		console.log(menu_input_img.files);
		//여기도 잘찍힘.ㅎㅎ

		$(menu_input_img).on('change', function() {
			console.log(this.files);
			readURL_menu_img(this, menu_check_img);
			console.log(this);
		});
	}

	function readURL_menu_img(input, menu_check_img) {
		console.log(menu_check_img);
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				menu_check_img.setAttribute('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
	//메뉴 사진 미리보기 스크립트.
	
	//취소 스크립트

	function reset_img(reset_btn) {

		var id = $(reset_btn).attr('id');
		var idIndex = id.charAt(id.length - 1);
		var checkimg = "menu-check-img" + idIndex;

		var menu_check_img = document.getElementById(checkimg); //menu_check_img
		var reset_btn = document.getElementById(id); //menu_input_img

		console.log(menu_check_img);
		console.log(reset_btn);

		menu_check_img.setAttribute("src","http://proxyprivat.com/images/noimage.jpeg");

	}

	//메뉴 사진 미리보기 스크립트.

	//누르면추가
	 $(function() {
		var i = <%=temp%>;
		var list;
		$("#addBtn").click( function() {
							list = $('<li id='
									+ "addr"
									+ (i + 1) 
									+ '><form action="<%=request.getContextPath()%>/truckMenuInsertEnd" method="post"  enctype="multipart/form-data"><div clas="row"><div class="col-xs-9"><br><div class="row"><div class="col-xs-12"><div class="form-group"><input name="menuName"class="form-control" type="text" placeholder="메뉴입력"><br><input name="menuPrice" class="form-control" type="number" placeholder="가격입력"><input type="hidden" name="truckPk" value="<%=truckPk%>" /></div></div></div></div><div class="col-xs-3 col-md-3-body-center"><img id='
									+ "menu-check-img"
									+ (i + 1)
									+ ' class="menu-check-img" src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=81% height=100><br><button class="btn-success menu-img-replace">사진등록</button><div class="test"><input id='
									+ "menu-input-img"
									+ (i + 1)
									+ ' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name="up_file"  style="width: 82%; height: 33px;" onclick="view_img(this)" required="required"></div></div></div><div class="row"><div class="col-xs-12 result-btn-positon"><button id='+"result-button"+(i+1)+' class="btn btn-success result-btn" type="submit">완료</button> <button id='
									+ "menu-reset-btn" + (i + 1)
									+ ' class="btn btn-success result-btn" type="reset" onclick="reset_img(this)">취소</button><hr></div></div></form></li>');
							$('#comment-main').append(list);
							i++;
						});

		$('#addBtnRemove').click(function() {
			var menuRemove=confirm("삭제하시겠습니까?");
			if(menuRemove==true){
				$("#addr" + (i)).remove();
				i--;
			}
			//ajax처리
		})
		
		
	}); 
	
	
	
	 
	
	<%--  $(function() {
		var i = <%=temp%>;
		$("#addBtn").click( function() {
			var list=$('<li id='+ "addr"+ (i + 1)+ '><li>');
			var html='<form action="#" method="get"><div class="row"><div class="col-xs-9"><br>';
			html+='<div class="row"><div class="col-xs-12"><div class="form-group">';
			html+='<input name="menu-name"class="form-control" type="text" placeholder="메뉴입력"><br>';
			html+='<input name="menu-price" class="form-control" type="text" placeholder="가격입력">';
			html+='</div></div></div></div>';
			html+='<div class="col-xs-3 col-md-3-body-center">';
			html+='<img id='+ "menu-check-img"+ (i + 1)+ ' class="menu-check-img" src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=81% height=100><br>';
			html+='<button class="btn-success menu-img-replace">사진등록</button>';
			html+='<div class="test"><input id='+ "menu-input-img"+ (i + 1)+ ' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name="menu-img"  style="width: 82%; height: 33px;" onclick="view_img(this)">';
			html+='</div></div></div><div class="row"><div class="col-xs-12 result-btn-positon">';
			html+='<button id="result-button" class="btn btn-success result-btn" type="submit">완료</button> ';
			html+='<button id='+ "menu-reset-btn"+ (i + 1)+' class="btn btn-success result-btn" type="reset" onclick="reset_img(this)">취소</button>';
			html+='<hr></div></div></form>';
			list.html(html);
			$('#comment-main').append(list);
			i++;
		});

		$('#addBtnRemove').click(function() {
			$("#addr" + (i)).remove();
			i--;
		})
	});  --%>
</script>
