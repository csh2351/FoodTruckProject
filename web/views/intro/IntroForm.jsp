<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>    
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/introduction.css">
<!-- Services section -->
  <section id="what-we-do">
       
    <div class="container-fluid">
      <h2 class="section-title mb-2 h1">What we do</h2>
      <p class="text-center text-muted h5">Food Truck Guide</p>
      <div class="row mt-5">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">
          <div class="card">
            <div class="card-block block-1">
              <h3 class="card-title">실시간 위치 제공</h3>
              <p class="card-text">푸드트럭의 실시간 위치 장소를 제공해줍니다.</p>
              <a href="javascript:void();" title="Read more" class="read-more">more<i class="fa fa-angle-double-right ml-2"></i></a>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">
          <div class="card">
            <div class="card-block block-2">
              <h3 class="card-title">맛집리스트</h3>
              <p class="card-text">푸드트럭의 실시간 인기순위, 맛집정보를 제공해줍니다.</p>
              <a href="javascript:void();" title="Read more" class="read-more">more<i class="fa fa-angle-double-right ml-2"></i></a>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">
          <div class="card">
            <div class="card-block block-3">
              <h3 class="card-title">시간,메뉴 제공</h3>
              <p class="card-text">푸드트럭의 휴무일 메뉴판 가격을 한눈에 볼수 있습니다.</p>
              <a href="javascript:void();" title="Read more" class="read-more">more<i class="fa fa-angle-double-right ml-2"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- /Services section -->

  <!-- Team -->
  <section id="team" class="pb-5">
      <div class="container">
          <h5 class="section-title h1">OUR TEAM</h5>
          <div class="row">
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img src="images/intro/captin.jpg" class=" img-fluid"  alt="card image"></p>
                                      <h4 class="card-title">박혜은</h4>
                                      <p class="card-text">Team Leader</p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">박혜은</h4>
                                      <p class="card-text">전반적 프론트엔드와 로그인,회원가입,회원정보수정,탈퇴,암호화,점포가입신청 기능구현</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img src="images//intro/iron.jpg" class=" img-fluid"  alt="card image"></p>
                                      <h4 class="card-title">김재홍</h4>
                                      <p class="card-text">The old man</p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">김재홍</h4>
                                      <p class="card-text">전반적인 프론트엔드와 공지사항 1대1문의 이벤트 게시판, 검색 기능구현</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img src="images/intro/doctor.jpg" class=" img-fluid" alt="card image"></p>
                                      <h4 class="card-title">최승훈</h4>
                                      <p class="card-text">Broken heart</p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">최승훈</h4>
                                      <p class="card-text">데이터베이스 기획 및 설계와 MAP API기능적용</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img src="images/intro/antman.jpg" class=" img-fluid" alt="card image"></p>
                                      <h4 class="card-title">홍성진</h4>
                                      <p class="card-text">I am on diet</p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">홍성진</h4>
                                      <p class="card-text">메인화면 푸드트럭리스트 Store, 점포관리 기능구현</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_05.png" alt="card image"></p>
                                      <h4 class="card-title">장민오</h4>
                                      <p class="card-text">도중하차 (취업부럽다)                                                                     </p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">장민오</h4>
                                      <p class="card-text">DB설계 MAP API하는중에 취업으로 인한 중도하차</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->
              <!-- Team member -->
              <div class="col-xs-12 col-sm-6 col-md-4">
                  <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                      <div class="mainflip">
                          <div class="frontside">
                              <div class="card">
                                  <div class="card-body text-center">
                                      <p><img src="images/intro/tanos.jpg" class=" img-fluid"  alt="card image"></p>
                                      <h4 class="card-title">안지훈</h4>
                                      <p class="card-text">A weak person</p>
                                      <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                  </div>
                              </div>
                          </div>
                          <div class="backside">
                              <div class="card">
                                  <div class="card-body text-center mt-4">
                                      <h4 class="card-title">안지훈</h4>
                                      <p class="card-text">자주묻는질문,이벤트기능구현, 문서 작업기능담당</p>
                                      <ul class="list-inline">
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-facebook"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-twitter"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-skype"></i>
                                              </a>
                                          </li>
                                          <li class="list-inline-item">
                                              <a class="social-icon text-xs-center" target="_blank" href="#">
                                                  <i class="fa fa-google"></i>
                                              </a>
                                          </li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- ./Team member -->

          </div>
      </div>
  </section>
  <!-- Team -->
  <%@ include file="/views/common/footer.jsp"%>