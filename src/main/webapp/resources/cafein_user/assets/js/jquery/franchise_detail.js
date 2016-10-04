$(document).ready(function(){

	var franchise_num = $('#franchise_num').val();
	var u_name = $('#u_name').val();
	var u_uid = $('#u_uid').val();

	$.ajax({
		type:'post',
		data:{
			franchise_num:franchise_num,
			u_uid:u_uid
		},
		url:'/CafeIN/cafein_user/franchise/selectLike.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			if(data.result == 'checked'){
				$('#fcafe_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 취소하기!'		
				);
			}else{
				$('#fcafe_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 좋아요!'		
				);
			}
		},error:function(){
			alert('좋아요 error');
		}
	});

	$('#fcafe_like').unbind('click').bind('click', function(){	
		$.ajax({
			type:'post',
			data: {
				franchise_num:franchise_num,
				u_uid:u_uid
			},
			url:'/CafeIN/cafein_user/franchise/like.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 이용 가능합니다.');
				}else{
					if(data.result == 'insert'){
						$('#fcafe_like').html(
								'<i class="fa fa-thumbs-o-up"></i> 취소하기!'		
						);
						$('#like_count').html(
								'<i class="fa fa-heart color-green" style="font-size:15px;"></i>' + ' ' + data.count
						);
						alert(totalCount);
					}
					if(data.result == 'delete'){
						$('#fcafe_like').html(
								'<i class="fa fa-thumbs-o-up"></i> 좋아요!'		
						);
						$('#like_count').html(
								'<i class="fa fa-heart color-green" style="font-size:15px;"></i>' + ' ' + data.count
						);
						alert(totalCount);
					}
				}
			},error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	});

	$.ajax({
		type:'get',
		data:{
			franchise_num:franchise_num,
			u_uid:u_uid
		},
		url:'/CafeIN/cafein_user/franchise/selectbookmark.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			if(data.result == 'checked'){
				$('#star').removeClass("fa fa-star-o");
				$('#star').addClass("fa fa-star");
			}
		},error:function(){
			//alert(u_uid);
			alert('북마크 오류 발생');
		}
	});


	$('#bookmark').unbind('click').bind('click', function(){	
		$.ajax({
			type:'post',
			data: {
				franchise_num:franchise_num,
				u_uid:u_uid
			},
			url:'/CafeIN/cafein_user/franchise/bookmark.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 이용 가능합니다.');
				}else{
					if(data.result == 'bookmarkInsert'){
						$('#star').removeClass("fa fa-star-o");
						$('#star').addClass("fa fa-star");
					}
					if(data.result == 'bookmarkDelete'){
						$('#star').removeClass("fa fa-star");
						$('#star').addClass("fa fa-star-o");
					}
				}
			},error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	});

	var currentPage;
	var count;
	var rowCount

	function selectData(pageNum){
		currentPage = pageNum;

		if(pageNum == 1){
			$('#replyList').empty();
		}

		$.ajax({
			type:'post',
			data:{
				pageNum:pageNum,
				franchise_num:franchise_num,

			},
			url:'/CafeIN/cafein_user/franchise/franchise_replylist.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				var list = data.replyList;
				count = data.count;
				rowCount = data.rowCount;
				$(list).each(function(index, item){

					var output = '';
					output += '<div class="media-body">';
					output += '<input type="hidden" value="' + item.freply_num + '" id="freply_num">';
					output += '<h4 class="media-heading korean-font-bold">' + item.freply_nickname;

					if($('#u_uid').val() && $('#u_uid').val() == item.u_uid){
						output += '<span>' + item.freply_reg_date;
						output += ' <a href="" id="deleteReply">삭제</a> |';  
						output += ' <a class="fdeclear_button" data-toggle="modal" data-target="#declear" data-num="' +item.freply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a></span></h4>';
					}else{
						output += '<span>' + item.freply_reg_date + ' |';
						output += ' <a class="fdeclear_button" data-toggle="modal" data-target="#declear" data-num="' +item.freply_num+ '" data-id="' +item.u_uid+ '" style="text-decoration:none;cursor:pointer;">신고</a></span></h4>';
					}

					output += '<br>';
					output += '<div class="col-md-11">';
					output += '<p class="korean-font">' + item.freply_content + '</p>';
					output += '</div>';
					output += '</div> <hr>';

					$('#replyList').append(output);

					//alert('data : ' + item.freply_num)
				});

				//alert('currentPage : ' + currentPage + ", count : " + count + ", rowCount : " + rowCount); 
				if(currentPage >= Math.ceil(count/rowCount)){
					$('.paging').hide();
				}else{
					$('.paging').show();
				}
			},error:function(){
				alert("오류 발생");
			}
		});
	}

	$('.paging').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum);
	});

	$('#reply').submit(function(event){
		if($('#freply_content').val() == ''){
			alert('내용을 입력하세요');
			$('#freply_content').focus();
			return false;
		}

		var data = $(this).serialize();

		$.ajax({
			type:'post',
			data:data,
			url:'/CafeIN/cafein_user/franchise/writeReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					initForm();
					selectData(1);
				}else{
					alert('등록 실패');
				}
			},error:function(){
				alert('댓글작성 Ajax 오류');
			}
		});
		event.preventDefault();
	});
	function initForm(){
		$('#freply_content').val('');
	}

	$(document).on('click', '#deleteReply', function(event){
		var freply_num = $('#freply_num').val();
		//alert('freply_num : ' + freply_num);
		$.ajax({
			type:'post',
			data:{freply_num:freply_num},
			url:'/CafeIN/cafein_user/franchise/deleteReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					alert('삭제 완료');
					selectData(1);
				}
			},error:function(){
				alert('삭제 Ajax 에러');
			}
		});
		event.preventDefault();
	});
	selectData(1);

	//메뉴 페이징 번호 클릭 시 클릭여부를 가리기 위해 세션에 값 저장
	$('.pageNum').click(function(){
		//alert('pageNum Click');
		sessionStorage.setItem("pagingClick", "pagingClick");
		//$('#grid-container').focus();
	});

	//메뉴 페이징 번호 체크값이 세션에 있으면 tabindex 속성 추가 후 세션 지우기
	//tabindex=1 하면 div에서도 focus가 먹음
	if(sessionStorage.getItem("pagingClick")) {
		$( 'html, body' ).stop().animate( { scrollTop : '700' } );
		sessionStorage.removeItem("pagingClick");
	}

	//댓글 신고
	$(document).on('click','.fdeclear_button',function(){

		//댓글 번호
		var freply_num = $(this).attr('data-num');
		//댓글 작성자 아이디
		var u_uid_declared = $(this).attr('data-id');
		// alert("로그인 아이디 : " + u_uid + ", 댓글 아이디 : " + u_uid_declared); 

		if(u_uid == u_uid_declared) {
			alert('본인을 신고할 수 없습니다');
			$('#declear').hide();
			location.reload();
		}else {
			//댓글 신고
			$.ajax({
				type:'post',
				data:{
					freply_num:freply_num,
					u_uid_declared:u_uid_declared
				},
				url:'/CafeIN/cafein_user/franchise/franchise_replyDeclared_ajax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					if(data.result == 'logout') {
						alert('로그인해야 신고할 수 있습니다.');
						$('#declear').hide();
						location.reload();
					}else if(data.result == 'success'){
						//신고한 댓글의 시퀀스
						var declaredReply = data.declaredReply;
						//신고당한 사람의 u_uid와 닉네임
						var declaredMember_u_uid = data.declaredMember_u_uid;
						var declaredMember_u_name = data.declaredMember_u_name;

						//신고자/피신고자 정보 jsp에 바꿔주기
						$('#d_target_id').val(declaredReply.freply_num);
						$('#d_target_mem_id_name').val(declaredMember_u_name);
						$('#d_target_mem_id_name').html("피신고자 ID : " + declaredMember_u_name);
						$('#d_target_mem_id').val(declaredMember_u_uid);

						alert("신고댓글시퀀스 : " + declaredReply.freply_num + ", 신고당한 사람닉네임 :" + declaredMember_u_name + ", 신고당한사람 u_uid : " + declaredMember_u_uid + ", 신고한사람 u_uid : " + u_uid);

					}else {
						alert('신고시 오류 발생!');
					}
				},
				error:function(){
					alert("freply_num : " + freply_num + ", u_uid : " + u_uid);
					alert('네트워크 오류 발생!');
				}
			});
		}
	});
});
