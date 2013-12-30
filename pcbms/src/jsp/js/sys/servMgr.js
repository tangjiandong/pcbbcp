/**
 * @author caiqifan
 * @deprecated 创建菜单js
 * @date 2012-6-19
 */
var create = {
	init : function() {
		create.submit();
	},
	/** 提交表单 */
	submit : function() {
		$("#servMgrSubForm").bind("click", function() {
			$("#servMgrForm").ajaxSubmit({
				dataType : "text",
				success : function(t) {
					t = t.toLowerCase().substring(t.indexOf(">") + 1).replace(
							"</pre>", "");
					if (t == '1') {
						alert("菜单名称不能为空");
						$("#mname").focus();
					}else if(t=='7'){
						alert("菜单名称重复，请重新输入");
						$("#mname").val("");
						$("#mname").focus();
					} else if (t == '2') {
						alert("菜单编码不能为空");
						$("#mcode").focus();
					}else if(t=='8'){
						alert("菜单编码重复，请重新输入");
						$("#mcode").val("");
						$("#mcode").focus();
					} else if (t == '4') {
						alert("菜单描述不能为空");
						$("#mdesc").focus();
					} else if (t == '3') {
						alert("菜单别名不能为空");
						$("#malias").focus();
					}else if(t=='5'){
						alert("菜单图标不能为空");
						$("#micon").focus();
					}else if(t=='6'){
						alert("排序号不能为空");
						$("#msort").focus();
					} else if (t == "0000") {
						location.href = "sysServMgr!index.do?nav="
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
			create.init();
		});