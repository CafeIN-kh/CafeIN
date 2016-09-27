<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%-- stylesheet와 javascript 링크 ignore="true"로 설정하면 null일 때 실행되지 않음--%>
<tiles:importAttribute name="cssList" ignore="true"/>
<tiles:importAttribute name="jsList" ignore="true"/>  
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><tiles:getAsString name="title"/></title>



<%-- 
        <!-- Vendor CSS -->
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/vendors/fullcalendar/fullcalendar.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/vendors/animate-css/animate.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/vendors/sweet-alert/sweet-alert.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/vendors/material-icons/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/vendors/socicon/socicon.min.css" rel="stylesheet">
            
        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/css/app.min.1.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/cafein_admin/css/app.min.2.css" rel="stylesheet"> --%>
        
        <c:forEach var="cssName" items="${cssList}">
	<link rel="stylesheet" href="<c:out value='${cssName}' />"/>
	</c:forEach>
        
    </head>
    <body class="toggled sw-toggled">
    	<!-- 헤더 시작 -->
        <tiles:insertAttribute name="header"/>
        <!-- 헤더 끝 -->
        <section id="main">
        	<!-- 메뉴 시작 -->
            <tiles:insertAttribute name="menu"/>
            <!-- 메뉴 끝 -->
            <!-- 바디 시작 -->
            <tiles:insertAttribute name="body"/>
            <!-- 바디 끝 -->
        </section>
        
      
        
        <!-- Javascript Libraries -->
    <%--     <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/bootstrap.min.js"></script>
        
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/flot/jquery.flot.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/flot/jquery.flot.resize.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/flot/plugins/curvedLines.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/sparklines/jquery.sparkline.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/easypiechart/jquery.easypiechart.min.js"></script>
        
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/fullcalendar/lib/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/fullcalendar/fullcalendar.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/simpleWeather/jquery.simpleWeather.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/auto-size/jquery.autosize.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/nicescroll/jquery.nicescroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/waves/waves.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/vendors/sweet-alert/sweet-alert.min.js"></script>
        
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/flot-charts/curved-line-chart.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/flot-charts/line-chart.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/charts.js"></script>
        
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/charts.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cafein_admin/js/demo.js"></script> --%>
		<c:forEach var="jsName" items="${jsList}">
			<script src="<c:out value='${jsName}' />"></script>
		</c:forEach>
        
    </body>
  </html>