<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
		<div class="block-header">
			<h2>Member management</h2>

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
					회원 관리 <small>회원관리 페이지입니다.</small>
				</h2>
			</div>

			<div class="table-responsive">


				<table id="data-table-command"
					class="table table-striped table-vmiddle">
					<thead>
						<tr>
							<!-- data-type="numeric"  -->
							<th data-column-id="id" data-identifier="true">이름</th>
							<th data-column-id="sender">이메일</th>
							<th data-sortable="false">권한</th>
							<th data-column-id="received" data-order="desc">회원등록일</th>
							<th data-column-id="commands" data-formatter="commands"
								data-sortable="false">관리</th>
						</tr>
					</thead>
					<tbody>

						<!--<c:if test="${count > 0}">   -->

						<c:forEach var="member" items="${list}" varStatus="status">
							<tr>
								<%--  <td>${status.count}</td> --%>
								<td>${member.u_name}</td>
								<!-- <td><a href="detail.do?u_uid=${member.u_uid}">${member.u_uid}</a></td> -->
								<td>${member.u_email}</td>

								<c:choose>

									<c:when test="${member.u_level == '0'}">
										<td>일반회원</td>
									</c:when>

									<c:when test="${member.u_level == '1'}">
										<td>사업자회원</td>
									</c:when>

									<c:when test="${member.u_level == '2'}">
										<td>관리자</td>
									</c:when>

									<c:otherwise>
										<td>회원정보 없음</td>
									</c:otherwise>

								</c:choose>
								<td>${member.u_reg_date}</td>
							</tr>





							<div class="modal fade" id="layerpop">
								<div class="modal-dialog">
									<div class="modal-content">
										<!-- header -->
										<div class="modal-header">
											<!-- 닫기(x) 버튼 -->
											<button type="button" class="close" data-dismiss="modal">×</button>
											<!-- header title -->
											<h4 class="modal-title">Header</h4>
										</div>
										<!-- body -->
										<div class="modal-body">Body</div>
										<!-- Footer -->
										<div class="modal-footer">
											Footer
											<button type="button" class="btn btn-default"
												data-dismiss="modal">닫기</button>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>

						<!-- </c:if> -->
					</tbody>

				</table>

			</div>




		</div>
	</div>
</section>






