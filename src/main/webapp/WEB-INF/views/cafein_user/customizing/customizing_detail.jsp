<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--=== Breadcrumbs ===-->
<div class="breadcrumbs">
	<div class="container">
		<h1 class="pull-left">Customizing Menu</h1>
		<ul class="pull-right breadcrumb">
			<li><a
				href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
			<li><a href="customizing_list.do">Customizing<a></a></li>
			<li class="active">Customizing Menu</li>
		</ul>
	</div>
</div>
<!--/breadcrumbs-->
<div class="bg-color-light" style="padding-top: 15px;">
	<div class="cube-portfolio container">
		<div class="col-md-12">
			<c:if test="${customCommand.u_uid == u_uid}">
				<div class="btn-group" style="float: right; padding: 0 0 10px 10px;">
					<button type="button" class="btn-u korean-font" data-toggle="modal"
						data-target="#responsive" onclick="location.href='#'">메뉴 글	수정</button>
				</div>
			</c:if>
		</div>
	</div>
</div>

<input type="hidden" id="u_uid" name="u_uid" value="${u_uid}">

<!-- 카페등록 모달 -->
<div class="modal fade" id="responsive" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title korean-font" id="myModalLabel4">메뉴 글 수정</h4>
			</div>
			<div class="modal-body">
				<form action="custom/register.do" method="post"
					enctype="multipart/form-data" id="sky-form3" class="sky-form"
					style="border: 0;">
					
					<input type="hidden" name="custom_num" id="custom_num" value="${customCommand.custom_num}"> 
					<input type="hidden" name="u_uid" id="u_uid" value="${customCommand.u_uid}">
					<!--<input type="hidden" name="franchise_num" id="franchise_num" value="${customCommand.franchise_num}">-->
					<%-- <input type="hidden" name="custom_num" id="custom_num" value="1"> 
					<input type="hidden" name="u_uid" id="u_uid" value="${u_uid}">
					<input type="hidden" name="franchise_num" id="franchise_num" value="1"> --%>
					
					<!--  <header>Contacts form</header> -->

					<fieldset>
						<div class="row">
							<section class="col col-6">
								<label class="label">Custom Menu Name</label> <label
									class="input"> <!-- <i class="icon-append fa fa-user"></i> -->
									<input type="text" name="custom_name" id="custom_name" class="korean-font"
									value="${customCommand.custom_name}">
								</label>
							</section>

							<section class="col col-6">
								<label class="label">Custom Menu Name</label> 
								<label class="select"> 
									<select name="franchise_num" id="franchise_num">
										<c:forEach var="article" items="${customizingDetailCafeNameCommand}">
											<option class="korean-font" value="${article.franchise_num}">${article.franchise_name}</option>
										</c:forEach>
									</select> <i></i>
								</label>
							</section>
						</div>

						<section>
							<label class="label">Custom Introduce</label> <label
								class="textarea"> <!-- <i class="icon-append fa fa-comment"></i> -->
								<textarea rows="4" class="korean-font" name="custom_introduce" id="custom_introduce">${customCommand.custom_introduce}</textarea>
							</label>
						</section>

						<section>
							<label class="label">Custom Recipe</label> <label
								class="textarea"> <!-- <i class="icon-append fa fa-comment"></i> -->
								<textarea rows="4" class="korean-font" name="custom_recipe" id="custom_recipe">${customCommand.custom_recipe}</textarea>
							</label>
						</section>

						<section>
							<label class="label korean-font">Custom Tag (쉼표로 구분해주세요)</label> 
							<label class="input"> <!-- <i class="icon-append fa fa-tag"></i> -->
								<%-- <input type="text" name="custom_hash_tag" id="custom_hash_tag"
								value="${customCommand.custom_hash_tag}"> --%>
								<input type="text" class="korean-font" name="custom_hash_tag" id="custom_hash_tag" value="${customTagName}">
							</label>
						</section>

						<section style="margin-bottom: 50px;">
							<label class="label">Cafe Image Upload</label> <label
								for="custom_img" class="input input-file"> <!-- <div class="button"> -->
								<input type="file" name="upload" id="upload" multiple
								onchange="this.parentNode.nextSibling.value = this.value"
								class="korean-font"> <!-- Browse</div> --> <!-- <input type="text" placeholder="Please file upload" readonly> -->
							</label>
						</section>

						<button type="submit" class="btn-u btn-u-primary"
							style="float: right;">Register</button>
						<button type="button" class="btn-u btn-u-default"
							data-dismiss="modal" style="float: right; margin-right: 5px;">Close</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<!--=== Blog Posts ===-->
