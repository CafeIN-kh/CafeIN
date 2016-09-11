(function($, window, document, undefined) {
    'use strict';

    var gridContainer = $('#grid-container'),
        filtersContainer = $('#filters-container'),
        wrap, filtersCallback;


    /*******************************
        init cubeportfolio
     ****************************** */
    gridContainer.cubeportfolio({
        layoutMode: 'grid',
        rewindNav: true,
        scrollByPage: false,
        mediaQueries: [{
            width: 1100,
            cols: 3
        }, {
            width: 800,
            cols: 3
        }, {
            width: 500,
            cols: 2
        }, {
            width: 320,
            cols: 1
        }],
        defaultFilter: '*',
        animationType: 'rotateSides',
        gapHorizontal: 10,
        gapVertical: 10,
        gridAdjustment: 'responsive',
        caption: 'overlayBottomPush',
        displayType: 'sequentially',
        displayTypeSpeed: 100,

        // lightbox
        lightboxDelegate: '.cbp-lightbox',
        lightboxGallery: true,
        lightboxTitleSrc: 'data-title',

        // singlePage popup
        singlePageDelegate: '.cbp-singlePage',
        singlePageDeeplinking: true,
        singlePageStickyNavigation: true,
        singlePageCallback: function(url, element) {
            // to update singlePage content use the following method: this.updateSinglePage(yourContent)
        },

        // singlePageInline
        singlePageInlineDelegate: '.cbp-singlePageInline',
        singlePageInlinePosition: 'below',
        singlePageInlineInFocus: true,
        singlePageInlineCallback: function(url, element) {
            // to update singlePageInline content use the following method: this.updateSinglePageInline(yourContent)
            var t = this;

            $.ajax({
                    url: url,
                    /*type: 'GET',
                    dataType: 'html',*/
                    type: 'POST',
                    dataType: 'json',
                    timeout: 5000
                })
                .done(function(result) {
                	var PcafeMenuSuccess = result.PcafeMenuSuccess;
                	
                	if(PcafeMenuSuccess == "PcafeMenuSuccess") {
                		t.updateSinglePageInline(attach_PCafeMenuDetail(result));
                	}else {
                		/*원본 소스*/
                		t.updateSinglePageInline(result);
                	}
                	
                	/*원본 소스*/
                    /*t.updateSinglePageInline(result);*/

                })
                .fail(function() {
                    t.updateSinglePageInline("Error! Please refresh the page!");
                });
        }
    });
    
    function attach_PCafeMenuDetail(result) {
    	//menuLikeCount=0이면 로그인 안한 상태거나 좋아요를 누르지 않은 것임
    	//좋아요,취소하기 상태변화는 private_detail.js에서 에이작스로 처리
    	if(result.menuLikeCount == 0){
	    	$('.cbp-popup-content').html(
	    			'<input type="hidden" id="pmenu_num" value=" ' + result.pcafeMenuCommand.pmenu_num + ' ">' +
	    			'<div class="cbp-l-inline" style="margin-bottom:0;padding-right:60px;">' +
	    		    '<div class="cbp-l-inline-left">' +
	    		        '<img src="/CafeIN/upload/private_menu/' + result.pcafeMenuCommand.pmenu_img + '" alt="Dashboard" class="cbp-l-project-img">' +
	    		    '</div>' +
	
	    		    '<div class="cbp-l-inline-right">' +
	    		    	'<div class="pull-left">' +
	    		        	'<div class="cbp-l-inline-title korean-font">' + result.pcafeMenuCommand.pmenu_name + ' | ' + result.pcafeMenuCommand.pmenu_price + '원</div>' +
	    		        '</div>' +
	    		        '<ul class="list-unstyled list-inline pull-left" style="margin:5px 0 0 10px;">' +
	    		   			'<li id="menuLike_count" style="font-size:15px;"><i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + result.totalMenuLikeCount + '</li>' +
	    		   		'</ul>' +
	    		    '</div>' +
	    		    '<div class="cbp-l-inline-right" style="padding-left: 40px;">' +
				   		'<p class="cbp-l-inline-desc korean-font">' + result.pcafeMenuCommand.pmenu_introduce + '</p>' +
				        '<a onclick="pcafeMenu_like();" id="pcafeMenu_like" class="cbp-l-inline-view btn-u btn-u-large korean-font" style="text-decoration:none;color:#ffffff;cursor:pointer;">' +
							'<i class="fa fa-thumbs-o-up"></i> 좋아요!' +
						'</a>' +
					'</div>' +
	    		'</div>'
	    	);
    	}else {
    		$('.cbp-popup-content').html(
    				'<input type="hidden" id="pmenu_num" value=" ' + result.pcafeMenuCommand.pmenu_num + ' ">' +
	    			'<div class="cbp-l-inline" style="margin-bottom:0;padding-right:60px;">' +
	    		    '<div class="cbp-l-inline-left">' +
	    		        '<img src="/CafeIN/upload/private_menu/' + result.pcafeMenuCommand.pmenu_img + '" alt="Dashboard" class="cbp-l-project-img">' +
	    		    '</div>' +
	
	    		    '<div class="cbp-l-inline-right">' +
	    		    	'<div class="pull-left">' +
	    		        	'<div class="cbp-l-inline-title korean-font">' + result.pcafeMenuCommand.pmenu_name + ' | ' + result.pcafeMenuCommand.pmenu_price + '원</div>' +
	    		        '</div>' +
	    		        '<ul class="list-unstyled list-inline pull-left" style="margin:5px 0 0 10px;">' +
	    		   			'<li id="menuLike_count" style="font-size:15px;"><i class="fa fa-heart color-green" style="font-size:15px;"></i> ' + result.totalMenuLikeCount + '</li>' +
	    		   		'</ul>' +
	    		    '</div>' +
	    		    '<div class="cbp-l-inline-right" style="padding-left: 40px;">' +
				   		'<p class="cbp-l-inline-desc korean-font">' + result.pcafeMenuCommand.pmenu_introduce + '</p>' +
				        '<a onclick="pcafeMenu_like();" id="pcafeMenu_like" class="cbp-l-inline-view btn-u btn-u-large korean-font" style="text-decoration:none;color:#ffffff;cursor:pointer;">' +
							'<i class="fa fa-thumbs-o-up"></i> 취소하기' +
						'</a>' +
					'</div>' +
	    		'</div>'
	    	);
    	}
    }


    /*********************************
        add listener for filters
     *********************************/
    if (filtersContainer.hasClass('cbp-l-filters-dropdown')) {
        wrap = filtersContainer.find('.cbp-l-filters-dropdownWrap');

        wrap.on({
            'mouseover.cbp': function() {
                wrap.addClass('cbp-l-filters-dropdownWrap-open');
            },
            'mouseleave.cbp': function() {
                wrap.removeClass('cbp-l-filters-dropdownWrap-open');
            }
        });

        filtersCallback = function(me) {
            wrap.find('.cbp-filter-item').removeClass('cbp-filter-item-active');
            wrap.find('.cbp-l-filters-dropdownHeader').text(me.text());
            me.addClass('cbp-filter-item-active');
            wrap.trigger('mouseleave.cbp');
        };
    } else {
        filtersCallback = function(me) {
            me.addClass('cbp-filter-item-active').siblings().removeClass('cbp-filter-item-active');
        };
    }

    filtersContainer.on('click.cbp', '.cbp-filter-item', function() {
        var me = $(this);

        if (me.hasClass('cbp-filter-item-active')) {
            return;
        }

        // get cubeportfolio data and check if is still animating (reposition) the items.
        if (!$.data(gridContainer[0], 'cubeportfolio').isAnimating) {
            filtersCallback.call(null, me);
        }

        // filter the items
        gridContainer.cubeportfolio('filter', me.data('filter'), function() {});
    });


    /*********************************
        activate counter for filters
     *********************************/
    gridContainer.cubeportfolio('showCounter', filtersContainer.find('.cbp-filter-item'), function() {
        // read from url and change filter active
        var match = /#cbpf=(.*?)([#|?&]|$)/gi.exec(location.href),
            item;
        if (match !== null) {
            item = filtersContainer.find('.cbp-filter-item').filter('[data-filter="' + match[1] + '"]');
            if (item.length) {
                filtersCallback.call(null, item);
            }
        }
    });

})(jQuery, window, document);
