<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form action="privatecafe-reply.do" id="file-check"
	enctype="multipart/form-data" commandName="adminprivatereply">

	<section id="content">
		<div class="container">

			<div class="block-header"></div>

			<div class="card" id="profile-main">
				<div class="pm-overview c-overflow">
					<div class="pmo-pic">

						<div class="fileinput fileinput-new" data-provides="fileinput">
							<div class="fileinput-preview thumbnail" data-trigger="fileinput">
								<img
									src="${pageContext.request.contextPath}/upload/private/${adminprivatereply.pcafe_img}"
									alt="">
							</div>
							<div style="display: none;">
								<span class="btn btn-info btn-file"> <span
									class="fileinput-new"></span> <span class="fileinput-exists"></span>
									<input type="file" name="upload" id="pcafe_img">
								</span> <a href="#" class="btn btn-danger fileinput-exists"
									data-dismiss="fileinput"></a>
							</div>
						</div>



						<div class="pmo-stat">

							<h6 class="m-0 c-white">${adminprivatereply.pcafe_visit}<br>Total
								Visit
							</h6>

							<%-- </c:forEach> --%>
						</div>
						<div class="m-t-10">
							<button type="submit" class="btn btn-primary btn-sm">
								Save<i class="md md-insert-photo"></i>
							</button>



						</div>
					</div>

					<%-- <div class="pmo-block pmo-contact hidden-xs">
						<h2>Customizing Info</h2>

						<ul>
							<li><i class="socicon socicon-twitter"></i>
								<h5>${adminprivatereply.pcafe_name}</h5></li>
							<li><i class="md md-email"></i>${adminprivatereply.pcafe_introduce}</li>
							<li><i class="md md-phone"></i>
								${adminprivatereply.pcafe_address}</li>
							<li><i class="socicon socicon-skype"></i>
								${adminprivatereply.pcafe_reg_date}</li>
							<li><i class="md md-location-on"></i>
								<address class="m-b-0">
									${adminprivatereply.pcafe_hash_tag} <br />
										${commandMenu.pcafe_hash_tag} <br />
								${commandMenu.pcafe_hash_tag}
								</address></li>
						</ul>

					</div>

					<div class="pmo-block pmo-items hidden-xs">
						<h5>Following User</h5>

						<div class="pmob-body">
							<c:forEach items="${getLikeUser1 }" var="getLikeUser1">
								<div class="row">
									<code>${getLikeUser1.u_uid}</code>


								</div>
							</c:forEach>
						</div>
					</div> --%>
				</div>

				<div class="pm-body clearfix">
					   <ul class="tab-nav tn-justified">
					<li class="waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe-detail.do?pcafe_num=${commandMenu.pcafe_num}">Private Cafe</a></li>
					<li class="waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafemenu.do?pcafe_num=${commandMenu.pcafe_num}">Cafe Menu</a></li>
					<li class="active waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe-reply.do?pcafe_num=${commandMenu.pcafe_num}">Cafe Reply</a></li>
				</ul>
					
					
					
					<div class="pmb-block">
					<c:forEach items="${selectReplyp}" var="selectReplyp">
					
						<div class="pmbb-header">
							
							
							<!-- <여기다여기> -->
							
							
							<h4>
                        <i class="md md-perm-identity">&nbsp;</i>닉네임 : ${selectReplyp.preply_nickname} &nbsp;&nbsp;&nbsp;
                     </h4>
                       
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${selectReplyp.preply_reg_date}
                     <ul class="actions">
                        <li class="dropdown"><a href="" data-toggle="dropdown">
                              <i class="md md-more-vert"></i>
                        </a>

                           <ul class="dropdown-menu dropdown-menu-right">
                              <li><a href="${pageContext.request.contextPath}/admin/private/privatecafe-reply.do?preply_num=${selectReplyp.preply_num}">Delete</a></li>
                           </ul></li>
                     </ul>
						</div>
						<div class="pmbb-body p-l-30">
							<div class="pmbb-view"><h5>댓글내용 : ${selectReplyp.preply_content}<h5></div>


							


						</div>
						<br><br>
						
						</c:forEach>
					</div>

					

					
				</div>
			</div>
		</div>
	</section>
</form:form>
