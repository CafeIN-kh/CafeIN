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
                
                    <div class="col-sm-4 result-category">
                        <h2>Private</h2>
                    </div>
                    
                </div><!--/end result category-->

                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
                <!-- 마이페이지 개인카페 즐겨찾기 정보 페이징 하는 부분 -->
				<c:if test="${count == 0}">
					<div class="korean-font" style="text-align:center;font-size: xx-large;color:#72c02c;margin:200px 0 400px 0;">등록된 즐겨찾기가 없습니다.</div>
				</c:if>
				<c:if test="${count > 0}">
	                <div class="filter-results">
	                    <div class="row illustration-v2 margin-bottom-30">
	                    
	                        <c:forEach var="bookmarkMypage" items="${bookmarkMypage}" varStatus="status">
		                        <div class="col-md-4">
		                            <div class="product-img product-img-brd">
		                                <!-- <a href="#"> -->
		                                	<img class="full-width img-responsive" src="/CafeIN/upload/private/${bookmarkMypage.pcafe_img}">
		                                <!-- </a> -->
		                                <a class="product-review korean-font" href="/CafeIN/cafein_user/mypage/mypage_bookmark_private_deleteBookmark.do?pcafe_num=${bookmarkMypage.pcafe_num}" >즐겨찾기 취소</a>
		                                <a class="add-to-cart" href="/CafeIN/cafein_user/private/private_detail.do?pcafe_num=${bookmarkMypage.pcafe_num}">
		                                	<i class="glyphicon glyphicon-search"></i>Detail Page
		                                </a>
		                            </div> 
		                            <div class="product-description product-description-brd margin-bottom-30">
		                                <div class="overflow-h margin-bottom-5">
		                                    <div style="text-align:center;">
		                                        <h4 class="title-price korean-font">${bookmarkMypage.pcafe_name}</h4>
		                                    </div>    
		                                </div>    
		                            </div>
		                        </div>
	                        </c:forEach>
	
	                    </div>
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


