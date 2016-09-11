<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Private Cafe</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li class="active">Private Cafe</li>
            </ul>
        </div>
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->
    
   <!--=== Search Block Version 2 ===-->
    <!-- <div class="search-block-v2">
        <div class="container">
            <div class="col-md-6 col-md-offset-3">
                <h2>Search</h2>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search words with regular expressions ...">
                    <span class="input-group-btn">
                        <button class="btn-u" type="button"><i class="fa fa-search"></i></button>
                    </span>
                </div>
            </div>
        </div>    
    </div> --><!--/container-->     
    <!--=== End Search Block Version 2 ===-->

    <!--=== Content Part ===-->
    <div class="container content">		
    	<div class="row blog-page">    
            <!-- Left Sidebar -->
        	<div class="col-md-12 md-margin-bottom-40">
        		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        		<div class="col-md-12">
        			<!-- 사장 권한으로 방문시 생성 -->
        			<c:if test="${u_level == 1}">
	        			<div class="btn-group" style="float: right; padding: 0 0 10px 10px;">
							<button type="button" class="btn-u korean-font" data-toggle="modal" data-target="#responsive">
								카페 등록
							</button>
						</div>
					</c:if>
					<!-- END 사장 권한으로 방문시 생성 -->
					<div class="btn-group" style="float: right;">
						<button type="button" class="btn-u dropdown-toggle pcafe_category korean-font"
							data-toggle="dropdown" aria-expanded="false">
							정렬하기 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li class="korean-font"><a id="pcafe_category_recent" style="cursor:pointer">최신순</a></li>
							<li class="korean-font"><a id="pcafe_category_visit" style="cursor:pointer">조회순</a></li>
							<li class="korean-font"><a id="pcafe_category_like" style="cursor:pointer">좋아요순</a></li>
							<!-- 사장 권한으로 방문시 생성 -->
							<c:if test="${u_level == 1}">
								<li class="korean-font"><a id="pcafe_category_myPCafe" style="cursor:pointer">나의 등록글</a></li>
							</c:if>
							<!-- END 사장 권한으로 방문시 생성 -->
						</ul>
					</div>
        			
				</div>
				
				<!-- 카페등록 모달 -->
				<div class="modal fade" id="responsive" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title korean-font" id="myModalLabel4">카페등록</h4>
                            </div>
                            <div class="modal-body">
                                <form action="pcafe/register.do" method="post" enctype="multipart/form-data" 
                                		id="sky-form1" class="sky-form" novalidate="novalidate" style="border:0;">
				                     
				                    <fieldset>                  
				                        <div class="row">
				                            <section class="col col-6">
				                            	<!-- <label class="label" for="pcafe_name">Cafe Name</label>
				                            	<label class="input">
				                            		<form:input path="pcafe_name"/>
				                            	</label> -->
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
				                        
				                        <div class="row">
				                            <section class="col col-6">
				                                <label class="label">Cafe Home URL</label>
				                                <label class="input">
				                                    <!-- <i class="icon-append fa fa-user"></i> -->
				                                    <input type="text" class="korean-font" name="pcafe_url" id="pcafe_url">
				                                </label>
				                            </section>
				                            <!-- <section class="col col-6">
				                                <label class="label">Cafe Business Hours</label>
				                                <label class="input">
				                                    <input type="text" name="pcafe_time" id="pcafe_time">
				                                </label>
				                            </section> -->
											<section class="col col-3">
				                            	<label class="label">Start Time</label>
												<label class="select">
													<select name='pcafe_time_start'>
														<option title='start_time' value='6:00AM'>6:00AM</option>
														<option title='start_time' value='6:30AM'>6:30AM</option>
														<option title='start_time' value='7:00AM'>7:00AM</option>
														<option title='start_time' value='7:30AM'>7:30AM</option>
														<option title='start_time' value='8:00AM'>8:00AM</option>
														<option title='start_time' value='8:30AM'>8:30AM</option>
														<option title='start_time' value='9:00AM' selected>9:00AM</option>
														<option title='start_time' value='9:30AM'>9:30AM</option>
														<option title='start_time' value='10:00AM'>10:00AM</option>
														<option title='start_time' value='10:30AM'>10:30AM</option>
														<option title='start_time' value='11:00AM'>11:00AM</option>
														<option title='start_time' value='11:30AM'>11:30AM</option>
														<option title='start_time' value='12:30PM'>12:30PM</option>
														<option title='start_time' value='1:00PM'>1:00PM</option>
													</select>
												</label>
											</section>

											<section class="col col-3" >
												<label class="label">End Time</label>
												<label class="select">
													<select name='pcafe_time_end'>
														<option title='end_time' value='9:00PM'>9:00PM</option>
														<option title='end_time' value='9:30PM'>9:30PM</option>
														<option title='end_time' value='10:00PM'>10:00PM</option>
														<option title='end_time' value='10:30PM'>10:30PM</option>
														<option title='end_time' value='11:00PM'>11:00PM</option>
														<option title='end_time' value='11:30PM'>11:30PM</option>
														<option title='end_time' value='12:00AM'>12:00AM</option>
														<option title='end_time' value='12:30AM'>12:30AM</option>
														<option title='end_time' value='1:00AM' selected>1:00AM</option>
														<option title='end_time' value='1:30AM'>1:30AM</option>
														<option title='end_time' value='2:00AM'>2:00AM</option>
														<option title='end_time' value='2:30AM'>2:30AM</option>
														<option title='end_time' value='3:00AM'>3:00AM</option>
													</select>
												</label>
											</section>
				                        </div>
				                        
				                        <section>
				                            <label class="label">Cafe Introduce</label>
				                            <label class="textarea">
				                                <!-- <i class="icon-append fa fa-comment"></i> -->
				                                <textarea rows="4" class="korean-font" name="pcafe_introduce" id="pcafe_introduce"></textarea>
				                            </label>
				                        </section>
				                        
				                        <section>
				                            <label class="label korean-font">Cafe Tag(쉼표로 구분해주세요)</label> 
				                            <label class="input">
				                                <input type="text" class="korean-font" name="pcafe_hash_tag" id="pcafe_hash_tag">
				                            </label>
				                        </section>
				                        
				                        <section style="margin-bottom:50px;">
				                        	<label class="label">Cafe Image Upload</label>
											<label for="pcafe_img" class="input input-file">
												<!-- <div class="button"> -->
													<input type="file" name="upload" id="upload" multiple onchange="this.parentNode.nextSibling.value = this.value" class="korean-font">
												<!-- Browse</div> -->
												<!-- <input type="text" placeholder="Please file upload" readonly> -->
											</label>
										</section>
										
				                    </fieldset>
				                    
				                    <div class="modal-footer">
		                                <button type="button" class="btn-u btn-u-default" data-dismiss="modal">Close</button>
		                                <button type="submit" class="btn-u btn-u-primary">Register</button>
		                            </div>
				                </form>
                            </div>
                        </div>
                    </div>
                </div><!-- 카페등록 모달 END -->
				
				<div class="margin-bottom-10"></div> 
        		
        		<hr class="margin-bottom-60">
        		
        		<!-- Recent Works -->
		        <div class="text-center margin-bottom-50">
	                <h2 class="title-v2 title-center">PRIVATE CAFE</h2>
	                <p class="space-lg-hor korean-font">전국의 개인카페애 대한 정보가 들어있습니다. <span class="color-green">원하는 카드를 선택하여 들어가시면</span>, 더 많은 정보를 보실 수 있습니다.</p>
	            </div>
		        
		        <div class="row margin-bottom-20 news-v1">
		        
		        	<!-- 내글보기 누르면 삭제버튼 나오도록 하기 -->
		            <%-- <div class="col-md-4 col-sm-6 easy-block-v1">
		            	<!-- 삭제버튼 관련 소스, 바로 아래 a태그와 바로 위 easy-bolck-v1 클래스 -->
		            	<a href="#" class="easy-block-v1-badge rgba-red" style="left:22px;top:25px;text-decoration:none;">
		            		<i class="fa fa-trash-o"></i> Delete
		            	</a> 
		            	  
		            	<div class="thumbnails thumbnail-style thumbnail-kenburn news-v1-in">
		                    <div class="thumbnail-img">
		                        <div class="overflow-hidden">
		                            <img class="img-responsive" src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/main/img2.jpg"/>
		                        </div>
		                        <a class="btn-more hover-effect" href="${pageContext.request.contextPath}/cafein_user/private/private_detail.do" style="text-decoration:none;">read more +</a>                   
		                    </div>
		                    <div class="caption">
		                    	<h3 class="font-normal korean-font">Cafe O Clock</h3>
	                        	<ul class="list-unstyled list-inline blog-info">
		                            <li class='korean-font'>
		                            	<p style="max-height:43px;min-height:43px;overflow:hidden;margin-bottom:0px;">
		                            		<i class="fa fa-tags"></i> 
		                            		사업자가 내글보기를 누르면 카페 삭제하는 버튼 나오도록 하기!
		                            	</p>
		                            </li>
		                        </ul>
		                    </div>
		                    <ul class="list-inline news-v1-info no-margin-bottom" style="margin-top:15px;">
	                            <li><i class="fa fa-clock-o"></i> 2016-08-17</li>
	                            <li>|</li>
	                            <li><i class="fa fa-comments-o"></i> 14</li>
	                            <li>|</li>
	                            <li><i class="fa fa-eye"></i> 10</li>
	                            <li class="pull-right"><i class="fa fa-heart"></i> 239</li>
	                        </ul>
		                </div>
		            </div>
		            
		            <div class="col-md-4 col-sm-6">
		            	<div class="thumbnails thumbnail-style thumbnail-kenburn news-v1-in">
		                    <div class="thumbnail-img">
		                        <div class="overflow-hidden">
		                            <img class="img-responsive" src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/main/img2.jpg"/>
		                        </div>
		                        <a class="btn-more hover-effect" href="${pageContext.request.contextPath}/cafein_user/private/private_detail.do" style="text-decoration:none;">read more +</a>                   
		                    </div>
		                    <div class="caption">
		                    	<h3 class="font-normal korean-font">Cafe O Clock</h3>
	                        	<ul class="list-unstyled list-inline blog-info">
		                            <li class='korean-font'>
		                            	<p style="max-height:43px;min-height:43px;overflow:hidden;margin-bottom:0px;">
		                            		<i class="fa fa-tags"></i> 
		                            		강서구, 우장산, 분위기짱, 스터디
		                            	</p>
		                            </li>
		                        </ul>
		                    </div>
		                    <ul class="list-inline news-v1-info no-margin-bottom" style="margin-top:15px;">
	                            <li><i class="fa fa-clock-o"></i> 2016-08-17</li>
	                            <li>|</li>
	                            <li><i class="fa fa-comments-o"></i> 14</li>
	                            <li>|</li>
	                            <li><i class="fa fa-eye"></i> 10</li>
	                            <li class="pull-right"><i class="fa fa-heart"></i> 239</li>
	                        </ul>
		                </div>
		            </div> --%>
		            
		            <!-- 목록 출력 -->
					<div id="output" class="col-md-12 col-sm-6"></div>
					<div class="paging_button" style="display:none;">
						<br><br>
        				<button type="button" class="btn-u btn-block">Load More</button>
					</div>
					<div id="loading" style="text-align:center;display:none;">
						<img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/ajax-loader.gif"
							style="width:30px;height:30px;margin-top:15px;margin-bottom:350px;">
					</div>
		            
		        </div>
		        <!-- END Recent Works -->   

                
                <!--Pagination-->
                <!-- <div class="text-center">
                    <ul class="pagination">
                        <li><a href="#">«</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li class="active"><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#">»</a></li>
                    </ul>                                                            
                </div> -->
                <!-- <br><br>
        		<button type="button" class="btn-u btn-block">Load More</button> -->
                <!-- End Pagination -->
            </div>
            <!-- End Left Sidebar -->

        </div><!--/row-->        
    </div><!--/container-->		
    <!--=== End Content Part ===-->
