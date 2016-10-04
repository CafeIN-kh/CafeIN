admin_noticeModify<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<section id="content">
   <div class="container">
		<div class="card">
    		<div class="card c-timeline" id="profile-main">
				<div class="timeline">                            
					<c:forEach items="${list }" var="list">
						<div class="t-view" data-tv-type="text">
						<!-- head 시작 -->
							<div class="tv-header media">
								<div class="media-body p-t-5">
                                	<strong class="d-block">${list.admin_notice_title }</strong>
                                    <small class="c-gray">${list.u_uid } | ${list.admin_notice_reg_date }</small>
                                 </div>
                                 	<ul class="actions m-t-20 hidden-xs">
                                    	<li class="dropdown">
                                        	<a href="" data-toggle="dropdown"><i class="md md-more-vert"></i></a>
	                                        <ul class="dropdown-menu dropdown-menu-right">
	                                        	<li><a href="update.do?admin_notice_num=${list.admin_notice_num }">Edit</a></li>
	                                            <li><a href="delete.do?admin_notice_num=${list.admin_notice_num }">Delete</a></li>
	                                        </ul>
                                        </li>
                                    </ul>
                            </div>
                            <!-- head끝 -->
							<div class="tv-body">
								<c:if test="${!empty list.admin_notice_img }">
								<div class="lightbox m-b-20">
									<div data-src="img/headers/sm/4.png">
										<div class="lightbox-item pull-left">
											<img src="${pageContext.request.contextPath}/upload/admin_notice/${list.admin_notice_img}" alt="">
										</div>
									</div>
								</div>
								</c:if>
								<p>${list.admin_notice_content }</p>
							</div>
						</div>
					</c:forEach>    
				</div>
			</div>
		</div>
	</div>
</section>

