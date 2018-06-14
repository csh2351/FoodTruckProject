<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/nav-tabs.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/customer.css">
<style>
        #event-input-img {
          position: relative;
          width: 94%;
          cursor: pointer;
          display: inline;
          margin: 0;
        }
        .upload {
          width: 94%;
          opacity: 0;
          position: relative;
          display: inline;
        }
        .event-img-replace{
          display: inline-block;
          position: absolute;
          width: 90%;
          height: 20;
          border-radius: 3px;
          border-color: transparent;
          background: green;
          color: #fff;
          cursor: pointer;
        }
        .event-check-img {
          margin: 0px;
        }
       
  
            @media(max-width:1199px) {
          /*해상도가 작을 때 드랍다운 아이템에 마우스를 올렸을때*/
       
          .event-img-replace{
            width: 87%;
          }
      
        }
        @media(max-width:991px) {
          /*해상도가 작을 때 드랍다운 아이템에 마우스를 올렸을때*/
          .event-img-replace{
            width: 100%;
            height: 20;
          }
          .event-img-replace{
            width: 84%;
          }
          #event-check-img{
            height: 150px;
          }
       
        }
        @media(max-width:700px) {
          /*세부적 해도되고 안해도됨*/
        }
        @media(max-width:480px) {
          /*해상도가 작을 때 드랍다운 아이템에 마우스를 올렸을때*/
          .event-img-replace {
            width: 94%;
            height: 20;
          }
        
          #event-check-img{
            width: 129%;
            height: 150px;
          }
        }
          @media(max-width:480px) {
          /*해상도가 작을 때 드랍다운 아이템에 마우스를 올렸을때*/
          .event-img-replace {
            width: 94%;
            height: 20;
          }
       
          #event-check-img{
            width: 129%;
            height: 130px;
          }
  
        }
      
    </style>
<section>
        <div class='container'>
            <div class="panel">
              
                <ul class="nav nav-tabs">
                      <li class="active" role="presentation"><a href="<%=request.getContextPath()%>/eventForm.do">이벤트</a></li>
                <li role="presentation"><a href="<%=request.getContextPath()%>/eventCouponForm.do">쿠폰</a></li>
                </ul>

                     <div class="panel-body">
                            <div class="page-header">
                                    <h2> 이벤트 수정</h2>
                            </div>
                            <form class="form-horizontal">
                                    
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label" for="">작성자 </label>
                                    <div class="col-sm-6">
                                      <input class="form-control" type="text" placeholder="아이디" width="100">
                                    </div>
                                    </div>
        
                                    
                                  <div class="form-group">
                                        <label class="col-sm-3 control-label" for="">제목 </label>
                                      <div class="col-sm-6">
                                        <input class="form-control" type="text" placeholder="제목을 입력하세요.">
                                      </div>
                                    </div>
        
                                    <div class="form-group">
                                       
                                        <label for="" class="col-sm-3 control-label">내 용 </label>
                                        <div class="col-sm-6">
                                                <textarea class="form-control" rows="13" style="resize: none;"></textarea>
                                        </div>
                                    
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-xs-3 control-label">사진등록 </label>
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-3">
                                          <img id='event-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100>
                                          <br>
                                          <div class="">
                                          </div>
                                          <button class="event-img-replace">사진등록</button>
                                          <input id='event-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='truck-img'>
                                        </div>
                          
                                      </div>
                                    <br>
                                    <div class="row">
                                        <div class="form-group">
                                          <div class="col-sm-12 text-center">
                                            <button class="btn btn-primary" type="submit">수정하기<i class="fa fa-check spaceLeft"></i></button>
                                            <button class="btn btn-danger" type="submit">취소<i class="fa fa-times spaceLeft"></i></button>
                                          </div>
                                        </div>
                                      </div>
                            </form>
                           
                        </div>
            </div>
        </div>
    </section>


<%@ include file="/views/common/footer.jsp"%>