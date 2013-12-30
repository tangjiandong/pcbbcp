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
		<div class="contentright">
	    	<div class="posi">
	    		<div class="l"></div><div class="r"></div>
	    		<div class="c">
	    			<strong>您当前的位置：</strong>[新闻采集管理]-[采集模板管理]<div class="tab_btn"><span><a href="website!gotoAdd.do?nav=${nav}"><img src="../../images/22.gif" />新增</a></span></div>
		    	</div>
		    </div>
        	<div class="box">
        		<form id="UserForm" action="website!list.do?nav=${nav}" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<table class="tab" width="100%" bgcolor="#b5d6e6" border="0" cellspacing="1" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="10%">编号</th>
					            <th width="10%">名称</th>
					            <th width="10%">原链接</th>
					            <th width="10%">链接前缀</th>
					            <th width="25%">新闻列表连接</th>
					             <th width="10%"> 添加时间</th>
					             <th width="6%">用户ID</th>
					            <th width="5%">用户名</th>
					            <th width="15%">操作</th>
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr height="25" bgcolor="#FFFFFF" align="center">
							            <td>${id}</td>
							             <td>${webname}</td>
							              <td>${link}</td>
							               <td>${forwardlink}</td>
							                <td>${plink}</td>
							               <td><s:date name="addtime" format="yyyy-MM-dd" /></td>
							                <td>${userid}</td>
							                <td>${username}</td>
							            <td><span class="bj"><a href="website!gotoUpdate.do?nav=${nav}&id=${id}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span>
							            <span class="bj"><a href="javascript:on_del(${id});">删除</a></span>
							            <span class="bj"><a href="javascript:on_load(${id});">采集</a></span>
							            </td>
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="9">暂无数据</td>
		          				</tr>
	          				</s:else>
	        			</tbody>
	        		</table>
	        		<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	        			<app:paging pageNumber="${rd.pageNumber}" pageCount="${rd.pageCount}" recordCount="${rd.recordCount}" formId="UserForm" />
	        		</s:if>
		        </form>
        	</div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
    	</div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
	<script type="text/javascript">
	function on_del(id){
		$.ajax({
			url : "website!doDele.do?id=" + id + "&d="
					+ new Date().getTime(),
			dataType : "html",
			success : function(t) {
				t=$.trim(t);
				if (t == "0000") {
					alert("删除成功");
					location.href = "website!list.do?nav=" + $("#nav").val();
				} else {
					alert("网络异常，请稍候重试");
				}
			}
		});
	}
	function on_load(id){
		$.ajax({
			url : "website!loadNews.do?id=" + id + "&d="
					+ new Date().getTime(),
			dataType : "html",
			success : function(t) {
				t=$.trim(t);
				if (t == "0000") {
					alert("采集新闻成功");
					location.href = "website!list.do?nav=" + $("#nav").val();
				} else {
					alert("网络异常，请稍候重试");
				}
			}
		});
	}

	
	</script>
</body>
</html>