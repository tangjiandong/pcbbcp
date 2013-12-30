/**
 * @author caiqifan
 * @deprecated 用户列表js
 * @date 2012-6-19
 */
var search = {
	init : function() {

	},
	/** 提交表单 */
	resetPwd : function(userid) {
		$.ajax({
					url : "user!resetPwd.do?userInfo.userid=" + userid + "&d="
							+ new Date().getTime(),
					dataType : "html",
					success : function(t) {
						if (t == "0000") {
							alert("重置密码成功");
						} else {
							alert("网络异常，请稍候重试");
						}
					}
				});
	}
};

$(document).ready(function() {
			search.init();
		});