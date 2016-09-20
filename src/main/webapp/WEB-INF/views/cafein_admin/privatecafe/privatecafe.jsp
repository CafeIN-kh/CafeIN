<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
  <section id="content">
                <div class="container">
                    <div class="block-header">
                        <h2>Data Table</h2>
                        
                        <ul class="actions">
                            <li>
                                <a href="">
                                    <i class="md md-trending-up"></i>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="md md-done-all"></i>
                                </a>
                            </li>
                            <li class="dropdown">
                                <a href="" data-toggle="dropdown">
                                    <i class="md md-more-vert"></i>
                                </a>
                                
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li>
                                        <a href="">Refresh</a>
                                    </li>
                                    <li>
                                        <a href="">Manage Widgets</a>
                                    </li>
                                    <li>
                                        <a href="">Widgets Settings</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    
                    
                  
                  <div class="card">
                        <div class="card-header">
                            <h2>Private Cafe <small>Private Cafe의 정보를 조회 삭제 수정하기</small></h2>
                        </div>
                        
                        <table id="data-table-command" class="table table-striped table-vmiddle">
                            <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric">Pcafe_num</th>
                                    <th data-column-id="sender">Pcafe_name</th>
                                    <th data-column-id="receiveds" data-order="desc">Reg_date</th>
                                    <th data-column-id="received" data-order="desc">Address</th>
                                    <th data-column-id="commands" data-formatter="commands" data-sortable="false">카페 수정 및 삭제하기</th>
                                </tr>
                            </thead>
                            <tbody>
								<c:forEach items="${list }" var="list">
									<tr>
										<td>${list.pcafe_num}</td>
										<td>${list.pcafe_name}</td>
										<td>${list.pcafe_reg_date}</td>
										<td>${list.pcafe_address}</td>
										
						</tr>
					</c:forEach>
                            </tbody>
                        </table>
                    </div>
              
                  
                </div>
            </section>
          