jQuery(document).ready(function() {
   App.init();
   //LoginForm.initLoginForm();
   ContactForm.initContactForm();
   //PageContactForm.initPageContactForm();
   Registration.initRegistration();
});

$(function(){
   var base = $('.franchise');
   base.addClass('active');

   var base2 = $('.customizing_	main');
   base2.addClass('active');
});

//좋아요?
$(document).ready(function(){

   var custom_num = $('#custom_num').val();

   var u_uid = $('#u_uid').val();

   $.ajax({
      type:'post',
      data: {
         custom_num:custom_num,
         u_uid:u_uid
      },
      url:'/CafeIN/cafein_user/custom/selectlike.do',
      dataType:'json',
      cache:false,
      timeout:30000,
      success:function(data) {
         var result = data.result;

         if(result=='success'){
            $('#like').removeClass('icon-heart');
            $('#like').addClass('fa fa-heart');
         }else if(result=='fail'){
            $('#like').removeClass('fa fa-heart');
            $('#like').addClass('icon-heart');
         }else{
            alert('에러발생');
         }

      },error:function() {
         alert('네트워크 오류 발생!');
      }
   });

//즐겨찾기?
   $.ajax({
      type:'post',
      data: {
         custom_num:custom_num,
         u_uid:u_uid
      },
      url:'/CafeIN/cafein_user/custom/selectbookmark.do',
      dataType:'json',
      cache:false,
      timeout:30000,
      success:function(data) {
         var result = data.result;

         if(result=='success'){
            $('#bookmark').removeClass('icon-star');
            $('#bookmark').addClass('fa fa-star');
         }else if(result=='fail'){
            $('#bookmark').removeClass('fa fa-star');
            $('#bookmark').addClass('icon-star');
         }else{
            alert('에러발생');
         }

      },error:function() {
         alert('네트워크 오류 발생!');
      }
   });

   $('#custom_like').bind('click',function(){
	   //로그인 여부 체크
	   if($('#u_uid').val() == '') {
		   alert('로그인 해야 사용할 수 있습니다.');
		   location.reload();
	   }else{
	      $.ajax({
	         type:'post',
	         data: {
	            custom_num:custom_num,
	            u_uid:u_uid
	         },
	         url:'/CafeIN/cafein_user/custom/insertlike.do',
	         dataType:'json',
	         cache:false,
	         timeout:30000,
	         success:function(data) {
	
	            var result = data.result;
	            var LikeTotalCount = data.LikeTotalCount;
	
	            if(result == 'LikeInsert'){
	               $('#like').removeClass('icon-heart');
	               $('#like').addClass('fa fa-heart');
	               $('#likevalue').text(LikeTotalCount);
	               /*$('#bookmark').html(
	                     '<span>'+LikeTotalCount+'</span>'
	               );*/
	            }else if(result == 'LikeDelete') {
	               $('#like').removeClass('fa fa-heart');
	               $('#like').addClass('icon-heart');
	               $('#likevalue').text(LikeTotalCount);
	               /*   $('#bookmark').html(
	                     '<span>'+LikeTotalCount+'</span>'
	               );*/
	            }else {
	               alert('즐겨찾기 호출 오류');
	            }
	
	         },error:function() {
	           alert('네트워크 오류 발생!');
		     }
		  });
	   }
   });

   $('#custom_bookmark').bind('click',function(){
	   //로그인 여부 체크
	   if($('#u_uid').val() == '') {
		   alert('로그인 해야 사용할 수 있습니다.');
		   location.reload();
	   }else{
	      $.ajax({
	         type:'post',
	         data: {
	            custom_num:custom_num,
	            u_uid:u_uid
	         },
	         url:'/CafeIN/cafein_user/custom/insertbookmark.do',
	         dataType:'json',
	         cache:false,
	         timeout:30000,
	         success:function(data) {
	
	            var result = data.result;
	            var LikeTotalCount = data.LikeTotalCount;
	
	            if(result == 'bookmarkInsert'){
	               $('#bookmark').removeClass('icon-star');
	               $('#bookmark').addClass('fa fa-star');
	               /*$('#bookmark').html(
	                     '<span>'+LikeTotalCount+'</span>'
	               );*/
	               $('#bookmarkvalue').text(LikeTotalCount);
	            }else if(result == 'bookmarkDelete') {
	               $('#bookmark').removeClass('fa fa-star');
	               $('#bookmark').addClass('icon-star');
	               $('#bookmarkvalue').text(LikeTotalCount);
	               /*   $('#bookmark').html(
	                     '<span>'+LikeTotalCount+'</span>'
	               );*/
	            }else {
	               alert('즐겨찾기 호출 오류');
	            }
	
	         },error:function() {
	            alert('네트워크 오류 발생!');
	         }
	      });
	   }
   });
/* 댓글 */
   
   var currentPage;
   var count;
   var rowCount;
   
   //댓글 목록
   function selectData(pageNum,custom_num) {
      currentPage = pageNum;
      //custom_num = custom_num;
      
      if(pageNum == 1) {
         //처음 호출시는 해당 ID의 div의 내부 내용물을 제거
         $('#output').empty();
      }
      //로딩 이미지 노출
      $('#loading').show();
      /*data:{
            pageNum:pageNum,
            u_uid:u_uid
         },*/
      

      //목록 호출 Ajax
      $.ajax({
         type:'post',
         data:{
            pageNum:pageNum,
            custom_num:custom_num
         },
         url:'/CafeIN/cafein_user/customizing/custom/customreplylistAjax.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data) {
            //로딩 이미지 감추기
            $('#loading').hide();
            count = data.count;
            rowCount = data.rowCount;
            var customReplyList = data.customReplyList;

            //count가 음수가 오면 오류가 났다는거.
            if(count < 0 || customReplyList == null) {
               alert('목록 호출 오류 발생');
            }else {

               $(customReplyList).each(function(index,item){

                  /*$('#output').append(
                        '<div class="media-body">' +
                        '<h4 class="media-heading korean-font">'+
                        item.creply_nickname + 
                        '<span>'+ item.creply_reg_date + ' | '+
                        '<a href="?d_mem_id='+item.u_uid+'" data-toggle="modal" data-target="#declear">신고</a> | '+
                        '<a href="?u_uid='+item.u_uid+'>' +
                        '<input type="button" data-num="'+ item.creply_num +'" data-id="'+ item.u_uid 
                        +'" class="delete_button">삭제</a></span>' +
                        '</h4>'+
                        '<br>'+
                        '<div class="col-md-11">'+
                        '<p class="korean-font">'+ item.creply_content +'</p>'+
                        '</div>'+
                        '</div>'+
                        '<hr>'+
                        '<input type="hidden" id="reply_usernum" name="reply_usernum" value='+item.u_uid+'>'
                  ); */  
                  
	                //문서 객체에 추가 
	                var output = '';
	                output += '<div class="media-body">';
	                output += '<input type="hidden" id="creply_num' + item.creply_num + '" value=" ' + item.creply_num + ' ">';
	                output += '<input type="hidden" id="u_uid' + item.u_uid + '" value=" ' + item.u_uid + ' ">';
	                output += '<h4 class="media-heading korean-font-bold">' + item.creply_nickname;
	                         
	                if($('#u_uid').val() && $('#u_uid').val() == item.u_uid) {
	                   output += '<span>' + item.creply_reg_date;
	                   //output += ' | <a class="modify_button" data-num="' +item.preply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">수정</a>';
	                   output += ' | <a class="delete_button" data-num="' +item.creply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">삭제</a> ';
	                   output += ' | <a class="declear_button" data-toggle="modal" data-target="#declear" data-num="' +item.creply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a>';
	                   output += '</span>';
	                }else {
	                   output += '<span>' + item.creply_reg_date;
	                   output += ' | <a class="declear_button" data-toggle="modal" data-target="#declear" data-num="' +item.creply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a>';
	                   //output += ' | <a href="">신고</a>';
	                   output += '</span>';
	                }
	                   
	                output += '</h4>';
	                output += '<br>';
	                output += '<div class="col-md-11">';
	                output += '<p class="korean-font">' + item.creply_content + '</p>';
	                output += '</div>';
	                output += '</div>';
	                output += '<hr>';
	                
	                $('#output').append(output);
                        
                     
               });

               //paging button 처리
               if(currentPage >= Math.ceil(count/rowCount)) {
                  //다음 페이지가 없음
                  $('.paging_button').hide();
               }else {
                  //다음 페이지가 존재
                  $('.paging_button').show();
               }

            }
         },
         error:function() {
            //로딩 이미지 감추기
            $('#loading').hide();
            alert('네트워크 오류 발생! 댓글을 불러올 수 없습니다.');
         }
      });
   }

   $('.paging_button button').click(function(){
      var pageNum = currentPage +1;
      //PageNum,category
      selectData(pageNum,$('#custom_num').val());
   });
   selectData(1,$('#custom_num').val());

   $('#reply').submit(function(event){
	   //alert("reply");
	   
      if($('#creply_content').val() == '') {
         alert('내용을 입력하세요!');
         $('#creply_content').focus();
         return false;
      }
      
      var data = $(this).serialize();

      $.ajax({
         type:'post',
         data:data,
         url:'/CafeIN/cafein_user/customizing/custom/insertreply.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result == 'success'){
               //폼 초기화
               initForm();

               alert('댓글 등록 완료!');
               selectData(1,$('#custom_num').val());
            }else{
               alert('등록시 오류 발생!');
            }
         },
         error:function(request,status,error){
            alert('네트워크 오류 발생! 댓글입력실패');
         }
      });
      //기본 이벤트 제거
      event.preventDefault();      
   });

   //댓글 삭제

   $(document).on('click', '.delete_button', function(){
	   //로그인 여부 체크
	   if($('#u_uid').val() == '') {
		   alert('로그인 해야 사용할 수 있습니다.');
		   location.reload();
	   }else{

		   var answer = confirm("댓글을 정말로 삭제 하시겠습니까?");

		   if(answer){

			   //댓글 번호 ??
			   var creply_num = $(this).attr('data-num');
			   //작성자 아이디 ???
			   var u_uid = $(this).attr('data-id');

			   //alert('data-num : ' + creply_num + 'data-id : ' + u_uid);

			   //삭제
			   $.ajax({
				   type: 'post',
				   data: {creply_num:creply_num, 
					   u_uid:u_uid }, 
					   url: '/CafeIN/cafein_user/customizing/customizing_deleteReplyAjax.do',
					   dataType: 'json',
					   cacha: false,
					   timeout: 30000,
					   success: function(data){

						   //로그인했을때
						   if(data.result == 'logout'){
							   alert('로그인해야 삭제할 수 있습니다.');
						   }else if(data.result == 'wrongAccess'){
							   alert('잘못된 접속입니다.');
						   }else if(data.result == 'success'){
							   alert('삭제 완료!');
							   //삭제후 데이터 읽어오기
							   selectData(1,$('#custom_num').val());
						   }else{
							   alert('삭제시 오류 발생!');
						   }

						   //로그인 가정안하고
						   /*if(data.result == 'success'){
							   alert('삭제 완료!');
							   //삭제후 데이터 읽어오기
							   selectData(1,$('#custom_num').val());
						   }else{
							   alert('삭제시 오류 발생!');
						   }*/
					   },
					   error: function(){
						   alert('네트워크 오류 발생');
					   }
			   });
		   }
	   }
   });   
   
   // 댓글 신고
   $(document).on('click','.declear_button',function(){
	      
	      //댓글 번호
	      var creply_num = $(this).attr('data-num');
	      //댓글 작성자 아이디
	      var u_uid = $(this).attr('data-id');
	      var franchise_num = $('#franchise_num').val();
	      var custom_num = $('#custom_num').val();
	      
	      
	      //alert("creply_num : " + creply_num + ", u_uid : " + u_uid + ", franchise_num : " + franchise_num + ", custom_num : " + custom_num);
	      //alert("session_u_uid : " + $('#session_u_uid').val());
	      
	      //로그인 연결 안되어 있으므로 
	      if($('#session_u_uid').val() == u_uid) {
	         alert('본인을 신고할 수 없습니다');
	         $('#declear').hide();
	         location.reload();
	      }else if($('#session_u_uid').val() == '') {
	    	  alert('로그인해야 신고할 수 있습니다.');
              $('#declear').hide();
              location.reload();
	      }else{
	    	 //댓글 신고
	         $.ajax({
	            type:'post',
	            data:{
	               custom_num:custom_num,
	               creply_num:creply_num,
	               franchise_num:franchise_num,
	               u_uid:u_uid
	            },
	            url:'/CafeIN/cafein_user/customizing/customizing_detailReplyDeclared_ajax.do',
	            dataType:'json',
	            cache:false,
	            timeout:30000,
	            success:function(data){
	            	//alert('댓글신고 Ajax + creply_num : ' + creply_num);
	               if(data.result == 'logout') {
	                  alert('로그인해야 신고할 수 있습니다.');
	                  $('#declear').hide();
	                  location.reload();
	               }else if(data.result == 'success'){
	                  //신고한 댓글의 시퀀스
	                  var declaredReply = data.declaredCustomizingReply;
	                  //신고당한 사람의 u_uid와 닉네임
	                  var declaredMember_u_uid = data.declaredMember_u_uid;
	                  var declaredMember_u_name = data.declaredMember_u_name;
	                  
	                  //alert("신고자 아이디: " + declaredMember_u_name);
	                  //alert("신고댓글시퀀스 : " + declaredReply.creply_num + ", 신고당한 사람닉네임 :" + declaredMember_u_name + ", 신고당한사람 u_uid : " + declaredMember_u_uid + ', custom_num: ' + declaredReply.custom_num);
	                  
	                  //신고자/피신고자 정보 jsp에 바꿔주기
	                  $('#d_target_id').val(declaredReply.creply_num);
	                  $('#d_target_mem_id_name').val(declaredMember_u_uid);
	                  $('#d_target_mem_id_name').html("피신고자 닉네임 : " + declaredMember_u_name);
	                  $('#d_target_mem_id').val(declaredMember_u_uid);
	                  $('#d_target_num').val(declaredReply.custom_num);
	                  
	               
	               }else {
	                  alert('신고시 오류 발생!');
	                  $('#declear').hide();
	                  location.reload();
	               }
	            },
	            error:function(){
	               alert('네트워크 오류 발생!');
	               $('#declear').hide();
	               location.reload();
	            }
	         });
	      }
	   });

   function initForm() {
      $('textarea').val('');
   }
   //초기 데이터(목록)호출
   //selectData(1,$('#custom_num').val());

});