$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,pcafe_num) {
		currentPage = pageNum;
		
		if(pageNum == 1) {
			//처음 호출시는 해당 ID의 div의 내부 내용물을 제거
			$('#output').empty();
		}
		//로딩 이미지 노출
		$('#loading').show();
		
		//목록 호출 Ajax
		$.ajax({
			type:'post',
			data:{
				pageNum:pageNum,
				pcafe_num:pcafe_num
			},
			url:'private_detailReply_ajax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data) {
				//로딩 이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var replyList = data.replyList;
				
				//count가 음수가 오면 오류가 났다는거.
				if(count < 0 || replyList == null) {
					alert('목록 호출 오류 발생');
				}else {
					$(replyList).each(function(index,item){
						
						var output = '';
						output += '<div class="media-body">';
						output += '<input type="hidden" id="preply_num' + item.preply_num + '" value=" ' + item.preply_num + ' ">';
						output += '<input type="hidden" id="u_uid' + item.u_uid + '" value=" ' + item.u_uid + ' ">';
						output += '<h4 class="media-heading korean-font-bold">' + item.preply_nickname;
									
						if($('#u_uid').val() && $('#u_uid').val() == item.u_uid) {
							output += '<span>' + item.preply_reg_date;
							//output += ' | <a class="modify_button" data-num="' +item.preply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">수정</a>';
							output += ' | <a class="delete_button" data-num="' +item.preply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">삭제</a> ';
							output += ' | <a class="declear_button" data-toggle="modal" data-target="#declear" data-num="' +item.preply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a>';
							output += '</span>';
						}else {
							output += '<span>' + item.preply_reg_date;
							output += ' | <a class="declear_button" data-toggle="modal" data-target="#declear" data-num="' +item.preply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a>';
							//output += ' | <a href="">신고</a>';
							output += '</span>';
						}
							
						output += '</h4>';
						output += '<br>';
						output += '<div class="col-md-11">';
						output += '<p class="korean-font">' + item.preply_content + '</p>';
						output += '</div>';
						output += '</div>';
						output += '<hr>';
						
						//문서 객체에 추가 
						$('#output').append(output);
						
						//문서 객체에 추가 
						/*$('#output').append(
							'<div class="media-body">' +
							'<input type="hidden" id="preply_num' + index + '" value=" ' + item.preply_num + ' ">' +
								'<input type="hidden" id="u_uid' + index + '" value=" ' + item.u_uid + ' ">' +
								'<h4 class="media-heading korean-font-bold">' + item.preply_nickname + 
									'<span id="modify_delete'+index+'">' + item.preply_reg_date + ' | <a href="">신고</a></span>' + 
								'</h4>' +
								'<br>' +
								'<div class="col-md-11">' +
									'<p class="korean-font">' + item.preply_content + '</p>' +
								'</div>' +
							'</div>' +
							'<hr>'
						);
						
						if($('#u_uid').val() && $('#u_uid').val() == item.u_uid) {
							$('#modify_delete'+index).html(
								item.preply_reg_date + ' | <a href="">수정</a> | <a href="">삭제</a> | <a href="">신고</a>'	
							);
						}else {
							$('#modify_delete'+index).html(
								item.preply_reg_date + ' | <a href="">신고</a>'	
							);
						}*/
						
					});
					
					//paging button 처리
					if(currentPage >= Math.ceil(count/rowCount)) {
						//다음 페이지가 없음
						$('.paging_button').hide();
					}else {
						//다음 페이지가 존재
						$('.paging_button').show();
					}
					
					//alert("댓글목록출력!");
				}
			},
			error:function() {
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('네트워크 오류 발생!');
			}
		});
	}
	
	//다음 댓글보기 버튼 클릭시 데이터 추가(이벤트 연결)
	$('.paging_button button').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#pcafe_num').val());
	});
	
	//댓글 등록 유효성검사
	$('#reply_form').submit(function(event){
		if($('#preply_content').val() == '') {
			alert('내용을 입력하세요!');
			$('#preply_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		//var data = $(this).serialize();
		var pcafe_num = $('#pcafe_num').val();
		var preply_content = $('#preply_content').val();
		//사용자 닉네임이 없으면 Guest로 변경해서 넣어주기
		if($('#preply_nickname').val() != '') {
			var preply_nickname = $('#preply_nickname').val();
		}else {
			var preply_nickname = "Guest";
		}
		alert("preply_nickname : " + $('#preply_nickname').val());
		alert("pcafe_num:" + pcafe_num + ", preply_content:" + preply_content + ", preply_nickname:" + preply_nickname);
		//댓글 등록 Ajax
		$.ajax({
			type:'post',
			data:{
				pcafe_num:pcafe_num,
				preply_content:preply_content,
				preply_nickname:preply_nickname
			},
			url:'private_detailReplyRegister_ajax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					//폼 초기화
					initForm();
					
					//수정폼 초기화
					//initModifyForm();
					
					//댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글을 다시 호출
							//1페이지,목록 글번호
					selectData(1,$('#pcafe_num').val());
					
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();		
	});
	
	//댓글 작성 폼 초기화
	function initForm() {
		$('#preply_content').val('');
	}
	
	
	// 댓글 수정 버튼 클릭시 수정폼 노출
	// 미레이버튼? 조건에 따라 다른
	/*$(document).on('click','.modify_button',function(){
		// 버튼의 정보 읽어오기
		var num = $(this).attr('data-num');
		// 작성자 아이디
		var id = $(this).attr('data-id');
		//이전에 이미 수정하는 댓글이 있을 경우 수정버튼을
		//클릭하면 숨긴 sub-item를 환원시키는 작업
		$('.sub-item').show();
		//현재 클릭해서 수정하고자 하는 데이터는 감추기
		$('#i' + num + ' .sub-item').hide();
		
		//수정폼에 읽어온 데이터 셋팅
		$('#mre_no').val(num);
		$('#muserId').val(id);
		$('#mre_content').val($('#i' + num + ' p').text());
		
		//입력한 글자수 셋팅
		var inputLength = $('#mre_content').val().length;
		var remain = 300 - inputLength;
		remain += '/300';
		
		//문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
		
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#i' + num).append($('#mre_form'));
		
	});
	
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$('.re-reset').click(function(){
		initModifyForm();
	});
	   
	
	// 댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		//폼의 원래위치로 복원
		$('#modify_div').append($('#mre_form'));
		$('#mre_no').val('');
		$('#muserId').val('');
		$('#mre_content').val('');
		$('#mre_first .letter-count').text('300/300');

	}

	//댓글 수정
	$('#mre_form').submit(function(event){
		if($('#mre_content').val() == '') {
			alert('내용을 입력하세요!');
			$('#mre_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			data:data,
			url:'updateReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout') {
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result == 'wrongAccess') {
					alert('잘못된 접속입니다.')
				}else if(data.result == 'success') {
					$('#i' + $('#mre_no').val() + ' p').html($('#mre_content').val());
					//수정폼 초기화
					initModifyForm();
				}else {
					alert('수정시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});*/
	
	//댓글 삭제
	$(document).on('click','.delete_button',function(){
		//댓글 번호
		var preply_num = $(this).attr('data-num');
		//작성자 아이디
		var u_uid = $(this).attr('data-id');
		
		//삭제
		$.ajax({
			type:'post',
			data:{
				preply_num:preply_num,
				u_uid:u_uid
			},
			url:'private_detailReplyDelete_ajax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout') {
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result == 'wrongAccess') {
					alert('잘못된 접속입니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					//수정폼 초기화
					//initModifyForm();
					selectData(1,$('#pcafe_num').val());
				}else {
					alert('삭제시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	});
	
	//초기 데이터(목록)호출
	selectData(1,$('#pcafe_num').val());
	
});