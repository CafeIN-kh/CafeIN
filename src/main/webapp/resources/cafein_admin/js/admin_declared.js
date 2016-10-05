$(document).ready(function() {

	/*$('.declared_content').autoResize();*/

	/*========  아코디언 테이블 js ===================*/

	var article = (".recruit .show2"); // 예전에 선택되서 보여지고 있는 내용 tr

	var oldSelected = (".recruit .selectedColor"); // 예전에 선택된 머리 tr

	$(".recruit .title  td").click(function() {

		var myArticle = $(this).parents().next("tr"); 

		if ($(myArticle).hasClass('hide')) { 
			$(article).removeClass('show2').addClass('hide'); 
			$(myArticle).removeClass('hide').addClass('show2'); 

			$(oldSelected).find("td:first").html("+"); 

			$(oldSelected).removeClass('selectedColor'); 
			$(this).parent().addClass('selectedColor');

			$(this).parent().find("td:first").html("-"); 

		} else { 
			$(myArticle).addClass('hide').removeClass('show2'); 
			$(this).parent().find("td:first").html("+"); 
			$(oldSelected).removeClass('selectedColor'); 
		}
	});

	
	
	
	
	
}); // $(document).ready End





/*=============== 처리 상태 selectPicker ====================*/

$(function() {
	var article = (".recruit .show2"); // 예전에 선택되서 보여지고 있는 내용 tr
	var oldSelected = (".recruit .selectedColor");


	$('.selectpicker').on('change', function() {  

		var d_seq = $(oldSelected).find("td:nth-child(2)").text(); // 선택된 tr의 두번째 td 값을 읽어옴. text()는 xml,html 둘다 읽어옴

		
		var selected = $(this).find("option:selected").attr("value"); // value 값 찾기   0,1...
		var selectedText = $(this).find("option:selected").attr("name"); // 처리 상태 - 처리전 ..

	
		$('.selectpicker').selectpicker('refresh');

		
		$.ajax({
			type : 'post',
			data : {
				d_seq : d_seq,
				d_state : selected
			},
			url : 'd_selectPickerAjax.do',
			cache : false,
			timeout : 30000,
			success : function(data) {

				$(oldSelected).find("td:last").html(selectedText);
			},
			error : function() {

				alert('네트워크 오류 발생_declared!');
			}

		}); // End ajax

		

	}); // End on select box change

	
	
	/*=============== End on selectPicker change ====================*/
	
	
	
	/*=============== CommentBtn  ====================*/
	
	$('.d_commentBtn').click(function(){
		
		var d_commentText = $(article).find('.d_commentText').val(); 
		
		var d_commentSeq = $(oldSelected).find("td:nth-child(2)").text();  //seq
		
		//alert('comment : ' + d_commentText + ' , seq : '+d_commentSeq);
		
		

		$.ajax({
			type : 'post',
			data : {
				d_seq : d_commentSeq,
				d_comment : d_commentText
			},
			url : 'd_commentAjax.do',
			cache : false,
			timeout : 30000,
			success : function(data) {
				
				 $(article).find('.yes1').text('입력되었습니다.').css('color','red'); 
				 
				
			},
			error : function() {

				alert('네트워크 오류 발생_declared!');
			}

		}); // End ajax
		
		
		setTimeout(function(){
			 $(article).find('.yes1').text(''); 
			}, 1500);
		
	}); // End commentBtn click event
	
	
	
	
}); // End function



/*
 * // nicescroll 이 오류날 경우 $(function(){
 * 
 * //Scrollbar Tables if ($('.table-responsive')[0]) {
 * scrollbar('.table-responsive', 'rgba(0,0,0,0.5)', '5px'); }
 * 
 * });
 * 
 * function scrollbar(className, color, cursorWidth) { $(className).niceScroll({
 * cursorcolor: color, cursorborder: 0, cursorborderradius: 0, cursorwidth:
 * cursorWidth, bouncescroll: true, mousescrollstep: 100 }); }
 */