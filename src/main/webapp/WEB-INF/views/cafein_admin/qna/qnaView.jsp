<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<section id="content">
	<div class="container">
<div class="card" id="profile-main"	style="padding: 20px 20px 20px 20px;">
<div class="card-header">
        <h2>QnA <small>Detail</small></h2>
      </div>


	<div class="pmb-block">
		<div class="pmbb-header">
			<h2>
				<i class="md md-question-answer m-r-5"></i> Information
			</h2>

		</div>
		<div class="pmbb-body p-l-30">
			<div class="pmbb-view">
				<dl class="dl-horizontal">
					<dt>Email</dt>
					<dd>${qnaCommand.qa_email }</dd>
				</dl>
				<dl class="dl-horizontal">
					<dt>Registered</dt>
					<dd>${qnaCommand.qa_reg_date }</dd>
				</dl>
				<dl class="dl-horizontal">
					<dt>Title</dt>
					<dd>${qnaCommand.qa_title }</dd>
				</dl>
				<dl class="dl-horizontal">
					<dt>Content</dt>
					<dd>${qnaCommand.qa_content}</dd>
				</dl>
				<dl class="dl-horizontal">
					<dt>Classification</dt>
					<c:choose>
						<c:when test="${qnaCommand.qa_f_option==0}">
							<dd>프랜차이즈카페문의</dd>
						</c:when>
						<c:when test="${qnaCommand.qa_f_option==1}">
							<dd>개인카페문의</dd>
						</c:when>
						<c:when test="${qnaCommand.qa_f_option==2}">
							<dd>커스텀마이징문의</dd>
						</c:when>
						<c:when test="${qnaCommand.qa_f_option==3}">
							<dd>이벤트문의</dd>
						</c:when>
						<c:otherwise>
							<dd>건의사항</dd>
						</c:otherwise>
					</c:choose>
				</dl>
				<br>

				<dl class="dl-horizontal">
					<dt>Answer</dt>

					<c:if test="${qnaCommand.qa_answer==0}">
						<dd>					
							<dl class="dl-horizontal">

							<form:form action="detail.do" id="email_form" enctype="multipart/form-data" commandName="emailCommand">
									<div class="form-group fg-float">
										<input type="hidden" name="q_em_email" value="${qnaCommand.qa_email }" id="q_em_email">
										<input type="hidden" name="q_em_num" value="${qnaCommand.qa_num }" id="q_em_num">
									<div class="form-group fg-float">
										<div class="fg-line">
											<input type="text" name="q_em_subject" id="q_em_subject" class="input-lg form-control fg-input" value="${qnaCommand.qa_title }에 대한 답변입니다"/>
										</div>
										<label for="q_em_subject" class="fg-label">Subject</label>
									</div>

									<div class="form-group fg-float">
										<div class="fg-line">
											<textarea name="q_em_content" id="q_em_content" cols="30" rows="10" class="input-lg form-control fg-input" >
Title : ${qnaCommand.qa_title } 
Content : ${qnaCommand.qa_content } 
에 대한 답변입니다.
------------------------------------------------------------------
												
											</textarea>
										</div>
										<label for="q_em_content" class="fg-label">content</label>
									</div>

									<div class="row">
										<div class="col-sm-4" style="float: right; width: 174px;">
											<button type="submit" class="btn bgm-orange waves-effect waves-button waves-float fileupload1">SEND</button>
											<button type="button" style="margin-left: 10px;" class="btn bgm-green waves-effect waves-button waves-float fileupload1" onclick="location.href='List.do'">CANCEL</button>
										</div>
									</div>
								</div>
						</form:form>
						</dl>
					</dd>
					</c:if>
					<c:if test="${qnaCommand.qa_answer==1}">
						<dd>Answered</dd>	
					</c:if>

				</dl>
					
			</div>
		</div>
	</div>
</div>
<c:if test="${qnaCommand.qa_answer==1}">
	<div class="col-sm-4" style="float: right; padding-top: 20px; width: 110px;">
		<button style="margin-left: 10px;" class="btn bgm-green waves-effect waves-button waves-float fileupload1" onclick="location.href='List.do'">MENU</button>
	</div>
</c:if>

</div>
</section>

