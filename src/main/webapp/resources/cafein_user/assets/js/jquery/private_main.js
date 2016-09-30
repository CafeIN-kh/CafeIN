jQuery(document).ready(function() {
	App.init();
	//ContactForm.initContactForm();
	Login.initLogin();
});

/* header에서 들어간 메뉴에 밑줄가도록 active 추가 해주기 */
$(function(){
	var base = $('.private');
	base.addClass('active');
});

/*페이지 리로드, 카페 등록 후 모달창이 사라지지 않아서 새로고침 해주기 위해 작성*/
/*if (self.name != 'reload') {
	self.name = 'reload';
	self.location.reload(true);
} else
	self.name = '';*/


$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	var category;
	var keyword;
	
	//카페 목록
	/*function selectData(pageNum,u_uid, category) {*/
	function selectData(pageNum, category, keyword) {
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
				category:category,
				keyword:keyword
			},
			url:'/CafeIN/cafein_user/private/private_main_ajax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data) {
				//로딩 이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				var category_mywrite = data.category_mywrite;
				
				//count가 음수가 오면 오류가 났다는거.
				if(count < 0 || list == null) {
					alert('목록 호출 오류 발생');
				}else {
					//키워드 초기화 후 포커스아웃
					$('#keyword').val('');
					$('#keyword').blur();
					
					//불러올 목록이 없으면 없다는 표시 해주기.
					if(list != 0) {
						
						$(list).each(function(index,item){
							attach_pcafe_main(item,index.category_mywrite);
						});
						
					}else {
						$('#output').html(
							'<div class="korean-font" style="text-align:center;font-size:xx-large;color:#72c02c;margin:200px 0;">현재 카페정보가 없습니다.</div>'
						);
					}
					
					if(list != 0) {
						//paging button 처리
						if(currentPage >= Math.ceil(count/rowCount)) {
							//다음 페이지가 없음
							$('.paging_button').hide();
						}else {
							//다음 페이지가 존재
							$('.paging_button').show();
						}
					}else {
						//불러올 목록이 없으면 버튼 숨기기.
						$('.paging_button').hide();
					}
					
				}
			},
			error:function() {
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('네트워크 오류 발생!');
			}
		});
	}
	
	
	//다음 목록보기 버튼 클릭시 데이터 추가(이벤트 연결)
	$('.paging_button button').click(function(){
		var pageNum = currentPage +1;
				//PageNum,category
		selectData(pageNum,category,keyword);
	});
	
	//최신순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_recent').bind('click',function(){
		category = 1;
		selectData(1, category, keyword);
	});
	//조회순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_visit').bind('click',function(){
		category = 2;
		selectData(1, category, keyword);
	});
	//좋아요순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_like').bind('click',function(){
		category = 3;
		selectData(1, category, keyword);
	});
	//내글보기 눌렀을때 데이터 호출
	$('#pcafe_category_myPCafe').bind('click',function(){
		category = 4;
		selectData(1, category, keyword);
	});
	
	//검색어 입력시 데이터 호출
	$('#pcafe_search').submit(function(event){
		if($('#keyword').val() == '') {
			alert('검색어를 입력하세요!');
			$('#keyword').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var keyword = $('#keyword').val();
		//alert("keyword : " + keyword);
		
		//기본 이벤트 제거
		event.preventDefault();
		
		//검색어 입력시 자동으로 최신순 정렬로 드롭다운 이름 변경
		$('.pcafe_category').html('최신순 <span class="caret"></span>');
		
		//페이지넘버,카테고리넘버,검색어
		selectData(1, 1, keyword);
	});
	
	
	//초기 데이터(목록)호출
	//pageNum, category, 검색어
	selectData(1, 1, keyword);
	
	
	
	
	//드롭다운 이름 변경
	$('#pcafe_category_recent').bind('click',function() {
		$('.pcafe_category').html('최신순 <span class="caret"></span>');
	});
	$('#pcafe_category_visit').bind('click',function() {
		$('.pcafe_category').html('조회순 <span class="caret"></span>');
	});
	$('#pcafe_category_like').bind('click',function() {
		$('.pcafe_category').html('좋아요순 <span class="caret"></span>');
	});
	$('#pcafe_category_myPCafe').bind('click',function() {
		$('.pcafe_category').html('나의 등록글<span class="caret"></span>');
	});
	
});

