
            $(document).ready(function(){
                //Basic Example
                $("#data-table-basic").bootgrid({
                    css: {
                        icon: 'md icon',
                        iconColumns: 'md-view-module',
                        iconDown: 'md-expand-more',
                        iconRefresh: 'md-refresh',
                        iconUp: 'md-expand-less'
                    },
                }); 
                
                //Selection
                $("#data-table-selection").bootgrid({
                    css: {
                        icon: 'md icon',
                        iconColumns: 'md-view-module',
                        iconDown: 'md-expand-more',
                        iconRefresh: 'md-refresh',
                        iconUp: 'md-expand-less'
                    },
                    selection: true,
                    multiSelect: true,
                    rowSelect: true,
                    keepSelection: true
                });
                
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

                            return "<a href=\"franchise_brandDetail.do?franchise_num="+row.id+"&franchise_name="+row.franchise_name+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.id + "\"><span class=\"md md-search\"></span></button></a> " +
                            /*"<a href=\"menuList2.do?franchise_name="+row.franchise_name+"&franchise_num="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.franchise_name + "\"><span class=\"md md-border-color\"></span></button></a> " +*/
                            /*"<a href=\"franchise_writemenu.do?franchise_num="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.id + "\"><span class=\"md md-border-color\"></span></button></a> " +
                             +
                            "<button type=\"button\" class=\"btn btn-icon command-edit\" data-row-id=\"" + row.id + "\"><span class=\"md md-edit\"></span></button> " +*/
                            "<a href=\"franchise_brandDelete.do?franchise_num="+row.id+"&franchise_name="+row.franchise_name+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.id + "\"><span class=\"md md-delete\"></span></button></a> ";
                        }
                    }
                });
                
                $('#file-check').submit(function(){

                	var fileName = $("#fmenu_img").val();
                	var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
                	var extension = (fileName.substr(pathFileName, fileName.length)).toLowerCase();

                	if(extension != "jpg"){
                		alert('그림 파일 업로드는 jpg 형식만 업로드 할 수 있습니다.');
                		return false;

                	}else{
                		alert('성공적으로 글을 등록했습니다.');
                	}
                });  
            });
