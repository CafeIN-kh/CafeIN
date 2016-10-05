$(document).ready(function(){

	/* Make some random data for Flot Line Chart*/
	$.ajax({
		type:'post',
		url:'pcafe_Count.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {
			var pLikeDayCount = new Array();
			var pMenuLikeDayCount = new Array();
			var pLikeMonthCount = new Array();
			var pMenuLikeMonthCount = new Array();
			var pBookmarkDayCount = new Array();
			var pBookmarkMonthCount = new Array();
			
			

			$(data.pLikeDayCount).each(function(index,item){
				pLikeDayCount[index] = item.count;

			});
			$(data.pmenuLikeDayCount).each(function(index,item){
				pMenuLikeDayCount[index] = item.count;

			});

			$(data.pLikeMonthCount).each(function(index,item){
				pLikeMonthCount[index] = item.count;
				
			});
			$(data.pmenuLikeMonthCount).each(function(index,item){
				pMenuLikeMonthCount[index] = item.count;

			});
			
			$(data.pBookmarkDayCount).each(function(index,item){
				pBookmarkDayCount[index] = item.count;
		
			});
			
			$(data.pBookmarkMonthCount).each(function(index,item){
				pBookmarkMonthCount[index] = item.count;

			});
			
			
			for(i=0;i<7;i++){
				if(pLikeDayCount[i]==null){
					pLikeDayCount[i] =0;
				}
				if(pMenuLikeDayCount[i]==null){
					pMenuLikeDayCount[i]=0;
				}
				if(pBookmarkDayCount[i]==null){
					pBookmarkDayCount[i] = 0;
				}
			}

			for(i=0;i<12;i++){
				if(pLikeMonthCount[i] == null){
					pLikeMonthCount[i] =0;
				}
				if(pMenuLikeMonthCount[i] == null){
					pMenuLikeMonthCount[i] =0;
				}
				if(pBookmarkMonthCount[i] == null){
					pBookmarkMonthCount[i] = 0;
				}
			}

			var data1 = [[1,pLikeDayCount[0]], [2,pLikeDayCount[1]], [3,pLikeDayCount[2]], [4,pLikeDayCount[3]], [5,pLikeDayCount[4]], [6,pLikeDayCount[5]], [7,pLikeDayCount[6]]];
			var data2 = [[1,pMenuLikeDayCount[0]], [2,pMenuLikeDayCount[1]], [3,pMenuLikeDayCount[2]], [4,pMenuLikeDayCount[3]], [5,pMenuLikeDayCount[4]], [6,pMenuLikeDayCount[5]], [7,pMenuLikeDayCount[6]]];
			var data3 = [[1,pLikeMonthCount[0]], [2,pLikeMonthCount[1]], [3,pLikeMonthCount[2]], [4,pLikeMonthCount[3]], [5,pLikeMonthCount[4]], [6,pLikeMonthCount[5]], [7,pLikeMonthCount[6]], [8,pLikeMonthCount[7]], [9,pLikeMonthCount[8]], [10,pLikeMonthCount[9]], [11,pLikeMonthCount[10]], [12,pLikeMonthCount[11]]];
			var data4 = [[1,pMenuLikeMonthCount[0]], [2,pMenuLikeMonthCount[1]], [3,pMenuLikeMonthCount[2]], [4,pMenuLikeMonthCount[3]], [5,pMenuLikeMonthCount[4]], [6,pMenuLikeMonthCount[5]], [7,pMenuLikeMonthCount[6]], [8,pMenuLikeMonthCount[7]], [9,pMenuLikeMonthCount[8]], [10,pMenuLikeMonthCount[9]], [11,pMenuLikeMonthCount[10]], [12,pMenuLikeMonthCount[11]] ];
			var data5 = [[1,pBookmarkDayCount[0]], [2,pBookmarkDayCount[1]], [3,pBookmarkDayCount[2]], [4,pBookmarkDayCount[3]], [5,pBookmarkDayCount[4]], [6,pBookmarkDayCount[5]], [7,pBookmarkDayCount[6]]];
			var data6 = [[1,pBookmarkMonthCount[0]], [2,pBookmarkMonthCount[1]], [3,pBookmarkMonthCount[2]], [4,pBookmarkMonthCount[3]], [5,pBookmarkMonthCount[4]], [6,pBookmarkMonthCount[5]], [7,pBookmarkMonthCount[6]], [8,pBookmarkMonthCount[7]], [9,pBookmarkMonthCount[8]], [10,pBookmarkMonthCount[9]], [11,pBookmarkMonthCount[10]], [12,pBookmarkMonthCount[11]] ];
			//alert(data3);
			var barData = new Array();
			var barData2 = new Array();
			var barData3 = new Array();
			var barData4 = new Array();
			
			barData.push({
				data : data1,
				label: 'private',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#8BC34A'
				}
			});
			barData.push({
				data : data2,
				label: 'privateMenu',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#00BCD4'
				}
			});
			barData2.push({
				data : data3,
				label: 'private',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#8BC34A'
				}
			});
			barData2.push({
				data : data4,
				label: 'privateMenu',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#00BCD4'
				}
			});
			barData3.push({
				data : data5,
				label: 'private',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#FF9800'
				}
			});
			barData4.push({
				data : data6,
				label: 'private',
				bars : {
					show : true,
					barWidth : 0.10,
					order : 0,
					lineWidth: 0,
					fillColor: '#FF9800'
				}
			});

			
			if ($('#bar-chart')[0]) {
				$.plot($("#bar-chart"), barData, {

					grid : {
						borderWidth: 1,
						borderColor: '#eee',
						show : true,
						hoverable : true,
						clickable : true
					},

					yaxis: {
						tickColor: '#eee',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f",
						},
						shadowSize: 0
					},

					xaxis: {
						tickColor: '#fff',
						tickDecimals: 0,	
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f"
						},
						shadowSize: 0,
					},

					legend:{
						container: '.flc-bar',
						backgroundOpacity: 0.5,
						noColumns: 0,
						backgroundColor: "white",
						lineWidth: 0
					}

				});
			}
			if ($('#bar-chart2')[0]) {
				$.plot($("#bar-chart2"), barData2, {
					grid : {
						borderWidth: 1,
						borderColor: '#eee',
						show : true,
						hoverable : true,
						clickable : true
					},

					yaxis: {
						tickColor: '#eee',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f",
						},
						shadowSize: 0
					},

					xaxis: {
						tickColor: '#fff',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f"
						},
						shadowSize: 0,
					},

					legend:{
						container: '.flc-bar',
						backgroundOpacity: 0.5,
						noColumns: 0,
						backgroundColor: "white",
						lineWidth: 0
					}

				});
			}
			
			if ($('#bar-chart3')[0]) {
				$.plot($("#bar-chart3"), barData3, {
					grid : {
						borderWidth: 1,
						borderColor: '#eee',
						show : true,
						hoverable : true,
						clickable : true
					},

					yaxis: {
						tickColor: '#eee',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f",
						},
						shadowSize: 0
					},

					xaxis: {
						tickColor: '#fff',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f"
						},
						shadowSize: 0,
					},

					legend:{
						container: '.flc-bar',
						backgroundOpacity: 0.5,
						noColumns: 0,
						backgroundColor: "white",
						lineWidth: 0
					},
					legendLabel:{
						container: '.flc-bar',
						noColumns: 0,
						backgroundColor: "white",
						lineWidth: 0
					}
				});
			}
			if ($('#bar-chart4')[0]) {
				$.plot($("#bar-chart4"), barData4, {
					grid : {
						borderWidth: 1,
						borderColor: '#eee',
						show : true,
						hoverable : true,
						clickable : true
					},

					yaxis: {
						tickColor: '#eee',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f",
						},
						shadowSize: 0
					},

					xaxis: {
						tickColor: '#fff',
						tickDecimals: 0,
						font :{
							lineHeight: 13,
							style: "normal",
							color: "#9f9f9f"
						},
						shadowSize: 0,
					},

					legend:{
						container: '.flc-bar',
						backgroundOpacity: 0.5,
						noColumns: 0,
						backgroundColor: "white",
						lineWidth: 0
					}
				});
			}
			
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
				
				//$("<div class='flot-tooltip' class='chart-tooltip'></div>").appendTo("body");
			}
		},error:function() {
			alert('네트워크 오류 발생!');
		}
	});

	//var data1 = [[1,20], [2,0], [3,60], [4,40], [5,100], [6,25], [7,65]];
	//  alert(data1);
	// var data3 = [[1,100], [2,20], [3,60], [4,90], [5,80], [6,10], [7,5]];

	/* Create an Array push the data + Draw the bars*/

	/*  var barData = new Array();

    barData.push({
            data : data1,
            label: 'Tokyo',
            bars : {
                    show : true,
                    barWidth : 0.08,
                    order : 1,
                    lineWidth: 0,
                    fillColor: '#8BC34A'
            }
    });
	 */
	/*  barData.push({
            data : data2,
            label: 'Seoul',
            bars : {
                    show : true,
                    barWidth : 0.08,
                    order : 2,
                    lineWidth: 0,
                    fillColor: '#00BCD4'
            }
    });

    barData.push({
            data : data3,
            label: 'Beijing',
            bars : {
                    show : true,
                    barWidth : 0.08,
                    order : 3,
                    lineWidth: 0,
                    fillColor: '#FF9800'
            }
    });*/

	/* Let's create the chart */
	/* if ($('#bar-chart1')[0]) {
        $.plot($("#bar-chart1"), barData, {
            grid : {
                    borderWidth: 1,
                    borderColor: '#eee',
                    show : true,
                    hoverable : true,
                    clickable : true
            },

            yaxis: {
                tickColor: '#eee',
                tickDecimals: 0,
                font :{
                    lineHeight: 13,
                    style: "normal",
                    color: "#9f9f9f",
                },
                shadowSize: 0
            },

            xaxis: {
                tickColor: '#fff',
                tickDecimals: 0,
                font :{
                    lineHeight: 13,
                    style: "normal",
                    color: "#9f9f9f"
                },
                shadowSize: 0,
            },

            legend:{
                container: '.flc-bar',
                backgroundOpacity: 0.5,
                noColumns: 0,
                backgroundColor: "white",
                lineWidth: 0
            }
        });
    }*/

	/* Tooltips for Flot Charts */

	/* if ($(".flot-chart")[0]) {
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
    }*/
});