<div class="bg-color-light">
	<div class="container content-sm" style="padding-top: 30px;">
		<!-- News v3 -->
		<div class="news-v3 margin-bottom-30">
			<img class="img-responsive full-width"
				src="${pageContext.request.contextPath}/upload/customizing/${customCommand.custom_img}">
			<div class="news-v3-in">
				<ul class="list-inline posted-info korean-font">
					<li>By <a style="text-decoration:none;color:#555;">${customCommand.u_name}</a></li>
					<li>Like <a href="#">${customCommand.custom_visit}</a></li>
					<li>${customCommand.custom_reg_date}</li>
				</ul>
				<h2 class="korean-font">
					<a style="text-decoration:none;color:#555;">${customCommand.custom_name}</a>
				</h2>
				<p class="korean-font">${customCommand.custom_introduce}</p>
				<p class="korean-font">${customCommand.custom_recipe}</p>
				<blockquote class="hero">
					<p class="korean-font">
						<em>${customCommand.custom_hash_tag}</em>
					</p>
				</blockquote>

				<ul class="post-shares post-shares-lg">
					<li><a
						href="${pageContext.request.contextPath}/cafein_user/customizing/customizing_list.do">
							<i class="rounded-x icon-speech" title="메뉴 리스트"></i>
					</a></li>

					<li><a id="custom_like"> <i class="rounded-x" id="like"
							name="like" title="좋아요"></i> <span id="likevalue"
							name="likevalue">${likeCount}</span>
					</a></li>

					<li><a id="custom_bookmark"> <i class="rounded-x"
							id="bookmark" name="bookmark" title="즐겨찾기"></i> <span
							id="bookmarkvalue" name="bookmarkvalue">${bookmarkCount}</span>
					</a></li>

					<li><i class="rounded-x icon-eye" title="조회"></i> <span>${customCommand.custom_visit}</span>
					</li>
				</ul>
			</div>
		</div>
		<!-- End News v3 -->




		<!-- Authored Blog -->
		<div class="row news-v2 margin-bottom-50">
			<c:forEach var="article1" items="${list}">
				<div class="col-sm-4 sm-margin-bottom-30">
					<div class="news-v2-badge">
						<img class="img-responsive"
							src="${pageContext.request.contextPath}/upload/customizing/${article1.custom_img}"
							alt="">

					</div>
					<div class="news-v2-desc">
						<h3 class="korean-font">
							<a
								href="${pageContext.request.contextPath}/cafein_user/customizing/customizing_detail.do?custom_num=${article1.custom_num}&u_uid=${article1.u_uid}&franchise_num=${article1.franchise_num}">${article1.custom_name}</a>
						</h3>
						<small class="korean-font">By ${article1.u_name} | 조회수
							${article1.custom_visit} | ${article1.custom_reg_date} </small>
						<p class="korean-font">${article1.custom_introduce}</p>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- End Authored Blog -->

		<hr>

		<!-- 댓글 부분 : blog_large_full_width_item.html -->
		<div class="container content blog-page blog-item">
			<!-- Recent Comments -->
			<div class="headline margin-bottom-30">
				<h3>Comments</h3>
			</div>
			<div class="media margin-bottom-40">
				<!-- <h3>Comments</h3> -->
				<!-- <hr> -->

				<div id="output"></div>
				
				<div class="modal fade" id="declear" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title korean-font" id="myModalLabel4">신고</h4>
							</div>
							<div class="modal-body">
								<form action="/CafeIN/cafein_user/customizing/customizing_ReplyDeclaredRegister.do" method="post" novalidate="novalidate"
									id="sky-form4" class="sky-form"	style="border: 0;"><!-- 입력,form action="컨트롤러 맵핑 주소" -->
									<fieldset>
									
										<!-- 현재 선택한 댓글의 시퀀스 -->
           				                <input type="hidden" id="d_target_id" name="d_target_id" value="${declaredReply.creply_num}">
                            
                     			       	<!-- d_target_path : 0[프랜차이즈 댓글] 1[개인카페 댓글] 2[커스터마이징 댓글] -->
                         			    <input type="hidden" id="d_target_path" name="d_target_path" value="2">
                         			    
                            			<!-- d_target_num : 신고 대상(댓글)의 상위 경로 시퀀스(커스텀메뉴 시퀀스) -->
                           				<input type="hidden" id="d_target_num" name="d_target_num" value="${declaredReply.custom_num}">
                            			
                            			<%-- <input type="hidden" name="custom_num" id="custom_num" value="${customCommand.custom_num}">  --%>
										<%-- <input type="hidden" name="u_uid" id="u_uid" value="${customCommand.u_uid}"> --%>
										<%-- <input type="hidden" name="franchise_num" id="franchise_num" value="${FranchiseCommand.franchise_num}"> --%>
										<%-- <input type="hidden" name="custom_num" id="custom_num" value="${declaredReply.custom_num}">  --%>
										<input type="hidden" name="session_u_uid" id="session_u_uid" value="${u_uid}">
										<input type="hidden" name="franchise_num" id="franchise_num" value="${customCommand.franchise_num}">
                            
									
										<section>
											<!-- 신고한 사람의 정보는 세션에서 가져오기 -->
											
											<c:if test="${u_name != null}">
                           				  		<label class="label" id="d_mem_id_name" name="d_mem_id_name" style="font-weight:bold;">신고자 닉네임 : ${u_name}</label> 
                            				</c:if>
                            				<c:if test="${u_name == null}">
                           				  		<label class="label" id="d_mem_id_name" name="d_mem_id_name" style="font-weight:bold;">신고자 닉네임 : Guest</label> 
                            				</c:if>
                            				
                            				<input type="hidden" name="d_mem_id" id="d_mem_id" value="${u_uid}"> 
										</section>
										
										<section>
	                             			<label class="label" id="d_target_mem_id_name" name="d_target_mem_id_name" value="" style="font-weight:bold;">피신고자 닉네임 : ${declaredCommand.u_uid}</label> 
	                            			<input type="hidden" name="d_target_mem_id" id="d_target_mem_id" value="${declaredCommand.u_uid}">
                         				</section>

										<section>
	                           				<label class="label korean-font">신고 내용</label> 
	                           				<label class="textarea"> <!-- <i class="icon-append fa fa-comment"></i> -->
	                               				<textarea rows="4" name="d_content" id="d_content" class="korean-font"></textarea>
	                             			</label>
                          				</section>

										<button type="submit" class="btn-u btn-u-primary" style="float: right;">Register</button>
										<button type="button" class="btn-u btn-u-default"
											data-dismiss="modal" style="float: right; margin-right: 5px;">Close</button>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>

				<br>
				<!-- <div class="cbp-l-loadMore-button"> -->
				<!-- <a href="" class="cbp-l-loadMore-button-link">LOAD MORE</a> -->
				<!-- <a href="${pageContext.request.contextPath}/resources/cafein_user/assets/ajax/loadMore.html" class="cbp-l-loadMore-button-link">LOAD MORE</a> -->
				<!-- </div> -->
				<div class="paging_button" style="display:none;">
             	<button type="button" class="btn-u btn-block" style="width: 10%;margin:0 45%;">Load More</button>
     			 </div>
        
      		<!-- <input type="button" value="다음글 보기"> -->
    		  <div id="loading" style="display:none;">
     		  <img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/ajax-loader.gif">
    		  </div>



			<!-- End Recent Comments -->
			</div>
			<!--/media-->

			<!-- Comment Form -->
			<!-- <div class="headline margin-bottom-30"><h3>Leave a Comment</h3></div> -->
			<div class="post-comment">
				<!-- <h3>Leave a Comment</h3> -->

				<!-- <form action="custom/insertreply.do" method="post" id="reply" class="reply" style="border: 0;"> -->
				<form id="reply" class="reply" style="border: 0;">
					<input type="hidden" id="custom_num" name="custom_num" value="${customCommand.custom_num}">
					
					<c:if test="${u_uid != null}">
						<label style="font-size: 17px;" class="korean-font-bold"><i class="fa fa-user">&nbsp;&nbsp;</i>${u_name}</label>
						<input type="hidden" id="creply_nickname" name="creply_nickname" value="${u_name}">
					</c:if>
					<c:if test="${u_uid == null}">
						<label style="font-size: 17px;"><i class="fa fa-user">&nbsp;&nbsp;</i>Guest</label>
						<input type="hidden" id="creply_nickname" name="creply_nickname" value="Guest">
					</c:if>
					<div class="row margin-bottom-20">
						<div class="col-md-12 col-md-offset-0">
							<textarea class="form-control korean-font" id="creply_content"
								name="creply_content" rows="5"></textarea>
						</div>
					</div>

					<p style="float: right;">
						<button class="btn-u" type="submit">Send Message</button>
					</p>
				</form>
			</div>
			<!-- End Comment Form -->

		</div>
		<!--/container-->
		<!-- END 댓글 부분 : blog_large_full_width_item.html -->
		<!--=== End Content Part ===-->
	</div>
</div>