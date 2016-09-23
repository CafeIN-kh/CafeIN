<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>

    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Private Info</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li><a href="private_main.do">Private Cafe</a></li>
                <li class="active">Private Info</li>
            </ul>
        </div><!--/container-->
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->

    <!--=== Content Part ===-->
    <div class="container content"> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
        <div class="headline">
        	<h2>Cafe Introduce</h2>
        	
        	<!-- 로그인 여부 체크하기 위해 세션 u_uid값 hidden 처리(좋아요,즐겨찾기 여부 판단 위해) -->
        	<input type="hidden" id="u_uid" value="${u_uid}">
        	
        	<!-- 사장 권한으로 방문시 생성, 현재  등록된 카페의 u_uid와 세션의 u_uid 값이 같고 레벨이 1이면 생성 -->
        	<c:if test="${u_level == 1 && pcafe_info.u_uid == u_uid}">
				<div class="btn-group" style="float: right; padding: 0 0 10px 10px;">
					<button type="button" class="btn-u korean-font" data-toggle="modal" data-target="#responsive">카페관리</button>
				</div>
			</c:if>
       		<!-- END 사장 권한으로 방문시 생성 -->
       		
        </div><!-- headline END -->
        
        <!-- 카페등록 모달 -->
		<div class="modal fade" id="responsive" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title korean-font" id="myModalLabel4">카페정보 관리</h4>
					</div>
					<div class="modal-body">
						<form action="pcafe/modify.do" method="post" id="sky-form1"
							enctype="multipart/form-data" class="sky-form"
							novalidate="novalidate" style="border: 0;">
	
							<fieldset>
								<input type="hidden" name="pcafe_num" value="${pcafe_info.pcafe_num}" id="pcafe_num">
								<div class="row">
									<section class="col col-6">
										<label class="label">Cafe Name</label> 
										<label class="input">
											<input type="text" class="korean-font" name="pcafe_name" id="pcafe_name" 
													value="${pcafe_info.pcafe_name}" >
										</label>
									</section>
									<section class="col col-6">
										<label class="label">Cafe Phone Number</label> 
										<label class="input"> <!-- <i class="icon-append fa fa-envelope-o"></i> -->
											<input type="text" class="korean-font" name="pcafe_phone" id="pcafe_phone"
													value="${pcafe_info.pcafe_phone}">
										</label>
									</section>
								</div>
	
								<section>
									<label class="label">Cafe Address</label> 
									<label class="input">
										<!-- <i class="icon-append fa fa-tag"></i> --> 
										<input type="text" class="korean-font" name="pcafe_address" id="pcafe_address"
												value="${pcafe_info.pcafe_address}">
									</label>
								</section>
	
								<div class="row">
									<section class="col col-6">
										<label class="label">Cafe Home URL</label> 
										<label class="input">
											<!-- <i class="icon-append fa fa-user"></i> --> 
											<input type="text" class="korean-font" name="pcafe_url" id="pcafe_url"
													value="${pcafe_info.pcafe_url}">
										</label>
									</section>
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
	
									<section class="col col-3">
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
									<label class="textarea"> <!-- <i class="icon-append fa fa-comment"></i> -->
										<textarea rows="4" class="korean-font" name="pcafe_introduce" id="pcafe_introduce">${pcafe_info.pcafe_introduce}</textarea>
									</label>
								</section>
	
								<section>
									<label class="label korean-font">Cafe Tag(쉼표로 구분해주세요)</label> 
									<label class="input">
										<input type="text" class="korean-font" name="pcafe_hash_tag" id="pcafe_hash_tag"
												value="${pcafe_info.pcafe_hash_tag}">
									</label>
								</section>
								
								<section style="margin-bottom: 50px;">
									<label class="label korean-font">Cafe Image <span style="color:red;">Add</span>(필수추가 항목이 아닙니다.)</label>
									<label for="pcafe_img" class="input input-file"> 
									 	<!-- <div class="button"> -->
										<input type="file" name="upload_modify" id="upload_modify" multiple 
										onchange="this.parentNode.nextSibling.value = this.value" class="korean-font"> 
										<!-- Browse</div> --> <!-- <input type="text" placeholder="Please file upload" readonly> -->
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
		</div>
		<!-- 카페등록 모달 END -->

		<div class="row portfolio-item margin-bottom-50"> 

            <!-- Content Info --> 
            <div class="col-md-6 md-margin-bottom-40 funny-boxes" style="background:#ffffff;">
            	<div class="pull-left">
            		<!-- pcafe_num 박아놓기. private_detail.js ajax에서 넘겨야하므로 -->
            		<input type="hidden" name="pcafe_num" value="${pcafe_info.pcafe_num}" id="pcafe_num">
            		<h2 class="korean-font">${pcafe_info.pcafe_name}</h2>
            	</div>
            	<ul class="list-unstyled list-inline funny-boxes-rating pull-right" style="margin-top:-3px;">
                	<li>
                		<a id="pcafe_bookmark" style="text-decoration:none;color:#ffffff;cursor:pointer;">
                			<!-- bookmarkCount가 0이라면 해당 아이디는 즐겨찾기는 하지 않은 것임 -->
                			<c:if test="${bookmarkCount == 0}">
                				<i class="fa fa-star-o" style="font-size:25px;"></i>
                			</c:if>
                			<c:if test="${bookmarkCount != 0}">
                				<i class="fa fa-star" style="font-size:25px;"></i>
                			</c:if>
                		</a>
                	</li>
                </ul>
            	<div class="row portfolio-item1">
                    <div class="col-xs-12">
                    	<ul class="list-unstyled list-inline blog-info">
		                	<li style="padding:5px 5px;"><i class="fa fa-calendar color-green"></i> ${pcafe_info.pcafe_reg_date}</li>
		                    <li style="padding:5px 5px;"><i class="fa fa-comments color-green"></i> ${pcafe_info.pc_reply_cnt} Comments</li>
		                    <li style="padding:5px 5px;"><i class="fa fa-eye color-green"></i> ${pcafe_info.pcafe_visit}</li>
		                    <li style="padding:5px 5px;" id="like_count"><i class="fa fa-heart color-green" style="font-size:15px;"></i> ${pcafe_info.pc_like_cnt}</li>
	                	</ul>
                    	<p class='korean-font' style="margin-bottom:30px;"> 
                    		${pcafe_info.pcafe_introduce} <br>
						</p>
						<!-- likeCount가 0이라면 해당 아이디는 좋아요를 하지 않은 것임 -->
                		<c:if test="${likeCount == 0}">
							<a id="pcafe_like" class="btn-u btn-u-large korean-font" style="text-decoration:none;color:#ffffff;cursor:pointer;">
								<i class="fa fa-thumbs-o-up"></i> 좋아요!
							</a>
						</c:if>
						<c:if test="${likeCount > 0}">
               				<a id="pcafe_like" class="btn-u btn-u-large korean-font" style="text-decoration:none;color:#ffffff;cursor:pointer;">
								<i class="fa fa-thumbs-o-up"></i> 취소하기
							</a>
               			</c:if>
                    </div>
                </div>  
            </div>
            <!-- End Content Info -->  
            
            <!-- Carousel -->
            <div class="col-md-6">
                <div class="carousel slide carousel-v1" id="myCarousel">
                    <div class="carousel-inner" id="pcafe_img">
                    	<!-- 자바스크립트에서 *,단위 잘라서 append 붙이기 -->
                    </div>
                    
                    <div class="carousel-arrow">
                        <a data-slide="prev" href="#myCarousel" class="left carousel-control">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a data-slide="next" href="#myCarousel" class="right carousel-control">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                </div>
            </div>
            <!-- End Carousel -->      
        </div><!--/row-->

        <div class="tag-box tag-box-v2">
        	<div class="col-md-6">
        		<ul class="list-unstyled">
        			<li class="korean-font" id="pcafe_address"><i class="fa fa-map-marker color-green"></i> ${pcafe_info.pcafe_address}</li>
        		</ul>
        	</div>
        	<div class="col-md-6">
        		<ul class="list-unstyled">
        			<li><i class="fa fa-home color-green"></i> ${pcafe_info.pcafe_url}</li>
        		</ul>
        	</div>
        	<div class="col-md-6">
        		<ul class="list-unstyled">
        			<li><i class="fa fa-phone color-green"></i> ${pcafe_info.pcafe_phone}</li>
        		</ul>
        	</div>
        	<div class="col-md-6">
        		<ul class="list-unstyled">
        			<li><i class="fa fa-history color-green"></i> ${pcafe_info.pcafe_time}</li>
        		</ul>
        	</div>
        	<!-- 자바스크립트에서 ,단위로 잘라서 가져오기 -->
        	<ul class="list-unstyled">
        		<li style="padding:0 15px;" class="korean-font" id="pcafe_tag"></li>
        	</ul>
        </div>

        <div class="margin-bottom-20 clearfix"></div>   
        
        
        <!-- 구글 맵 Begin Content -->
        <div class="col-md-12">

            <!-- Basic Map -->
            <div class="headline"><h3>Cafe Map</h3></div>
            <div id="map_tag"></div>
            <div id="map" class="map margin-bottom-50"></div>
            <!-- End Basic Map -->

        </div>
        <!-- End 구글 맵 Content --> 
        
		<div class="margin-bottom-20 clearfix"></div>
            
        <!-- Cafe Menu -->
        <div class="headline">
        
        	<h2>Cafe Menu</h2>
        	
	        <!-- 사장 권한으로 방문시 생성, 현재  등록된 카페의 u_uid와 세션의 u_uid 값이 같고 레벨이 1이면 생성 -->
        	<c:if test="${u_level == 1 && pcafe_info.u_uid == u_uid}">
	        	<div class="btn-group" style="float: right; padding: 0 0 10px 10px;">
					<button type="button" class="btn-u korean-font" data-toggle="modal" data-target="#responsive-menu">메뉴추가</button>
				</div>
	   		</c:if>
	   		<!-- END 사장 권한으로 방문시 생성 -->
        
        </div>
        
        
        <!-- 카페메뉴 모달 -->
		<div class="modal fade" id="responsive-menu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title korean-font" id="myModalLabel4">카페메뉴 관리</h4>
					</div>
					<div class="modal-body">
						<form action="pcafe/menuRegister.do" method="post" id="sky-form5"
							enctype="multipart/form-data" class="sky-form"
							novalidate="novalidate" style="border: 0;">
	
							<fieldset>
								<input type="hidden" name="pcafe_num" value="${pcafe_info.pcafe_num}" id="pcafe_num">
								<div class="row">
									<section class="col col-6">
										<label class="label">Cafe Menu Name</label> 
										<label class="input">
											<input type="text" class="korean-font" name="pmenu_name" id="pmenu_name" >
										</label>
									</section>
									<section class="col col-6">
										<label class="label">Cafe Menu Price</label> 
										<label class="input"> 
											<input type="text" class="korean-font" name="pmenu_price" id="pmenu_price" placeholder="숫자만 입력해주세요.">
										</label>
									</section>
								</div>
	
								<section>
									<label class="label">Cafe Menu Introduce</label> 
									<label class="textarea"> 
										<textarea rows="4" class="korean-font" name="pmenu_introduce" id="pmenu_introduce"></textarea>
									</label>
								</section>
	
								<section style="margin-bottom: 50px;">
									<label class="label">Cafe Image Upload</label>
									<label for="pmenu_img" class="input input-file"> 
									 	<!-- <div class="button"> -->
										<input type="file" name="upload_menu" id="upload_menu" multiple 
										onchange="this.parentNode.nextSibling.value = this.value" class="korean-font"> 
										<!-- Browse</div> --> <!-- <input type="text" placeholder="Please file upload" readonly> -->
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
		</div>
		<!-- 카페메뉴 모달 END -->
		
        
        <!-- Cube Portfolio -->
        <div class="cube-portfolio container margin-bottom-20">
            <div class="margin-bottom-30">
            	<!-- <div id="filters-container" class="cbp-l-filters-text">
                    <div data-filter="*" class="cbp-filter-item cbp-filter-item"> All </div> |
                    <div data-filter=".web-design" class="cbp-filter-item"> Web Design </div>
                </div> -->
                <!-- <div id="filters-container" class="cbp-l-filters-text">
                    <div data-filter="*" class="cbp-filter-item-active cbp-filter-item"> All </div> |
                    <div data-filter=".illustration" class="cbp-filter-item"> Illustration </div> |
                    <div data-filter=".web-design" class="cbp-filter-item"> Web Design </div> |
                    <div data-filter=".graphic" class="cbp-filter-item"> Graphic </div> |
                    <div data-filter=".logo" class="cbp-filter-item"> Logo </div>
                </div> --><!--/end Filters Container-->
            </div>
            
           	<!-- 카페 메뉴 정보 페이징 하는 부분 -->
            <%-- <div id="grid-container" class="cbp-l-grid-gallery pcafeMenuList">
            	
            	<div class="cbp-item illustration web-design">
                	<!-- cube-portfolio-lightbox.js 파일로 ajax 처리해서 정보 아래 뿌리는거! -->
                	<a href="#" class="cbp-caption cbp-singlePageInline"
                       data-title="World Clock Widget<br>by Paul Flavius Nechita">
                        <div class="cbp-caption-defaultWrap">
                            <img src="/CafeIN/upload/private_menu/147317581933210.jpg">
                        </div>
                        <div class="cbp-caption-activeWrap">
                            <div class="cbp-l-caption-alignLeft">
                                <div class="cbp-l-caption-body">
                                    <div class="cbp-l-caption-title korean-font">${menuList.pmenu_name}</div>
                                    <div class="cbp-l-caption-desc">가격 : ${menuList.pmenu_price}원</div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div> --%>
           	
           	<!-- 카페 메뉴 정보 페이징 하는 부분 -->
           	<c:if test="${count == 0}">
				<div class="korean-font" style="text-align:center;font-size: xx-large;color:#72c02c;margin: 200px 0;">등록된 메뉴가 없습니다.</div>
			</c:if>
			<c:if test="${count > 0}">
	            <div id="grid-container" class="cbp-l-grid-gallery pcafeMenuList">
					
					<c:forEach var="menuList" items="${menuList}" varStatus="status">
		                <div class="cbp-item illustration web-design menuList${status.index} easy-block-v1">
		                
			                <!-- 현재  등록된 카페의 u_uid와 세션의 u_uid 값이 같으면 메뉴 삭제 버튼 생성 -->
	        				<c:if test="${pcafe_info.u_uid == u_uid}">
	        					<!-- 메뉴 삭제 부분 -->
				            	<a onclick="pcafeMenuDelete(${menuList.pmenu_num},${pcafe_info.pcafe_num})"
				            		class="easy-block-v1-badge rgba-red" style="text-decoration:none;position:initial;line-height:30px;cursor:pointer;">
				            		<i class="fa fa-trash-o"></i> Delete
				            	</a> 
			            	</c:if>
			            	
		                	<!-- cube-portfolio-lightbox.js 파일로 ajax 처리해서 정보 아래 뿌리는거! -->
		                	<a href="/CafeIN/cafein_user/private/private_detailMenuDetail_ajax.do?pmenu_num=${menuList.pmenu_num}" class="menuListNum${status.index} cbp-caption cbp-singlePageInline"
		                       data-title="World Clock Widget<br>by Paul Flavius Nechita">
		                        <div class="cbp-caption-defaultWrap menuListImg${status.index}" name="menuListImg${status.index}">    
		                            <img src="/CafeIN/upload/private_menu/${menuList.pmenu_img}">
		                        </div>
		                        <div class="cbp-caption-activeWrap">
		                            <div class="cbp-l-caption-alignLeft">
		                                <div class="cbp-l-caption-body">
		                                	<div class="menuListName${status.index} cbp-l-caption-title korean-font" name="menuListName${status.index}">${menuList.pmenu_name}</div>
		                                    <div class="menuListPrice${status.index} cbp-l-caption-desc" name="menuListPrice${status.index}">가격 : ${menuList.pmenu_price}원</div>
		                                </div>
		                            </div>
		                        </div>
		                    </a>
		                </div>
	                </c:forEach>
	            </div><!--/end Grid Container-->
            	<div class="text-center">
	        		<ul class="pagination">
	        			${pagingHtml}
	        		</ul>  
	        	</div>
            </c:if>
			<!-- END 카페 메뉴 정보 페이징 하는 부분 -->
            <br><br>
            
        </div>
        <!-- End Cube Portfolio -->
    	
    </div><!--/container-->	 	
    <!--=== End Contednt Part ===-->
    


    <!-- 댓글 부분 : blog_large_full_width_item.html -->
    <div class="container content blog-page blog-item">		
    <!-- Recent Comments -->
        <div class="headline margin-bottom-30"><h3>Comments</h3></div>
        <div class="media margin-bottom-40">
            <!-- <h3>Comments</h3> -->
            <!-- <hr> -->
            
            <!-- 댓글 목록 출력 -->
			<div id="output"></div>
			<!-- END 댓글 목록 출력 -->
			
            <!-- <div class="media-body">
                <h4 class="media-heading korean-font-bold">jang_delay <span>2016-08-13 | <a href="">삭제</a> | <a href="">신고</a></span></h4>
                <br>
                <div class="col-md-11">
	                <p class="korean-font">댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요.
	                						댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요.</p>
				</div>
            </div>
            <hr> -->
            
        <br>
        
        <!-- <div class="cbp-l-loadMore-button">
        	<a href="" class="cbp-l-loadMore-button-link">LOAD MORE</a>
            <a href="${pageContext.request.contextPath}/resources/cafein_user/assets/ajax/loadMore.html" class="cbp-l-loadMore-button-link">LOAD MORE</a>
        </div> -->
        
        <div class="paging_button" style="display:none;">
       		<button type="button" class="btn-u btn-block" style="width: 10%;margin:0 45%;">Load More</button>
		</div>
        
		<!-- <input type="button" value="다음글 보기"> -->
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/ajax-loader.gif">
		</div>
		
        <!-- End Recent Comments -->
        </div><!--/media-->
        
        <div class="modal fade" id="declear" tabindex="-1" role="dialog"
        	 aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
              <div class="modal-content">
                 <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                       aria-hidden="true">&times;</button>
                    <h4 class="modal-title korean-font" id="myModalLabel4">신고</h4>
                 </div>
                 <div class="modal-body">
                    <form action="/CafeIN/cafein_user/private/private_detailReplyDeclaredRegister.do" novalidate="novalidate"
                    	  id="sky-form4" class="sky-form" method="post" style="border: 0;">
                       <fieldset>
                       
                       	  <!-- 현재 선택한 댓글의 시퀀스 -->
                       	  <input type="hidden" id="d_target_id" name="d_target_id" value="${declaredReply.preply_num}">
                       	  
                       	  <!-- d_target_path : 0[프랜차이즈 댓글] 1[개인카페 댓글] 2[커스터마이징 댓글] 개인카페 쪽이므로 1번으로 박아서 넘김 -->
                       	  <input type="hidden" id="d_target_path" name="d_target_path" value="1">
                       	  
                       	  <!-- d_target_num : 신고 대상(댓글)의 상위 경로 시퀀스(개인카페 시퀀스) -->
                       	  <input type="hidden" name="pcafe_num" value="${pcafe_info.pcafe_num}" id="pcafe_num">
                       	  
                          <section>
                          	 <!-- 신고한 사람의 정보는 세션에서 가져오기 -->
                             <label class="label" id="d_mem_id_name" name="d_mem_id_name" style="font-weight:bold;">신고자 닉네임 : ${u_name}</label> 
                             <input type="hidden" name="d_mem_id" id="d_mem_id" value="${u_uid}">
                          </section>
                          
                          <section>
                             <label class="label" id="d_target_mem_id_name" name="d_target_mem_id_name" value="" style="font-weight:bold;">피신고자 닉네임 : </label> 
                             <input type="hidden" name="d_target_mem_id" id="d_target_mem_id" value="">
                          </section>

                          <section>
                             <label class="label korean-font">신고 내용</label> <label
                                class="textarea"> <!-- <i class="icon-append fa fa-comment"></i> -->
                                <textarea rows="4" name="d_content" id="d_content" class="korean-font"></textarea>
                             </label>
                          </section>

                          <button type="submit" class="btn-u btn-u-primary"
                             style="float: right;">Register</button>
                          <button type="button" class="btn-u btn-u-default"
                             data-dismiss="modal" style="float: right; margin-right: 5px;">Close</button>
                       </fieldset>
                    </form>
                 </div>
              </div>
           </div>
        </div>

        <!-- Comment Form -->
        <div class="post-comment">
            <!-- <h3>Leave a Comment</h3> -->
            
            <form id="reply_form">
            	<%-- <input type="hidden" id="replyForm_u_uid" value="${u_uid}"> --%>
            	<input type="hidden" id="preply_nickname" value="${u_name}">
                <label style="font-size:17px;" class="korean-font-bold">
                	<c:if test="${u_name != null}">
                		<i class="fa fa-user">&nbsp;&nbsp;</i>${u_name}
                	</c:if>
                	<c:if test="${u_name == null}">
                		<i class="fa fa-user">&nbsp;&nbsp;</i>Guest
                	</c:if>
                </label>
                <div class="row margin-bottom-20">
                    <div class="col-md-12 col-md-offset-0">
                        <textarea id="preply_content" class="form-control korean-font" rows="5"></textarea>
                    </div>                
                </div>
                <p style="float:right;">
                	<button class="btn-u" type="submit">Send Message</button>
                </p>
            </form>
        </div>
        <!-- End Comment Form -->
        
    </div><!--/container--><!-- END 댓글 부분 : blog_large_full_width_item.html -->		
    <!--=== End Content Part ===-->
