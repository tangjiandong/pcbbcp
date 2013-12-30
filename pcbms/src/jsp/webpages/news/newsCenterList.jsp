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
	    			<strong>您当前的位置：</strong>[新闻采集管理]-[新闻管理]
		    	</div>
		    </div>
        	<div class="box">
        		<form id="UserForm" action="news!list.do?nav=${nav}" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<table class="tab" width="100%" bgcolor="#b5d6e6" border="0" cellspacing="1" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="10%">编号</th>
					            <th width="10%">标题</th>
					            <th width="10%">作者</th>
					            <th width="10%">来源</th>
					            <th width="10%">发布时间</th>
					            <th width="10%">是否发布</th>
					             <th width="10%">采集时间</th>
					             <th width="6%">用户ID</th>
					            <th width="5%">用户名</th>
					            <th width="5%">原地址</th>
					            <th width="15%">操作</th>
					            
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr height="25" bgcolor="#FFFFFF" align="center">
							            <td>${id}</td>
							             <td>${title}</td>
							              <td>${author}</td>
							               <td>${comefrom}</td>
							                <td>${timeline}</td>
							                <td><s:if test="isrelease==1"><span style="color: red">是</span></s:if><s:else>否</s:else></td>
							                <td><s:date name="addtime" format="yyyy-MM-dd" /></td>
							                <td>${userid}</td>
							                <td>${username}</td>
							                <td>
							             <span class="bj"><a href="${oldhref}" target="_blank">查看</a></span>
							            </td>
							            <td>
							            <span class="bj"><a href="news!gotoView.do?id=${id}&nav=${nav}"><img width="14" height="14" src="../../images/33.gif">查看</a></span>
							            <span class="bj"><a href="javascript:on_del(${id});">删除</a></span>
							               <s:if test="isrelease==1"></s:if><s:else>
							            <span class="bj"><a href="javascript:on_rate(${id});">审核</a></span>
							            </s:else>
							            </td>
							      
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="11">暂无数据</td>
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
			url : "news!doDele.do?id=" + id + "&d="
					+ new Date().getTime(),
			dataType : "html",
			success : function(t) {
				t=$.trim(t);
				if (t == "0000") {
					alert("删除成功");
					location.href = "news!list.do?nav=" + $("#nav").val();
				} else {
					alert("网络异常，请稍候重试");
				}
			}
		});
	}
	function on_rate(id){
		$.ajax({
			url : "news!doRate.do?id=" + id + "&d="
					+ new Date().getTime(),
			dataType : "html",
			success : function(t) {
				t=$.trim(t);
				if (t == "0000") {
					alert("新闻审核成功!");
					location.href = "news!list.do?nav=" + $("#nav").val();
				} else {
					alert("网络异常，请稍候重试");
				}
			}
		});
	}

	
	</script>
</body>
</html>