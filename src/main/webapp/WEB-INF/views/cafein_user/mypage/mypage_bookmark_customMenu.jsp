<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Bookmark</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li><a href="mypage_user_modify_check.do">MyPage</a></li>
                <li class="active">Bookmark</li>
            </ul>
        </div><!--/container-->
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->

    <!--=== Content Part ===-->
    <div class="content container">
        <div class="row">
        
            <!-- 왼쪽 메뉴바 -->
            <div class="col-md-3 filter-by-block md-margin-bottom-60">
                <h1 style="background:#72c02c;">My Page</h1>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="korean-font" style="text-decoration:none;">
                                   	 개인정보
                                    <i class="fa fa-angle-down"></i>
                                </a>
                            </h2>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
	                            <div class="panel-body" style="padding-left:10px;">
	                                <ul class="list-unstyled checkbox-list">
	                                    <li>
	                                        <a href="mypage_user_modify_check.do" class="checkbox korean-font-bold" style="text-decoration:none;">
	                                         	회원정보수정	
	                                            <!-- <small><a href="#">(23)</a></small> -->
	                                        </a>
	                                    </li>
	                                    <li>
	                                        <a href="mypage_user_leave.do" class="checkbox korean-font-bold" style="text-decoration:none;">
	                                         	회원탈퇴
	                                        </a>
	                                    </li>
	                                </ul>        
	                            </div>
	                        </div>
	                    </div>
	                </div><!--/end panel group-->

                <div class="panel-group" id="accordion-v2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion-v2" href="#collapseTwo" class="korean-font" style="text-decoration:none;">
                                    	즐겨찾기
                                    <i class="fa fa-angle-down"></i>
                                </a>
                            </h2>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse in">
                            <div class="panel-body" style="padding-left:10px;">
                                <ul class="list-unstyled checkbox-list">
                                    <li>
                                        <a href="mypage_bookmark_franchise.do" class="checkbox korean-font-bold" style="text-decoration:none;">
                                         	프렌차이즈카페
                                        </a>
                                    </li>
                                    <li>
                                        <a href="mypage_bookmark_private.do" class="checkbox korean-font-bold" style="text-decoration:none;">
                                         	개인카페
                                        </a>
                                    </li>
                                    <li>
                                        <a href="mypage_bookmark_customMenu.do" class="checkbox korean-font-bold" style="text-decoration:none;">
                                         	커스텀마이징메뉴
                                        </a>
                                    </li>
                                </ul>        
                            </div>
                        </div>
                    </div>
                </div><!--/end panel group-->

                <div class="panel-group" id="accordion-v3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion-v3" href="#collapseThree" class="korean-font" style="text-decoration:none;">
                                    	좋아요
                                    <i class="fa fa-angle-down"></i>
                                </a>
                            </h2>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse in">
                            <div class="panel-body" style="padding-left:10px;">
                                <ul class="list-unstyled checkbox-list">
                                    <li>
                                        <a href="mypage_like_cafe.do" class="checkbox korean-font-bold" style="text-decoration:none;">
                                         	카페
                                        </a>
                                    </li>
                                    <li>
                                        <a href="mypage_like_menu.do" class="checkbox korean-font-bold" style="text-decoration:none;">
                                         	카페메뉴
                                        </a>
                                    </li>
                                </ul>        
                            </div>
                        </div>
                    </div>
                </div><!--/end panel group-->

            </div><!-- 왼쪽 메뉴바 끝 -->

            <div class="col-md-9">
                <div class="row margin-bottom-5">
                
                    <div class="col-sm-6 result-category">
                        <h2>Customizing Menu</h2>
                    </div>
	                    
				</div><!--/end result category-->

				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
				
                <!-- 마이페이지 프렌차이즈 카페 즐겨찾기 정보 페이징 하는 부분 -->
				<c:if test="${count == 0}">
					<div class="korean-font" style="text-align:center;font-size: xx-large;color:#72c02c;margin:200px 0 400px 0;">등록된 즐겨찾기가 없습니다.</div>
				</c:if>
				<c:if test="${count > 0}">
	                <div class="filter-results">
	                	<c:forEach var="bookmarkMypage" items="${bookmarkMypage}" varStatus="status">
		                    <div class="list-product-description product-description-brd margin-bottom-30">
		                        <div class="row">
		                        
		                            <div class="col-sm-4">
		                                <a href="shop-ui-inner.html">
		                                	<img class="img-responsive sm-margin-bottom-20" src="/CafeIN/upload/customizing/${bookmarkMypage.custom_img}" style="min-height:200px;">
		                                </a>
		                            </div> 
		                            <div class="col-sm-8 product-description" style="padding:15px;">
		                                <div class="overflow-h margin-bottom-5">
		                                    <ul class="list-inline overflow-h">
		                                        <li><h4 class="title-price korean-font">${bookmarkMypage.custom_name}</h4></li>
		                                        <li class="pull-right">
		                                        </li>
		                                    </ul>    
		                                    <h6 style="margin:0;">&nbsp;</h6>
		                                    <p class="margin-bottom-20 korean-font">
		                                    	${bookmarkMypage.custom_introduce}
		                                    </p>
		                                    <!-- 아직 커스텀 매핑 주소를 몰라서 프렌차이즈 매핑주소로 기입해놓음 후에 바꾸기 -->
		                                    <button type="button" class="btn-u" onclick="location.href='/CafeIN/cafein_user/franchise/franchise_detail.do?franchise_num=${bookmarkMypage.custom_fnum}'">
		                                    	Detail Page
		                                    </button>
		                                    <button type="button" class="btn-u btn-u-default korean-font" onclick="location.href='/CafeIN/cafein_user/mypage/mypage_bookmark_custom_deleteBookmark.do?custom_num=${bookmarkMypage.custom_num}'">
		                                    	즐겨찾기 취소
		                                    </button>
		                                </div>    
		                            </div>
		                        </div>
		                    </div>
	                    </c:forEach>
	                    
	                    
	
	                </div><!--/end filter resilts-->
	                
	                <div class="text-center" style="margin-bottom:30%;">
		        		<ul class="pagination">
		        			${pagingHtml}
		        		</ul>  
		        	</div>
	        	
                </c:if>

            </div>
        </div><!--/end row-->
    </div><!--/end container-->    
    <!--=== End Content Part ===-->

