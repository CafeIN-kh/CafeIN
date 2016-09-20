<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <section id="content">
                <div class="container">
                    
                    <div class="block-header">
                        <h2>개인카페 정보 조회 및 수정하기 <small>개인카페 정보를 조회하고 수정할 수 있는 메뉴입니다.</small></h2>
                        
                        <ul class="actions m-t-20 hidden-xs">
                            <li class="dropdown">
                                <a href="" data-toggle="dropdown">
                                    <i class="md md-more-vert"></i>
                                </a>
                    
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li>
                                        <a href="">Privacy Settings</a>
                                    </li>
                                    <li>
                                        <a href="">Account Settings</a>
                                    </li>
                                    <li>
                                        <a href="">Other Settings</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="card" id="profile-main">
                        <div class="pm-overview c-overflow">
                          <%--   <div class="pmo-pic">
                                <div class="p-relative">
                                    <a href="">
                                        <img src="${pageContext.request.contextPath}/upload/${privateCommandmenu.pcafe_img}" alt=""> 
                                    </a> <div class="col-sm-1"> 
                                    <div class="fileinput fileinput-new" data-provides="fileinput">
                                        <span class="btn btn-primary btn-file m-r-10">
                                            <span class="fileinput-new"><i class="md md-insert-photo"></i></span>
                                            <span class="fileinput-exists">Change</span>
                                            <input type="file" name="...">
                                        </span>
                                        <span class="fileinput-filename"></span>
                                        <a href="#" class="close fileinput-exists" data-dismiss="fileinput">&times;</a>
                                    </div>
                                </div>
                                    
                              
                                    

                                </div>
                            
                                
                                <div class="pmo-stat">
                                    <h2 class="m-0 c-white"> ${privateCommandmenu.pcafe_visit}</h2>
                                    	&nbsp;&nbsp;&nbsp; 좋아요
                                </div>
                            </div> --%>
                            <div class="pmo-pic">
                     
							<div class="fileinput fileinput-new" data-provides="fileinput">
								<div class="fileinput-preview thumbnail"
									data-trigger="fileinput">
									<img src="${pageContext.request.contextPath}/upload/${privateCommandmenu.pcafe_img}" alt=""> 
								</div>
								<div style="display:none;">
									<span class="btn btn-info btn-file"> <span
										class="fileinput-new"></span> <span
										class="fileinput-exists"></span> <input type="file"
										name="upload">
									</span> <a href="#" class="btn btn-danger fileinput-exists"
										data-dismiss="fileinput"></a>
								</div>
							</div>



                     <div class="pmo-stat">
                     <%-- <c:forEach items="${list1 }" var="list1"> --%>
                        <h6 class="m-0 c-white">${privateCommandmenu.pcafe_visit}<br>조회수</h6>
                   
                     <%-- </c:forEach> --%></div>
                     <div class="m-t-10">
								<button type="submit" class="btn btn-primary btn-sm">save<i class="md md-insert-photo"></i></button>

								<!-- <a href="profile-connections.html">&nbsp;&nbsp;&nbsp;Cancel</a> -->
								<!-- <button data-pmb-action="reset" class="btn btn-link btn-sm"><a href="profile-connections.html">Cancel</a></button> 
										 -->

							</div>
                  </div>
                            
                            <div class="pmo-block pmo-contact hidden-xs">
                                <h2>Contact</h2>
                                
                                <ul>
                                    <li><i class="md md-phone"></i><h5> ${privateCommandmenu.pcafe_name}</h5></li>
                                    <li><i class="md md-email"></i> ${privateCommandmenu.pcafe_address}</li>
                                    <li><i class="socicon socicon-skype"></i> ${privateCommandmenu.pcafe_phone}</li>
                                    <li><i class="socicon socicon-twitter"></i> ${privateCommandmenu.pcafe_time}</li>
                                    <li>
                                        <i class="md md-location-on"></i>
                                        <address class="m-b-0">
                                           		${privateCommandmenu.pcafe_hash_tag},${privateCommandmenu.pcafe_hash_tag} <br/>
                                            	${privateCommandmenu.pcafe_hash_tag},${privateCommandmenu.pcafe_hash_tag} <br/>
                                            	${privateCommandmenu.pcafe_hash_tag},${privateCommandmenu.pcafe_hash_tag}
                                        </address>
                                    </li>
                                </ul>
                            </div>
                            
                            <div class="pmo-block pmo-items hidden-xs">
                                <h2>Connections</h2>
                                
                                <h5>좋아요를 눌른 아이디</h5>
                                
                                <div class="pmob-body">
                                    <div class="row">
                                 	    <code>.m-b-0</code>
                                 	      <code>.m-b-0</code>
                                 	        <code>.m-b-0</code>
                                 	          <code>.m-b-0</code>
                                 	            <code>.m-b-0</code>
                                 	              <code>.m-b-0</code>
                                 	                <code>.m-b-0</code>
                                 	                  <code>.m-b-0</code>
                                 	                    <code>.m-b-0</code>
                                 	                      <code>.m-b-0</code>
                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="pm-body clearfix">
                            <ul class="tab-nav tn-justified">
                                <li class="waves-effect"><a href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe-detail.do?pcafe_num=${privateCommandmenu.pcafe_num}">개인카페</a></li>
                                <li class="active waves-effect"><a href="${pageContext.request.contextPath}/admin/privatecafe/privatecafemenu.do?pcafe_num=${privateCommandmenu.pcafe_num}">개인카페메뉴</a></li>
                            </ul>
                            
                            <div class="pmb-block">
                                <div class="p-header">
                                    <ul class="p-menu">
                                        
                                        <li><a href=""><i class="md md-people hidden-xs"></i> 카페메뉴 검색</a></li>
                                        <li class="pm-search">
                                            <div class="pms-inner">
                                                <i class="md md-search"></i>
                                                <input type="text" placeholder="Search...">
                                            </div>
                                        </li>
                                    </ul>
                                    
                                    <ul class="actions m-t-20 hidden-xs">
                                        <li class="dropdown">
                                            <a href="" data-toggle="dropdown">
                                                <i class="md md-more-vert"></i>
                                            </a>
                                
                                            <ul class="dropdown-menu dropdown-menu-right">
                                                <li>
                                                    <a href="">Refresh</a>
                                                </li>
                                               <!--  <li>
                                                    <a href="">Settings</a>
                                                </li> -->
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                                
                                  <div class="contacts clearfix row">
                                <c:forEach items="${listmenu }" var="listmenu">
              
                                    <div class="col-md-3 col-sm-6 col-xs-6">
                                        <div class="c-item">
                                            <a href="" class="ci-avatar">
                                                <img src="${pageContext.request.contextPath}/upload/${listmenu.pmenu_img}" alt="">
                                           
                                            </a>
                                            
                                            <div class="c-info">
                                                <strong>${listmenu.pmenu_name}</strong>
                                                <small>${listmenu.pmenu_price}원</small>
                                            </div>
                                            
                                            <div class="c-footer">
                                                <a href="${pageContext.request.contextPath}/admin/privatecafe/privatecafemenu-modify.do?pmenu_num=${listmenu.pmenu_num}"><button class="waves-effect"><i class="md md-person-add"></i> 수정하기</button></a>
                                            </div>
                                        </div>
                                    </div>
                                    
                                   
                                  
                             
                                </c:forEach>
                                   </div>
                                
                                <div class="load-more">
                                    <a href=""><i class="md md-refresh"></i> Load More...</a>
                                </div>	
                            </div>
                        </div>
                    </div>
                </div>
            </section>
