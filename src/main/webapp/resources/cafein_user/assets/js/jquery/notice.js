jQuery(document).ready(function() {
	App.init();
});

$(function(){
	var base = $('.notice');
	base.addClass('active');
});

$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;

	function noticeList(pageNum){
		currentPage = pageNum;

		$('#noticeSection').empty();

		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'noticeAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var noticeList = data.noticeList;

				$(noticeList).each(function(index, item) {
					var output = '';
					//alert('item : ' + item.notice_num); 
					output += '<div class="panel-group acc-v1 margin-bottom-40" id="accordion">';
					output += '<div class="panel panel-default" style="height: 5px; line-height: 30px; border: 0;">';
					output += '<div class="panel-heading">';
					output += '<ul class="panel-title" style="padding-left: 0;">';
					output += '<li id="nNum" style="list-style: none; float: left; width: 10%; text-align: center; border: 1px solid #DDD; border-right: 0;">';
					output += '<a style="text-decoration: none;">' + item.notice_num + '</a></li>';
					output += '<li id="nTitle" style="list-style: none;float: left;width: 90%;text-align: center;border-top: 1px solid #DDD;border-bottom: 1px solid #DDD;border-right: 1px solid #DDD;">';
					output += '<a class="accordion-toggle korean-font" data-toggle="collapse" data-parent="#accordion" href="#collapse' + index + '" style="text-decoration: none; overflow: hidden">';
					output += item.notice_title + '</a></li>';
					output += '</ul></div></div></div>';
					output += '<div id="collapse' + index + '" class="panel-collapse collapse" style="border: 1px solid #DDD; border-top: 0; margin-bottom: 5px;">';
					output += '<div class="panel-body">';

					if(item.notice_img==null) {
						output += '<ul style="padding-right: 30px;">';
						output += '<li style="list-style: none; float: left; text-align: justify;">';
						output += '<p class="korean-font">' + item.notice_content + '</p></li>';
						output += '<li style="list-style: none; height: 20px; float: right;">';
						output += '<p>' + item.notice_reg_date + '</p></li></ul>';
					} else {
						output += '<div class="col-md-4">';
						output += '<img class="img-responsive" src="/CafeIN/upload/notice/' + item.notice_img + '" alt=""></div>';
						output += '<div class="col-md-8">';
						output += '<div id="contentTwo" style="text-align: justify;">';
						output += '<p class="korean-font">' + item.notice_content + '</p></div>';
						output += '<div class="col-md-13">';
						output += '<p id="regDateTwo" style="float: right;">' + item.notice_reg_date + '</p>';
						output += '</div></div></div></div>';
					}

					$('#noticeSection').append(output);

				});
				setPage();
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	}
	function setPage(){
		$('.pagination1').empty();
		if(count == 0){
			return;
		}
		var totalPage = Math.ceil(count/rowCount);
		var startPage = Math.floor((currentPage - 1)/pageCount)*pageCount + 1;
		var endPage = startPage+pageCount-1;

		
		if(currentPage == undefined || currentPage == ''){
			currentPage = 1;
		}

		if(currentPage > totalPage){
			currentPage = totalPage;
		}

		if(endPage > totalPage){
			endPage = totalPage;
		}

		var add;
		if(startPage > pageCount){
			add = '';
			add += '<li>';
			add += '<a style="padding-right:6px;cursor:pointer;" data-page="' + (startPage-1) + '"><</a>';
			add += '</li>';
			//$('<li><a style="padding-right:6px;cursor:pointer;"></a></li>').html('<').attr('data-page', (startPage-1));
			$('.pagination1').append(add);
		}
		
		for(var i=startPage; i<=endPage; i++){
			if(i == currentPage){
				//add = $('<li style="padding-right:6px;"><a style="cursor:pointer;"></a></li>').html(i).attr('data-page', i).css('color','red');   
				add = '';
				add += '<li class="active">';
				add += '<a style="cursor:pointer;" data-page="'+i+'">' + i + '</a>';
				add += '</li>';
			}else{
				//add = $('<li style="padding-right:6px;"><a style="cursor:pointer;"></a></li>').html(i).attr('data-page', i);
				add = '';
				add += '<li>';
				add += '<a style="cursor:pointer;" data-page="'+i+'">'+i+'</a>';
				add += '</li>';
			}
			$('.pagination1').append(add);
		}
		if(endPage < totalPage){
			//add = $('<li style="padding-right:6px;><a style="cursor:pointer;"></a></li>').html('>').attr('data-page', (startPage + pageBlock));
			add = '';
			add += '<li>';
			add += '<a style="cursor:pointer;" data-page="'+(startPage + pageBlock)+'">></a>';
			add += '</li>';
			$('.pagination1').append(add);
		}
	}
	$(document).on('click', '.pagination1 li a', function(){
		if(currentPage != $(this).attr('data-page')){
			currentPage = $(this).attr('data-page');
			noticeList(currentPage, rowCount);
		}
	});
	noticeList(1, count);
});


