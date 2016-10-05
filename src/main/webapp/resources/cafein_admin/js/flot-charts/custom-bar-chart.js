$(document).ready(function(){

	/* Make some random data for Flot Line Chart*/
	$.ajax({
		type:'post',
		url:'custom_Count.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {
			var cLikeDayCount = new Array();
			var cLikeMonthCount = new Array();
			var cBookmarkDayCount = new Array();
			var cBookmarkMonthCount = new Array();
			
			$(data.cLikeDayCount).each(function(index,item){
				cLikeDayCount[index] = item.count;

			});
			$(data.cLikeMonthCount).each(function(index,item){
				cLikeMonthCount[index] = item.count;
			});
			$(data.cBookmarkDayCount).each(function(index,item){
				cBookmarkDayCount[index] = item.count;
			});
			
			$(data.cBookmarkMonthCount).each(function(index,item){
				cBookmarkMonthCount[index] = item.count;

			});
			
			
			for(i=0;i<7;i++){
				if(cLikeDayCount[i]==null){
					cLikeDayCount[i] =0;
				}
				if(cBookmarkDayCount[i]==null){
					cBookmarkDayCount[i]=0;
				}
			}

			for(i=0;i<12;i++){
				if(cLikeMonthCount[i] == null){
					cLikeMonthCount[i] =0;
				}
				if(cBookmarkMonthCount[i] == null){
					cBookmarkMonthCount[i] =0;
				}
			}

			var data1 = [[1,cLikeDayCount[0]], [2,cLikeDayCount[1]], [3,cLikeDayCount[2]], [4,cLikeDayCount[3]], [5,cLikeDayCount[4]], [6,cLikeDayCount[5]], [7,cLikeDayCount[6]]];
			var data3 = [[1,cLikeMonthCount[0]], [2,cLikeMonthCount[1]], [3,cLikeMonthCount[2]], [4,cLikeMonthCount[3]], [5,cLikeMonthCount[4]], [6,cLikeMonthCount[5]], [7,cLikeMonthCount[6]], [8,cLikeMonthCount[7]], [9,cLikeMonthCount[8]], [10,cLikeMonthCount[9]], [11,cLikeMonthCount[10]], [12,cLikeMonthCount[11]]];
			var data5 = [[1,cBookmarkDayCount[0]], [2,cBookmarkDayCount[1]], [3,cBookmarkDayCount[2]], [4,cBookmarkDayCount[3]], [5,cBookmarkDayCount[4]], [6,cBookmarkDayCount[5]], [7,cBookmarkDayCount[6]]];
			var data6 = [[1,cBookmarkMonthCount[0]], [2,cBookmarkMonthCount[1]], [3,cBookmarkMonthCount[2]], [4,cBookmarkMonthCount[3]], [5,cBookmarkMonthCount[4]], [6,cBookmarkMonthCount[5]], [7,cBookmarkMonthCount[6]], [8,cBookmarkMonthCount[7]], [9,cBookmarkMonthCount[8]], [10,cBookmarkMonthCount[9]], [11,cBookmarkMonthCount[10]], [12,cBookmarkMonthCount[11]] ];
			//alert(data6);
			var barData = new Array();
			var barData2 = new Array();
			var barData3 = new Array();
			var barData4 = new Array();
			
			barData.push({
				data : data1,
				label: 'Customizing',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#8BC34A'
				}
			});
			barData2.push({
				data : data3,
				label: 'Customizing',
				bars : {
					show : true,
					barWidth : 0.08,
					order : 0,
					lineWidth: 0,
					fillColor: '#8BC34A'
				}
			});
			barData3.push({
				data : data5,
				label: 'Customizing',
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
				label: 'Customizing',
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