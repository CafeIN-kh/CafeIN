
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
                $("#data-table-jys").bootgrid({
                    css: {
                        icon: 'md icon',
                        iconColumns: 'md-view-module',
                        iconDown: 'md-expand-more',
                        iconRefresh: 'md-refresh',
                        iconUp: 'md-expand-less'
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
            
            

            
           /* function upload() {
            	var fileName = $("#franchise_img").val();
            	if(fileName < 1) {
            		alert("이미지를 선택하세요.");
            		return;
            	}
            	var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
            	var fileNameExt = fileName.lastIndexOf("\\")+1;    //파일경로를 제외한 파일명+확장자
            	var extension = (fileName.substr(pathFileName, fileName.length)).toLowerCase();	//확장자명
            	//파일명.확장자
            	var fileNameCheck = fileName.substring(fileNameExt, fileName.length).toLowerCase();

            	if(fileNameCheck.length != 0){
            		if(extension == "jpg"){
            			for(i=0;i <fileNameCheck.length; i++){
            				var chk = fileNameCheck.charCodeAt(i);
            				if(chk > 128){
            					alert("한글 파일명은 업로드 할 수 없습니다.");
            					return;
            				}
            			}
            			document.fileForm.submit();
            		}else{
            			alert("jpg , png , gif 파일만 업로드 할 수 있습니다.");
            			return;  
            		}
            	}else{
            		alert("선택된 이미지가 없습니다.");
            	}
            }*/
            
            
 /*           $(document).submit(function(){
               if(document.getElementById("upload2")){
                 var str = document.getElementById("upload2").value;
                 dot = str.lastIndexOf(".");
                 ext = str.substring(dot).toLowerCase();
                 if (ext != ".jpg"){
                    alert("이미지는 업로드 할 수 없는 확장자입니다.");
                    document.getElementById("upload2").select();
                    document.selection.clear();
                    return false;
                  }
               }
            });*/