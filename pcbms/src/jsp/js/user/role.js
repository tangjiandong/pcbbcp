/**
 * @author caiqifan
 * @deprecated 分配角色js
 * @date 2012-6-19
 */
var role = {
	init : function() {
		role.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#UserRoleSubForm").bind("click", function() {
			var c = role.check();
			if (c == "") {
				role.fuzhi();
				$("#UserRoleForm").ajaxSubmit({
					dataType : "text",
					success : function(t) {
						t = t.toLowerCase().substring(t.indexOf(">") + 1)
								.replace("</pre>", "");
						if (t == "0000") {
							$("#UserRoleSubForm").attr("disabled", true);
							alert("分配角色成功");
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
		$("div[class='list_form']").find("input[name='roleIds']").each(
				function() {
					if ($(this).attr("checked")) {
						count++;
					}
				});
		if (count <= 0) {
			r = "请选择角色";
			return r;
		}
		return r;
	},
	/** 赋值 */
	fuzhi : function() {
		var ids = "";
		$("div[class='list_form']").find("input[name='roleIds']").each(
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
	/** 角色选择 */
	selectRole : function() {
		var count = 0;
		var roleIds = $("div[class='list_form']").find("input[name='roleIds']");
		roleIds.each(function() {
					if ($(this).attr("checked")) {
						count++;
					}
				});
		if (count == roleIds.size()) {
			$("#selectAll").attr("checked", true);
		} else {
			$("#selectAll").attr("checked", false);
		}
	},
	/** 全选 */
	selectAll : function(obj) {
		var roleIds = $("div[class='list_form']").find("input[name='roleIds']");
		if ($(obj).attr("checked")) {
			roleIds.each(function() {
						$(this).attr("checked", true);
					});
		} else {
			roleIds.each(function() {
						$(this).attr("checked", false);
					});
		}
	}
};

$(document).ready(function() {
			role.init();
		});