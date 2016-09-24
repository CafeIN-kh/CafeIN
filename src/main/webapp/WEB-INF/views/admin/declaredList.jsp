<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
		<div class="block-header">
			<h2>Declared</h2>

			<ul class="actions">
				<li><a href=""> <i class="md md-trending-up"></i>
				</a></li>
				<li><a href=""> <i class="md md-done-all"></i>
				</a></li>
				<li class="dropdown"><a href="" data-toggle="dropdown"> <i
						class="md md-more-vert"></i>
				</a>

					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="">Refresh</a></li>
						<li><a href="">Manage Widgets</a></li>
						<li><a href="">Widgets Settings</a></li>
					</ul></li>
			</ul>

		</div>





		<div class="card">
			<div class="card-header">
				<h2>
					신고 관리 <small>신고된 게시글, 회원을 관리하는 페이지입니다.</small>
				</h2>
			</div>

			<div class="table-responsive">

				<table class="table table-hover recruit">
					<thead>
						<tr id="declared_head">
							<th>+/-</th>
							<th>번호</th>
							<th>신고인 아이디</th>
							<th>신고대상</th>
							<th>신고날짜</th>
							<th>처리 상태</th>

							<!--  누르면 신고 내용 나옴 없으면 안늘어남 -->

						</tr>
					</thead>
					<tbody>

						<c:forEach var="declared" items="${list}" varStatus="status">
							<tr class="title">
								<%--  <td>${status.count}</td> --%>
								<td>+</td>
								<td>${declared.d_seq}</td>
								<!-- <td><a href="detail.do?u_uid=${member.u_uid}">${member.u_uid}</a></td> -->
								<td>${declared.d_mem_id}</td>
								<td>${declared.d_target_mem_id}</td>
								<td>${declared.d_reg_date}</td>


								<!-- 처리상태(0.처리 전, 1.처리 중,2.처리 완료, 3처리 보류, 4. 처리 취소)  -->
								<c:choose>

									<c:when test="${declared.d_state == '0'}">
										<td>처리 전</td>
									</c:when>

									<c:when test="${declared.d_state == '1'}">
										<td>처리 중</td>
									</c:when>

									<c:when test="${declared.d_state == '2'}">
										<td>처리 완료</td>
									</c:when>

									<c:when test="${declared.d_state == '3'}">
										<td>처리 보류</td>
									</c:when>

									<c:when test="${declared.d_state == '4'}">
										<td>처리 취소</td>
									</c:when>

									<c:otherwise>
										<td>처리 에러</td>
									</c:otherwise>

								</c:choose>


							</tr>

							<tr class="hide">
								<!--   style="display:none" -->

								<td colspan="6" style="padding-top:15px;">

									<div class="declared_div col-xs-11 col-md-11">

										<div class="div_inner1">

											<h5>※ 신고 내역 ※</h5>
											<hr style="border-top: 1px solid #8c8b8b;">

											${declared.d_content}
										</div>
										<br> <br>

										<div class="div_inner2">
											<select class="selectpicker">
												<option>처리 전</option>
												<option>처리 중</option>
												<option>처리 완료</option>
												<option>처리 보류</option>
												<option>처리 취소</option>
											</select>
										</div>
									</div> <br>




											<div class="panel panel-default widget col-xs-11 col-md-11">
												<div class="panel-heading">
													<span class="glyphicon glyphicon-comment"></span>
													<h3 class="panel-title">Reply</h3>

												</div>
												<div class="panel-body">
													<ul class="list-group">
														<li class="list-group-item">
															<div class="row">
																<!-- <div class="col-xs-2 col-md-1">
                                <img src="http://placehold.it/80" class="img-circle img-responsive" alt="" /></div> -->
																<div class="col-xs-10 col-md-11">
																	<div>
																		<a href="#"> Congratulations</a>
																		<div class="mic-info">
																			By: <a href="#">Check My Athletics</a> on 12 Jun 2014
																		</div>
																	</div>
																	<div class="comment-text">We would like to
																		congratulate John on his achievement...</div>


																</div>
															</div>
														</li>


													</ul>

												</div>
												<div class="col">


													<div class="panel-body">
														<form role="form">
															<fieldset>
																<div class="form-group">
																	<textarea class="form-control" rows="3"
																		placeholder=" Write in your wall"></textarea>


																</div>


																<button type="submit" class="[ btn btn-success ]"
																	data-loading-text="Loading...">Post reply</button>
															</fieldset>
														</form>
													</div>
												</div>

											</div>
										
										
										<!-- ------------------------------------ -->
								</td>
							</tr>
						</c:forEach>




					</tbody>
				</table>
			</div>
		</div>


	</div>
</section>
