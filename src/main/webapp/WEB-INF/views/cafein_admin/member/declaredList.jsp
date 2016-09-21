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
                            <h2>Report Management Table <br><br><small>Report Message & User Controller Page</small></h2>
                        </div>
                        
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th>+/-</th>
                                        <th>Report Sequence</th>
                                        <th>Report User ID</th>
                                        <th>Infomant ID</th>
                                        <th>Reported Date</th>
                                        <th>Handle Type</th>
                                       
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
							 
							  <tr> <!--   style="display:none" -->
							
                                <td colspan="6"><p>신고 내용 : ${declared.d_content}</p></td>
						    </tr>
							</c:forEach>
				
                               
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                  
                </div>
            </section>

       