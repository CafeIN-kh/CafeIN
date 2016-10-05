<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<section id="content">
	<div class="container">
<form:form action="franchise_brandDetail.do" id="file-check" enctype="multipart/form-data" commandName="command">
<div class="card" id="profile-main" style="height: 750px;">
	<div class="pm-overview c-overflow">
		<div class="pmo-pic">
			<div class="p-relative">
				<a style="text-decoration:none;"> 
					<img class="img-responsive"src="/CafeIN/upload/franchise/${franchise.franchise_img}">
				</a>

				<!-- <div class="dropdown pmop-message">
					<a data-toggle="dropdown" href=""
						class="btn bgm-white btn-float z-depth-1"> <i
						class="md md-message"></i>
					</a>

					<div class="dropdown-menu">
						<textarea placeholder="Write something..."></textarea>

						<button class="btn bgm-green btn-icon">
							<i class="md md-send"></i>
						</button>
					</div>
				</div> -->

				<!-- <a href="" class="pmop-edit"> <i class="md md-camera-alt"></i> <span
					class="hidden-xs">Update Profile Picture</span>
				</a> -->
			</div>


			<div class="pmo-stat">
				<h2 class="m-0 c-white">${franchise.franchise_visit}</h2>
				Total Visit
			</div>
		</div>

		<%-- <div class="pmo-block pmo-contact hidden-xs">
			<h2>Brand Info</h2>

			<ul>
				<li><i class="md md-phone"></i> ${franchise.franchise_num}</li>
				<li><i class="md md-email"></i> ${franchise.franchise_name}</li>
				<!--	<li><i class="socicon socicon-skype"></i> malinda.hollaway</li>
				<li><i class="socicon socicon-twitter"></i> @malinda
					(twitter.com/malinda)</li>   -->
				<li><i class="md md-location-on">
						${franchise.franchise_introduce}</i>
			</ul>
		</div> --%>
		<%-- <div class="pmo-block pmo-contact hidden-xs">
			<h2>Brand Info</h2>
			<ul>
				<li><i class="socicon socicon-twitter"></i>
					<h5>${privateCommand.pcafe_name}</h5></li>
				<li><i class="md md-email"></i>${franchise.franchise_num}</li>
				<li><i class="md md-phone"></i> ${franchise.franchise_name}</li>
				<li><i class="socicon socicon-skype"></i>
					${privateCommand.pcafe_time}</li>
				<li><i class="md md-location-on"></i>
					<address class="m-b-0">
						${privateCommand.pcafe_hash_tag} <br />
						${privateCommand.pcafe_hash_tag} <br />
						${privateCommand.pcafe_hash_tag}
					</address></li>
			</ul>
		</div> --%>

	</div>

	<div class="pm-body clearfix">
		<ul class="tab-nav tn-justified">
			<li class="waves-effect"><a
				href="franchise_brandDetail.do?franchise_num=${franchise.franchise_num}">Brand Info Detail</a></li>
			<li class="waves-effect"><a
				href="franchise_menuList.do?franchise_num=${franchise.franchise_num}">Menu</a></li>
		</ul>

		
		<div class="pmb-block">
			<div class="pmbb-header">
				<h2>
					<i class="md md-view-list"></i> Contact Information
				</h2>

				<ul class="actions">
					<li class="dropdown"><a href="" data-toggle="dropdown"> <i
							class="md md-border-color"></i>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="franchise_brandUpdate.do?franchise_num=${franchise.franchise_num }">Modify</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="pmbb-body p-l-30">
			
					<div class="pmbb-view">
						<dl class="dl-horizontal">
							<dt>방문수</dt>
							<dd>${franchise.franchise_visit }</dd>
						</dl>   
						<dl class="dl-horizontal">
							<dt>상호</dt>
							<dd>${franchise.franchise_name}</dd>
						</dl>
						<dl class="dl-horizontal">
							<dt>프랜차이즈 소개</dt>
							<dd>${franchise.franchise_introduce }</dd>
						</dl>
					</div>


				<div class="pmbb-edit">
					<dl class="dl-horizontal">
						<dt class="p-t-10">번호</dt>
						<dd>
							<div class="fg-line">
								<input type="number" class="form-control"
									placeholder="eg. ${franchise.franchise_num }">
							</div>
						</dd>
					</dl>
					<dl class="dl-horizontal">
						<dt class="p-t-10">브랜드명</dt>
						<dd>
							<div class="fg-line">
								<input type="text" class="form-control"
									placeholder="eg. ${franchise.franchise_name }">
							</div>
						</dd>
					</dl>
					<dl class="dl-horizontal">
						<dt class="p-t-10">브랜드 소개</dt>
						<dd>
							<div class="fg-line">
								<input type="text" class="form-control"
									placeholder="eg. ${franchise.franchise_introduce }">
							</div>
						</dd>
					</dl>
					
					
					<div class="fileinput fileinput-new" data-provides="fileinput">
					<span class="btn btn-primary btn-file m-r-10"> 
					<span class="fileinput-new">Select file</span> 
					<span class="fileinput-exists"></span> 
					<input type="file" name="upload" id="franchise_img">
					<span class="fileinput-filename"></span> 
					</span>	
					</div>
	
						<button  type="submit" class="btn btn-primary btn-sm">Save</button>
						<button data-pmb-action="reset" class="btn btn-link btn-sm">Cancel</button>
		
					
				</div>
			</div>
		</div>
	</div>
</div>
</form:form>
</div>
</section>
