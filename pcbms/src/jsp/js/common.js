// JavaScript Document
$(document).ready(function() {
    var H = $(document).height();
	$(".content").height(H-110);
	$(".contentright").width($(".content").width()-180)
	
	$(window).resize(function(){
		var H = $(document).height();
		$(".content").height(H-110);
		$(".contentright").width($(".content").width()-180)
	})
	
	$(".sidebar h3").click(function(){
		$(".sidebar ul").slideUp();
		if($(this).next("ul").is(":hidden")){
			$(this).next("ul").slideDown();
		}
	})
	
	$(".p_re a").hover(function(){
		$(this).next(".show_box").show();
	},function(){
		$(this).next(".show_box").hide();
	});
	$(".show_box").hover(function(){
		$(this).show();
	},function(){
		$(this).hide();
	});
});