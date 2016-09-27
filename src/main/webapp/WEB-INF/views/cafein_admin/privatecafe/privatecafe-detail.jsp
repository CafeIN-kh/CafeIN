<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form action="privatecafe-detail.do" id="file-check" enctype="multipart/form-data" commandName="commandMenu"> 

<section id="content">
	<div class="container">

		<div class="block-header">
		
		</div>

		<div class="card" id="profile-main">
			<div class="pm-overview c-overflow">
				<div class="pmo-pic">

					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-preview thumbnail" data-trigger="fileinput">
							<img
								src="${pageContext.request.contextPath}/upload/private/${commandMenu.pcafe_img}"
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
						
						<h6 class="m-0 c-white">${commandMenu.pcafe_visit}<br>Total Visit
						</h6>

						<%-- </c:forEach> --%>
					</div>
					<div class="m-t-10">
						<button type="submit" class="btn btn-primary btn-sm">
							Save<i class="md md-insert-photo"></i>
						</button>

					

					</div>
				</div>

				<div class="pmo-block pmo-contact hidden-xs">
					<h2>Private Cafe Info</h2>
				
					<ul>
						<li><i class="socicon socicon-twitter"></i>
							<h5>${commandMenu.pcafe_name}</h5></li>
						<li><i class="md md-email"></i>${commandMenu.pcafe_address}</li>
						<li><i class="md md-phone"></i> ${commandMenu.pcafe_phone}</li>
						<li><i class="socicon socicon-skype"></i>
							${commandMenu.pcafe_time}</li>
						<li><i class="md md-location-on"></i>
							<address class="m-b-0">
								${commandMenu.pcafe_hash_tag} <br />
							<%-- 	${commandMenu.pcafe_hash_tag} <br />
								${commandMenu.pcafe_hash_tag} --%>
							</address></li>
					</ul>
				
				</div>

				<div class="pmo-block pmo-items hidden-xs">
					<h5>Following User</h5>

					<div class="pmob-body">
					<c:forEach items="${getLikeUser }" var="getLikeUser">
						<div class="row">
							<code>${getLikeUser.u_uid}</code>
							

						</div>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="pm-body clearfix">
				<ul class="tab-nav tn-justified">
					<li class="active waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe.do">Private Cafe</a></li>
					<li class="waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafemenu.do?pcafe_num=${commandMenu.pcafe_num}">Cafe Menu</a></li>
				</ul>


				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-equalizer m-r-5"></i> Private Cafe Name
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">Modify</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">${commandMenu.pcafe_name}</div>
						
						
						<!-- 수정  -->
						<div class="pmbb-edit">
							<div class="fg-line">
								<textarea name="pcafe_name" id="pcafe_name" class="form-control" rows="2"
									placeholder="수정할 카페명을 입력해주세요."> ${commandMenu.pcafe_name}</textarea>
							</div>
							<div class="m-t-10">
								<button type="submit" class="btn btn-primary btn-sm1">Save</button>
								<button data-pmb-action="reset" class="btn btn-link1 btn-sm">Cancel</button>
							</div>
						</div>
						<!-- 수정끝  -->
						
						
					</div>
				</div>

				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-person m-r-5"></i> Cafe Foreign Info
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">Modify</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">
							<dl class="dl-horizontal">
								<dt>Cafe Location</dt>
								<dd>${commandMenu.pcafe_address}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>Cafe Phone-Number</dt>
								<dd>${commandMenu.pcafe_phone}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>Cafe office hours</dt>
								<dd>${commandMenu.pcafe_time}</dd>
							</dl>
							<!--  <dl class="dl-horizontal">
                                            <dt>Martial Status</dt>
                                            <dd>Single</dd>
                                        </dl> -->
						</div>


						<!-- 수정시작 -->
						<div class="pmbb-edit">
							<dl class="dl-horizontal">
								<dt class="p-t-10">Cafe Location</dt>
								<dd>
									<div class="fg-line">
										<input name="pcafe_address" id="pcafe_address" type="text" class="form-control"
											value="${commandMenu.pcafe_address}"
											placeholder="카페위치를 입력해주세요">
									</div>

								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">Cafe Phone-Number</dt>
								<dd>
									<div class="fg-line">
										<input name="pcafe_phone" id="pcafe_phone" type="text" class="form-control"
											value="${commandMenu.pcafe_phone}"
											placeholder="카페 전화번호를 적어주세요">
									</div>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">Cafe office hours</dt>
								<dd>
									<div class="fg-line">
										<input name="pcafe_time" id="pcafe_time" type="text" class="form-control"
											value="${commandMenu.pcafe_time}">

									</div>
								</dd>
							</dl>


							<div class="m-t-30">
								<button type="submit" class="btn btn-primary btn-sm">Save</button>
								<button data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
							</div>
						</div>
						<!-- 수정끝  -->
					</div>
				</div>


				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-phone m-r-5"></i> Cafe Info
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">Modify</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">
							<dl class="dl-horizontal">
								<dt>Introduce Cafe</dt>
								<dd>${commandMenu.pcafe_introduce}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>The Cafe URL</dt>
								<dd>${commandMenu.pcafe_url}</dd>
							</dl>

							<dl class="dl-horizontal">
								<dt>Hash_Tag With Cafe</dt>
								<dd>
									<div class="pmob-body">
										<div class="row">
											<code>${commandMenu.pcafe_hash_tag}</code>
											<%-- <code>#${commandMenu.pcafe_hash_tag}</code>
											<code>#${commandMenu.pcafe_hash_tag}</code>
											<code>#${commandMenu.pcafe_hash_tag}</code>
											<code>#${commandMenu.pcafe_hash_tag}</code>
											<code>#${commandMenu.pcafe_hash_tag}</code> --%>
											<code></code>
											<code></code>
											<code></code>


										</div>
									</div>
								</dd>
							</dl>

						</div>
						<!-- 수정시작 -->
						
						<div class="pmbb-edit">
							<dl class="dl-horizontal">
								<dt class="p-t-10">Introduce Cafe</dt>
								<dd>
									<div class="fg-line">
										<input name="pcafe_introduce" id="pcafe_introduce" type="text" class="form-control"
											value="${commandMenu.pcafe_introduce}"
											placeholder="카페소개글을 적어주세요.">
									</div>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">The Cafe URL</dt>
								<dd>
									<div class="fg-line">
										<input name="pcafe_url" id="pcafe_url" type="text" class="form-control"
											value="${commandMenu.pcafe_url}"
											placeholder="HTTP:// 형태로 시작합니다.">
									</div>
								</dd>
							</dl>

							<dl class="dl-horizontal">
								<dt class="p-t-10">Hash_Tag With Cafe</dt>
								<dd>
									<div class="fg-line">
										<div class="pmob-body">
											<div class="row">
												<input name="pcafe_hash_tag" id="pcafe_hash_tag" type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${hashTagOriginal}"> <%-- <input name="pcafe_hash_tag" id="pcafe_hash_tag" 
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${commandMenu.pcafe_hash_tag}"> <input name="pcafe_hash_tag" id="pcafe_hash_tag" 
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${commandMenu.pcafe_hash_tag}"> <input name="pcafe_hash_tag" id="pcafe_hash_tag" 
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${commandMenu.pcafe_hash_tag}"> <input name="pcafe_hash_tag" id="pcafe_hash_tag"
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${commandMenu.pcafe_hash_tag}"> <input name="pcafe_hash_tag" id="pcafe_hash_tag"
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${commandMenu.pcafe_hash_tag}"> --%>



											</div>
										</div>

									</div>
								</dd>
							</dl>


							<div class="m-t-30">
								<button type="submit" class="btn btn-primary btn-sm">Save</button>
								<button type="button" data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
							</div>
						</div>
						<!-- 수정끝 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
 </form:form> 