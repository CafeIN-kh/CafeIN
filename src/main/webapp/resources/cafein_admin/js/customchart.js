$(document).ready(function () {
	/*
	 * SPARKLINE
	 */
	function sparklineBar(id, values, height, barWidth, barColor, barSpacing) {
		$('.'+id).sparkline(values, {
			type: 'bar',
			height: height,
			barWidth: barWidth,
			barColor: barColor,
			barSpacing: barSpacing
		})
	}

	function sparklineLine(id, values, width, height, lineColor, fillColor, lineWidth, maxSpotColor, minSpotColor, spotColor, spotRadius, hSpotColor, hLineColor) {
		$('.'+id).sparkline(values, {
			type: 'line',
			width: width,
			height: height,
			lineColor: lineColor,
			fillColor: fillColor,
			lineWidth: lineWidth,
			maxSpotColor: maxSpotColor,
			minSpotColor: minSpotColor,
			spotColor: spotColor,
			spotRadius: spotRadius,
			highlightSpotColor: hSpotColor,
			highlightLineColor: hLineColor
		});
	}

	function sparklinePie(id, values, width, height, sliceColors) {
		$('.'+id).sparkline(values, {
			type: 'pie',
			width: width,
			height: height,
			sliceColors: sliceColors,
			offset: 0,
			borderWidth: 0
		});
	}    

	function commify(n) {
		var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
		n += '';                          // 숫자를 문자열로 변환

		while (reg.test(n))
			n = n.replace(reg, '$1' + ',' + '$2');

		return n;
	}

	$.ajax({
		type:'post',
		url:'custom_Count.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {
			var customPageCount = new Array();
			var cDeClaredCount = new Array();

			$(data.customPV).each(function(index,item){
				customPageCount[index] = item.ucnt_log_custom;
			});
			
			$(data.cDeClaredCount).each(function(index,item){
				cDeClaredCount[index] = item.count;
				
			});
			if ($('.dash-widget-visits')[0]) {

				for(i=0;i<7;i++){
					if(customPageCount[i] == null){
						customPageCount[i] = 0;
					}
				}
				sparklineLine('dash-widget-visits', [customPageCount[0],customPageCount[1],customPageCount[2],customPageCount[3],customPageCount[4],customPageCount[5],customPageCount[6]], '100%', '95px', 'rgba(255,255,255,0.7)', 'rgba(0,0,0,0)', 2, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 5, 'rgba(255,255,255,0.4)', '#fff');
			}
			

			if ($('.dash-widget-visits1')[0]) {
				for(i=0;i<7;i++){
					if(cDeClaredCount[i] == null){
						cDeClaredCount[i] =0;
					}
				}
				sparklineLine('dash-widget-visits1', [cDeClaredCount[0],cDeClaredCount[1],cDeClaredCount[2],cDeClaredCount[3],cDeClaredCount[4],cDeClaredCount[5],cDeClaredCount[6]], '100%', '95px', 'rgba(255,255,255,0.7)', 'rgba(0,0,0,0)', 2, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 5, 'rgba(255,255,255,0.4)', '#fff');
			}


			var cpvCount = parseInt(data.cpvCount);

			$("#cpvCount").text(commify(cpvCount));
			
			var cdcCount = parseInt(data.cDeClaredTotal);
			$("#cdcCount").text(commify(cdcCount));

		},error:function() {
			alert('네트워크 오류 발생!');
		}
	});
	/* Mini Chart - Bar Chart 1 */
	if ($('.stats-bar')[0]) {
		sparklineBar('stats-bar', [1,2,3,4,5,6,7,8,3,5,9,5,8,4,3,6,8], '45px', 3, '#fff', 2);
	}

	/* Mini Chart - Bar Chart 2 */
	if ($('.stats-bar-2')[0]) {
		sparklineBar('stats-bar-2', [4,7,6,2,5,3,8,6,6,4,8,6,5,8,2,4,6], '45px', 3, '#fff', 2);
	}

	/* Mini Chart - Line Chart 1 */
	if ($('.stats-line')[0]) {
		sparklineLine('stats-line', [9,4,6,5,6,4,5,7,9,3,6,5], 85, 45, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
	}

	/* Mini Chart - Line Chart 2 */
	if ($('.stats-line-2')[0]) {
		sparklineLine('stats-line-2', [5,6,3,9,7,5,4,6,5,6,4,9], 85, 45, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
	}

	/* Mini Chart - Pie Chart 1 */
	if ($('.stats-pie')[0]) {
		sparklinePie('stats-pie', [20, 35, 30, 5], 45, 45, ['#fff', 'rgba(255,255,255,0.7)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.2)']);
	}

	/* Dash Widget Line Chart */



	/*
	 * Easy Pie Charts - Used in widgets
	 */
	function easyPieChart(id, trackColor, scaleColor, barColor, lineWidth, lineCap, size) {
		$('.'+id).easyPieChart({
			trackColor: trackColor,
			scaleColor: scaleColor,
			barColor: barColor,
			lineWidth: lineWidth,
			lineCap: lineCap,
			size: size
		});
	}

	/* Main Pie Chart */
	if ($('.main-pie')[0]) {
		easyPieChart('main-pie', 'rgba(255,255,255,0.2)', 'rgba(255,255,255,0.5)', 'rgba(255,255,255,0.7)', 7, 'butt', 148);
	}

	/* Others */
	if ($('.sub-pie-1')[0]) {
		easyPieChart('sub-pie-1', '#eee', '#ccc', '#2196F3', 4, 'butt', 95);
	}

	if ($('.sub-pie-2')[0]) {
		easyPieChart('sub-pie-2', '#eee', '#ccc', '#FFC107', 4, 'butt', 95);
	}
});



