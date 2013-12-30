var create = {
	init : function() {
		create.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#createChannel").bind("click", function() {
			$("#channelCreateForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("渠道名称不能为空");
						$("#chlname").focus();
					} else if (t == '2') {
						alert("企业名称不能为空");
						$("#chlcomname").focus();
					} else if (t == '3') {
						alert("联系人电话不能为空");
						$("#chltel").focus();
					} else if (t == '4') {
						alert("移动电话不能为空");
						$("#chlmobile").focus();
					} else if (t == '5') {
						alert("邮箱地址不能为空");
						$("#chlemail").focus();
					} else if (t == '6') {
						alert("收费金额不能为空");
						$("#chlamount").focus();
					} else if (t == "0000") {
						location.href = "channel!getChannelList.do?nav="
								+ $("#nav").val();
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
