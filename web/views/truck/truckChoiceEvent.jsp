<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckEvent.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/event.css">
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">


  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
 
 
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;이벤트</p>
                  </div>
                  <table class="table">
                                <thead id='tablehead'>
                                        <tr>
                                            <td>번호</td>
                                            <td>제목</td>
                                            <td>기간</td>
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>
                                            <!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>
												<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                        <tr>
                                          	<td>2</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>												<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                     	<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                </tbody>
                            </table>
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



