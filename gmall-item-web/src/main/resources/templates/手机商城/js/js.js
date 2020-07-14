//		关注频道
		$(".banner_nav_right .xin a").hover(function() {
			$(this).children("img").attr("src", "img/xin1_03.png")
		}, function() {
			$(this).children("img").attr("src", "img/xin_03.png")
		})
		//					菜单
		$(".banner_meau_item").hover(function() {
			$(this).children(".list_meau").show()
		}, function() {
			$(this).children(".list_meau").hide()
		})

		//轮播
		var timer = setInterval(change, 2000)
		var i = 0;

		function change() {
			i++;
			if(i == 7) {
				i = 0
			}
			same()
		}
		//当鼠标移入的时候停止
		$("#box").mouseover(function() {
			clearInterval(timer)
			$("#left").show()
			$("#right").show()
		}).mouseout(function() {
			timer = setInterval(change, 2000)
			$("#left").hide()
			$("#right").hide()
		})
		//点击前一个
		$("#left").click(function() {
			i--
			if(i == -1) {
				i = 6
			}
			same()
		})
		//点击下一个
		$("#right").click(function() {
			i++
			if(i == 7) {
				i = 0
			}
			same()
		})

		function same() {　
			$("#box ul li").eq(i).fadeIn(800)
			$("#box ul li").eq(i).siblings().fadeOut(800)
			$("#box ol li").eq(i).children("a").stop(true).animate({
				top: "0"
			}, 300)
			$("#box ol li").eq(i).siblings().children("a").stop(true).animate({
				top: "90%"
			}, 300)

		}

		$("#box ol li").mouseover(function() {
			i = $(this).index();
			same()
		})

		//		新品尚

		$(".p-item").mouseenter(function() {
			var i = $(this).index()
			$(".p-item").removeClass("current").eq(i).addClass("current")
		})

		$(".banner_meau_item").mouseover(function() {

			$(this).css("border-bottom", "none").css("border-bottom", "1px solid #e0e0e0")
			$(this).css("border-right", "none")
			$(this).css("border-top", "1px solid #e0e0e0")
			$(this).siblings().css("border-right", "1px solid #e0e0e0")
			$(this).siblings().css("border-bottom", "none")
		})