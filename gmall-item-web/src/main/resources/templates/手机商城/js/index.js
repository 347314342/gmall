//正好商品下button按钮hover效果
$(".shop_btn button").hover(function(){
  $(this).css("background","#333").css("color","white")
},function(){
  $(this).css("background","none").css("color","#747474")
})
var isShow = false;


$(".firstLi button").click(function(){
  isShow = !isShow

  if(isShow == true){
    $(this).children("div").show();
    $(this).siblings().children("div").hide()
    $(".firstLi_btm .ipt").hide();
  }
  else{
    $(this).children("div").hide();
    // $(this).siblings().children("div").hide()
    // $(this).siblings().children("div").hide()
    $(".firstLi_btm .ipt").show();
    isShow = false;
  }
  console.log(isShow)
})



$(".brand_content_mi_left").mouseenter(function(){

    $(this).find(".brand_content_mi_leftqie>ul").stop(true).animate({"left":"-200px"});
}).mouseleave(function(){
    $(this).find(".brand_content_mi_leftqie>ul").stop(true).animate({"left":"0px"});
})

$("#selection>ul>li").hover(function(){
    $(this).children(".ul_zhe").css("display","block");
},function(){
    $(this).children(".ul_zhe").css("display","");
})





var swiper = new Swiper(".swiper-container", {
  paginationClickable: true,
  loop:true,
  prevButton: ".swiper-button-prev",
  //					实现上一页的点击
  nextButton: ".swiper-button-next",
  //					实现下一页的点击
})


$(".isShow").hover(function(){
  $(this).find(".btns").show()
},function(){
  $(this).find(".btns").hide()
})

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




    //楼层

    $(function(){
      var winHeight = document.body.scrollTop || document.documentElement.scrollTop,
      // var winHeight = $(window).height(), //获取浏览器可是窗口的盖度

        // headerHeight = $(".head").height(),  //获取header的高度

        onOff = false;    //布尔值变量,通错这个变量可以防止快速连续点击的时候出现的连续滚动

      $(window).on("scroll",function(){

        var scTop = $(window).scrollTop();  //获取滚动条的滚动距离

        //当楼侧开始出现时显示楼层导航条

        if(scTop >= 100){

          $("#nav").show(400);   //也可以不传参数，传参数表示运动时间

        }else{

          $("#nav").hide(400);

        }



        //滚动时切换显示楼层

        if(!onOff){

          $(".floor").each(function(index,element){

            var _top = $(this).offset().top;

            //当每层楼的最上面滚动到浏览器窗口的中间时切换导航条的显示

            if(scTop >= _top - winHeight / 2){

              //此处添加curr类样式并不是改变显示样式，而是为了标当前所在的楼层

              $("#nav>li").eq(index).addClass("curr").children().show()

              .end().siblings().removeClass("curr").children().hide();

            }

          });

        }

      })



      $("#nav>li").hover(function(){

        $(this).children().show();

      },function(){

        //此处用到.not(‘.curr‘)来过滤当前楼层，鼠标移开时仍然保持当前的显示样式

        $(this).not(".curr").children().hide();

      }).on("click",function(){

        onOff = true;  //将开关变量onOff置为true

        var index = $(this).index(),  //获取当前电机的li的索引

          _top = $(".floor").eq(index).offset().top;//获取相对于的楼层到文档顶部的距离

        $(this).addClass("curr").children().show().end()

        .siblings().removeClass("curr").children().hide();



        $("html,body").animate({"scrollTop":_top},400,function(){

          onOff = false; //在运动执行完毕的毁掉函数中将onOff的值重置为false

        });


        //或者也可以用scrollIntoView()方法，只是该方法没有滚动的效果，而是直接跳到浏览器可是窗口的最上面.用法如下：

        /*var index = $(this).index();

        $(‘.floor‘).get(index).scrollIntoView();*/

      });

    });



  //   clc:function(rr){
  //
	// 		//滚动页面，显示侧边栏
	// 		$(window).scroll(function(){
  //
	// 			//滚动条高度
	// 			var scrollTop=$(window).scrollTop();
	// 			//判断条件
	// 			scrollTop>1000? $(".abisList").show() :$(".abisList").hide() ;
  //
  //
	// 			$(rr).each(function(index){
	// 				var t=$(this).offset().top-$(window).scrollTop();
  //
  //
	// 				if (t<400) {
	// 					$(".abisList li").removeClass("ac").eq(index).addClass("ac");
	// 				}
  //
	// 			});
  //
	// 		});
  //
  //
	// 		$(".abisList li").click(function(){
  //
  //
  //
	// 			var index=$(this).index();
  //
	// 			var s_top=$(rr).eq(index).offset().top;
  //
	// 			$("body,html").animate({"scrollTop":s_top},500)
  //
  //
	// 		})
  //
  //
	// },
  //


$(".btnTop").click(function(){
  document.body.scrollTop = 0;
})
$(document).bind("scroll",function(){
  var oTop = document.body.scrollTop || document.documentElement.scrollTop;
  // var oScreen=window.screen.width
  if(oTop>110){
    $(".btnTop").stop(true).show(50)
  }else{
    $(".btnTop").stop(true).hide(50)
  }
})
