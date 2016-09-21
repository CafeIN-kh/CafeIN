$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	
   $('#like').bind('click',function() {
      $('#pcafe_category').html('나의 등록글<span class="caret"></span>');
   });
	
   
   
	//댓글 등록
	$("#re_form").submit(function(event){
		if($('#custom_name').val() == '') {
			alert('내용을 입력하세요!');
			$('#custom_name').focus();
			return false;
		}
		if($('#upload').val() == '') {
			alert('사진을 꼭 등록 하세요');
			$('#upload').focus();
			return false;
		}
		if($('#custom_introduce').val() == '') {
			alert('커스터메이징 소개를 등록하세요');
			$('#upload').focus();
			return false;
		}
		if($('custom_recipe').val() == '') {
			alert('커스터메이징 레시피를 등록하세요');
			$('#upload').focus();
			return false;
		}
		if($('#custom_hash_tag').val() == '') {
			alert('해쉬태그를 꼭 등록 하세요');
			$('#upload').focus();
			return false;
		}
		
		
		 
		//전체 데이터를 전부 지정할 때
		var formData = new FormData($(this)[0]);
		
		//댓글 등록 Ajax
		$.ajax({
			url:'/CafeIN/cafein_user/customizing/customizingInsert_ajax.do',
			type:'POST',
			data:formData,
			dataType:'json',
			contentType:false,
			processData:false,
			success:function(data){
					//폼 초기화
				initForm();
				location.reload();
			},
			error:function(){
				alert('네트워크 오류 발생!!!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();		
	});
	
	function initForm(){
		$('textarea').val('');
		$('input').val('');
		$('#responsive').hide();
	}
	
	
	
});