/**
 * @author caiqifan
 * @deprecated 创建用户js
 * @date 2012-6-19
 */
var pwd = {
	init : function() {
		pwd.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#UserPwdSubForm").bind("click", function() {
			$("#UserPwdForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("旧密码不能为空");
						$("#password").focus();
					} else if (t == '2') {
						alert("旧密码错误，请重新输入");
						$("#password").val("");
						$("#password").focus();
					} else if (t == '3') {
						alert("新密码不能为空");
						$("#passwordnew").val("");
						$("#passwordnew").focus();
					} else if (t == '4') {
						alert("新密码限6-16个字符，字母、数字或符号");
						$("#passwordnew").val("");
						$("#passwordnew").focus();
					} else if (t == '5') {
						alert("确认新密码不能为空");
						$("#passwordconfirm").focus();
					} else if (t == "6") {
						alert("两次密码不一致，请重新输入");
						$("#passwordconfirm").val("");
						$("#passwordconfirm").focus();
					} else if (t == "0000") {
						$("#UserPwdSubForm").attr("disabled", true);
						alert("密码修改成功");
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
			pwd.init();
		});