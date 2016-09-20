<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">

		<div class="block-header">
			<h2>
				개인카페 정보 조회 및 수정하기 <small>개인카페 정보를 조회하고 수정할 수 있는 메뉴입니다.</small>
			</h2>

			<ul class="actions m-t-20 hidden-xs">
				<li class="dropdown"><a href="" data-toggle="dropdown"> <i
						class="md md-more-vert"></i>
				</a>

					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="">Privacy Settings</a></li>
						<li><a href="">Account Settings</a></li>
						<li><a href="">Other Settings</a></li>
					</ul></li>
			</ul>
		</div>

		<div class="card" id="profile-main">
			<div class="pm-overview c-overflow">
				<div class="pmo-pic">

					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-preview thumbnail" data-trigger="fileinput">
							<img
								src="${pageContext.request.contextPath}/upload/${privateCommand.pcafe_img}"
								alt="">
						</div>
						<div style="display: none;">
							<span class="btn btn-info btn-file"> <span
								class="fileinput-new"></span> <span class="fileinput-exists"></span>
								<input type="file" name="upload">
							</span> <a href="#" class="btn btn-danger fileinput-exists"
								data-dismiss="fileinput"></a>
						</div>
					</div>



					<div class="pmo-stat">
						<%-- <c:forEach items="${list1 }" var="list1"> --%>
						<h6 class="m-0 c-white">${privateCommand.pcafe_visit}<br>조회수
						</h6>

						<%-- </c:forEach> --%>
					</div>
					<div class="m-t-10">
						<button type="submit" class="btn btn-primary btn-sm">
							save<i class="md md-insert-photo"></i>
						</button>

						<!-- <a href="profile-connections.html">&nbsp;&nbsp;&nbsp;Cancel</a> -->
						<!-- <button data-pmb-action="reset" class="btn btn-link btn-sm"><a href="profile-connections.html">Cancel</a></button> 
										 -->

					</div>
				</div>

				<div class="pmo-block pmo-contact hidden-xs">
					<h5>카페정보</h5>
					<%-- <c:forEach items="${list1 }" var="list1"> --%>
					<ul>
						<li><i class="socicon socicon-twitter"></i>
							<h5>${privateCommand.pcafe_name}</h5></li>
						<li><i class="md md-email"></i>${privateCommand.pcafe_address}</li>
						<li><i class="md md-phone"></i> ${privateCommand.pcafe_phone}</li>
						<li><i class="socicon socicon-skype"></i>
							${privateCommand.pcafe_time}</li>
						<li><i class="md md-location-on"></i>
							<address class="m-b-0">
								${privateCommand.pcafe_hash_tag} <br />
								${privateCommand.pcafe_hash_tag} <br />
								${privateCommand.pcafe_hash_tag}
							</address></li>
					</ul>
					<%-- </c:forEach> --%>
					<!-- <ul>
                        <li><i class="socicon socicon-twitter"></i>
                        <h5>내발산 할리스 카페</h5></li>
                        <li><i class="md md-email"></i> 서울특별시 강서구 내발산</li>
                        <li><i class="md md-phone"></i> 02-949-0306</li>
                        <li><i class="socicon socicon-skype"></i> 8:30~01:00</li>
                        <li><i class="md md-location-on"></i>
                           <address class="m-b-0">
                              강서구,우가욱 <br /> 우장산,분위기짱 <br /> 스터디,강서구
                           </address></li>
                     </ul> -->
				</div>

				<div class="pmo-block pmo-items hidden-xs">
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
					<li class="active waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafe.do">개인카페</a></li>
					<li class="waves-effect"><a
						href="${pageContext.request.contextPath}/admin/privatecafe/privatecafemenu.do?pcafe_num=${privateCommand.pcafe_num}">개인카페메뉴</a></li>
				</ul>


				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-equalizer m-r-5"></i> 개인카페명
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">수정하기</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">${privateCommand.pcafe_name}</div>

						<div class="pmbb-edit">
							<div class="fg-line">
								<textarea class="form-control" rows="2"
									placeholder="수정할 카페명을 입력해주세요."> ${privateCommand.pcafe_name}</textarea>
							</div>
							<div class="m-t-10">
								<button class="btn btn-primary btn-sm1">Save</button>
								<button data-pmb-action="reset" class="btn btn-link1 btn-sm">Cancel</button>
							</div>
						</div>
					</div>
				</div>

				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-person m-r-5"></i> 카페정보
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">수정하기</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">
							<dl class="dl-horizontal">
								<dt>카페 위치</dt>
								<dd>${privateCommand.pcafe_address}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>카페 전화번호</dt>
								<dd>${privateCommand.pcafe_phone}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>카페 영업시간</dt>
								<dd>${privateCommand.pcafe_time}</dd>
							</dl>
							<!--  <dl class="dl-horizontal">
                                            <dt>Martial Status</dt>
                                            <dd>Single</dd>
                                        </dl> -->
						</div>



						<%--    <div class="pmbb-body p-l-30">
                        <div class="pmbb-view">${privateCommand.pcafe_name}</div>

                        <div class="pmbb-edit">
                           <div class="fg-line">
                              <textarea class="form-control" rows="5"
                                 placeholder="수정할 카페명을 입력해주세요."> ${privateCommand.pcafe_name}</textarea>
                           </div>
                           <div class="m-t-10">
                              <button class="btn btn-primary btn-sm">Save</button>
                              <button data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
                           </div>
                        </div>
                     </div> --%>

						<div class="pmbb-edit">
							<dl class="dl-horizontal">
								<dt class="p-t-10">카페 위치</dt>
								<dd>
									<div class="fg-line">
										<input type="text" class="form-control"
											value="${privateCommand.pcafe_address}"
											placeholder="카페위치를 입력해주세요">
									</div>

								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">카페 전화번호</dt>
								<dd>
									<div class="fg-line">
										<input type="text" class="form-control"
											value="${privateCommand.pcafe_phone}"
											placeholder="카페 전화번호를 적어주세요">
									</div>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">카페영업시간</dt>
								<dd>
									<div class="fg-line">
										<input type="text" class="form-control"
											value="${privateCommand.pcafe_time}">

									</div>
								</dd>
							</dl>

							<!--    <dl class="dl-horizontal">
                              <dt class="p-t-10">Martial Status</dt>
                              <dd>
                                 <div class="fg-line">
                                    <select class="form-control">
                                       <option>Single</option>
                                       <option>Married</option>
                                       <option>Other</option>
                                    </select>
                                 </div>
                              </dd>
                           </dl> -->

							<div class="m-t-30">
								<button class="btn btn-primary btn-sm">Save</button>
								<button data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
							</div>
						</div>
					</div>
				</div>


				<div class="pmb-block">
					<div class="pmbb-header">
						<h2>
							<i class="md md-phone m-r-5"></i> 카페내용
						</h2>

						<ul class="actions">
							<li class="dropdown"><a href="" data-toggle="dropdown">
									<i class="md md-more-vert"></i>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a data-pmb-action="edit" href="">수정하기</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="pmbb-body p-l-30">
						<div class="pmbb-view">
							<dl class="dl-horizontal">
								<dt>카페소개글</dt>
								<dd>${privateCommand.pcafe_introduce}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>카페 URL</dt>
								<dd>${privateCommand.pcafe_url}</dd>
							</dl>

							<dl class="dl-horizontal">
								<dt>카페 해시태그</dt>
								<dd>
									<div class="pmob-body">
										<div class="row">
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code>#${privateCommand.pcafe_hash_tag}</code>
											<code></code>
											<code></code>
											<code></code>


										</div>
									</div>
								</dd>
							</dl>

						</div>

						<div class="pmbb-edit">
							<dl class="dl-horizontal">
								<dt class="p-t-10">카페소개글</dt>
								<dd>
									<div class="fg-line">
										<input type="text" class="form-control"
											value="${privateCommand.pcafe_introduce}"
											placeholder="카페소개글을 적어주세요.">
									</div>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt class="p-t-10">카페 URL</dt>
								<dd>
									<div class="fg-line">
										<input type="email" class="form-control"
											value="${privateCommand.pcafe_url}"
											placeholder="HTTP:// 형태로 시작합니다.">
									</div>
								</dd>
							</dl>

							<dl class="dl-horizontal">
								<dt class="p-t-10">카페 해시태그</dt>
								<dd>
									<div class="fg-line">
										<div class="pmob-body">
											<div class="row">
												<input type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}"> <input
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}"> <input
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}"> <input
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}"> <input
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}"> <input
													type="text" class="hash-code" placeholder="해쉬태그입력!"
													value="${privateCommand.pcafe_hash_tag}">



											</div>
										</div>

									</div>
								</dd>
							</dl>


							<div class="m-t-30">
								<button class="btn btn-primary btn-sm">Save</button>
								<button data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>