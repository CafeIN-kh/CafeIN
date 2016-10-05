jQuery(document).ready(function() {
	App.init();
});

$(function(){
	var base = $('.event');
	base.addClass('active');
});

$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;
	
	function eventList(pageNum){
		currentPage = pageNum;
		
		$('#eventSection').empty();
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'eventAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var eventList = data.eventList;
				
				$(eventList).each(function(index, item) {
					var output = '';
					output += '<div class="panel-group acc-v1 margin-bottom-40" id="accordion">';
					output += '<div class="panel panel-default" style="height: 5px; line-height: 30px; border: 0;">';
					output += '<div class="panel-heading">';
					output += '<ul class="panel-title" style="padding-left: 0;">';
					output += '<li id="nNum" style="list-style: none; float: left; width: 10%; text-align: center; border: 1px solid #DDD; border-right: 0;">';
					output += '<a style="text-decoration: none;">' + item.event_num + '</a></li>';
					output += '<li id="eTitle" style="list-style: none; float: left; width: 75%; text-align: center; border-top: 1px solid #DDD; border-bottom: 1px solid #DDD;">';
					output += '<a class="accordion-toggle" onclick="visit_event(' + item.event_num + ')" data-toggle="collapse" data-parent="#accordion" href="#collapse-' + index + '" style="text-decoration: none; overflow: hidden">';
					output += item.event_title + '</a></li>';
					output += '<li id="nHit" style="list-style: none; float: left; width: 15%; text-align: center; border: 1px solid #DDD; border-left: 0;">';
					output += '<a style="text-decoration: none;">' + item.event_hit + '</a></li>';
					output += '</ul></div></div></div>';
					output += '<div id="collapse-' + index + '" class="panel-collapse collapse" style="border: 1px solid #DDD; border-top: 0; margin-bottom: 5px;">';
					output += '<div class="panel-body">';

					if(item.event_img==null) {
						output += '<ul style="padding-right: 30px;">';
						output += '<li style="list-style: none; float: left; text-align: justify;">';
						output += '<p>' + item.event_content + '</p></li>';
						output += '<li style="list-style: none; height: 20px; float: right;">';
						output += '<p>' + item.event_reg_date + '</p></li></ul>';
					} else {
						output += '<div class="col-md-4">';
						output += '<img class="img-responsive" src="' + item.event_img + '" alt=""></div>';
						output += '<div class="col-md-8">';
						output += '<div id="contentTwo" style="text-align: justify;">';
						output += '<p>' + item.event_content + '</p></div>';
						output += '<div class="col-md-13">';
						output += '<p id="regDateTwo" style="float: right;">' + item.event_reg_date + '</p>';
						output += '</div></div></div></div>';
					}
					
					$('#eventSection').append(output);
				});
				setPage();
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	}
	function setPage(){
		$('.pagination2').empty();
		if(count == 0){
			return;
		}
		var totalPage = Math.ceil(count/rowCount);
		var startPage = Math.floor((currentPage - 1)/pageCount)*pageCount + 1;
		var endPage = startPage+pageCount-1
		
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
			$('.pagination2').append(add); 
		}
		
		for(var i=startPage; i<=endPage; i++){
			if(i == currentPage){
				add = '';
				add += '<li class="active">';
				add += '<a style="cursor:pointer;" data-page="'+i+'">' + i + '</a>';
				add += '</li>';
			}else{
				add = '';
				add += '<li>';
				add += '<a style="cursor:pointer;" data-page="'+i+'">'+i+'</a>';
				add += '</li>';
			}
			$('.pagination2').append(add);
		}
		if(endPage < totalPage){
			add = '';
			add += '<li>';
			add += '<a style="cursor:pointer;" data-page="'+(startPage + pageBlock)+'">></a>';
			add += '</li>';
			$('.pagination2').append(add);
		}
	}
	$(document).on('click', '.pagination2 li a', function(){
		if(currentPage != $(this).attr('data-page')){
			currentPage = $(this).attr('data-page');
			eventList(currentPage, rowCount);
		}
	});
	eventList(1, count);
	
	function visit_event (event_num) {
		alert("event_num : " + event_num);
		var event_num = event_num;
		
		$.ajax({
			type:'post',
			data:{event_num:event_num},
			url:'/cafein_user/notice/visit_eventAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.visit_event == 'visit_event') {
					alert("성공");
				}
			}, 
			error:function(){
				alert('네트워크 오류');
			}
		});
	}
		
});

