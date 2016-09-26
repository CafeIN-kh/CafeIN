<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<%-- stylesheet와 javascript 링크 ignore="true"로 설정하면 null일 때 실행되지 않음--%>
<tiles:importAttribute name="cssList" ignore="true"/>
<tiles:importAttribute name="jsList" ignore="true"/> 
 
<!-- <!DOCTYPE html> -->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<head>
    <title>CafeIn</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">

	<c:forEach var="cssName" items="${cssList}">
	<link rel="stylesheet" href="<c:out value='${cssName}' />"/>
	</c:forEach>
</head>	

<body>
<div class="wrapper">
    <!-- 헤더 시작 -->
    <tiles:insertAttribute name="header"/>
    <!-- 헤더 끝 -->
   	<!-- 바디 시작 -->
   	<tiles:insertAttribute name="body"/>
   	<!-- 바디 끝 -->
	<!-- 푸터 시작 -->
    <tiles:insertAttribute name="footer"/>
    <!-- 푸터 끝 -->
</div><!--/wrapper-->


<c:forEach var="jsName" items="${jsList}">
	<script src="<c:out value='${jsName}' />"></script>
</c:forEach>

<script type="text/javascript">
	//타이머 함수는 모든일이 끝난후 실행된다. initCafeINMap이 googleapisView보다 후에 실행되야 하는데 script안에 있으면 jsp가 다 처리되기 전에 실행되버려서 써줌
	setTimeout(function () { // 0초 후에 body에 script를 넣어줘라
		/* 구글 map api 이용. key=구글의 api 키 값을 넣어 준것. initCafeINMap은 private_detail_map.js에서 부름 */
		if(document.location.pathname=="/CafeIN/cafein_user/private/private_detail.do"){
			$('body').append('<script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyByaawrixh9HdCUSOSfjvGM4wGM9XCyRHo&callback=initCafeINMap\" async defer><\/script>');
		}
	}, 0);
</script>



<!-- <script type="text/javascript">
    jQuery(document).ready(function() {
      	App.init();
      	LayerSlider.initLayerSlider();
    });
</script> -->
<!--[if lt IE 9]>
    <script src="assets/plugins/respond.js"></script>
    <script src="assets/plugins/html5shiv.js"></script>
    <script src="assets/plugins/placeholder-IE-fixes.js"></script>
<![endif]-->
</body>
</html>