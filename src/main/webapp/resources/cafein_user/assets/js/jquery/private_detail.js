jQuery(document).ready(function() {
	App.init();
	//ContactPage.initMap();
	Login.initLogin();
	//ContactForm.initContactForm();
	PageContactForm.initPageContactForm();
	Registration.initRegistration();
});

$(function(){
	var base = $('.private');
	base.addClass('active');
});



$(document).ready(function(){
	//에이작스로 넘길 pcafe_num
	var pcafe_num =	$('#pcafe_num').val();
	//상세페이지 카페 메뉴 정보 데이터 처리(페이징)
	var currentPage;
	var count;
	var rowCount;
	var category;
	//var pageNum;
	
	//상세페이지 카페 정보 데이터처리
	$.ajax({
		type:'post',
		data: {
			pcafe_num:pcafe_num
		},
		url:'/CafeIN/cafein_user/private/private_detail_ajax.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {
			var pcafe_info_list = data.pcafe_info_list;
			
			attach_pcafe_info_list(pcafe_info_list);
			
		},error:function() {
			alert('네트워크 오류 발생!');
		}
	});
	
	
	//메뉴 페이징 번호 클릭 시 클릭여부를 가리기 위해 세션에 값 저장
	$('.pageNum').click(function(){
		sessionStorage.setItem("pagingClick", "pagingClick");
	});
	
	//메뉴 페이징 번호 체크값이 세션에 있으면 tabindex 속성 추가 후 세션 지우기
	//tabindex=1 하면 div에서도 focus가 먹음
	if(sessionStorage.getItem("pagingClick")) {
		$('#grid-container').attr("tabindex","1");
		sessionStorage.removeItem("pagingClick");
	}
	
	//메뉴 페이징 번호 클릭 후 새로고침 시에도 메뉴에 포커스가 고정되게 하기위함
	$('#grid-container').focus();
	
	
	
	//즐겨찾기 버튼 눌렀을 때 데이터 처리
	$('#pcafe_bookmark').bind('click',function(){
		//hidden으로 박아놓은 u_uid 값 있으면 로그인한 상태
		if($('#u_uid').val() != '') {
			$.ajax({
				type:'post',
				data: {
					pcafe_num:pcafe_num
				},
				url:'/CafeIN/cafein_user/private/private_detail_bookmark_ajax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data) {
					
					var result = data.result;
					
					if(result == 'bookmarkinsert'){
						$('#pcafe_bookmark').html(
							'<i class="fa fa-star" style="font-size:25px;"></i>'		
						);
					}else if(result == 'bookmarkdelete') {
						$('#pcafe_bookmark').html(
							'<i class="fa fa-star-o" style="font-size:25px;"></i>'
						);
					}else {
						alert('즐겨찾기 호출 오류');
					}
					
				},error:function() {
					alert('네트워크 오류 발생!');
				}
			});
		}else {
			alert("로그인후 즐겨찾기 가능합니다.");
			$('#pcafe_bookmark').html(
				'<i class="fa fa-star-o" style="font-size:25px;"></i>'		
			);
		}
	});
	
	//좋아요 눌렀을 때 데이터 처리
	$('#pcafe_like').bind('click',function(){
		//hidden으로 박아놓은 u_uid 값 있으면 로그인한 상태
		if($('#u_uid').val() != '') {
			$.ajax({
				type:'post',
				data: {
					pcafe_num:pcafe_num
				},
				url:'/CafeIN/cafein_user/private/private_detail_like_ajax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data) {
					
					var result = data.result;
					var totalLikeCount = data.totalLikeCount;
					
					if(result == 'likeinsert'){
						$('#pcafe_like').html(
							'<i class="fa fa-thumbs-o-up"></i> 취소하기'		
						);
						$('#like_count').html(
							'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalLikeCount
						);
					}else if(result == 'likedelete') {
						$('#pcafe_like').html(
							'<i class="fa fa-thumbs-o-up"></i> 좋아요!'
						);
						$('#like_count').html(
							'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalLikeCount
						);
					}else {
						alert('좋아요 호출 오류');
					}
					
				},error:function() {
					alert('네트워크 오류 발생!');
				}
			});
		}else {
			alert("로그인후 좋아요 가능합니다");
			$('#pcafe_like').html(
				'<i class="fa fa-thumbs-o-up"></i> 좋아요!'
			);
		}
	});
	
});

