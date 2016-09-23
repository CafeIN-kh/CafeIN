jQuery(document).ready(function() {
	App.init();
	//App.initScrollBar();        
	//MouseWheel.initMouseWheel();
});

$(document).ready(function(){
	//드롭다운 이름 변경
	var category = $('#category').val();
	if(category == 1) {
		$('#menu_category').html('Franchise Menu <span class="caret"></span>');
	}else if(category == 2) {
		$('#menu_category').html('Private Menu <span class="caret"></span>');
	}else if(category == 3) {
		$('#menu_category').html('Customizing Menu <span class="caret"></span>');
	}
});