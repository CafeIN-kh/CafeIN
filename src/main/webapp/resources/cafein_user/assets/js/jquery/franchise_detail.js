$(document).ready(function(){
	
	var franchise_num = $('#franchise_num').val();
	var u_uid = 'test';
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
				if(data.result == 'bookmarkInsert'){
					$('#star').removeClass("fa fa-star-o");
					$('#star').addClass("fa fa-star");
				}
				if(data.result == 'bookmarkDelete'){
					$('#star').removeClass("fa fa-star");
					$('#star').addClass("fa fa-star-o");
				}
				
			},error:function(){
				alert('네트워크 오류 발생! : ');
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
					$('#replyList').append(
						'<div class="media-body">' + 
						'<input type="hidden" value="' + item.freply_num + '" id="freply_num">' +
						'<h4 class="media-heading korean-font">' + item.u_uid + '<span>' + 
						item.freply_reg_date + ' <a href="" id="deleteReply">삭제</a> | <a href="">신고</a></span></h4>' + 
						'<br>' + 
						'<div class="col-md-11">' + 
						'<p class="korean-font">' + item.freply_content + '</p>' +
						'</div>' + 
						'</div> <hr>'
					);
					
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
});