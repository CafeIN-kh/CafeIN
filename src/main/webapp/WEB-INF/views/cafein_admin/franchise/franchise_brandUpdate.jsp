<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



 <section id="content">
                <div class="container">
<form:form action="franchise_update.do" id="file-check" enctype="multipart/form-data" commandName="command">
<div class="card">
	<div class="card-header">
		<h2>
			FranchiseCafe Insert <small>FranchiseCafe Inset Page</small>
		</h2>
	</div>

	<div class="card-body card-padding">

		<p class="m-b-25 m-t-25 c-black f-500">FranchiseCafe Controller</p>
	

		<div class="form-group fg-float">
		
		<div class="form-group fg-float">
		         
			<div class="fg-line">        
					 <input type="number" name="franchise_num" id="franchise_num" class="input-lg form-control fg-input" />
				</div>
			<label class="fg-label">franchise_num</label>
		</div>
	
		<div class="form-group fg-float">
		
			<div class="fg-line">
				<input type="text" name="franchise_name" id="franchise_name" class="input-lg form-control fg-input"/>
			</div>
			<label for="franchise_name" class="fg-label">franchise_name</label>
		</div>

		<div class="form-group fg-float">
		
			<div class="fg-line">
				<textarea name="franchise_introduce" id="franchise_introduce" cols="30" rows="10" class="input-lg form-control fg-input"></textarea>
			</div>
			<label for="franchise_introduce" class="fg-label">franchise_introduce</label>
		</div>

		<div class="row">
			<div class="col-sm-4">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<span class="btn btn-primary btn-file m-r-10"> 
					<span class="fileinput-new">Select file</span> 
					<span class="fileinput-exists"></span> 
					<input type="file" name="upload" id="fmenu_img">
					<span class="fileinput-filename"></span> 
					</span>	
				</div>
				<button type="submit" class="btn bgm-orange waves-effect waves-button waves-float fileupload1">SAVE</button>
			</div>
		</div>
	</div>
</div>
</div>
</form:form>
</div>
</section>
