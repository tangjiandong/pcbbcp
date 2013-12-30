/**
 * @author caiqifan
 * @deprecated 编辑用户js
 * @date 2012-6-19
 */
var edit = {
	init : function() {
		edit.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#UserEditSubForm").bind("click", function() {
			$("#UserEditForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("真实姓名不能为空");
						$("#realname").focus();
					} else if (t == "0000") {
						$("#UserEditSubForm").attr("disabled", true);
						alert("编辑用户成功");
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
			edit.init();
		});