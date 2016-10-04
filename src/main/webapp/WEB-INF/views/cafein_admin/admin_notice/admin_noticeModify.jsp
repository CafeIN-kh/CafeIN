<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <section id="content">
                <div class="container">
<div class="card">
	<div class="card-header">
		<h2>
			Admin Notice <small>Modify</small>
		</h2>
	</div>
<form:form action="update.do" id="admin_notice_modify_form" enctype="multipart/form-data" commandName="admin_noticeCommand">

	<div class="card-body card-padding">	

		<div class="form-group fg-float">

		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:input path="admin_notice_title" class="input-lg form-control fg-input"/>
			</div>
			<label for="admin_notice_title" class="fg-label">Title</label>
		</div>

		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:textarea path="admin_notice_content" cols="30" rows="10" class="input-lg form-control fg-input"></form:textarea>
			</div>
			<label for="admin_Notice_content" class="fg-label">Content</label>
		</div>
		
		<c:if test="${!empty admin_noticeCommand.admin_notice_img}">
			<div class="form-group fg-float">
				<div class="fg-line">
					<span>${admin_noticeCommand.admin_notice_img } is already exists. </span>
				</div>
			</div>
		</c:if>
		
		<div class="row" style="margin-left: 15px;">
			<p class="f-500 c-black m-b-20">Image Preview <small style="margin-left: 15px;">jpg확장자 파일만 등록가능합니다.</small></p>
            <div class="fileinput fileinput-new"  data-provides="fileinput">
            	<div class="fileinput-preview thumbnail" data-trigger="fileinput">
                	<img src="${pageContext.request.contextPath}/upload/admin_notice/${admin_noticeCommand.admin_notice_img}" alt=""> 
                </div>
				<div class="row">
                	<div  style="float: left">
                     	<span class="btn btn-info btn-file" style="margin-left: 15px;"> 
	                    	<span class="fileinput-new">Select image</span> 
	                    	<span class="fileinput-exists">Change</span>
	                    	<input type="file" name="upload" id="upload"/>
                        </span> 
                        <a href="#" class="btn btn-danger fileinput-exists" data-dismiss="fileinput">Remove</a>
                    </div>
                   	<div style="float: right; position:absolute; right:0px; margin-left: 15px;">
						<button type="button" style="margin-left: 10px;" class="btn bgm-green waves-effect waves-button waves-float fileupload1" onclick="location.href='list.do'">Menu</button>
						<button type="submit"  style="margin-left: 10px;" class="btn bgm-orange waves-effect waves-button waves-float fileupload1">SAVE</button>
					</div>
				</div>
			</div>
		</div>

		
		
	</div>
</div>
</form:form>

</div>
</div>
</section>
