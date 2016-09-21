<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

	<section id="content">
		<div class="container">
			<div class="block-header">
				

			</div>




			<div class="card">
				<div class="card-header">
					<h2>
						Member Management <small>Member Management Page</small><br><br>
					</h2>
				</div>
				
				<div class="table-responsive">
				
				
					<table id="data-table-command"
						class="table table-striped table-vmiddle">
						<thead>
							<tr>
								<!-- data-type="numeric"  -->
								<th data-column-id="id" data-identifier="true">User Name</th>
								<th data-column-id="sender">Email</th>
								<th data-column-id="received" data-order="desc">User Join Reg_Date</th>
								<th data-column-id="commands" data-formatter="commands"
									data-sortable="false">Modify & Delete</th>
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
								<td>${member.u_reg_date}</td>
							</tr>
							</c:forEach>
				
							<!-- </c:if> -->
						</tbody>
						
					</table>
					
				</div>
			
			
			
			
			
			</div>
		</div>
	</section>



