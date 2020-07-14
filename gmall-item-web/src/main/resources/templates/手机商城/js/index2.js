$(".wz").hover(function(){
	$(this).children(".wz0").css("display","block")
	},function(){
	$(this).children(".wz0").css("display","none")
})

$(".wdjd").hover(function(){
	$(this).children(".wdjdy").css("display","block")
	$(this).css("background","white")
	},function(){
	$(this).children(".wdjdy").css("display","none")
	$(this).css("background","#E3E4E5")

})

$(".khfw").hover(function(){
	$(this).children(".khfwy").css("display","block")
	$(this).css("background","white")
	},function(){
	$(this).children(".khfwy").css("display","none")
	$(this).css("background","#E3E4E5")

})

$(".wzdh").hover(function(){
	$(this).children(".wzdhy").css("display","block")
	$(this).css("background","white")
	},function(){
	$(this).children(".wzdhy").css("display","none")
	$(this).css("background","#E3E4E5")

})

$(".sjjd").hover(function(){
	$(this).children(".ewmy").css("display","block")
	},function(){
	$(this).children(".ewmy").css("display","none")
})

$(".fl").hover(function(){
	$(this).children(".fly").css("display","block")
	},function(){
	$(this).children(".fly").css("display","none")
})

$(".QRcode").hover(function(){
	$(this).children(".erweima").css("display","block")},
function(){
	$(this).children(".erweima").css("display","none")
})

$(".ShoppingCart").hover(function(){
	$(this).css({"background":"white","border-bottom":"none"})
	$(this).children(".gouwuche").css({"display":"block"})},
function(){
	$(this).css({"background":"#F9F9F9","border-bottom":"1px solid #DFDFDF"})
	$(this).children(".gouwuche").css("display","none")
})

var delete1 = document.getElementById("delete1")
var headimg = document.getElementsByClassName("headImg")[0]

 delete1.onclick = function(){
	headimg.remove();
}
