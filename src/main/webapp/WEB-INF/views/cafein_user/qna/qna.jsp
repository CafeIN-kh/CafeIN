<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Q &amp; A</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li class="active">Contacts</li>
            </ul>
        </div>
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->
    <!--=== Content Part ===-->
    <div class="container content">     
        <div class="row margin-bottom-30">
            <div class="col-md-9 mb-margin-bottom-30">
            
          	    <!-- 구글 맵 Begin Content -->
		        <div class="col-md-12">
		            <!-- Basic Map -->
		            <div class="headline"><h3>CafeIN Map</h3></div>
		            <input type="hidden" id="pcafe_address" name="pcafe_address" value="서울시 강남구 테헤란로10길 9 그랑프리빌딩 KH정보교육원 2관">
		            <div id="map_tag"></div>
		            <div id="map" class="map map-box map-box-space margin-bottom-10"></div>
		            <!-- End Basic Map -->
		        </div>
		        <!-- End 구글 맵 Content --> 
                
                <!-- Google Map -->
                <!-- <div id="map" class="map map-box map-box-space margin-bottom-40"></div> -->
                <!--End Google Map General Unify Forms -->
               
               	<!-- <div class="headline"><h3><input type="hidden" value=""></h3></div> -->
                <!-- 경도 폼 들어가는 부분 -->
				<form:form action="/CafeIN/cafein_user/qna/qna.do" commandName="command" id="sky-form4" class="sky-form contact-style" > 
				<fieldset>
					<hr>
						<div class="sky-form" style="border:0;">
							 <section>	
			                       	 <div class="inline-group">
			                            <label class="radio korean-font"><input type="radio" name="inline" value="0" checked><i class="rounded-x"></i>프랜차이즈카페 문의</label>
			                            <label class="radio korean-font"><input type="radio" name="inline" value="1"><i class="rounded-x"></i>개인카페 문의</label>
			                            <label class="radio korean-font"><input type="radio" name="inline" value="2"><i class="rounded-x"></i>커스터마이징 문의</label>
			                            <label class="radio korean-font"><input type="radio" name="inline" value="3"><i class="rounded-x"></i>이벤트 문의</label>
			                            <label class="radio korean-font"><input type="radio" name="inline" value="4"><i class="rounded-x"></i>건의사항</label>
			                        </div>
			                </section>
						</div>
					<hr>
					<div class="margin-bottom-20">&nbsp;</div>
						<ul style="list-style:none;padding-left:initial;">
							<li class="col-md-6" >
								<label for="email">이메일<span class="color-red">*</span></label>
								<div class="row sky-space-20 col-md-12">
									<div class="korean-font">
										<form:input path="email" class="form-control"/>
									</div>
								</div>
							</li>
							
							<!-- <li class="col-md-1"><input type="hidden"></li> -->
							
							<li class="col-md-6">
								<label for="password">비밀번호<span class="color-red">*</span></label>
								<div class="row sky-space-20 col-md-12">
				                    <div class="korean-font">
									 	<form:password	path="password" class="form-control"/>
									 </div>
								 </div> 
							</li>
							
							<li class="col-md-12">
								<label for="title">제목<span class="color-red">*</span></label>
								<div class="row sky-space-20 col-md-12">
				                    <div class="korean-font">
										<form:input path="title" class="form-control"/>
									</div>
								</div>
							</li>
							
							<li class="col-md-12">
								<label for="content">내용<span class="color-red">*</span></label>
								 <div class="row sky-space-20 col-md-12">
				                     <div class="korean-font">
									 	<form:textarea	path="content" rows="8" class="form-control" name="message" id="message"/> 
									 </div>
								 </div>
							</li>
							
							<%-- <li class="col-md-6">
								<label for="password">비밀번호<span class="color-red">*</span></label>
								<div class="row sky-space-20">
				                    <div class="col-md-12 col-md-offset-0">
									 	<form:password	path="password"/>
									 </div>
								 </div> 
							</li> --%>
							<li class="col-md-12">
								<p><button type="submit" class="btn-u">Send Message</button></p>
							</li>
							
						</ul>
					</fieldset>
				
					<div class="message">
                        <i class="rounded-x fa fa-check"></i>
                        <p>Your message was successfully sent!</p>
                    </div>
				</form:form>
			
			
            </div><!--/col-md-9-->
            
            
            
            
            
            
            
            <div class="col-md-3">
                <!-- Contacts -->
                <div class="headline"><h2>Contacts</h2></div>
                <ul style="list-style:none;" class="list-unstyled who margin-bottom-30" >
                    <li class="korean-font"><a style="text-decoration:none;"><i class="fa fa-home" style="color:#72c02c;"></i>서울시 강남구 테헤란로10길 9 그랑프리빌딩 KH정보교육원 2관</a></li>
                    <li class="korean-font"><a style="text-decoration:none;"><i class="fa fa-envelope" style="color:#72c02c;"></i>cafeIn@cafein.com</a></li>
                    <li class="korean-font"><a style="text-decoration:none;"><i class="fa fa-phone" style="color:#72c02c;"></i>(02)542-2132</a></li>
                    <li class="korean-font"><a style="text-decoration:none;"><i class="fa fa-globe" style="color:#72c02c;"></i>http://www.CafeIn.com</a></li>
                </ul>
                <!-- Business Hours -->
                <div class="headline"><h2>Business Hours</h2></div>
                <ul class="list-unstyled margin-bottom-30">
                    <li><strong>Monday-Friday:</strong> 9am to 6pm</li>
                    <li><strong>Saturday:</strong> 9am to 1pm</li>
                    <li><strong>Sunday:</strong> Closed</li>
                </ul>
                <!-- Why we are? -->
                <div class="headline"><h2>Why we are?</h2></div>
                <p class="korean-font">사이트 문의사항이나 건의사항을 등록하고 싶으신가요? 이곳에서 등록해주세요. cafeIn은 언제나 당신의 이야기에 귀 기울입니다.</p>
                <ul class="list-unstyled">
                    <li class="korean-font"><i class="fa fa-check color-green"></i> 프렌차이즈 카페 등록을 하고 싶으신가요?</li>
                    <li class="korean-font"><i class="fa fa-check color-green"></i> 카페 이용에 불편하신 점이 있으신가요?</li>
                    <li class="korean-font"><i class="fa fa-check color-green"></i> 신고하고 싶으신게 있으신가요?</li>
                </ul>
            </div><!--/col-md-3-->
        </div><!--/row-->
    </div><!--/container-->     
    <!--=== End Content Part ===-->
<!--  <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBAlmuTlr7ouP-hD79meE6RP7lJ8dW0Ks&signed_in=true&callback=initMap">
 </script> -->