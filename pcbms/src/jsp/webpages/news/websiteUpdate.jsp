<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>CRM管理系统</title>
	<link type="text/css" href="../../css/Base.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="../head.jsp" %>

	<!--主要内容开始-->
	<div class="content">
		<%@ include file="../left.jsp" %>
	    
		<!--右边结束-->
		<div class="contentright" id="welcome">
			<div class="posi">
				<div class="l"></div><div class="r"></div>
	        	<div class="c"><strong>您当前的位置：</strong>[新闻采集管理]-[新增新闻采集模板]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="appForm" action="website!doUpdate.do?nav=${nav}" method="post" onsubmit="return false">
	        		<input type="hidden" id="id"  name="modelinfo.id" value="${modelinfo.id}"  />
		            	<ul>

		                	<li><span class="l">模板名称</span><input type="text" id="webname" name="modelinfo.webname"  value="${modelinfo.webname}"  style="width: 240px;"/></li>
		                	<li><span class="l">原链接</span><input type="text" id="link" name="modelinfo.link"  style="width: 540px;" value="${modelinfo.link}"/></li>
		                	<li><span class="l">链接前缀</span><input type="text" id="forwardlink" name="modelinfo.forwardlink" style="width: 540px;"  value="${modelinfo.forwardlink}"></li>
		                	<li><span class="l">新闻列表连接</span><input type="text" id="plink" name="modelinfo.plink" style="width: 540px;" value="${modelinfo.plink}"/></li>
		                	<li><span class="l">新闻列表连接规则</span><input type="text" id="phref" name="modelinfo.phref"  value="${modelinfo.phref }" style="width: 240px;"/></li>
		                	<li><span class="l">标题规则</span><input type="text" id="title" name="modelinfo.title"  value="${modelinfo.title }" style="width: 240px;"/></li>
		                	<li><span class="l">作者规则</span><input type="text" id="author" name="modelinfo.author"  value="${modelinfo.author }" style="width: 240px;"/></li>
		                	<li><span class="l">来源规则</span><input type="text" id="source" name="modelinfo.source"  value="${modelinfo.source }" style="width: 240px;"/></li>
		                 	<li><span class="l">发布时间规则</span><input type="text" id="timeline" name="modelinfo.timeline"  value="${modelinfo.timeline }" style="width: 240px;"/></li>
		                 	<li><span class="l">内容规则</span><input type="text" id="content" name="modelinfo.content" value="${ modelinfo.content}" style="width: 240px;" /></li>
		                 	<li><span class="l"> 简介规则</span><input type="text" id="summary" name="modelinfo.summary" value="${modelinfo.summary }" style="width: 240px;"/></li>
		                 	
		                    <li class="btn"><input type="submit" id="btn_ok" value="确定"/><input type="button" value="返回" onclick="location.href='website!list.do?nav=${nav}'" /></li>
		                </ul>
	                </form>
	            </div>
	        </div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
	    </div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
	
		<script type="text/javascript">
		$(function(){
			
			$("#btn_ok").bind("click", function() {
				$("#appForm").ajaxSubmit({
					dataType : "text",
					success : function(t) {
					  t=$.trim(t);
						if (t == '1') {
						} else if (t == "0000") {
							location.href = "website!list.do?nav="+ $("#nav").val();
						} else if (t == "1111") {
							alert("网络异常，请稍候重试");
						}
					},
					error : function() {
						alert("网络异常，请稍候重试");
					}
				});
			});
			
		});
		
		
		
		
	</script>
</body>
</html>