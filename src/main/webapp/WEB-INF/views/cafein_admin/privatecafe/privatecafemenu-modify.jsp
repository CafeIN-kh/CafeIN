<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="privatecafemenu-modify.do" id="file-check"
	enctype="multipart/form-data" commandName="command">
	<section id="content">
		<div class="container">
			<div class="block-header">


				<ul class="actions">
					<li><a href=""> <i class="md md-trending-up"></i>
					</a></li>
					<li><a href=""> <i class="md md-done-all"></i>
					</a></li>
					<li class="dropdown"><a href="" data-toggle="dropdown"> <i
							class="md md-more-vert"></i>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="">Refresh</a></li>
							<li><a href="">Manage Widgets</a></li>
							<li><a href="">Widgets Settings</a></li>
						</ul></li>
				</ul>

			</div>

			<div class="card">
				<div class="card-header">
					<h2>
						카페메뉴 수정하기 <small>개인카페 메뉴를 수정할 수 있습니다..</small>
					</h2>
				</div>

				<div class="card-body card-padding">

					<br />
					<br />

					<div class="row">
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="md md-local-cafe"></i></span>
								<div class="fg-line">
									<input type="text" class="form-control"
										name="pmenu_name" value="${command.pmenu_name}"
										placeholder="메뉴이름을 써주세요.">
										
								</div>
							</div>

							<br />

							<!-- privateCommandmodify -->

							<div class="input-group">
								<span class="input-group-addon"><i
									class="md  md-assignment"></i></span>
								<div class="fg-line">
									<input type="text" class="form-control"
										name="pmenu_price" value="${command.pmenu_price}"
										placeholder="메뉴가격을 써주세요.">
								</div>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"><i class="md  md-subject"></i></span>
								<div class="fg-line">
									<input type="text" class="form-control"
										name="pmenu_introduce" value="${command.pmenu_introduce}"
										placeholder="메뉴소개를 써주세요.">
								</div>
							</div>
							<br> <br>

							<p class="f-500 c-black m-b-20">Image Preview</p>

							<div class="fileinput fileinput-new" data-provides="fileinput">
								<div class="fileinput-preview thumbnail"
									data-trigger="fileinput">
									<img src="${pageContext.request.contextPath}/upload/${command.pmenu_img}" alt=""> 
								</div>
								<div>
									<span class="btn btn-info btn-file"> <span
										class="fileinput-new">Select image</span> <span
										class="fileinput-exists">Change</span> <input type="file"
										name="upload">
									</span> <a href="#" class="btn btn-danger fileinput-exists"
										data-dismiss="fileinput">Remove</a>
								</div>
							</div>
							<div class="m-t-10">
								<button type="submit" class="btn btn-primary btn-sm">Save</button>

								<a href="profile-connections.html">&nbsp;&nbsp;&nbsp;Cancel</a>
								<!-- <button data-pmb-action="reset" class="btn btn-link btn-sm"><a href="profile-connections.html">Cancel</a></button> 
										 -->

							</div>




							<br /> <br />


						</div>

						<div class="col-sm-4">


							<br /> <br /> <br />


						</div>

						<div class="col-sm-4">


							<br /> <br /> <br />

						</div>
					</div>


				</div>





			</div>


		</div>















	</section>

</form:form>