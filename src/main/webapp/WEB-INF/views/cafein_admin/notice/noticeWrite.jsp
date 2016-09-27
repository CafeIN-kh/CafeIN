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
			Notice <small>Write Post</small>
		</h2>
	</div>
<form:form action="write.do" id="notice_modify_form" enctype="multipart/form-data" commandName="noticeCommand">

	<div class="card-body card-padding">	

		<div class="form-group fg-float">

		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:input path="notice_title" class="input-lg form-control fg-input"/>
			</div>
			<label for="notice_title" class="fg-label">Title</label>
		</div>

		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:textarea path="notice_content" cols="30" rows="10" class="input-lg form-control fg-input"></form:textarea>
			</div>
			<label for="notice_content" class="fg-label">Content</label>
		</div>
		
	
		
		<div class="row" style="margin-left: 15px;">
			<p class="f-500 c-black m-b-20">Image Preview <small style="margin-left: 15px;">jpg확장자 파일만 등록가능합니다.</small></p>
            <div class="fileinput fileinput-new"  data-provides="fileinput">
            	<div class="fileinput-preview thumbnail" data-trigger="fileinput">
                <%-- 	<img src="${pageContext.request.contextPath}/resources/cafein_admin/img/notice/${noticeCommand.notice_img}" alt="">  --%>
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
						<button type="button"style="margin-left: 10px;" class="btn bgm-green waves-effect waves-button waves-float fileupload1" onclick="location.href='List.do'">MENU</button>
						<button type="submit" style="margin-left: 10px;" class="btn bgm-orange waves-effect waves-button waves-float fileupload1">SAVE</button>
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
