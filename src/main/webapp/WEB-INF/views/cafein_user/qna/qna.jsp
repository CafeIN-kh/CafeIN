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
                <!-- Google Map -->
                <div id="map" class="map map-box map-box-space margin-bottom-40"></div>
                <!--End Google Map General Unify Forms -->
               
                <!-- 경도 폼 들어가는 부분 -->
			<form:form action="qna.do" commandName="command" id="sky-form3" class="sky-form contact-style" > 
<fieldset>
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

				<ul>
					<li>
					<label for="email">이메일<span class="color-red">*</span></label>
					<div class="row sky-space-20">
					<div class="col-md-7 col-md-offset-0">
					<form:input path="email" class="form-control"/>
					</div>
					</div>
					</li>
					
					<li>
					<label for="title">제목<span class="color-red">*</span></label>
					<div class="row sky-space-20">
                    <div class="col-md-7 col-md-offset-0">
					<form:input path="title" class="form-control"/>
					</div>
					</div>
					</li>
					
					<li>
					<label for="content">내용<span class="color-red">*</span></label>
					 <div class="row sky-space-20">
                     <div class="col-md-11 col-md-offset-0">
					 <form:textarea	path="content" rows="8" class="form-control" name="message" id="message"/> 
					 </div>
					 </div>
					</li>
					
					<li>
					<label for="password">비밀번호<span class="color-red">*</span></label>
					<div class="row sky-space-20">
                    <div class="col-md-7 col-md-offset-0">
					 <form:password	path="password"/>
					 </div>
					 </div> 
					</li>
					<p><button type="submit" class="btn-u">Send Message</button></p>
					
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
                    <li><a href="#"><i class="fa fa-home"></i>서울시 강남구 테헤란로10길 9 그랑프리빌딩 KH정보교육원 2관</a></li>
                    <li><a href="#"><i class="fa fa-envelope"></i>info@example.com</a></li>
                    <li><a href="#"><i class="fa fa-phone"></i>(02)542-2132</a></li>
                    <li><a href="#"><i class="fa fa-globe"></i>http://www.CafeIn.com</a></li>
                </ul>
                <!-- Business Hours -->
                <div class="headline"><h2>Business Hours</h2></div>
                <ul class="list-unstyled margin-bottom-30">
                    <li><strong>Monday-Friday:</strong> 10am to 8pm</li>
                    <li><strong>Saturday:</strong> 11am to 3pm</li>
                    <li><strong>Sunday:</strong> Closed</li>
                </ul>
                <!-- Why we are? -->
                <div class="headline"><h2>Why we are?</h2></div>
                <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum.</p>
                <ul class="list-unstyled">
                    <li><i class="fa fa-check color-green"></i> Odio dignissimos ducimus</li>
                    <li><i class="fa fa-check color-green"></i> Blanditiis praesentium volup</li>
                    <li><i class="fa fa-check color-green"></i> Eos et accusamus</li>
                </ul>
            </div><!--/col-md-3-->
        </div><!--/row-->
    </div><!--/container-->     
    <!--=== End Content Part ===-->
 <!-- <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBAlmuTlr7ouP-hD79meE6RP7lJ8dW0Ks&signed_in=true&callback=initMap">
 </script> -->

