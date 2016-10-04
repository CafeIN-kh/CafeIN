<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
 <section id="content">
                <div class="container">
                 <div class="pm-body clearfix">
                             <ul class="tab-nav tn-justified">
                                <li class="active waves-effect"><a href="/cafein_admin/notice/AdminLogList.do">Admin Log</a></li>
                                <li class="waves-effect"><a href="/cafein_admin/event/UserLogList.do">User Log</a></li>
                                
                            </ul> 
	<div class="card">
		<div class="card-header" style="padding-bottom: 0px;">
			<h2>
				Notice <small>Log List</small>
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
					<th data-column-id="an_log_num" data-type="numeric">Num</th>
					<th data-column-id="an_log_uid">User Name</th>
					<th data-column-id="an_log_message">Message</th>
					<th data-column-id="an_log_reg_date">Date</th>
					<th data-column-id="an_log_change">Change</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list }">
					<tr>
						<td>${list.n_log_num }</td>
						<td>${list.n_log_uid}</td>
						<td>${list.n_log_message }</td>
						<td>${list.n_log_reg_date}</td>
						<c:choose>
							<c:when test="${list.n_log_change==0}">
								<td>Write</td>
							</c:when>
							<c:when test="${list.n_log_change==1}">
								<td>Delete</td>
							</c:when>
							<c:otherwise>
								<td>Update</td>
							</c:otherwise>
						</c:choose>  
					</tr>  
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	</div>
	</section>
	 <!-- Data Table -->
	 
        
	

