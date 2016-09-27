<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
 <section id="content">
                <div class="container">
	<div class="card">
		<div class="card-header" style="padding-bottom: 0px;">
			<h2>
				FranchiseCafe <small>FranchiseCafe Controller Page</small>
			    <%-- <a style="float: right" href="${pageContext.request.contextPath}/cafein_admin/franchise/franchise_brandWrite.do"><i class="md md-border-color"></i></a> --%>
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
				<col style="width: 10%;" />
			</colgroup>
			<thead>
				<tr>     
					<th data-column-id="franchise_log_seq" data-type="numeric">franchise_log_seq</th>
					<th data-column-id="franchise_num_log">franchise_num_log</th>
					<th data-column-id="franchise_message_log">franchise_message_log</th>
					<th data-column-id="franchise_admin_log">franchise_admin_log</th>
					<th data-column-id="franchise_reg_date_log">franchise_reg_date_log</th>
					<th data-column-id="franchise_change_log">franchise_change_log</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${logList }">
					<tr>
						<td>${article.franchise_log_seq }</td>
						<td>${article.franchise_num_log}</td>
						<td>${article.franchise_message_log }</td>
						<td>${article.franchise_admin_log }</td>
						<td>${article.franchise_reg_date_log}</td>
						<td>${article.franchise_change_log}</td>  
					</tr>  
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	</section>
	 <!-- Data Table -->
	 
        
	

