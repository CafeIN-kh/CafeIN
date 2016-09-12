<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
 <!--=== Slider : pagee_home1.html ===-->
    <div id="layerslider" style="width: 100%; height: 500px; margin: 0px auto;">
        <!-- First slide -->
        <div class="ls-slide" data-ls="slidedelay:4500;transition2d:25;">
            <img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/sliders/layer/mainEvent1.jpg" class="ls-bg" alt="Slide background"/>

            <!-- <span class="ls-s-1" style=" text-transform: uppercase; line-height: 45px; font-size:35px; color:#fff; top:200px; left: 590px; slidedirection : top; slideoutdirection : bottom; durationin : 3500; durationout : 3500; delayin : 1000;">
                Event banner!
            </span> -->
            
        	<!-- <a class="btn-u btn-u-orange ls-s-1" href="#" style=" padding: 9px 20px; font-size:25px; top:340px; left: 590px; slidedirection : bottom; slideoutdirection : top; durationin : 3500; durationout : 2500; delayin : 1000; ">
                Click Event GO!
            </a> -->
        </div>

        <!--Second Slide-->
        <div class="ls-slide" data-ls="transition2d:93;">
            <img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/sliders/layer/mainEvent2.jpg" class="ls-bg" alt="Slide background">

            <!-- <span class="ls-s-2" style=" color: #fff; font-weight: 200; font-size: 22px; top:170px; left: 70px; slidedirection : top; slideoutdirection : bottom; durationin : 3500; durationout : 2500; ">
                Event banner!
            </span>
            
            <a class="btn-u btn-u-blue ls-s1" href="#" style=" padding: 9px 20px; font-size:25px; top:340px; left: 40px; slidedirection : bottom; slideoutdirection : bottom; durationin : 3500; durationout : 3500; ">
                Click Event GO!
            </a> -->

        </div>                

        <!--Third Slide-->
        <div class="ls-slide" style="slidedirection: right; transition2d: 92,93,105; ">
            <img src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/sliders/layer/mainEvent3.jpg" class="ls-bg" alt="Slide background">

            <!-- <span class="ls-s-1" style=" color: #777; line-height:45px; font-weight: 200; font-size: 35px; top:100px; left: 50px; slidedirection : top; slideoutdirection : bottom; durationin : 1000; durationout : 1000; ">
                Event banner!
            </span>
            
            <a class="btn-u btn-u-green ls-s-1" href="#" style=" padding: 9px 20px; font-size:25px; top:220px; left: 50px; slidedirection : bottom; slideoutdirection : bottom; durationin : 2000; durationout : 2000; ">
                Click Event GO!
            </a> -->

        </div>
        <!--End Third Slide-->
    </div><!--/layer_slider-->
    <!--=== End Slider : pagee_home1.html ===-->

    <!--=== Content Part ===-->
    <div class="container content-sm">
    
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
    	
        	<!-- Popular  Custom Menu Block 1~5위 -->
    		<div class="col-md-12 md-margin-bottom-40">
    			<div class="headline"><h2>Popular  Custom Menu</h2></div>
                <div class="row">
                
                	<!-- feature-news-bolcks 템플릿 커스텀 메뉴 top -->
                	<div class="bg-color">
						<div class="container content-md" style="padding:20px 15px 40px 15px;">
							<div class="row news-v2 blog blog-medium">
								<c:forEach var="cCommand" items="${customizingCommand}"  varStatus="status">
								<!-- 좋아요 커스텀 1위 메뉴(가장 크게) -->
								<c:if test="${status.index == 0}">
								<div class="col-md-7 sm-margin-bottom-30">
									<div class="news-v2-badge">
										<img class="img-responsive" src="/CafeIN/upload/customizing/${cCommand.custom_img}" alt="">
									</div>
									<div class="news-v2-desc">
										<h3 class="korean-font-bold2 likeRank1-custom-menuName">
											커스텀마이징 좋아요 1위 메뉴 <br>
											<h2>${cCommand.custom_name}</h2>
										</h3>
										<ul class="list-inline news-v1-info" style="margin-top:15px;">
											<li class="korean-font" style="color:#888;">작성자&nbsp;'&nbsp;${cCommand.u_uid}&nbsp;'&nbsp;&nbsp;/</li>
											<li style="color:#888;"><i class="fa fa-clock-o"></i> ${cCommand.custom_reg_date}&nbsp;&nbsp;&nbsp;/</li>
											<li style="color:#888;"><i class="fa fa-heart"></i>&nbsp;${cCommand.cCount}</li>
										</ul>
										<p class="korean-font" style="margin-bottom:20px;">${cCommand.custom_introduce}</p>
										<a class="read-more" href="#">Read More</a>
									</div>
								</div>
								</c:if>
								<!-- END 좋아요 커스텀 1위 메뉴(가장 크게) -->
								
								<!-- 2위부터 5위까지 메뉴(작게) blog_medium_right_sidebar 템플릿 -->
								<c:if test="${status.index != 0 && status.index < 5}">
								<div class="col-md-5" style="margin-bottom:15px;" value="${status.index}">
									<div class="col-md-4">
										<img class="img-responsive" src="/CafeIN/upload/customizing/${cCommand.custom_img}" alt="">
									</div>
									<div class="col-md-8" style="padding-top:5px;">
										<a href="#" class="korean-font likeRank-custom-menuName">커스텀마이징 좋아요 2~5위 메뉴 <br>${cCommand.custom_name}</a>
										<ul class="list-inline news-v1-info" style="margin-top:8px;">
											<li style="color:#888;"><i class="fa fa-clock-o"></i> ${cCommand.custom_reg_date}&nbsp;&nbsp;&nbsp;/</li>
											<li style="color:#888;"><i class="fa fa-heart"></i> &nbsp;${cCommand.cCount} </li>
										</ul>
									</div>
								</div>
								</c:if>
								</c:forEach>
								<!-- END 2위부터 5위까지 메뉴(작게) -->
								
								
							</div>
						</div>
					</div>
					<!-- END feature-news-bolcks 커스텀 메뉴 top -->
				</div>
            </div><!-- END Popular  Custom Menu block / row-->        
    	</div>	
    	<!-- End Info Blokcs -->
    	
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
    	
        	<!-- Favorite Franchise Block 1위 -->
    		<div class="col-md-12 md-margin-bottom-40">
    			<div class="headline"><h2>Favorite Franchise</h2></div>
                <div class="row">
                
                	<!-- feature-news-bolcks 템플릿 -->
                	<div class="bg-color">
						<div class="container content-md" style="padding:20px 15px 40px 0;">
							<div class="row news-v2 blog blog-medium">
							
								<!-- 즐겨찾기 1위 프렌차이즈 카페  blog_medium_right_sidebar 템플릿 -->
								<div class="col-md-12" style="margin-bottom:15px;">
									<div class="col-md-4">
										<img class="img-responsive" src="/CafeIN/upload/franchise/${franchiseCommandB.franchise_img}" alt="">
									</div>
									<div class="col-md-8" style="padding-top:5px;">
										<h3 class="korean-font-bold2 likeRank1-custom-menuName">
											${franchiseCommandB.franchise_name}
										</h3>

										<p class="korean-font" style="margin-bottom:20px;margin-top:20px;">${franchiseCommandB.franchise_introduce}</p>
										<a class="read-more" href="#">Read More</a>
										
									</div>
								</div>
								
								<!-- END 즐겨찾기 1위 프렌차이즈 카페 -->
								
							</div>
						</div>
					</div>
					<!-- END feature-news-bolcks 템플릿 -->
				</div>
            </div><!-- END Favorite Franchise Block -->        
    	</div>	
    	<!-- End Info Blokcs -->
    	
    	
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
    	
        	<!-- Favorite Private Cafe Block 1~2위 -->
    		<div class="col-md-12 md-margin-bottom-40">
    			<div class="headline"><h2>Favorite Private Cafe</h2></div>
                <div class="row">
                
                	<!-- feature-news-bolcks 템플릿 커스텀 메뉴 top -->
                	<div class="bg-color">
						<div class="container content-md" style="padding:20px 15px 40px 15px;">
							<div class="row news-v2 blog blog-medium">
							
								<!-- 즐겨찾기  1~2위 개인카페  -->
									<c:forEach var="pCommand" items="${privateCafeCommand}"  varStatus="status">
	                				<c:if test="${status.index < 2 }">
									<div class="col-md-6 sm-margin-bottom-30">
										<div class="news-v2-badge">
											<img class="img-responsive" src="/CafeIN/upload/private/${pCommand.pcafe_img}" alt="">
										</div>
										<div class="news-v2-desc">
											<h3 class="korean-font-bold2 likeRank1-custom-menuName">
												개인카페 즐겨찾기 순위 <br> ${pCommand.pcafe_name}
											</h3>
											<ul class="list-inline news-v1-info" style="margin-top:15px;">
												<li style="color:#888;"><i class="fa fa-clock-o"></i> ${pCommand.pcafe_reg_date}&nbsp;&nbsp;&nbsp;/</li>
												<li style="color:#888;"><i class="fa fa-star"></i> ${pCommand.count } </li>
											</ul>
											<p class="korean-font" style="margin-bottom:20px;">${pCommand.pcafe_introduce}</p>
											<a class="read-more" href="#">Read More</a>
										</div>
									</div>
									</c:if>
									</c:forEach>
								<!-- END 즐겨찾기  1~2위 개인카페  -->
								
							</div>
						</div>
					</div>
					<!-- END feature-news-bolcks 커스텀 메뉴 top -->
					
				</div>
            </div><!-- END Favorite Private Cafe Block 1~2위 -->       
    	</div>	
    	<!-- End Info Blokcs -->
    	
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
    	
        	<!-- Popular Franchise Menu Block 1~4위 -->
    		<div class="col-md-12 md-margin-bottom-40">
    			<div class="headline"><h2>Popular Franchise Menu</h2></div>
                <div class="row">
                
                	<!-- shortcode_thumbnailss 템플릿-->
                	<c:forEach var="fmCommand" items="${fmenuCommandL}"  varStatus="status">
                	<c:if test="${status.index < 4 }">
                	<div class="col-md-3">
						<div class="thumbnails thumbnail-style">
							<a class="fancybox" data-rel="fancybox-button" title="Project #1" href="assets/img/main/img18.jpg">
								<img class="img-responsive" src="/CafeIN/upload/franchise_menu/${fmCommand.fmenu_img}" alt="">
							</a>
							<div class="caption">
								<h3 class="korean-font likeRank-menuName">
										 ${fmCommand.fmenu_name}
								</h3>
								<ul class="list-inline news-v1-info" style="margin-top:15px;">
									<li><p class="korean-font" style="margin:0 10px 10px 10px;color:#888;">${fmCommand.franchise_name}&nbsp;&nbsp;&nbsp;&nbsp;/</p></li>
									<li><i class="fa fa-heart" style="color:#888;"></i>&nbsp;${fmCommand.fcount} &nbsp; <br></li>
								</ul>
								<a class="read-more" href="#" style="margin:10px;">Read More</a>
							</div>
						</div>
					</div>
					</c:if>
					</c:forEach>
					
					<!-- END shortcode_thumbnails 템플릿 -->
				</div>
            </div><!-- END Popular Franchise Menu Block -->        
    	</div>	
    	<!-- End Info Blokcs -->
    	
    	
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
    	
        	<!-- Popular Private Menu Block 1~4위 -->
    		<div class="col-md-12 md-margin-bottom-40">
    			<div class="headline"><h2>Popular Private Menu</h2></div>
                <div class="row">
                
                	<!-- feature-news-bolcks 템플릿 커스텀 메뉴 top -->
                	<div class="bg-color">
						<div class="container content-md" style="padding:20px 15px 40px 15px;">
							<div class="row news-v2 blog blog-medium">
							
								<!-- 좋아요  1~4위 개인카페 메뉴  -->
								<c:forEach var="pmCommand" items="${pmenuCommandL}"  varStatus="status">
                				<c:if test="${status.index < 4 }">
								<div class="col-md-6 sm-margin-bottom-30">
									<div class="news-v2-badge">
										<img class="img-responsive" src="/CafeIN/upload/private_menu/${pmCommand.pmenu_img}" alt="">
									</div>
									<div class="news-v2-desc">
										<h3 class="korean-font-bold2">
											<a href="#" class="likeRank1-custom-menuName">개인카페 메뉴이름 (좋아요 순위) ${pmCommand.pmenu_name}</a>
										</h3>
										<ul class="list-inline news-v1-info" style="margin-top:15px;">
											<li class="korean-font" style="color:#888;">개인카페 이름&nbsp;&nbsp;${pmCommand.pcafe_name}&nbsp;/</li>
											<li style="color:#888;"><i class="fa fa-clock-o"></i> ${pmCommand.pcafe_reg_date }&nbsp;&nbsp;&nbsp;/</li>
											<li style="color:#888;"><i class="fa fa-star"></i> ${pmCommand.pcount } </li>
										</ul>
										<!-- <a class="read-more" href="#">Read More</a> -->
									</div>
								</div>
								</c:if>
								</c:forEach>
								
								<!-- END 즐겨찾기  1~2위 개인카페  -->
								
							</div>
						</div>
					</div>
					<!-- END feature-news-bolcks 커스텀 메뉴 top -->
					
				</div>
            </div><!-- END Popular Private Menu Block 1~4위 -->       
    	</div>	
    	<!-- End Info Blokcs -->
    	

    </div><!--/container-->
    <!-- End Content Part -->