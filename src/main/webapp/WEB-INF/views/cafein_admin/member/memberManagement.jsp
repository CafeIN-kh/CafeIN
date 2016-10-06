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
                           
                           <c:when test="${member.u_level == '3'}">
                              <td>계정 정지</td>
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





      <!-- 회원정보 모달  -->
      <div class="modal fade admin_memberModify" role="dialog">
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                     aria-hidden="true">&times;</button>
                  <h4 class="modal-title korean-font" id="myModalLabel4">회원정보</h4>
               </div>
               <div class="modal-body">



                  <!-- action="admin_memberModify.do"  -->
                  <form id="adminMembermodify_form" class="log-reg-block sky-form">

                     <fieldset>

                        <div class="form-group">
                           <label for="u_email" class="form-control-label">Email </label>
                           <input type="text" class="form-control" placeholder="Email"
                              name="u_email" id="u_email" readonly>
                        </div>

                        <div class="form-group">
                           <label for="u_name" class="form-control-label">Name </label> 
                           <input type="text" class="form-control" placeholder="Username"
                              name="u_name" id="u_name">
                        </div>

                        <div class="form-group">
                           <label for="u_name" class="form-control-label">Password</label> 
                           <input type="text" class="form-control"
                              placeholder="New Password" name="u_password" id="u_password">
                        </div>


                        권한

                        <div class="inline-group">

                           <div class="adminMemberChk">


                              <input type="radio" value="0" name="u_level" /> 
                              <label class="radio korean-font">일반회원</label> 
                              
                              <input type="radio" value="1" name="u_level" /> 
                              <label class="radio korean-font">사업자 회원</label> 
                              
                              <input type="radio" value="2" name="u_level" /> 
                              <label class="radio korean-font">관리자</label>
                              
                              <input type="radio" value="4" name="u_level" /> 
                              <label class="radio korean-font">계정 정지</label>

                           </div>

                        </div>
                     </fieldset>

                     <div class="modal-footer">
                        <button type="button" class="btn-u btn-u-default" data-dismiss="modal">닫기</button>
                        <button type="submit" class="btn-u btn-u-primary" id="adminMemberModifyBtn">수정</button>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
      <!-- 카페등록 모달 END -->





   <!-- 회원삭제 모달  -->
      <div class="modal fade admin_memberDelete" role="dialog">
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                     aria-hidden="true">&times;</button>
                  <h4 class="modal-title korean-font" id="myModalLabel4">회원삭제</h4>
               </div>
               <div class="modal-body">

                         정말 <span style="color:red; font-weight:bold;" id="checkemail"></span> 계정을 삭제하시겠습니까?

                     <div class="modal-footer">
                        <button type="button" class="btn-u btn-u-default" data-dismiss="modal">취소</button>
                        <button type="submit" class="btn-u btn-u-primary" id="adminMemberDeleteBtn">삭제</button>
                     </div>
               
               </div>
            </div>
         </div>
      </div>
      <!-- 회원 삭제 모달 END -->





   </div>
   <!--  End container -->
</section>