//태그와 이미지 ,로 쪼갠후 html에 append 하는 부분
function attach_pcafe_info_list(pcafe_info_list) {
	//개인카페 태그 쪼개기
	if(pcafe_info_list.pcafe_hash_tag != null) {
		var hash_tag_array = new Array();
		var hash_tag = pcafe_info_list.pcafe_hash_tag;
		hash_tag_array = hash_tag.split(',');
		var hash_tag_append = '';
		for (i = 0; i < hash_tag_array.length; i++) {
			hash_tag_append += '<span class="pcafe-tag-content" id="hash_tag'+ [i] +'"> #' + hash_tag_array[i] + ' ';
		}
	}else {
		var hash_tag_append = '';
	}
	
	var pcafe_img_array = new Array();
	var pcafe_img = pcafe_info_list.pcafe_img;
	pcafe_img_array = pcafe_img.split(',');
	var pcafe_img_append_front = '';
	for (i = 0; i < pcafe_img_array.length; i++) {
		//array 인덱스 안에 * 값이 없으면 -1 반환
		if(pcafe_img_array[i].indexOf('*') != -1){
			//대표이미지 찾아서 *표시 없애주기
			var pcafe_img_front = pcafe_img_array[i].replace('*','');
			pcafe_img_append_front += '<div class="item active"><img src="/CafeIN/upload/private/' + pcafe_img_front + '"></div>';
		}else{
			var pcafe_img_front = pcafe_img_array[i];
			pcafe_img_append_front += '<div class="item"><img src="/CafeIN/upload/private/' + pcafe_img_front + '"></div>';
		}
	}
	
	$('#pcafe_tag').append(
			'<i class="fa fa-tags color-green"></i>' +
			hash_tag_append
	);
	
	$('#pcafe_img').append(
			pcafe_img_append_front
	);
}

//메뉴좋아요 눌렀을 때 데이터 처리, .bind가 안먹어서 onclick 이벤트이용!
function pcafeMenu_like() {
	//alert("pcafeMenu_like 누름");
	//hidden으로 박아놓은 u_uid 값 있으면 로그인한 상태
	if($('#u_uid').val() != '') {
		//에이작스로 넘길 pcafe_num
		var pmenu_num =	$('#pmenu_num').val();
		$.ajax({
			type:'post',
			data: {
				pmenu_num:pmenu_num
			},
			url:'/CafeIN/cafein_user/private/private_detailMenu_like_ajax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data) {
				
				var result = data.result;
				var totalMenuLikeCount = data.totalMenuLikeCount;
				
				if(result == 'menulikeinsert'){
					$('#pcafeMenu_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 취소하기'		
					);
					$('#menuLike_count').html(
							'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalMenuLikeCount
					);
				}else if(result == 'menulikedelete') {
					$('#pcafeMenu_like').html(
						'<i class="fa fa-thumbs-o-up"></i> 좋아요!'
					);
					$('#menuLike_count').html(
						'<i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + totalMenuLikeCount
					);
				}else {
					alert('좋아요 호출 오류');
				}
				
			},error:function() {
				alert('네트워크 오류 발생!');
			}
		});
	}else {
		alert("로그인후 좋아요 가능합니다");
		$('#pcafeMenu_like').html(
			'<i class="fa fa-thumbs-o-up"></i> 좋아요!'
		);
	}
}

//개인카페 메뉴 삭제
function pcafeMenuDelete(pmenu_num,pcafe_num) {
	alert('pmenu_num : ' + pmenu_num + ', pcafe_num : ' + pcafe_num);
	var answer = confirm("메뉴를 삭제 하시겠습니까?");
	
	if(answer){
		var url='/CafeIN/cafein_user/private/private_detailMenuDelete.do?pmenu_num='+pmenu_num+'&pcafe_num='+pcafe_num;
		$.ajax({
			url: url,	      
			type:'post',

			success:function(data){	   
				if(data.result == 'success') {
					//새로고침(html만 지우면 그 공간만 비어버리고 스타일이 안먹기 때문에)
					window.location.reload();
				}else {
					alert('메뉴삭제 호출 오류!');
				}
			},error : function(xhr, status, error) {
				alert("네트워크 오류 발생!");
				alert(error);
			}
		})
	}
}