//메인에 개인카페 정보 리스트(카드)append로 html 붙이는 부분 
function attach_pcafe_main(item,category_mywrite) {

	//개인카페 태그 쪼개기
	if(item.pcafe_hash_tag != null) {
		var hash_tag_array = new Array();
		var hash_tag = item.pcafe_hash_tag;
		hash_tag_array = hash_tag.split(',');
		var hash_tag_append = '';
		for (i = 0; i < hash_tag_array.length; i++) {
			hash_tag_append += '<span class="hashtag-content" id="hash_tag'+ [i] +'"> #' + hash_tag_array[i] + ' ';
		}
	}else {
		var hash_tag_append = '';
	}
	
	//개인카페 이미지 쪼개기
	var pcafe_img_array = new Array();
	var pcafe_img = item.pcafe_img;
	pcafe_img_array = pcafe_img.split(',');
	for (i = 0; i < pcafe_img_array.length; i++) {
		//array 인덱스 안에 * 값이 없으면 -1 반환
		if(pcafe_img_array[i].indexOf('*') != -1){
			//대표이미지 찾아서 *표시 없애주기
			var pcafe_img_front = pcafe_img_array[i].replace('*','');
			var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
			break;
		}else{
			var pcafe_img_front = pcafe_img_array[i];
			var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
			break;
		}
	}
	
	//삭제버튼 관련 소스, pcafeDelete() a태그와 바로 위 easy-bolck-v1 클래스
	//내글 보기 누를 경우 삭제 버튼 나오는 html 붙이기
	if(category_mywrite == 'category_mywrite' ) {
		$('#output').append(
			'<div class="col-md-4 col-sm-6 easy-block-v1">' +
				'<a onclick="pcafeDelete(' + item.pcafe_num + ',' + item.u_uid + ')" class="easy-block-v1-badge rgba-red"' + 
					'style="left:22px;top:25px;text-decoration:none;cursor:pointer;">' +
		    		'<i class="fa fa-trash-o"></i> Delete' +
		    	'</a>' + 
	        	'<div class="thumbnails thumbnail-style thumbnail-kenburn news-v1-in">' +
	                '<div class="thumbnail-img">' +
	                    '<div class="overflow-hidden">' +
	                    	pcafe_img_append_front +
	                    '</div>' +
	                    '<a class="btn-more hover-effect" href="/CafeIN/cafein_user/private/private_detail.do?pcafe_num=' + item.pcafe_num + '" style="text-decoration:none;">read more +</a>' +              
	                '</div>' +
	                '<div class="caption">' +
	                	'<h3 class="font-normal korean-font">' + item.pcafe_name + '</h3>' +
	                	'<ul class="list-unstyled list-inline blog-info">' +
	                        '<li class="korean-font">' +
	                        	'<p style="max-height:43px;min-height:43px;overflow:hidden;margin-bottom:0px;">' +
	                        		'<i class="fa fa-tags"></i> ' +
	                        			hash_tag_append +
	                        	'</p>' +
	                        '</li>' +
	                    '</ul>' +
	                '</div>' +
	                '<ul class="list-inline news-v1-info no-margin-bottom" style="margin-top:15px;">' +
	                    '<li><i class="fa fa-clock-o"></i> ' + item.pcafe_reg_date + '</li>' +
	                    '<li>|</li>' +
	                    '<li><i class="fa fa-comments-o"></i> ' + item.pc_reply_cnt + '</li>' +
	                    '<li>|</li>' +
	                    '<li><i class="fa fa-eye"></i> ' + item.pcafe_visit + '</li>' +
	                    '<li class="pull-right"><i class="fa fa-heart"></i> ' + item.pc_like_cnt + '</li>' +
	                '</ul>' +
	            '</div>' +
	        '</div>'
		);
	}else {
		$('#output').append(
				'<div class="col-md-4 col-sm-6">' +
	        	'<div class="thumbnails thumbnail-style thumbnail-kenburn news-v1-in">' +
	                '<div class="thumbnail-img">' +
	                    '<div class="overflow-hidden">' +
	                    	pcafe_img_append_front +
	                    '</div>' +
	                    '<a class="btn-more hover-effect" href="/CafeIN/cafein_user/private/private_detail.do?pcafe_num=' + item.pcafe_num + '" style="text-decoration:none;">read more +</a>' +              
	                '</div>' +
	                '<div class="caption">' +
	                	'<h3 class="font-normal korean-font">' + item.pcafe_name + '</h3>' +
	                	'<ul class="list-unstyled list-inline blog-info">' +
	                        '<li class="korean-font">' +
	                        	'<p style="max-height:43px;min-height:43px;overflow:hidden;margin-bottom:0px;">' +
	                        		'<i class="fa fa-tags"></i> ' +
	                        			hash_tag_append +
	                        	'</p>' +
	                        '</li>' +
	                    '</ul>' +
	                '</div>' +
	                '<ul class="list-inline news-v1-info no-margin-bottom" style="margin-top:15px;">' +
	                    '<li><i class="fa fa-clock-o"></i> ' + item.pcafe_reg_date + '</li>' +
	                    '<li>|</li>' +
	                    '<li><i class="fa fa-comments-o"></i> ' + item.pc_reply_cnt + '</li>' +
	                    '<li>|</li>' +
	                    '<li><i class="fa fa-eye"></i> ' + item.pcafe_visit + '</li>' +
	                    '<li class="pull-right"><i class="fa fa-heart"></i> ' + item.pc_like_cnt + '</li>' +
	                '</ul>' +
	            '</div>' +
	        '</div>'
		);
	}

}

//해당 개인카페 정보 삭제하는 부분
function pcafeDelete(pcafe_num,u_uid) {
	alert('pcafe_num : ' + pcafe_num + ', u_uid : ' + u_uid);
	var answer = confirm("등록한 카페를 삭제 하시겠습니까?");
	
	if(answer){
		var url='/CafeIN/cafein_user/private/pcafeDelete_ajax.do?pcafe_num='+pcafe_num+'&u_uid='+u_uid;
		$.ajax({
			url: url,	      
			type:'post',
			success:function(data){	   
				if(data.result == 'success') {
					//새로고침(해당 html만 지우면 그 공간만 비기 때문에)
					window.location.reload();
				}else {
					alert('개인카페 삭제 호출 오류!');
				}
			},error : function(xhr, status, error) {
				alert("네트워크 오류 발생!");
				alert(error);
			}
		})
	}
}