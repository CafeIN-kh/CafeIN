function fcafeMenu_like(){
	var u_uid = $('#u_uid').val();
	var fmenu_num = $('#fmenu_num').val();
	
	if(u_uid != ''){
		$.ajax({
			type:'post',
			data:{
				fmenu_num:fmenu_num
			},
			url:'/CafeIN/cafein_user/franchise/selectMenuLike.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				var result = data.result;
				var totalLikeCount = data.totalLikeCount;
				
				if(result == 'likeInsert'){
					$('#fcafeMenu_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 취소하기!'		
					);
					$('#fmenuLike_count').html(
						'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalLikeCount
					);
				}else if(result == 'likeDelete'){
					$('#fcafeMenu_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 좋아요!'		
					);
					$('#fmenuLike_count').html(
						'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalLikeCount
					);
				}else{
					alert('좋아요 호출 오류');
				}
			},error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	}else{
		alert("로그인 후 이용 가능합니다");
		$('#fcafeMenu_like').html(
			'<i class="fa fa-thumbs-o-up"></i> 좋아요!'
		);
	}
}