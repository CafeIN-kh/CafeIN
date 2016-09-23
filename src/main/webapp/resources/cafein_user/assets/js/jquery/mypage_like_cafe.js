jQuery(document).ready(function() {
	App.init();
	//App.initScrollBar();        
	//MouseWheel.initMouseWheel();
});

$(document).ready(function(){
	//드롭다운 이름 변경
	var category = $('#category').val();
	if(category == 1) {
		$('#cafe_category').html('Franchise <span class="caret"></span>');
	}else if(category == 2) {
		$('#cafe_category').html('Private <span class="caret"></span>');
	}
});
