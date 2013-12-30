/**
 * @author caiqifan
 * @deprecated 分配菜单js
 * @date 2012-6-19
 */
var menu = {
	init : function() {
		menu.submit();
		menu.isCheckALL();
	},
	/** 提交表单 */
	submit : function() {
		$("#RoleMenuSubForm").bind("click", function() {
			var c = menu.check();
			if (c == "") {
				menu.fuzhi();
				$("#RoleMenuForm").ajaxSubmit({
					dataType : "text",
					success : function(t) {
						t = t.toLowerCase().substring(t.indexOf(">") + 1)
								.replace("</pre>", "");
						if (t == "0000") {
							$("#RoleMenuSubForm").attr("disabled", true);
							alert("分配菜单成功");
						} else if (t == "1111") {
							alert("网络异常，请稍候重试");
						}
					},
					error : function() {
						alert("网络异常，请稍候重试");
					}
				});
			} else {
				alert(c);
			}
		});
	},
	/** 校验 */
	check : function() {
		var r = "";
		var count = 0;
		$("div[class='list_form']").find("input[name='menuIds']").each(
				function() {
					if ($(this).attr("checked")) {
						count++;
					}
				});
		if (count <= 0) {
			r = "请选择菜单";
			return r;
		}
		return r;
	},
	/** 赋值 */
	fuzhi : function() {
		var ids = "";
		$("div[class='list_form']").find("input[name='menuIds']").each(
				function() {
					if ($(this).attr("checked")) {
						ids += $(this).attr("value") + ",";
					}
				});
		if (null != ids && ids != "") {
			ids = ids.substring(0, ids.length - 1);
			$("#ids").val(ids);
		}
	},
	/** 一级菜单选择 */
	level1All : function(obj) {
		var menuIds = $("div[class='list_form']").find("input[mpid='"
				+ $(obj).attr("value") + "']");
		if ($(obj).attr("checked")) {
			menuIds.each(function() {
						$(this).attr("checked", true);
					});
		} else {
			menuIds.each(function() {
						$(this).attr("checked", false);
					});
		}
		menu.isCheckALL();
	},
	/** 二级菜单选择 */
	level2All : function(obj) {
		var mpid = $(obj).attr("mpid");
		var count = 0;
		var menuIds = $("div[class='list_form']");
		if ($(obj).attr("checked")) {
			menuIds.find("input[value='" + mpid + "']").attr("checked", true);
		} else {
			menuIds.find("input[mpid='" + mpid + "']").each(function() {
						if ($(this).attr("checked")) {
							count++;
						}
					});
			if (count == 0) {
				menuIds.find("input[value='" + mpid + "']").attr("checked",
						false);
			}
		}
		menu.isCheckALL();
	},
	/** 是否选中“全选” */
	isCheckALL : function() {
		var count = 0;
		var menuIds = $("div[class='list_form']").find("input[name='menuIds']");
		menuIds.each(function() {
					if ($(this).attr("checked")) {
						count++;
					}
				});
		if (count == menuIds.size()) {
			$("#selectAll").attr("checked", true);
		} else {
			$("#selectAll").attr("checked", false);
		}
	},
	/** 全选 */
	selectAll : function(obj) {
		var menuIds = $("div[class='list_form']").find("input[name='menuIds']");
		if ($(obj).attr("checked")) {
			menuIds.each(function() {
						$(this).attr("checked", true);
					});
		} else {
			menuIds.each(function() {
						$(this).attr("checked", false);
					});
		}
	}
};

$(document).ready(function() {
			menu.init();
		});