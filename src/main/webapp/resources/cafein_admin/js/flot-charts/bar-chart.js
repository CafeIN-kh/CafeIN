$(document).ready(function(){

	/* Make some random data for Flot Line Chart*/
	$.ajax({
		type:'post',
		url:'franchise_pageCount.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data) {
			var fLikeDayCount = new Array();
			var fMenuLikeDayCount = new Array();
			var fLikeWeekCount = new Array();
			var fMenuLikeWeekCount = new Array();
			var fBookmarkDayCount = new Array();
			var fBookmarkWeekCount = new Array();
			var fBookmarkDayRegDate = new Array();
			var test = new Array();

			$(data.fLikeDayCount).each(function(index,item){
				fLikeDayCount[index] = item.count;

			});
			$(data.fmenuLikeDayCount).each(function(index,item){
				fMenuLikeDayCount[index] = item.count;

			});

			$(data.fLikeWeekCount).each(function(index,item){
				fLikeWeekCount[index] = item.count;
				console.log(fLikeWeekCount[index]);
			});
			$(data.fmenuLikeWeekCount).each(function(index,item){
				fMenuLikeWeekCount[index] = item.count;

			});
			
			$(data.fbookmarkDayCount).each(function(index,item){
				fBookmarkDayCount[index] = item.count;
				fBookmarkDayRegDate[index] = item.bookmark_reg_date;
			});
			
			$(data.fbookmarkWeekCount).each(function(index,item){
				fBookmarkWeekCount[index] = item.count;

			});
			
			
			for(i=0;i<7;i++){
				if(fLikeDayCount[i]==null){
					fLikeDayCount[i] =0;
				}
				if(fMenuLikeDayCount[i]==null){
					fMenuLikeDayCount[i]=0;
				}
				if(fBookmarkDayCount[i]==null){
					fBookmarkDayCount[i] = 0;
				}
			}

			for(i=0;i<12;i++){
				if(fLikeWeekCount[i] == null){
					fLikeWeekCount[i] =0;
				}
				if(fMenuLikeWeekCount[i] == null){
					fMenuLikeWeekCount[i] =0;
				}
				if(fBookmarkWeekCount[i] == null){
					fBookmarkWeekCount[i] = 0;
				}
			}

			var data1 = [[1,fLikeDayCount[0]], [2,fLikeDayCount[1]], [3,fLikeDayCount[2]], [4,fLikeDayCount[3]], [5,fLikeDayCount[4]], [6,fLikeDayCount[5]], [7,fLikeDayCount[6]]];
			var data2 = [[1,fMenuLikeDayCount[0]], [2,fMenuLikeDayCount[1]], [3,fMenuLikeDayCount[2]], [4,fMenuLikeDayCount[3]], [5,fMenuLikeDayCount[4]], [6,fMenuLikeDayCount[5]], [7,fMenuLikeDayCount[6]]];
			var data3 = [[1,fLikeWeekCount[0]], [2,fLikeWeekCount[1]], [3,fLikeWeekCount[2]], [4,fLikeWeekCount[3]], [5,fLikeWeekCount[4]], [6,fLikeWeekCount[5]], [7,fLikeWeekCount[6]], [8,fLikeWeekCount[7]], [9,fLikeWeekCount[8]], [10,fLikeWeekCount[9]], [11,fLikeWeekCount[10]], [12,fLikeWeekCount[11]]];
			var data4 = [[1,fMenuLikeWeekCount[0]], [2,fMenuLikeWeekCount[1]], [3,fMenuLikeWeekCount[2]], [4,fMenuLikeWeekCount[3]], [5,fMenuLikeWeekCount[4]], [6,fMenuLikeWeekCount[5]], [7,fMenuLikeWeekCount[6]], [8,fMenuLikeWeekCount[7]], [9,fMenuLikeWeekCount[8]], [10,fMenuLikeWeekCount[9]], [11,fMenuLikeWeekCount[10]], [12,fMenuLikeWeekCount[11]] ];
			var data5 = [[1,fBookmarkDayCount[0]], [2,fBookmarkDayCount[1]], [3,fBookmarkDayCount[2]], [4,fBookmarkDayCount[3]], [5,fBookmarkDayCount[4]], [6,fBookmarkDayCount[5]], [7,fBookmarkDayCount[6]]];
			var data6 = [[1,fBookmarkWeekCount[0]], [2,fBookmarkWeekCount[1]], [3,fBookmarkWeekCount[2]], [4,fBookmarkWeekCount[3]], [5,fBookmarkWeekCount[4]], [6,fBookmarkWeekCount[5]], [7,fBookmarkWeekCount[6]], [8,fBookmarkWeekCount[7]], [9,fBookmarkWeekCount[8]], [10,fBookmarkWeekCount[9]], [11,fBookmarkWeekCount[10]], [12,fBookmarkWeekCount[11]] ];
			//alert(data6);
			var barData = new Array();
			var barData2 = new Array();
			var barData3 = new Array();
			var barData4 = new Array();
			
			barData.push({
				data : data1,
				label: 'Franchise',
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
				label: 'FranchiseMenu',
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
				label: 'Franchise',
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
				label: 'FranchiseMenu',
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
				label: 'Franchise',
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
				label: 'Franchise',
				bars : {
					show : true,
					barWidth : 0.10,
					order : 0,
					lineWidth: 0,
					fillColor: '#FF9800'
				}
			});
			$(barData4.label).each(function(index,item){
				test[index] = item.label.data;
				alert(test[index]);
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