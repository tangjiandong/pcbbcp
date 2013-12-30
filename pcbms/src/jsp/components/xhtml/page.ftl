<div class="page">
	共有 ${parameters.recordCount} 条记录，当前第 ${parameters.pageNumber}/${parameters.pageCount} 页
	<span class="r">
    	<#if parameters.pageCount != 1><a href="javascript:void(0);" onclick="javascript:btnPage('1');"><img src="../../images/first.gif"/></a><#else><a href="javascript:void(0);"><img src="../../images/first.gif"/></a></#if>
    	<#if parameters.pageNumber != 1><a href="javascript:void(0);" onclick="javascript:btnPage('${parameters.prePage}');"><img src="../../images/back.gif"/></a><#else><a href="javascript:void(0);"><img src="../../images/back.gif"/></a></#if>
    	<#if parameters.pageNumber != parameters.pageCount><a href="javascript:void(0);" onclick="javascript:btnPage('${parameters.nextPage}');"><img src="../../images/next.gif"/></a><#else><a href="javascript:void(0);"><img src="../../images/next.gif"/></a></#if>
    	<#if parameters.pageNumber != parameters.pageCount><a href="javascript:void(0);" onclick="javascript:btnPage('${parameters.pageCount}');"><img src="../../images/last.gif"/></a><#else><a href="javascript:void(0);"><img src="../../images/last.gif"/></a></#if>
        <span>转到第<input type="text" size="1" onkeyup="javascript:cpaging();" id="inputPage" />页</span><a href="javascript:void(0);" onclick="javascript:btnPage($('#inputPage').val());"><img src="../../images/go.gif"/></a>
    </span>
</div>
<input type="hidden" id="formIdFlt${parameters.nonsynchronous}" value="${parameters.formId}"/>
<input type="hidden" id="pageCount${parameters.nonsynchronous}" value="${parameters.pageCount}"/>
<input type="hidden" id="pageNumber${parameters.nonsynchronous}" value="${parameters.pageNumber}"/>
<input type="hidden" id="nonsynchronous" value="${parameters.nonsynchronous}"/>
<input type="hidden" id="nondiv" value="${parameters.nondiv}"/>
<script>
	function btnPage(toPage) {
		if(null != toPage && toPage != ""){
			toPage = parseInt(toPage.replace(",",""));
			var nonsynchronous = $.trim($("#nonsynchronous").val());
			var pageNumber = parseInt($('#pageNumber' + nonsynchronous).val().replace(",",""));
			var pageCount = parseInt($('#pageCount' + nonsynchronous).val().replace(",",""));
			if (toPage == pageNumber) {
				// alert('已在当前页!');
			} else if (toPage > pageCount || toPage < 1) {
				// alert('没有此页!');
			} else {
				var form = $('#' + $('#formIdFlt' + nonsynchronous).val());
				$('#pageNumber' + nonsynchronous).val(toPage);
				var nnn = $("#nonsynchronous").val();
				var nondiv = $("#nondiv").val();
				if (null != nnn && nnn != '') {
					form.ajaxSubmit(function(t) {
								$("#" + $('#nondiv').val()).html(t);
							});
				} else {
					form.submit();
				}
			}
		}
	}
	function currpage() {
		// alert('已在当前页!');
	}
	function cpaging() {
		var patt = /^[0-9]+$/;
		if (!patt.exec($.trim($("#inputPage").val()))) {
			$("#inputPage").val($("#inputPage").val().replace(/[^0-9]/, ""));
		}
	}
</script>