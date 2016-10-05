<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--=== Breadcrumbs ===-->
<div class="breadcrumbs">
	<div class="container">
		<h1 class="pull-left">Notice</h1>
		<ul class="pull-right breadcrumb">
			<li><a
				href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
			<li class="active">Notice</li>
		</ul>
	</div>
</div>
<!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container content-sm">
	<div class="row">
		<div class="col-md-12">
			<!-- Notice Section -->
			<div class="headline">
				<h2 class="korean-font">공지 사항</h2>
			</div>
			<div id="noticeSection"></div>
		</div>
		<!--/acc-v1-->
		
		<div class="text-center">
			<ul class="pagination1 pagination"></ul>
		</div>
		<!--END Notice Pagination-->
	</div>
	
	<br> <br> <br> <br>

	<div class="row">
		<div class="col-md-12">
			<!-- Event Section -->
			<div class="headline">
				<h2 class="korean-font">이벤트</h2>
			</div>
			<div id="eventSection"></div>
		</div>
		<!--/acc-v1-->
		
		<div class="text-center" style="margin-bottom:15%;">
			<ul class="pagination2 pagination"></ul>
		</div>
		<!--END Notice Pagination-->
	</div>
	<!--/acc-v1-->
	<!-- End Other Questions -->
</div>
<!--=== End Content Part ===-->