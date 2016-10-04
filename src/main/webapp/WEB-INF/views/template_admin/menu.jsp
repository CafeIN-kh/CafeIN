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
					<li class="active"><a href="${pageContext.request.contextPath}/admin/main.do"><i class="md md-home"></i> Home</a></li>
					<li class="sub-menu"><a href=""><i class="md md-perm-identity"></i> management</a>
						<ul>
						<!-- 같은경로  -->
							<li><a href="${pageContext.request.contextPath }/cafein_admin/member/memberlist.do">User Data Tables</a></li>
							<li><a href="${pageContext.request.contextPath }/cafein_admin/member/declaredlist.do">report Board</a></li>
						</ul>
					</li>
						
						
						
						
						
						<li class="sub-menu"><a href=""><i class="md md-now-widgets"></i>Customizing Cafe</a>

						<ul>
							<li><a href="">Customizing Cafe</a></li>
							<li><a href="">Customizing LogList</a></li>
						</ul>
						</li>
						
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
							<li><a href="${pageContext.request.contextPath}/cafein_admin/notice/AdminLogList.do">Notice Log</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/event/List.do">Event</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/event/AdminLogList.do">Event Log</a></li>
							<li><a  href="${pageContext.request.contextPath}/cafein_admin/qna/List.do">Q&A Pages</a></li>
							<li><a  href="${pageContext.request.contextPath}/cafein_admin/qna/AdminLogList.do">Q&A Log</a></li>
						</ul>
						
						</li>
						
						<%-- 
						<li>
                            <a href="${pageContext.request.contextPath}/cafein_admin/admin_notice/List.do"><i class="md md-announcement"></i> Admin Notice</a>
                               
                            <a href=""><i class="md md-my-library-books"></i> Franchise Write & inquiry</a>
                				<!-- <ul>
                                    <li><a href="fr-board_.html">User Data Tables</a></li>
                                    <li><a href="fr_board2.html">report Board</a></li>
                                </ul>
                                -->
                            </li>
					<li class="sub-menu"><a href=""><i
							class="md md-now-widgets"></i>Cafe Inquiry</a>

						<ul>
							<li><a href="private Cafe.html">Private Cafe</a></li>
							<li><a class="active" href="Customizing_.html">Customizing</a></li>
						</ul></li>
					<li class="sub-menu"><a href=""><i class="md md-view-list"></i>
							Notice Write & inquiry</a>
						<ul>
							<li><a href="notice2_.html">Notice</a></li>
							<li><a class="active" href="notice-write_.html">Notice-Write</a></li>
						</ul></li>

					<li class="active"><a href="qna2_.html"><i
							class="md md-content-copy"></i> Q&A Pages</a></li>
					<li class="sub-menu">
                       <a href=""><i class="md md-trending-up"></i>Charts</a>
                       <ul>
                          <li><a href="franchise_charts.do">Franchise</a></li>
                          <li><a href="private_charts.do">Private</a></li>
                          <li><a href="custom_charts.do">Custom</a></li>
                       </ul>
                   </li>
                            </li> --%>
                            
                            <li class="sub-menu"><a href=""><i class="md md-announcement"></i>Admin Notice</a>

						<ul>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/admin_notice/List.do">Admin Notice List</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/admin_notice/write.do">Admin Notice Write</a></li>
							<li><a href="${pageContext.request.contextPath}/cafein_admin/admin_notice/LogList.do">Admin Notice Log List</a></li>
						</ul>
						</li>
<%-- 
					<li class="active"><a href="${pageContext.request.contextPath}/cafein_admin/qna/List.do"><i
							class="md md-content-copy"></i> Q&A Pages</a></li> --%>
				</ul>
			</div>
		</div>
            </aside>
           