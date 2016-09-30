$(document).ready(function(){

	/* Make some random data for Recent Items chart */

	var data = [];
	var totalPoints = 100;
	var updateInterval = 30;
	function commify(n) {
		var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
		n += '';                          // 숫자를 문자열로 변환

		while (reg.test(n))
			n = n.replace(reg, '$1' + ',' + '$2');

		return n;
	}


	$.ajax({
		type:'post',
		url:'franchiseTotalCount.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {


			var adminMainFranchiseCommandarray = new Array();
			var adminMainPrivateCommandarray = new Array();
			var adminMainCustomCommandarray = new Array();
			var franchiseCount = new Array();
			var privateCount = new Array();
			var customCount = new Array();
			var pmenuCount = new Array();
			var fmenuCount = new Array();

			/*for(i=0;i<data.adminMainCommand.length;i++){
					adminMainCommandarray[i] = jQuery.parseJSON(data.adminMainCommand).ucnt_log_franchise;
					alert(adminMainCommandarray[i]);
				}*/


			$(data.adminMainFranchiseCommand).each(function(index,item){
				adminMainFranchiseCommandarray[index] = item.ucnt_log_franchise;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});

			$(data.adminMainPrivateCommand).each(function(index,item){
				adminMainPrivateCommandarray[index] = item.ucnt_log_private;
			});

			$(data.adminMainCustomizingCommand).each(function(index,item){

				adminMainCustomCommandarray[index] = item.ucnt_log_custom;

			});
			var d1 = [];
			var d2 = [];
			var d3 = [];
			for (var i = 0; i < 20; i += 1) {
				if(adminMainFranchiseCommandarray[i] ==null){
					d1.push([i, 0]);
				}else{
					d1.push([i, adminMainFranchiseCommandarray[i]]);					
				}
				if(adminMainPrivateCommandarray[i] == null){
					d2.push([i, 0]);
				}else{
					d2.push([i, adminMainPrivateCommandarray[i]]);					
				}
				if(adminMainCustomCommandarray[i] == null){
					d3.push([i, 0]);
				}else{
					d3.push([i, adminMainCustomCommandarray[i]]);					
				}
			}
			if ($("#line-chart")[0]) {
				$.plot($("#line-chart"), [
				                          {data: d1, lines: { show: true, fill: 0.98 }, label: 'Franchise', stack: true, color: '#2a4d7d' },
				                          {data: d2, lines: { show: true, fill: 0.98 }, label: 'Private', stack: true, color: '#4570a1' },
				                          {data: d3, lines: { show: true, fill: 0.98 }, label: 'Customizing', stack: true, color: '#a9b6c7' }
				                          ], options);
			}
			$(data.franchiseCountCommand).each(function(index,item){
				franchiseCount[index] = item.count;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});
			$(data.privateCountCommand).each(function(index,item){
				privateCount[index] = item.count;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});
			$(data.customCountCommand).each(function(index,item){
				customCount[index] = item.count;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});
			$(data.pmenuCountCommand).each(function(index,item){
				pmenuCount[index] = item.count;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});
			$(data.fmenuCountCommand).each(function(index,item){
				fmenuCount[index] = item.count;
				//alert(index);
				//alert(adminMainCommandarray[0]);
			});


			var c1 = [];
			var c2 = [];
			var c3 = [];
			var c4 = [];
			var c5 = [];
			for (var i = 0; i < 20; i += 1) {
				if(franchiseCount[i] == null){
					c1.push([i, 0]);
				}else{
					c1.push([i, franchiseCount[i]]);
				}
				if(privateCount[i] == null){
					c2.push([i, 0]);
				}else{
					c2.push([i, privateCount[i]]);
				}
				if(customCount[i] == null){
					c3.push([i, 0]);
				}else{
					c3.push([i, customCount[i]]);					
				}
				if(pmenuCount[i] == null){
					c4.push([i, 0]);
				}else{
					c4.push([i, pmenuCount[i]]);
				}
				if(fmenuCount[i] == null){
					c5.push([i, 0]);
				}else{
					c5.push([i, fmenuCount[i]]);
				}
			}
			if ($("#line-chart-1")[0]) {
				$.plot($("#line-chart-1"), [
				                            {data: c1, lines: { show: true, fill: 0.98 }, label: 'Franchise like', stack: true, color: '#9302b0' },
				                            {data: c2, lines: { show: true, fill: 0.98 }, label: 'Private like', stack: true, color: '#e7d2fc' },
				                            {data: c3, lines: { show: true, fill: 0.98 }, label: 'Custom like', stack: true, color: '#5cd0fa' },
				                            {data: c4, lines: { show: true, fill: 0.98 }, label: 'Pmenu like', stack: true, color: '#e685e6' },
				                            {data: c5, lines: { show: true, fill: 0.98 }, label: 'Fmenu like', stack: true, color: '#8b9ed6' }
				                            ], options);
			}

			var totalCount = parseInt(data.pageTotal);
			var franchiseCount = parseInt(data.franchiseTotal);
			var privateCount = parseInt(data.privateTotal);
			var customCount = parseInt(data.customTotal);
			//alert(adminMainCommandarray[1]);
			$("#totalcount").text(commify(totalCount));
			$("#franchiseCount").text(commify(franchiseCount));
			$("#privateCount").text(commify(privateCount));
			$("#customCount").text(commify(customCount));


		},error:function() {
			alert('네트워크 오류 발생!');
		}
	});

	function getRandomData() {
		if (data.length > 0)
			data = data.slice(1);

		while (data.length < totalPoints) {

			var prev = data.length > 0 ? data[data.length - 1] : 50,
					y = prev + Math.random() * 10 - 5;
			if (y < 0) {
				y = 0;
			} else if (y > 90) {
				y = 90;
			}

			data.push(y);
		}

		var res = [];
		for (var i = 0; i < data.length; ++i) {
			res.push([i, data[i]])
		}

		return res;
	}

	/* Make some random data for Flot Line Chart */

//	var d1 = [];
//	for (var i = 0; i <= 20; i += 1) {
//	d1.push([i, parseInt(Math.random() * 30)]);
//	}
	/*    var d2 = [];
    for (var i = 0; i <= 20; i += 1) {
        d2.push([i, parseInt(Math.random() * 30)]);
    }    
    var d3 = [];
    for (var i = 0; i <= 20; i += 1) {
        d3.push([i, parseInt(Math.random() * 30)]);
    }*/

	/* Chart Options */

	var options = {
			series: {
				shadowSize: 0,
				lines: {
					show: false,
					lineWidth: 0,
				},
			},
			grid: {
				borderWidth: 0,
				labelMargin:10,
				hoverable: true,
				clickable: true,
				mouseActiveRadius:6,

			},
			xaxis: {
				tickDecimals: 0,
				ticks: false
			},

			yaxis: {
				tickDecimals: 0,
				ticks: false
			},

			legend: {
				show: false
			}
	};

	/* Regular Line Chart */
	/* if ($("#line-chart")[0]) {
        $.plot($("#line-chart"), [
            {data: d1, lines: { show: true, fill: 0.98 }, label: 'Product 1', stack: true, color: '#FD7400' },
            {data: d2, lines: { show: true, fill: 0.98 }, label: 'Product 2', stack: true, color: '#FFE11A' },
            {data: d3, lines: { show: true, fill: 0.98 }, label: 'Product 3', stack: true, color: '#004358' }
        ], options);
    }*/
	/*if ($("#line-chart-1")[0]) {
        $.plot($("#line-chart-1"), [
            //{data: d1, lines: { show: true, fill: 0.98 }, label: 'Product 1', stack: true, color: '#e3e3e3' },
            {data: d2, lines: { show: true, fill: 0.98 }, label: 'Product 2', stack: true, color: '#00BCD4' },
            {data: d3, lines: { show: true, fill: 0.98 }, label: 'Product 3', stack: true, color: '#FFC107' }
        ], options);
    }*/

	/* Recent Items Table Chart */
	if ($("#recent-items-chart")[0]) {
		$.plot($("#recent-items-chart"), [
		                                  {data: getRandomData(), lines: { show: true, fill: 0.8 }, label: 'Items', stack: true, color: '#00BCD4' },
		                                  ], options);
	}

	/* Tooltips for Flot Charts */

	if ($(".flot-chart")[0]) {
		$(".flot-chart").bind("plothover", function (event, pos, item) {
			if (item) {
				var x = item.datapoint[0].toFixed(2),
				y = item.datapoint[1].toFixed(2);
				$(".flot-tooltip").html(item.series.label + " of " + x + " = " + y).css({top: item.pageY+5, left: item.pageX+5}).show();
			}
			else {
				$(".flot-tooltip").hide();
			}
		});

		$("<div class='flot-tooltip' class='chart-tooltip'></div>").appendTo("body");
	}
});