<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<section id="content">
                <div class="container">
                    <div class="block-header">
                        <h2>Dashboard</h2>
                        
                       
                        
                    </div>
                    
                    <div class="card">
                        <div class="card-header">
                            <h2>Total PageView <small>Franchise, Private, Customizing</small></h2>
                            
                            <ul class="actions">
                                <li>
                                    <a href="">
                                        <i class="md md-cached"></i>
                                    </a>
                                </li>
                                <!-- <li>
                                    <a href="">
                                        <i class="md md-file-download"></i>
                                    </a>
                                </li>
                                <li class="dropdown">
                                    <a href="" data-toggle="dropdown">
                                        <i class="md md-more-vert"></i>
                                    </a>
                                    
                                    <ul class="dropdown-menu dropdown-menu-right">
                                        <li>
                                            <a href="">Change Date Range</a>
                                        </li>
                                        <li>
                                            <a href="">Change Graph Type</a>
                                        </li>
                                        <li>
                                            <a href="">Other Settings</a>
                                        </li>
                                    </ul>
                                </li> -->
                            </ul>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-edge">
                                <div id="line-chart" class="flot-chart "></div>
                            </div>
                        </div>
                    </div>

            <div class="mini-charts">
                        <div class="row">
                            <div class="col-sm-6 col-md-3">
                                <div class="mini-charts-item bgm-cyan">
                                    <div class="clearfix">
                                        <div class="count" align=center>
                                            <small>Site TotalCount</small>
                                            <h2 id="totalcount"></h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6 col-md-3">
                                <div class="mini-charts-item bgm-lightgreen">
                                    <div class="clearfix">
                                        <div class="count" align=center>
                                            <small>Franchise TotalCount</small>
                                            <h2 id="franchiseCount"></h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6 col-md-3">
                                <div class="mini-charts-item bgm-orange">
                                    <div class="clearfix">
                                        <div class="count" align=center>
                                            <small>Private TotalCount</small>
                                            <h2 id="privateCount"></h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6 col-md-3">
                                <div class="mini-charts-item bgm-bluegray">
                                    <div class="clearfix">
                                        <div class="count" align=center>
                                            <small>Custom TotalCount</small>
                                            <h2 id="customCount"></h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="row">
                        <div class="col-sm-6">
                            <!-- Calendar -->
                            <div class="card">
                                <div class="card-header">
                                    <h2>Like Day Count Chart <small>Franchise, Private, Customizing, FranchiseMenu, CustomizingMenu</small></h2>
                            
                                    <ul class="actions">
                                        <li class="dropdown action-show">
                                            <a href="" data-toggle="dropdown">
                                                <i class="md md-more-vert"></i>
                                            </a>
                            
                                            <div class="dropdown-menu pull-right">
                                                <p class="p-20">
                                                    You can put anything here
                                                </p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            
                                <div class="card-body">
                                    <div class="chart-edge">
                                        <div id="line-chart-1" class="flot-chart"></div>
                                    </div>
                                </div>
                            </div> 
                        </div>
                        
                        
                        <div class="col-sm-6">
                            
                            
                            <!-- Recent Posts -->
                            <div class="card">
                                <div class="card-header ch-alt m-b-20">
                                    <h2>Admin Notice <small>공지 확인 잘해라!!!</small></h2>
                                    <ul class="actions">
                                        <li>
                                            <a href="">
                                                <i class="md md-cached"></i>
                                            </a>
                                        </li>
                                       <!--  <li>
                                            <a href="">
                                                <i class="md md-file-download"></i>
                                            </a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="" data-toggle="dropdown">
                                                <i class="md md-more-vert"></i>
                                            </a>
                                            
                                            <ul class="dropdown-menu dropdown-menu-right">
                                                <li>
                                                    <a href="">Change Date Range</a>
                                                </li>
                                                <li>
                                                    <a href="">Change Graph Type</a>
                                                </li>
                                                <li>
                                                    <a href="">Other Settings</a>
                                                </li>
                                            </ul>
                                        </li> -->
                                    </ul>
                                    
                                    
                                </div>
                                
                                <div class="card-body">
                                    <div class="listview">
                                    <c:forEach var="notice"
											items="${noticeList}">
                                        <a class="lv-item" href="">
                                            <div class="media">
                                               <div class="pull-left">
                                                    <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/2.jpg" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <div class="lv-title">${notice.admin_notice_title}</div>
                                                    <small class="lv-small">${notice.admin_notice_content}</small>
                                                </div>
                                            </div>
                                        </a>
                                        </c:forEach>
                                       <%--  <a class="lv-item" href="">
                                            <div class="media">
                                                <div class="pull-left">
                                                    <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/2.jpg" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <div class="lv-title">Jonathan Morris</div>
                                                    <small class="lv-small">Nunc quis diam diamurabitur at dolor elementum, dictum turpis vel</small>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="lv-item" href="">
                                            <div class="media">
                                                <div class="pull-left">
                                                    <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/3.jpg" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <div class="lv-title">Fredric Mitchell Jr.</div>
                                                    <small class="lv-small">Phasellus a ante et est ornare accumsan at vel magnauis blandit turpis at augue ultricies</small>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="lv-item" href="">
                                            <div class="media">
                                                <div class="pull-left">
                                                    <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/4.jpg" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <div class="lv-title">Glenn Jecobs</div>
                                                    <small class="lv-small">Ut vitae lacus sem ellentesque maximus, nunc sit amet varius dignissim, dui est consectetur neque</small>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="lv-item" href="">
                                            <div class="media">
                                                <div class="pull-left">
                                                    <img class="lv-img-sm" src="${pageContext.request.contextPath}/resources/cafein_admin/img/profile-pics/4.jpg" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <div class="lv-title">Bill Phillips</div>
                                                    <small class="lv-small">Proin laoreet commodo eros id faucibus. Donec ligula quam, imperdiet vel ante placerat</small>
                                                </div>
                                            </div>
                                        </a> --%>
                                        <a class="lv-footer" href="">View All</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>