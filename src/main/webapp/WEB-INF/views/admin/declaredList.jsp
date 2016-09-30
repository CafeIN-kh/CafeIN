<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
		<div class="block-header">
			<h2>REPORT</h2>

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
				<table class="table table-hover">
					<thead>
						<tr>
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
							<tr class="header">
								<%--  <td>${status.count}</td> --%>
								<td>+</td>
								<td><p>${declared.d_seq}</p></td>
								<!-- <td><a href="detail.do?u_uid=${member.u_uid}">${member.u_uid}</a></td> -->
								<td><p>${declared.d_mem_id}</p></td>
								<td><p>${declared.d_target_mem_id}</p></td>
								<td><p>${declared.d_reg_date}</p></td>
								<td><p>${declared.d_state}</p></td>
							</tr>

							<tr>
								<!--   style="display:none" -->

								<td colspan="6"><p>신고 내용 : ${declared.d_content}</p></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>


	</div>
</section>

