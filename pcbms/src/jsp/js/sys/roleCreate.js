/**
 * @author caiqifan
 * @deprecated 创建角色js
 * @date 2012-6-19
 */
var create = {
	init : function() {
		create.submit();
		$("#rolename").focus();
	},
	/** 提交表单 */
	submit : function() {
		$("#RoleCreateSubForm").bind("click", function() {
			$("#RoleCreateForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("角色名称不能为空");
						$("#rolename").focus();
					} else if (t == '3') {
						alert("角色名称已存在，请重新输入");
						$("#rolename").val("");
						$("#rolename").focus();
					} else if (t == '2') {
						alert("角色描述不能为空");
						$("#roledesc").focus();
					} else if (t == "0000") {
						$("#RoleCreateSubForm").attr("disabled", true);
						alert("创建角色成功");
					} else if (t == "1111") {
						alert("网络异常，请稍候重试");
					}
				},
				error : function() {
					alert("网络异常，请稍候重试");
				}
			});
		});
	}
};

$(document).ready(function() {
			create.init();
		});