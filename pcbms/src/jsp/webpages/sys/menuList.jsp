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
	    			<strong>您当前的位置：</strong>[系统管理]-[菜单管理]<div class="tab_btn"><span><a href="menu!create.do?nav=${nav}&pid=${pid}"><img src="../../images/22.gif" />新增一级菜单</a></span></div>
		    	</div>
		    </div>
        	<div class="box">
        		<form id="MenuForm" action="menu!list.do?nav=${nav}" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<input type="hidden" name="pid" value="${pid}" />
	        		<table class="add" width="100%" border="0" cellspacing="0" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="35%">菜单名称</th>
					            <th width="10%">菜单编号</th>
					            <th width="20%">链接地址</th>
					            <th width="10%">排序号</th>
					            <th width="10%">是否有效</th>
					            <th width="15%">操作</th>
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr class="add_list">
							            <td class="tit" style="padding-left:0px"><i class="last"></i><s:if test="isleaf == 1"><a href="javascript:void(0);" mid="${mid}" mname="${mname}" onclick="javascript:menuList.open(this);"><img src="../../images/on.gif">${mname}</a></s:if><s:else>${mname}</s:else></td>
							            <td>${mid}</td>
							            <td>${actionurl}</td>
							            <td>${msort}</td>
							            <td><s:if test="isvalid == 1">是</s:if><s:else>否</s:else></td>
							            <td><span class="bj"><a href="menu!edit.do?nav=${nav}&menuInfo.mid=${mid}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span><s:if test="parentid == 0"><span class="bj"><a href="menu!create.do?nav=${nav}&pid=${mid}"><img width="14" height="14" src="../../images/22.gif">新增子菜单</a></span></s:if></td>
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="5">暂无数据</div></td>
		          				</tr>
	          				</s:else>
	        			</tbody>
	        		</table>
	        		<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	        			<app:paging pageNumber="${rd.pageNumber}" pageCount="${rd.pageCount}" recordCount="${rd.recordCount}" formId="MenuForm" />
	        		</s:if>
		        </form>
        	</div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
    	</div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
	<script type="text/javascript" src="../../js/sys/menuList.js"></script>
</body>
</html>