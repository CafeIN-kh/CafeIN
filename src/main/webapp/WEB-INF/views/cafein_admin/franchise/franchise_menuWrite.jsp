<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


 <section id="content">
                <div class="container">
<form:form action="franchise_menuWrite.do" id="file-check" enctype="multipart/form-data" commandName="command">
<div class="card">
	<div class="card-header">
		<h2>
			글 작성 <small>프렌차이즈 카페를 등록합니다.</small>
		</h2>
	</div>

	<div class="card-body card-padding">

		<p class="m-b-25 m-t-25 c-black f-500">프렌차이즈 카페 관리</p>

		

		<input type="hidden" name="franchise_num" id="franchise_num" class="input-lg form-control fg-input" value="${number}" />


		<div class="form-group fg-float">
		         
			<div class="fg-line">        
				<input type="number" name="fmenu_price" id="fmenu_price" class="input-lg form-control fg-input" />
			</div>
			<label class="fg-label">fmenu_price</label>
		</div>
		
		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:input path="franchise_name" class="input-lg form-control fg-input" readonly="true" value="${name}"/>
			</div>
			<label for="franchise_name" class="fg-label">franchise_name</label>
		</div>
		
		<div class="form-group fg-float">
		
			<div class="fg-line">
				<form:input path="fmenu_name" class="input-lg form-control fg-input"/>
			</div>
			<label for="fmenu_name" class="fg-label">fmenu_name</label>
		</div>
		
		<div class="form-group fg-float">
		
			<div class="fg-line">
				<textarea name="fmenu_introduce" id="fmenu_introduce" cols="30" rows="10" class="input-lg form-control fg-input"></textarea>
			</div>
			<label for="franchise_name" class="fg-label">fmenu_introduce</label>
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

</form:form>

</div>
</section>