<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">Franchise Cafe</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
                <li class="active">Franchise Cafe</li>
            </ul>
        </div>
    </div>
    <!--=== End Breadcrumbs ===-->

    <!--=== Content Part ===-->
    <div class="container content-sm portfolio-4-columns" style="margin-bottom:5%;">  
    
    	<div class="text-center margin-bottom-10">
            <h2 class="title-v2 title-center">Franchise Cafe</h2>
            <p class="space-lg-hor korean-font">전국의 프렌차이즈 카페에 대한 정보가 담겨있습니다. <span class="color-green korean-font">원하는 카페를 선택해주세요.</span> 카페에 대한 모든 것이 담겨있습니다.</p>
        </div>
         
        <div class="row">
        	<c:forEach var="logo" items="${list}">
           		<div class="col-md-3 col-sm-6">
                	<div class="view view-tenth">
                    	<img class="img-logo" src="/CafeIN/upload/franchise/${logo.franchise_img}" alt="" />
                    	<div class="mask">
                        	<h2 class="korean-font">${logo.franchise_name}</h2>
                        	<a href="${pageContext.request.contextPath}/cafein_user/franchise/franchise_detail.do?franchise_num=${logo.franchise_num}" class="info">Read More</a>
                        	<input type="hidden" value="${logo.franchise_num}">
                    	</div>                
                	</div>
            	</div>
            </c:forEach>
        </div><!--/row-->  
    </div><!--/container-->
    <!--=== End Content Part ===-->
