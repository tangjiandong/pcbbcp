/**
 * @author caiqifan
 * @deprecated 创建用户js
 * @date 2012-6-19
 */
var create = {
	init : function() {
		create.submit();
		$("#username").focus();
	},
	/** 提交表单 */
	submit : function() {
		$("#UserCreateSubForm").bind("click", function() {
			$("#UserCreateForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("用户不能为空");
						$("#username").focus();
					} else if (t == '4') {
						alert("用户已存在，请重新输入");
						$("#username").val("");
						$("#username").focus();
					} else if (t == '2') {
						alert("真实姓名不能为空");
						$("#realname").focus();
					} else if (t == '3') {
						alert("密码不能为空");
						$("#password").focus();
					} else if (t == "0000") {
						$("#UserCreateSubForm").attr("disabled", true);
						alert("创建用户成功");
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