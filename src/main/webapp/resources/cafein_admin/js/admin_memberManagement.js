
$(document).ready(function() {
					// Command Buttons
					$("#data-table-command")
							.bootgrid({
										css : {
											icon : 'md icon',
											iconColumns : 'md-view-module',
											iconDown : 'md-expand-more',
											iconRefresh : 'md-refresh',
											iconUp : 'md-expand-less'
										},
										formatters : {
											"commands" : function(column, row) {
												
												return "<button type=\"button\"  class=\"btn btn-icon command-edit\" data-toggle=\"modal\" data-target=\"#admin_memberModify\" data-row-id=\""
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

