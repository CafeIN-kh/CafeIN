
$(document).ready(function(){

	//Command Buttons
	$("#data-table-command").bootgrid({
		css: {
			icon: 'md icon',
			iconColumns: 'md-view-module',
			iconDown: 'md-expand-more',
			iconRefresh: 'md-refresh',
			iconUp: 'md-expand-less'
		},
		formatters: {
			"commands": function(column, row) {

				return "<a href=\"update.do?seq="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-edit\" data-row-id=\"" + row.id + "\"><span class=\"md md-edit\"></span></button></a> " + 
				"<a href=\"delete.do?seq="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.id + "\"><span class=\"md md-delete\"></span></button></a> ";

				
			}
		}
	});
});
