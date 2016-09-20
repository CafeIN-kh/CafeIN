<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
 <section id="content">
                <div class="container">
	<div class="card">
		<div class="card-header" style="padding-bottom: 0px;">
			<h2>
				관리자페이지 <small>프렌차이즈 소개 페이지입니다.</small>
			    <a style="float: right" href="${pageContext.request.contextPath}/cafein_admin/notice/write.do"><i class="md md-border-color"></i></a>
			</h2>
		</div>

		<table id="data-table-command"
			class="table table-striped table-vmiddle">
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 10%;" />
				<col style="width: *;" />
				<col style="width: 10%;" />
				<col style="width: 10%;" />
			</colgroup>
			<thead>
				<tr>     
					<th data-column-id="id" data-type="numeric">franchise_num</th>
 
					<th data-column-id="franchise_name">franchise_name</th>
					
					<th data-column-id="introduce">franchise_introduce</th>
					<th data-column-id="franchise_visit">franchise_visit</th>
					<th data-column-id="commands" data-formatter="commands"
						data-sortable="false"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${list }">
					<tr>
						<td>${article.franchise_num }</td>
						<td>${article.franchise_name}</td>
						<td>${article.franchise_introduce }</td>
						<td>${article.franchise_visit }</td>
						  
					</tr>  
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	</section>
	 <!-- Data Table -->
	 
        
	

