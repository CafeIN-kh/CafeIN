<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


   
 <section id="content">
                <div class="container">
<div class="card" id="profile-main">   
	<div class="pm-overview c-overflow">
		<div class="pmo-pic">
			<div class="p-relative">
				<a href="franchise_menuUpdate.do"> <img src="${pageContext.request.contextPath}/upload/franchise/${franchise.franchise_name}/${franchise.franchise_img}"" alt="">
				</a>

				<div class="dropdown pmop-message">
					<a data-toggle="dropdown" href=""
						class="btn bgm-white btn-float z-depth-1"> <i
						class="md md-message"></i>
					</a>

					<div class="dropdown-menu">
						<textarea placeholder="Write something..."></textarea>

						<button class="btn bgm-green btn-icon">
							<i class="md md-send"></i>
						</button>
					</div>
				</div>

				<a href="" class="pmop-edit"> <i class="md md-camera-alt"></i> <span
					class="hidden-xs">Update Profile Picture</span>
				</a>
			</div>


			<div class="pmo-stat">
				<h2 class="m-0 c-white">${franchise.franchise_visit}</h2>
				Total Visit
			</div>
		</div>

		<div class="pmo-block pmo-contact hidden-xs">
			<h2>Brand Info</h2>

			<ul>
				<li><i class="md md-phone"></i> ${franchise.franchise_num}</li>
				<li><i class="md md-email"></i> ${franchise.franchise_name}</li>
				<!-- 				<li><i class="socicon socicon-skype"></i> malinda.hollaway</li>
				<li><i class="socicon socicon-twitter"></i> @malinda
					(twitter.com/malinda)</li>   -->
				<li><i class="md md-location-on">
						${franchise.franchise_introduce}</i>
			</ul>
		</div>


	</div>

	<div class="pm-body clearfix">   
		<ul class="tab-nav tn-justified">  
			<li class="waves-effect"><a href="franchise_brandDetail.do?franchise_num=${franchise.franchise_num}">Brand Info Detail</a></li>
			<li class="waves-effect"><a href="franchise_menuList.do?franchise_num=${franchise.franchise_num}">Menu</a></li>
		</ul>

		<div class="pmb-block">
			<div class="p-header">
				<form action="franchise_menuList.do" id="search_form" method="get">
					<ul class="p-menu">
						<li class="active"><a href=""><i
								class="md md-person-add hidden-xs"></i> Recommanded</a></li>
						<li><a href=""><i class="md md-people hidden-xs"></i>
								Connected</a></li>
						<li class="pm-search">
							<div class="pms-inner">
								<i class="md md-search"></i> 
								<input type="hidden" name="franchise_num" value="${franchise_num }"> 
									<input type="text" name="keyword" placeholder="Search...">
							</div>
						</li>
					</ul>
				</form>



				<ul class="actions m-t-20 hidden-xs">
					<li class="dropdown"><a href="" data-toggle="dropdown"> <i
							class="md md-more-vert"></i>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="franchise_menuWrite.do?franchise_num=${franchise.franchise_num}">Insert Cafe Menu</a></li>
							<li><a href="">Reload Settings</a></li>
						</ul></li>
				</ul>
			</div>

			<div class="contacts clearfix row">
				<c:if test="${count == 0 }">
					<div class="align-center">등록된 게시물이 없습니다.</div>
				</c:if>
				<c:if test="${count > 0 }">
					<c:forEach var="article" items="${franchiseMenu}">
						<div class="col-md-3 col-sm-6 col-xs-6">

							<div class="c-item">

								<a href="franchise_menuUpdate.do?franchise_num=${franchise.franchise_num }&fmenu_name=${article.fmenu_name}&fmenu_num=${article.fmenu_num}&franchise_name=${franchise.franchise_name }" class="ci-avatar"> 
								<img class="franchise_menu1"
									src="${pageContext.request.contextPath}/upload/franchise_menu/${franchise.franchise_name}/${article.fmenu_img}"
									alt="">
								</a>
								<div class="c-info">
									
									<strong>${article.fmenu_name }</strong> 
									<small>${article.fmenu_price }</small>
								</div>

								      <div class="c-footer">
								      
                                         <button class="waves-effect" onclick="location.href='franchise_menuDelete.do?fmenu_num=${article.fmenu_num }&franchise_num=${franchise.franchise_num }&fmenu_name=${article.fmenu_name }'"><i class="md md-delete"></i> 삭제</button>
                                            </div>
							</div>
						</div>

					</c:forEach>
				</c:if>
			</div>

			<div class="load-more">
				<i class="md"></i> ${pagingHtml }</a>
			</div>
		</div>
	</div>
</div>
</div>
</section>