/*

        $("#report tr:odd").addClass("odd");
        $("#report tr:not(.odd)").hide(); 
        $("#report tr:first-child").show(); //열머리글 보여주기

        $("#report tr.odd").click(function(){
            $(this).next("tr").toggle();
            $(this).find(".arrow").toggleClass("up");

        });
        
        
       // $(function() {

    });*/

$(document).ready(function() {
	var article = (".recruit .show2"); // 예전에 선택되서 보여지고 있는 내용 tr

	var oldSelected = (".recruit .selectedColor"); // 예전에 선택된 머리 tr

	$(".recruit .title  td").click(function() {

		
		var myArticle = $(this).parents().next("tr"); // 지금 선택된 tr의 다음 tr -> show,hide된 내용 tr

		if ($(myArticle).hasClass('hide')) { 	// 지금 선택된 머리 tr의 다음 tr(=내용 tr)이 hide 상태라면 
			$(article).removeClass('show2').addClass('hide');    // 예전에 선택한 내용 tr을 숨기고
			$(myArticle).removeClass('hide').addClass('show2');   // 지금 선택된 머리의 내용tr을 보여라

			$(oldSelected).find("td:first").html("+"); // 예전에 선택된 tr의 첫번째 td 부분을 +로 변경
			
			$(oldSelected).removeClass('selectedColor');   // 예전에 선택된 머리 tr의 배경색 지우기
			$(this).parent().addClass('selectedColor');   // 지금 선택된 머리tr의 배경색 넣기

				
			$(this).parent().find("td:first").html("-"); // 지금 선택된 td의 부모인 머리 tr 의 첫번째 td (+/-)있는 부분의 htrml을 -로 변경
			
		} else {  // 지금 선택된 머리 tr이 이미 전에 선택된 머리 tr 이었다면 
			$(myArticle).addClass('hide').removeClass('show2');  // 지금선택된 tr을 hide
			$(this).parent().find("td:first").html("+");	// 지금 선택된 td의 부모인 머리 tr의 첫번째 td 의 html을 +로 변경
			$(oldSelected).removeClass('selectedColor');  // 예전에 선택된 머리 tr의 배경색 지우기
		}
	});

});

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