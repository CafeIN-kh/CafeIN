<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!--=== Breadcrumbs ===-->
<div class="breadcrumbs">
	<div class="container">
		<h1 class="pull-left">Customizing</h1>
		<ul class="pull-right breadcrumb">
			<li><a href="${pageContext.request.contextPath}/cafein_user/main/main.do">Home</a></li>
			<li class="active">Customizing</li>
		</ul>
	</div>
</div>
<!--/breadcrumbs-->

<div class="search-block parallaxBg">
	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<form action="customizing_list.do" >
				<div class="input-group">
					
						<span class="input-group-btn">
							<select id="selectBox" name="keyfield" class="btn-u btn-u-lg" style="padding:8; height:48px; width:80px;">
										<option value="all">전체</option>
										<option value="custom_name">커스텀 제목</option>
										<option value="custom_recipe">레시피</option>
										<option value="custom_hash_tag">해쉬태그</option>
							</select>
						</span>
							<input type="text" class="form-control" name="keyword" id="keyword" 
								placeholder="Search words with regular expressions ..." style="border:1px solid #ccc;">
						<span class="input-group-btn">
							<button id="btnOK" class="btn-u btn-u-lg" type="submit" style="font-size:28px;"> 
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
			</form>
		</div>
	</div>
</div>
<!--/container-->

<div class="cube-portfolio container">

		<div class="col-md-12">
			<c:if test="${map.u_uid!=null }"> 
			<div class="btn-group" style="float: right; padding: 0 0 10px 10px;">
		<button type="button" class="btn-u korean-font" data-toggle="modal"
	           		data-target="#responsive" >
			카페 등록 
		</button>
	</div>
	</c:if>
	<div class="btn-group" style="float: right;">
				<button type="button" class="btn-u dropdown-toggle korean-font"
					data-toggle="dropdown" aria-expanded="false"><div id="pcafe_category">
					정렬하기 <span class="caret"></span></div>
				</button>
				<ul class="dropdown-menu">
					<li class="korean-font"><a href="customizing_list.do?category=2&keyfield=${map.keyfield}&keyword=${map.keyword}">조회수</a></li>
					<li class="korean-font"><a href="customizing_list.do?category=3&keyfield=${map.keyfield}&keyword=${map.keyword}" >좋아요</a></li>
					<c:if test="${map.u_uid!=null }">
					<li class="korean-font"><a href="customizing_list.do?category=4&keyfield=${map.keyfield}&keyword=${map.keyword}">내가 등록한 글 보기</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	
</div>
<!-- 카페등록 모달 시작 -->

<div class="modal fade" id="responsive" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title korean-font" id="myModalLabel4">카페등록</h4>
                          </div> 
                          
                           
                           
                          <div class="modal-body">
<form action="customizingInsert_ajax.do" method="post" 
enctype="multipart/form-data" id="re_form" class="sky-form" style="border:0;">
<fieldset>                  
    <div class="row">
        
        <section class="col col-6">
        	<label class="label">Custom_name</label>
            <label class="input">
                <input type="text" name="custom_name" id="custom_name">
            </label>
        </section>
      
        <!-- 승현이형꺼 -->
        
         <section class="col col-6">
         <label class="label">Franchise Name</label>
          <label class="select">
           <select name="franchise_num">
           <ul class="dropdown-menu">
               <c:forEach var="article" items="${franchiseList}">
                  <li class="korean-font"><option value="${article.franchise_num}">${article.franchise_name}</option></li>
               </c:forEach>
               </ul>
          </select> <i></i>
          </label>
        </section>
        
        
    </div>
       <section>
        <label class="label">custom Introduce</label>
        <label class="textarea">
            <textarea rows="4" name="custom_introduce" id="custom_introduce"></textarea>
        </label>
    </section>
    <section>
        <label class="label">custom_recipe</label>
        <label class="input">
            <input type="text" name="custom_recipe" id="custom_recipe">
        </label>
    </section>
    <section>
        <label class="label">Cafe Hash Tag</label>
        <label class="input">
            <input type="text" name="custom_hash_tag" id="custom_hash_tag" data-role="tagsinput" 
            placeholder=",를 넣어서 입력하세요">
        </label>
    </section> 	
