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
                                          + "<button type=\"button\" class=\"btn btn-icon command-delete\" onclick=\"admin_memberDeleteModal('"+row.sender+"');\" data-row-id=\"" 
                                          + row.id
                                          + "\"><span class=\"md md-delete\"></span></button>";
                                 }
                              },

                              selection : false,
                              multiSelect : false,
                              rowSelect : false,
                              keepSelection : false

                           });

               
               
            
               // 모달 창 내부의 adminMembermodify_form 이 submit 되면    
               
               $('#adminMembermodify_form').submit(function(event){
               
                  
                  var data = $('#adminMembermodify_form').serialize();
                  
                  //var right = $('input[name=adminMemberRight]:checked', '#adminMembermodify_form').val();
                  
                  
                  
                  $.ajax({
                     type : 'post',
                     data : data,
                     url : 'admin_memberModify.do',
                     dataType:'json',
                     cache : false,
                     timeout : 30000,
                     success : function(data) {
                        
                        $('div.admin_memberModify').hide();
                          location.reload();
                        
                     },
                     error : function() {

                        alert('네트워크 오류 발생_MemberManagementUpdate!');
                     }

                  }); // End ajax

                  
                  event.preventDefault();

               });  // End  click         
               
               
               
               
               // 회원 정보 삭제
               $('#adminMemberDeleteBtn').click(function(){
                  
                  var AdminModalD = $('div.admin_memberDelete');  // 모달 창
                  var u_email = AdminModalD.find('#checkemail').text();
                  
                  $.ajax({
                     type : 'post',
                     data : {
                        u_email : u_email
                     },
                     url : 'admin_memberDelete.do',
                     dataType:'json',
                     cache : false,
                     timeout : 30000,
                     success : function(data) {
                        
                        $('div.admin_memberDelete').hide();
                          location.reload();
                        
                     },
                     error : function() {

                        alert('네트워크 오류 발생_MemberManagementDelete!');
                     }

                  }); // End ajax

                  
                  
               }); // End click
});



// 수정 버튼을 누를 때 row.sender 값이 매개변수로 전달. 
//전달된 값은 u_email 값. ajax 로 controller 에 보내어 나머지 회원정보를 가져옴
function adminManagementModal(email){

   var AdminModal = $('div.admin_memberModify');  // 모달 창
   AdminModal.find('#u_email').val(email);  // 모달 창의 email 에 값 넣음
   
   
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
         $('input:radio[name=u_level]:input[value='+u_level+']').attr("checked", true);  // u_level의 값에 따라 checked 해줌

      },
      error : function() {

         alert('네트워크 오류 발생_MemberManagementget!');
      }

   }); // End ajax


   $('div.admin_memberModify').modal(); // 모달 창 나타남
   

}




function admin_memberDeleteModal(email){
   var AdminModalD = $('div.admin_memberDelete');  // 모달 창
   AdminModalD.find('#checkemail').text(email);  // 모달 창의 email 에 값 넣음
   
   $('div.admin_memberDelete').modal(); // 모달 창 나타남
   
}