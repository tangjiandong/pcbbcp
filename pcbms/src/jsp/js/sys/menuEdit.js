/**
 * @author caiqifan
 * @deprecated 编辑菜单js
 * @date 2012-6-19
 */
var edit = {
	init : function() {
		edit.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#MenuEditSubForm").bind("click", function() {
			$("#MenuEditForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("菜单名称不能为空");
						$("#mname").focus();
					} else if (t == '4') {
						alert("菜单名称已存在，请重新输入");
						$("#mname").val("");
						$("#mname").focus();
					} else if (t == '2') {
						alert("菜单描述不能为空");
						$("#mdesc").focus();
					} else if (t == '3') {
						alert("排序号不能为空");
						$("#msort").focus();
					} else if (t == "0000") {
						$("#MenuEditSubForm").attr("disabled", true);
						alert("编辑菜单成功");
					} else if (t == "1111") {
						alert("网络异常，请稍候重试");
					}
				},
				error : function() {
					alert("网络异常，请稍候重试");
				}
			});
		});
	},
	changeNum : function() {
		var patt = /^[0-9]+$/;
		if (!patt.exec(document.getElementById("msort").value)) {
			document.getElementById("msort").value = document
					.getElementById("msort").value.replace(/[^0-9]/, "");
		}
	}
};

$(document).ready(function() {
			edit.init();
		});