<section style="margin-bottom:50px;">
<label class="label">Cafe Image Upload</label>
   <label for="pcafe_img" class="input input-file">
         <input type="file" name="upload" id="upload" 
         multiple onchange="this.parentNode.nextSibling.value = this.value" 
         class="korean-font">
   </label>
</section>
						<!-- <button type="submit" class="btn-u btn-u-primary" style="float:right;">Register</button>
    <button type="button" class="btn-u btn-u-default" data-dismiss="modal" style="float:right;margin-right:5px;">Close</button> -->
    <div class="modal-footer">
          <button type="button" class="btn-u btn-u-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn-u btn-u-primary">Register</button>
      </div>
      </fieldset>
</form>
</div>
        </div>
    </div>
</div>

<!-- /카페등록 모달 -->


<!--=== Cube-Portfdlio ===-->
<div class="cube-portfolio container margin-bottom-60">
	<div class="content-xs">
		<div id="filters-container" class="cbp-l-filters-text content-xs">
			<div data-filter="*" class="cbp-filter-item-active cbp-filter-item korean-font">
				<a href = "customizing_list.do">All</a></div> 
			|
		<c:if test="${count == 0}">
		<div class="align-center" style="margin-bottom:25%">등록된 게시물이 없습니다.</div>
		</c:if>
		<!--franchise_num + custom_num을 디테일에 넘겨줘야 함  -->
		
		<c:if test="${count > 0}">
		<c:forEach var="franchiseList" items="${franchiseList}" varStatus="status">
			<div class="cbp-filter-item korean-font">
			<a href = "customizing_list.do?franchise_num=${franchiseList.franchise_num }"> ${franchiseList.franchise_name }</a></div>
			|
		</c:forEach>
		</c:if>
		</div>
		<!--/end Filters Container-->
	</div>

					<!--커스터마이징 하면 카드가 붙는 부분  -->
<div id="grid-container" class="cbp-l-grid-agency">
<c:if test="${count == 0}">
		<div class="align-center">등록된 게시물이 없습니다.</div>
</c:if>
		
		<c:if test="${count > 0}">
		<c:forEach var="list" items="${list}" varStatus="status">
		
		<div class="cbp-item easy-block-v1" >
			
			<c:if test="${list.u_uid == map.u_uid && map.category == 4 }">
			<a href="customizing_delete.do?custom_num=${list.custom_num }" class="easy-block-v1-badge rgba-red" style="text-decoration:none;position:initial;line-height:30px;cursor:pointer;">
		            		<i class="fa fa-trash-o delete_button">Delete</i></a>
      		</c:if>
      		
				<div class="cbp-caption margin-bottom-20">
					<div class="cbp-caption-defaultWrap">
					<a href="${pageContext.request.contextPath}/cafein_user/customizing/customizing_detail.do">
						<img src="${pageContext.request.contextPath}/upload/customizing/${list.custom_img}" alt="">
					</div>
					<div class="cbp-caption-activeWrap">
						<div class="cbp-l-caption-alignCenter"></div>
					</div>
				</div>
				<div class="cbp-title-dark">
					<div class="cbp-l-grid-agency-title korean-font" id="asd"}>${list.franchise_name}</div>
					<div class="cbp-l-grid-agency-desc korean-font">${list.custom_name}</div>
				</div>
			</a>
		</div>
		</c:forEach>
		</c:if>




	</div>
<!--/end Grid Container-->
<br> <br>
<c:if test ="${count>8 }">
<%-- <div class="align-center">${pagingHtml}</div> --%>
<div class="text-center">
	        		<ul class="pagination">
	        			${pagingHtml}
	        		</ul>  
	        	</div>
</c:if>
<!-- End Pagination -->
</div>
<!--=== End Cube-Portfdlio ===-->

<script src="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js"></script>








