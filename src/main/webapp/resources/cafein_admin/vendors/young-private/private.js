
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
                        	
                        	
                            return "<a href=\"privatecafe-detail.do?pcafe_num="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-edit\" data-row-id=\"" + row.id + "\"><span class=\"md md-search\"></span></button></a> " + 
                                "<a href=\"privatecafe-delete.do?pcafe_num="+row.id+"\"><button type=\"button\" class=\"btn btn-icon command-delete\" data-row-id=\"" + row.id + "\"><span class=\"md md-delete\"></span></button></a>";
                      
                        
                        }
                    }/*/admin/delete.do*/
                    
                });
              
            });
