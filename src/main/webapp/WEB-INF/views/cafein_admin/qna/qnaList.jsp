<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
   <div class="card">
      <div class="card-header">
        <h2>
			QnA <small>List </small>
		</h2>
      </div>
      
      <table id="data-table-command" class="table table-striped table-vmiddle">
      	<colgroup>
            <col style="width: 10%;" />
            <col style="width: *;" />
            <col style="width: 10%;" />
            <col style="width: 15%;" />
            <col style="width: 10%;" />
            <col style="width: 10%;" />

         </colgroup>
         <thead>
            <tr>     
               <th data-column-id="id" data-type="numeric">Num</th>
				<th data-column-id="sender">Title</th>
				<th data-column-id="sortd" data-order="desc">Classification</th>
				<th data-column-id="writer" data-order="desc">Writer</th>
				<th data-column-id="received" data-order="desc">Registered</th>	
				<th data-column-id="answer" data-order="desc">Reply Status</th>		
				<th data-column-id="commands" data-formatter="commands"	data-sortable="false"></th>
            </tr>
         </thead>
         <tbody>
           <c:forEach items="${list }" var="list">
				<tr>
					<td>${list.qa_num}</td>
					<td>${list.qa_title}</td>
					
					<c:choose>

						<c:when test="${list.qa_f_option==0}">
							<td>프랜차이즈카페문의</td>
						</c:when>
						<c:when test="${list.qa_f_option==1}">
							<td>개인카페문의</td>
						</c:when>
						<c:when test="${list.qa_f_option==2}">
							<td>커스텀마이징문의</td>
						</c:when>
						<c:when test="${list.qa_f_option==3}">
							<td>이벤트문의</td>
						</c:when>
						<c:otherwise>
							<td>건의사항</td>
						</c:otherwise>
					</c:choose>
					<td>${list.qa_email}</td>
					<td>${list.qa_reg_date}</td>
					<c:choose>

						<c:when test="${list.qa_answer==0}">
							<td>Complete</td>
						</c:when>
						<c:otherwise>
							<td>Incomplete</td>
						</c:otherwise>
					</c:choose>
					
				</tr>
			</c:forEach>
         </tbody>
      </table>

   </div>
   </div>
   </section>


        
   
