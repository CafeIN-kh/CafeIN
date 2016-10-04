<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Franchise Info</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li><a href="franchise_main.do">Franchise Cafe</a></li>
                <li class="active">Franchise Info</li>
                <input type="hidden" value="${u_uid}" id="u_uid">
            </ul>
        </div>
    </div>
    <!--=== End Breadcrumbs ===-->

    <!-- About Me Block -->
    <div class="container content-sm">
    	<div class="headline" style="margin-bottom:30px;">
            <h2>Cafe Introduce</h2>
        </div>
        
        <div class="row about-me">
            <div class="col-sm-4 shadow-wrapper md-margin-bottom-40">
                <div class="box-shadow shadow-effect-2">
                    <img class="img-responsive img-bordered full-width" src="/CafeIN/upload/franchise/${franchise.franchise_img}"  style="height:300px; width:300px;">
                    <input type="hidden" value="${franchise.franchise_name}" id="franchise_name">
                </div>
            </div>

            <div class="col-sm-8">
                <div class="overflow-h funny-boxes" style="background:#ffffff;">
                    <div class="pull-left">
                        <h2>${franchise.franchise_name}</h2>
                        <!-- <span class="korean-font"><-왼쪽은 카페 로고 들어가는 부분</span> -->
                        
                    </div>    
                   	<ul class="list-unstyled list-inline pull-left">
               			<li style="font-size:15px;margin-left:20px;"><i class="fa fa-eye color-green" style="font-size:18px;"></i> ${franchise.franchise_visit}</li>
               			<li style="font-size:15px;" id="like_count"><i class="fa fa-heart color-green" style="font-size:15px;"></i> ${likeCount}</li>
               		</ul>
                    <ul class="list-unstyled list-inline funny-boxes-rating pull-right" style="margin-top:-3px;">
                    	<!-- <li>
                    		<a href="#" style="text-decoration:none;color:#ffffff;">
                    			<i class="fa fa-star" style="font-size:25px;"></i>
                    		</a>
                    	</li> -->
                    	<li>
                    		<a style="text-decoration:none;color:#ffffff;" id="bookmark">
                    			<i class="fa fa-star-o" style="font-size:25px;" id="star"></i>
                    		</a>
                    	</li>
                    </ul>
                </div>   
                <!-- <hr style="margin-top:0px;">  -->
                <p class="korean-font">${franchise.franchise_introduce}</p>
                <input type="hidden" value="${franchise.franchise_num}" id="franchise_num">
     
                <br>
                <a id="fcafe_like" class="btn-u btn-u-large korean-font" style="text-decoration:none;color:#ffffff;cursor:pointer;">
					
				</a>

            </div>
        </div>
    </div>
    <!-- End About Me Block -->
    

    <!-- Portfolio -->
    <div class="container content-sm" >
        <div class="headline" style="margin-bottom:30px;">
            <h2 id="title_menu">Cafe Menu</h2>
        </div>

        <!-- Cube Portfolio -->
        <div class="cube-portfolio container margin-bottom-20">
            <div class="margin-bottom-30">
                <!-- <div id="filters-container" class="cbp-l-filters-text">
                    <div data-filter="*" class="cbp-filter-item-active cbp-filter-item"> All </div> |
                    <div data-filter=".illustration" class="cbp-filter-item"> Illustration </div> |
                    <div data-filter=".web-design" class="cbp-filter-item"> Web Design </div> |
                    <div data-filter=".graphic" class="cbp-filter-item"> Graphic </div> |
                    <div data-filter=".logo" class="cbp-filter-item"> Logo </div>
                </div> --><!--/end Filters Container-->
            </div>
            
            <div id="grid-container" class="cbp-l-grid-gallery">
            <c:forEach var="franchiseMenu" items="${franchiseMenu}">
                <div class="cbp-item illustration web-design">
                	<a href="${pageContext.request.contextPath}/cafein_user/franchise/franchise_Ajax.do?franchise_name=${franchise.franchise_name}&fmenu_num=${franchiseMenu.fmenu_num}" class="cbp-caption cbp-singlePageInline"
                       data-title="World Clock Widget<br>by Paul Flavius Nechita">
                        <div class="cbp-caption-defaultWrap">
                            <img src="/CafeIN/upload/franchise_menu/${franchiseMenu.fmenu_img}" alt="">
                            <input type="hidden" value="${franchiseMenu.fmenu_img}" id="photo">
							<input type="hidden" value="${franchiseMenu.fmenu_num}" id="fmenu_num">
                        </div>
                        <div class="cbp-caption-activeWrap">
                            <div class="cbp-l-caption-alignLeft">
                                <div class="cbp-l-caption-body">
                                    <div class="cbp-l-caption-title korean-font">${franchiseMenu.fmenu_name}<input type="hidden" id="name" value="${franchiseMenu.fmenu_name}"></div>
                                    <div class="cbp-l-caption-desc">가격 : ${franchiseMenu.fmenu_price} 원<input type="hidden" id="price" value="${franchiseMenu.fmenu_price}">
                                    <input type="hidden" value="${franchiseMenu.fmenu_introduce}" id="introduce">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                </c:forEach>
            </div><!--/end Grid Container-->
            <br><br>
        	<!-- <button type="button" class="btn-u btn-block">Load More</button> -->
        	<!--Pagination-->
			<div class="text-center">
				${pagingHtml}
				 <!-- <ul class="pagination">
					<li><a href="#">«</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">8</a></li>
					<li><a href="#">»</a></li>
				</ul>  -->
		</div>
		<!--END Pagination-->
        </div>
        <!-- End Cube Portfolio -->
    </div>
    <!-- End Portfolio -->
    
    
    <!-- 댓글 부분 : blog_large_full_width_item.html -->
    <div class="container content blog-page blog-item">		
    <!-- Recent Comments -->
        <div class="headline margin-bottom-30"><h3>Comments</h3></div>
        <div class="media margin-bottom-40">
            <!-- <h3>Comments</h3> -->
            <!-- <hr> --> 
            <div id="replyList"></div>
            <!-- <div class="media-body">
                <h4 class="media-heading korean-font">jang_delay <span>2016-08-13 | <a href="">신고</a></span></h4>
                <br>
                <div class="col-md-11">
	                <p class="korean-font">댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요.
	                						댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요. 댓글 내용을 입력해주세요.</p>
				</div>
            </div>
            <hr>

            <div class="media-body">
                <h4 class="media-heading korean-font">닉네임 <span>2016-08-14 | <a href="">신고</a></span></h4>
                <br>
                <div class="col-md-11">
                	<p class="korean-font">댓글 내용을 입력해주세요.</p>
                </div>
            </div>
            <hr> -->
            
        <br>
        <!-- <div class="cbp-l-loadMore-button"> -->
        	<!-- <a href="" class="cbp-l-loadMore-button-link">LOAD MORE</a> -->
            <!-- <a href="${pageContext.request.contextPath}/resources/cafein_user/assets//ajax/loadMore.html" class="cbp-l-loadMore-button-link">LOAD MORE</a> -->
        <!-- </div> -->
        <div class="paging" style="display:block;"><br><br>
       	<button type="button" class="btn-u btn-block" style="width: 10%;margin:0 45%;">Load More</button>
        </div>
        <!--Pagination-->
        <!-- <div class="text-center">
            <ul class="pagination">
                <li><a href="#">«</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">8</a></li>
                <li><a href="#">»</a></li>
            </ul>                                                            
        </div> -->
        <!--END Pagination-->
        
        <!-- End Recent Comments -->
        </div><!--/media-->
        
		<div class="modal fade" id="declear" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
              <div class="modal-content">
                 <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title korean-font" id="myModalLabel4">신고</h4>
                 </div>
                 <div class="modal-body">
                    <form action="/CafeIN/cafein_user/franchise/franchise_detailReplyDeclaredRegister.do" novalidate="novalidate"
                         id="sky-form4" class="sky-form" method="post" style="border: 0;">
                       <fieldset>
                       
                            <!-- 현재 선택한 댓글의 시퀀스 -->
                            <input type="hidden" id="d_target_id" name="d_target_id" value="${declaredReply.freply_num}">
                            
                            <!-- d_target_path : 0[프랜차이즈 댓글] 1[개인카페 댓글] 2[커스터마이징 댓글] 개인카페 쪽이므로 1번으로 박아서 넘김 -->
                            <input type="hidden" id="d_target_path" name="d_target_path" value="0">
                            
                            <input type="hidden" name="franchise_num" value="${franchise.franchise_num}" id="franchise_num">
                            
                          <section>
                              <!-- 신고한 사람의 정보는 세션에서 가져오기 -->
                             <label class="label" id="d_mem_id_name" name="d_mem_id_name" style="font-weight:bold;">신고자 ID : ${u_name}</label> 
                             <input type="hidden" name="d_mem_id" id="d_mem_id" value="${u_uid}">
                          </section>
                          
                          <section>
                             <label class="label" id="d_target_mem_id_name" name="d_target_mem_id_name" value="" style="font-weight:bold;">피신고자 ID : </label> 
                             <input type="hidden" name="d_target_mem_id" id="d_target_mem_id" value="">
                          </section>

                          <section>
                             <label class="label korean-font">신고 내용</label> <label class="textarea"> 
                             <!-- <i class="icon-append fa fa-comment"></i> -->
                                <textarea rows="4" name="d_content" id="d_content" class="korean-font"></textarea>
                             </label>
                          </section>

                          <button type="submit" class="btn-u btn-u-primary" style="float: right;">Register</button>
                          <button type="button" class="btn-u btn-u-default" data-dismiss="modal" style="float: right; margin-right: 5px;">Close</button>
                       </fieldset>
                    </form>
                 </div>
              </div>
           </div>
        </div>
        <!-- Comment Form -->
        <!-- <div class="headline margin-bottom-30"><h3>Leave a Comment</h3></div> -->
        <div class="post-comment">
            <!-- <h3>Leave a Comment</h3> -->
            
            <form action="${pageContext.request.contextPath}/cafein_user/franchise/writeReply.do?franchise_num=${franchise.franchise_num}" method="post" id="reply" class="reply">
            	<input type="hidden" value="${franchise.franchise_num}" id="franchise_num" name="franchise_num">
                <label style="font-size:17px;" id="u_name" class="korean-font-bold"><i class="fa fa-user">&nbsp;&nbsp;</i>${u_name} </label>
                <div class="row margin-bottom-20">
                    <div class="col-md-12 col-md-offset-0">
                        <textarea class="form-control korean-font" rows="5" id="freply_content" name="freply_content"></textarea>
                    </div>                
                </div>
               
                <p style="float:right;"><button class="btn-u" type="submit">Send Message</button></p>
            </form>
        </div>
        <!-- End Comment Form -->
        
    </div><!--/container--><!-- END 댓글 부분 : blog_large_full_width_item.html -->		
    <!--=== End Content Part ===-->
