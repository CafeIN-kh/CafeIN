<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside id="sidebar">
               <div class="sidebar-inner">
			<div class="si-inner">
				<div class="profile-menu">
					<a href="">
						<div class="profile-pic">
						   <img src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/pro8.png" alt="">
						</div>
						
						<div class="profile-info">
							Malinda Hollaway <i class="md md-arrow-drop-down"></i>
						</div>
					</a>

					<ul class="main-menu">
						<li><a href="profile-about.html"><i class="md md-person"></i>
								View Profile</a></li>
						<li><a href=""><i class="md md-settings-input-antenna"></i>
								Privacy Settings</a></li>
						<li><a href=""><i class="md md-settings"></i> Settings</a></li>
						<li><a href=""><i class="md md-history"></i> Logout</a></li>
					</ul>
				</div>
				<ul class="main-menu">   
					<li class="active"><a href="${pageContext.request.contextPath }/admin/main.do"><i
							class="md md-home"></i> Home</a></li>
					<li class="sub-menu"><a href=""><i
							class="md md-perm-identity"></i> management</a>

						<ul>
						<!-- 같은경로  -->
						
							<li><a href="${pageContext.request.contextPath }/admin/memberlist.do">User Data Tables</a></li>
							<li><a href="${pageContext.request.contextPath }/admin/declaredlist.do">report Board</a></li>
						</ul></li>
						
						
						
						
						
						<li class="sub-menu"><a href=""><i
							class="md md-now-widgets"></i>Customizing Cafe</a>

						<ul>
							<li><a href="">Customizing Cafe</a></li>
							<li><a href="">Customizing LogList</a></li>
						</ul></li>
						
					<li class="sub-menu"><a href=""><i class="md md-now-widgets"></i>Franchise_Cafe AdminPage</a>
						<ul>
							<li class="sub-menu"><a href=""><i class="md md-now-widgets"></i>Franchise_Cafe AdminPage</a>
								<ul><li style="list-style: none; text-align: right; padding-right: 2px;"><a href="${pageContext.request.contextPath }/cafein_admin/franchise/franchise_brandList.do">Franchise Write & inquiry</a></li>
						</ul>
							</li>
							<li><a href="${pageContext.request.contextPath }/cafein_admin/franchise/franchise_brandList.do">Franchise Write & inquiry</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/franchise/franchise_brandLogList.do">Franchise LogList</a></li>
						</ul>
					</li>
					
					<li class="sub-menu"><a href=""><i class="md md-now-widgets"></i>Private_Cafe AdminPage</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe.do">Private Cafe</a></li>
							<li><a href="">Private LogList</a></li>
						</ul>
					</li>
					
					
						
						
					<li class="sub-menu"><a href=""><i class="md md-view-list"></i>Notice & QnA</a>
					
						<ul>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/notice/List.do">Notice</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/event/List.do">Event</a></li>
							<li><a  href="${pageContext.request.contextPath}/cafein_admin/qna/List.do">Q&A Pages</a></li>
						</ul>
						
						</li>
						
						<li>
                                <a href="${pageContext.request.contextPath}/cafein_admin/admin_notice/List.do"><i class="md md-announcement"></i> Admin Notice</a>
                               
                            </li>
<%-- 
					<li class="active"><a href="${pageContext.request.contextPath}/cafein_admin/qna/List.do"><i
							class="md md-content-copy"></i> Q&A Pages</a></li> --%>
				</ul>
			</div>
		</div>
            </aside>
            <%-- 
            <aside id="chat">
                <ul class="tab-nav tn-justified" role="tablist">
                    <li role="presentation" class="active"><a href="#friends" aria-controls="friends" role="tab" data-toggle="tab">Friends</a></li>
                    <li role="presentation"><a href="#online" aria-controls="online" role="tab" data-toggle="tab">Online Now</a></li>
                </ul>
            
                <div class="chat-search">
                    <div class="fg-line">
                        <input type="text" class="form-control" placeholder="Search People">
                    </div>
                </div>
                
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="friends">
                        <div class="listview">
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/2.jpg" alt="">
                                        <i class="chat-status-busy"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Jonathan Morris</div>
                                        <small class="lv-small">Available</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/1.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">David Belle</div>
                                        <small class="lv-small">Last seen 3 hours ago</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/3.jpg" alt="">
                                        <i class="chat-status-online"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Fredric Mitchell Jr.</div>
                                        <small class="lv-small">Availble</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/4.jpg" alt="">
                                        <i class="chat-status-online"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Glenn Jecobs</div>
                                        <small class="lv-small">Availble</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/5.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Bill Phillips</div>
                                        <small class="lv-small">Last seen 3 days ago</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/6.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Wendy Mitchell</div>
                                        <small class="lv-small">Last seen 2 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/7.jpg" alt="">
                                        <i class="chat-status-busy"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Teena Bell Ann</div>
                                        <small class="lv-small">Busy</small>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="online">
                        <div class="listview">
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/2.jpg" alt="">
                                        <i class="chat-status-busy"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Jonathan Morris</div>
                                        <small class="lv-small">Available</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/3.jpg" alt="">
                                        <i class="chat-status-online"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Fredric Mitchell Jr.</div>
                                        <small class="lv-small">Availble</small>
                                    </div>
                                </div>
                            </a>
                            
                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/4.jpg" alt="">
                                        <i class="chat-status-online"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Glenn Jecobs</div>
                                        <small class="lv-small">Availble</small>
                                    </div>
                                </div>
                            </a>

                            <a class="lv-item" href="">
                                <div class="media">
                                    <div class="pull-left p-relative">
                                        <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/7.jpg" alt="">
                                        <i class="chat-status-busy"></i>
                                    </div>
                                    <div class="media-body">
                                        <div class="lv-title">Teena Bell Ann</div>
                                        <small class="lv-small">Busy</small>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </aside> --%>