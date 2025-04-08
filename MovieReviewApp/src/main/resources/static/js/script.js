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
	
	// ソートフォーム送信時にスクロール位置をURLに追加
	    $(document).ready(function() {
	        $('form').submit(function(event) {
	            var scrollPosition = $(window).scrollTop(); // 現在のスクロール位置を取得
	            var sortValue = $('#sort').val(); // 現在選ばれているソート値を取得
	            var currentUrl = window.location.href.split('?')[0]; // 現在のURLからクエリを削除
	            
	            if (scrollPosition > 0 || sortValue) {
	                // URLにスクロール位置とソート情報を追加
	                window.location.href = currentUrl + '?scroll=' + scrollPosition + '&sort=' + sortValue;
	            } else {
	                // 通常のフォーム送信
	                this.submit();
	            }
	        });

	        // ページが読み込まれたときにスクロール位置を復元
	        var scrollPosition = new URLSearchParams(window.location.search).get('scroll');
	        if (scrollPosition) {
	            $(window).scrollTop(scrollPosition); // スクロール位置を復元
	        }
	    });
	
	
});