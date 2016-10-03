$(document).ready(function() {
					// Command Buttons
					$("#data-table-command").bootgrid(
									{
										css : {
											icon : 'md icon',
											iconColumns : 'md-view-module',
											iconDown : 'md-expand-more',
											iconRefresh : 'md-refresh',
											iconUp : 'md-expand-less'
										},
										formatters : {
											"commands" : function(column, row) {

												return "<button type=\"button\"  class=\"btn btn-icon command-edit adminMemberModal\" onclick=\"adminManagementModal('"+row.sender+"');\" data-row-id=\""
														+ row.id
														+ "\"><span class=\"md md-edit\"></span></button> "
														+ "<button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\""
														+ row.id
														+ "\"><span class=\"md md-delete\"></span></button>";
											}
										},

										selection : true,
										multiSelect : true,
										/*rowSelect : true,*/
										keepSelection : true

									});

					
					
				});




var adminManagementModal = function(email){
	
	
	var AdminModal = $('div.admin_memberModify');
	AdminModal.find('#u_email').val(email);
	
	
	$.ajax({
		type : 'get',
		data : {
			u_email : email
		},
		url : 'admin_memberModify.do',
		dataType:'json',
		cache : false,
		timeout : 30000,
		success : function(data) {
			var u_email = data.u_email;
			var u_name = data.u_name;
			var u_password = data.u_password;
			var u_level = data.u_level;
			
			
			AdminModal.find('#u_name').val(u_name);
			AdminModal.find('#u_password').val(u_password);
			$('input:radio[name=adminMemberRight]:input[value='+u_level+']').attr("checked", true);

		},
		error : function() {

			alert('네트워크 오류 발생_MemberManagement!');
		}

	}); // End ajax


	$('div.admin_memberModify').modal(); // 모달 창 나타남
	

};





