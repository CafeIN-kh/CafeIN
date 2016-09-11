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
	
	//카페 목록
	/*function selectData(pageNum,u_uid, category) {*/
	function selectData(pageNum, category) {
		currentPage = pageNum;
		
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
				category:category
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
				
				//count가 음수가 오면 오류가 났다는거.
				if(count < 0 || list == null) {
					alert('목록 호출 오류 발생');
				}else {
					//불러올 목록이 없으면 없다는 표시 해주기.
					if(list != 0) {
						$(list).each(function(index,item){
							
							attach_pcafe_main(item);
								
						});
					}else {
						$('#output').html(
							'<div class="korean-font" style="text-align:center;font-size: xx-large;color:#72c02c;margin: 200px 0;">등록한 글이 없습니다.</div>'
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
		selectData(pageNum,1);
	});
	
	//최신순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_recent').bind('click',function(){
		category = 1;
		//alert("category :" + category);
		selectData(1, category);
	});
	//조회순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_visit').bind('click',function(){
		category = 2;
		selectData(1, category);
	});
	//좋아요순 버튼 눌렀을 때 데이터호출
	$('#pcafe_category_like').bind('click',function(){
		category = 3;
		selectData(1, category);
	});
	//내글보기 눌렀을때 데이터 호출
	$('#pcafe_category_myPCafe').bind('click',function(){
		category = 4;
		selectData(1, category);
	});
	
	//초기 데이터(목록)호출
	/*selectData(1,$('#u_uid').val());*/
	//pageNum, category
	selectData(1,1);
	
	
	
	
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



function attach_pcafe_main(item) {

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
	
/*	pcafe_img_array = item.pcafe_img;
	//array 인덱스 안에 * 값이 없으면 -1 반환
	if(pcafe_img_array.indexOf('*') != -1){
		//대표이미지 찾아서 *표시 없애주기
		var pcafe_img_front = pcafe_img_array.replace('*','');
		var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
	}else{
		var pcafe_img_front = pcafe_img_array;
		var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
	}*/
	
	//var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + item.pcafe_img + '">';
	
	var pcafe_img_array = new Array();
	var pcafe_img = item.pcafe_img;
	pcafe_img_array = pcafe_img.split(',');
	for (i = 0; i < pcafe_img_array.length; i++) {
		//array 인덱스 안에 * 값이 없으면 -1 반환
		if(pcafe_img_array[i].indexOf('*') != -1){
			//대표이미지 찾아서 *표시 없애주기
			var pcafe_img_front = pcafe_img_array[i].replace('*','');
			//server.xml에 외부 경로 매핑 적어줌 <Context docBase="D:/save" path="/Image" reloadable="true"/>
			var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
			break;
		}else{
			var pcafe_img_front = pcafe_img_array[i];
			var pcafe_img_append_front = '<img class="img-responsive" src="/CafeIN/upload/private/' + pcafe_img_front + '">';
			break;
		}
	}
	
	$('#output').append(
			'<div class="col-md-4 col-sm-6">' +
        	'<div class="thumbnails thumbnail-style thumbnail-kenburn news-v1-in">' +
                '<div class="thumbnail-img">' +
                    '<div class="overflow-hidden">' +
                    	pcafe_img_append_front +
                        /*'<img class="img-responsive" src="${pageContext.request.contextPath}/resources/cafein_user/assets/img/main/img2.jpg"/>' +*/
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
                        		/*'강서구, 우장산, 분위기짱, 스터디' +*/
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