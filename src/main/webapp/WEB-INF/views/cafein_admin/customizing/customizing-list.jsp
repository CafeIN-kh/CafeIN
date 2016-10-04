<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
  <section id="content">
                <div class="container">
                    <div class="block-header">
                        
                        
                       
                    </div>
                    
                    
                  
                  <div class="card">
                        <div class="card-header">
                            <h2>View Customizing List <small>Inquiry into Customizing Info</small></h2>
                        </div>
                        
                        <table id="data-table-command" class="table table-striped table-vmiddle">
                            <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric">Custom_num</th>
                                    <th data-column-id="sender">franchise_name</th>
                                    <th data-column-id="receivedy" data-order="desc">Custom_name</th>
                                    <th data-column-id="receiveds" data-order="desc">Reg_date</th>
                                    <th data-column-id="received" data-order="desc">Visit</th>
                                    <th data-column-id="commands" data-formatter="commands" data-sortable="false">Modify & Delete Cafe</th>
                                </tr>
                            </thead>
                            <tbody>
								<c:forEach items="${list }" var="list">
									<tr>
										<td>${list.custom_num}</td>
										<td>${list.franchise_name}</td>
										<%-- <td>${list.franchise_name}</td> --%>
										<td>${list.custom_name}</td>
										<td>${list.custom_reg_date}</td>
										<td>${list.custom_visit}</td>
										
						</tr>
					</c:forEach>
                            </tbody>
                        </table>
                    </div>
              
                  
                </div>
            </section>
          