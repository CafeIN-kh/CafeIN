<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <section id="content">
                <div class="container">
<div class="card">
	<div class="card-header">
		<h2 >
			Event 게시판 관리 <small>Event 게시판 관리 페이지입니다.</small>
		</h2>
		<div style="float: right">
			<a href="${pageContext.request.contextPath}/cafein_admin/event/write.do"><i class="md md-border-color"></i></a>
		</div>
	</div>


	<table id="data-table-command"	class="table table-striped table-vmiddle" style="width: 100%;">
		<thead>
			<tr>
				<th data-column-id="id" data-type="numeric">Event_num</th>
				<th data-column-id="sender">제목</th>
				<th data-column-id="received" data-order="desc">게시일</th>
				<th data-column-id="commands" data-formatter="commands"
					data-sortable="false"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.event_num}</td>
					<td>${list.event_title}</td>
					<td>${list.event_reg_date}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>
</div>
</section>

