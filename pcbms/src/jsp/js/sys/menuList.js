/**
 * @author caiqifan
 * @deprecated 菜单js
 * @date 2012-6-19
 */
var menuList = {
	init : function() {

	},
	/** 展开下级分类 */
	open : function(obj) {
		var mid = $(obj).attr("mid"); // 分类编号
		var mname = $(obj).attr("mname"); // 分类名称
		// 判断是否已展开了子级
		var tr = $(".box").find("tr[pid='" + mid + "']");
		if (tr.size() > 0) {
			$(obj).html("<img src=\"../../images/on.gif\">" + mname + "</a>");
			tr.each(function() {
						$(this).remove();
					});
		} else {
			$.ajax({
						url : "menu!listAjax.do?nav=" + $("#nav").val()
								+ "&pid=" + mid + "&d=" + new Date().getTime(),
						dataType : "html",
						success : function(t) {
							if (null != t && t != "") {
								$(obj)
										.html("<img src=\"../../images/off.gif\">"
												+ mname + "</a>");
								$(obj).parent().parent().after(t);
							}
						}
					});
		}
	}
};

$(document).ready(function() {
			menuList.init();
		});