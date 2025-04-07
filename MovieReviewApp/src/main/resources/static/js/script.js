$(function(){
	// ページ全体1秒かけてフェードイン
	$(document).ready(function () {
	  $("body").fadeIn(750);
	});
	
	//* 画像のフェードアップ
	$(window).on('load',function(){
	
    $(window).scroll(function (){
        $('.fade-up').each(function(){
            var POS = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();

            if (scroll > POS - windowHeight){
                $(this).css({
                        'opacity':'1',
                        'transform':'translateY(0)',
                        '-webkit-transform':'translateY(0)',
                        '-moz-transform':'translateY(0)',
                        '-ms-transform':'translateY(0)'
                });
            } else {
                $(this).css({
                        'opacity':'0',
                        'transform':'translateY(70px)',
                        '-webkit-transform':'translateY(70px)',
                        '-moz-transform':'translateY(70px)',
                        '-ms-transform':'translateY(70px)'
						});
					}
				});
			});
		});

	//* トップへ戻る
	$(document).ready(function () {
	    var $button = $("#scrollTopBtn");

	    // スクロール位置を監視してボタンを表示・非表示
	    $(window).scroll(function () {
	        if ($(this).scrollTop() > 500) {
	            $button.fadeIn();
	        } else {
	            $button.fadeOut();
	        }
	    });

	    // スムーズにスクロールして最上部へ移動
	    $button.click(function () {
	        $("html, body").animate({ scrollTop: 0 }, 500); // 500ms かけてスクロール
	    });
	});
	
	
});