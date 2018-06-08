<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
    <div class="container">
      <div class="row" id='row_padding'>
        <div class="col-md-5">
          <p>홈><span>(지역 입력)</span>지역에 총<span>(검색된수 입력)</span>개의 푸드트럭이 검색</p>
        </div>
        <div class="col-md-7">
          <div class="form-group nav navbar-nav">
            <select class="form-control" id="sel1">
                                   <option>추천순</option>
                                   <option>영업순</option>
                                   <option>리뷰순</option>
                                   <option>이벤트순</option>
              </select>
          </div>
          <div class="input-group">
            <span class="input-group-addon" id="sizing-addon2">현재위치</span>
            <input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon2">
          </div>
        </div>
      </div>
      <div class='row'>
        <ul class='store_ul'>
          <!--클릭리스너 만들기-->
          <li class='store_list'>
            <div class="col-sm-6 col-md-4 padding">
              <div class="thumbnail thumnail-botton">
                <div class="col-xs-12">
                    <br>
                </div>

                <div class="col-xs-8" align="left">
                    <span class='truck_name'>점포명</span>
                </div>
                <div class="col-xs-4">
                  <!--고정값으로 할수있는 checkd찾기-->
                  <div class="onoffswitch">
                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
                <label class="onoffswitch-label" for="myonoffswitch">
                    <span class="onoffswitch-inner"></span>
                    <span class="onoffswitch-switch"></span>
                  </label>
                  <!--클릭이벤트제거-->
            </div>
                    <!--고정값으로 할수있는 checkd찾기-->

                </div>
                <div class="col-xs-5">
                  <br>
                  <img src="http://proxyprivat.com/images/noimage.jpeg" alt="" class='img_size'>
                </div>
                <div class="col-xs-7">
                  <br>
                  <p>주소</p>
                  <p>평점</p>
                  <p>평균금액</p>
                </div>
                <div class='col-xs-4'></div>
                <div class='col-xs-4'></div>
                <div class='col-xs-4'></div>
                <!--지우지마셈 꺠짐-->
                <div>
                  <a>&nbsp;</a>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
  </section>

  <script>


      //on/off스위치
      $("#myonoffswitch").on('click', function(e) {
          e.preventDefault();
        })
        // 눌럿을떄 바로 이동
        $(".store_list").click(function() {
            location.href="FoodTruck_Menu.html";
        });
      
      </script>
