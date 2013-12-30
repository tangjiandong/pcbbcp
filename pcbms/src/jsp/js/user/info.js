/**
 * @author caiqifan
 * @deprecated 个人资料修改js
 * @date 2012-6-19
 */
var info = {
	init : function() {
		info.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#UserInfoSubForm").bind("click", function() {
			$("#UserInfoForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("真实姓名不能为空");
						$("#realname").focus();
					} else if (t == "0000") {
						$("#UserInfoSubForm").attr("disabled", true);
						alert("个人资料修改成功");
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
			info.init();
		});