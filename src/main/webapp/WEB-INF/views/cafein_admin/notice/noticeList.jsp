<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
<div class="card">    
	<div class="card-header" style="padding-bottom: 0px;">
		<h2>
			Notice 게시판 관리 <small>Notice 게시판 관리 페이지입니다.
			<a style="float: right" href="${pageContext.request.contextPath}/cafein_admin/franchise/franchise_brandWrite.do"><i class="md md-border-color"></i></a>
			</small>
		</h2>
		
		
	</div>


	<table id="data-table-command"	class="table table-striped table-vmiddle" style="width: 100%;">
	<colgroup>
            <col style="width: 10%;" />
            <col style="width: *;" />
            <col style="width: 20%;" />

         </colgroup>
		<thead>
			<tr>
				<th data-column-id="id" data-type="numeric">Notice_num</th>
				<th data-column-id="sender">제목</th>
				<th data-column-id="received" data-order="desc">게시일</th>
				<th data-column-id="commands" data-formatter="commands"
					data-sortable="false"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.notice_num}</td>
					<td>${list.notice_title}</td>
					<td>${list.notice_reg_date}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>
</div>
</section>

