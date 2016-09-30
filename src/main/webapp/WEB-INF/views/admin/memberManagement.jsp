<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section id="content">
	<div class="container">
		<div class="block-header">
			<h2>Member management</h2>

			<ul class="actions">
				<li><a href=""> <i class="md md-trending-up"></i>
				</a></li>
				<li><a href=""> <i class="md md-done-all"></i>
				</a></li>
				<li class="dropdown"><a href="" data-toggle="dropdown"> <i
						class="md md-more-vert"></i>
				</a>

					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="">Refresh</a></li>
						<li><a href="">Manage Widgets</a></li>
						<li><a href="">Widgets Settings</a></li>
					</ul></li>
			</ul>
		</div>




		<div class="card">
			<div class="card-header">
				<h2>
					회원 관리 <small>회원관리 페이지입니다.</small>
				</h2>
			</div>

			<div class="table-responsive">


				<table id="data-table-command"
					class="table table-striped table-vmiddle">
					<thead>
						<tr>
							<!-- data-type="numeric"  -->
							<th data-column-id="id" data-identifier="true">이름</th>
							<th data-column-id="sender">이메일</th>
							<th data-sortable="false">권한</th>
							<th data-column-id="received" data-order="desc">회원등록일</th>
							<th data-column-id="commands" data-formatter="commands"
								data-sortable="false">관리</th>
						</tr>
					</thead>
					<tbody>



						<c:forEach var="member" items="${list}" varStatus="status">
							<tr>
								<%--  <td>${status.count}</td> --%>
								<td>${member.u_name}</td>
								<!-- <td><a href="detail.do?u_uid=${member.u_uid}">${member.u_uid}</a></td> -->
								<td>${member.u_email}</td>

								<c:choose>

									<c:when test="${member.u_level == '0'}">
										<td>일반회원</td>
									</c:when>

									<c:when test="${member.u_level == '1'}">
										<td>사업자회원</td>
									</c:when>

									<c:when test="${member.u_level == '2'}">
										<td>관리자</td>
									</c:when>

									<c:otherwise>
										<td>회원정보 없음</td>
									</c:otherwise>

								</c:choose>
								<td>${member.u_reg_date}</td>
							</tr>


						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>





   <!-- 회원정보 모달 -->
            <div class="modal fade" id=admin_memberModify tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title korean-font" id="myModalLabel4">회원정보</h4>
                            </div>
                            <div class="modal-body">
                                <form action="admin_memberModify.do" method="post"
                                      id="sky-form1" class="sky-form" novalidate="novalidate" style="border:0;">
                                 
                                <fieldset>                  
                                    <div class="row">
                                        <section class="col col-6">
                                         
                                            <label class="label">Cafe Name</label>
                                            <label class="input">
                                                <input type="text" class="korean-font" name="pcafe_name" id="pcafe_name">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Cafe Phone Number</label>
                                            <label class="input">
                                                <!-- <i class="icon-append fa fa-envelope-o"></i> -->
                                                <input type="text" class="korean-font" name="pcafe_phone" id="pcafe_phone">
                                            </label>
                                        </section>
                                    </div>
                                    
                                    <section>
                                        <label class="label">Cafe Address</label>
                                        <label class="input">
                                            <!-- <i class="icon-append fa fa-tag"></i> -->
                                            <input type="text" class="korean-font" name="pcafe_address" id="pcafe_address">
                                        </label>
                                    </section>
                                    
                                    
                                    
                                    <section>
                                        <label class="label">Cafe Introduce</label>
                                        <label class="textarea">
                                            <!-- <i class="icon-append fa fa-comment"></i> -->
                                            <textarea rows="4" class="korean-font" name="pcafe_introduce" id="pcafe_introduce"></textarea>
                                        </label>
                                    </section>
                                 
                                </fieldset>
                                
                                <div class="modal-footer">
                                      <button type="button" class="btn-u btn-u-default" data-dismiss="modal">닫기</button>
									  <button type="submit" class="btn-u btn-u-primary">수정</button>
                                  </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div><!-- 카페등록 모달 END -->











	</div><!--  End container -->
</section>






