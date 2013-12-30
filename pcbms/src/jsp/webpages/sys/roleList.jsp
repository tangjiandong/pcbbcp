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
	    			<strong>您当前的位置：</strong>[系统管理]-[角色管理]<div class="tab_btn"><span><a href="role!create.do?nav=${nav}"><img src="../../images/22.gif" />新增</a></span></div>
		    	</div>
		    </div>
        	<div class="box">
        		<form id="RoleForm" action="role!list.do?nav=${nav}" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<table class="tab" width="100%" bgcolor="#b5d6e6" border="0" cellspacing="1" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="20%">角色名</th>
					            <th width="50%">角色描述</th>
					            <th width="15%">创建时间</th>
					            <th width="15%">操作</th>
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr height="25" bgcolor="#FFFFFF" align="center">
							            <td>${rolename}</td>
							            <td>${roledesc}</td>
							            <td><s:date name="optdate" format="yyyy-MM-dd HH:mm:ss" /></td>
							            <td><span class="bj"><a href="role!edit.do?nav=${nav}&roleInfo.id=${id}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span><span class="sc"><a href="role!menu.do?nav=${nav}&roleInfo.id=${id}"><img width="14" height="14" src="../../images/22.gif">分配菜单</a></span></td>
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="4">暂无数据</div></td>
		          				</tr>
	          				</s:else>
	        			</tbody>
	        		</table>
	        		<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	        			<app:paging pageNumber="${rd.pageNumber}" pageCount="${rd.pageCount}" recordCount="${rd.recordCount}" formId="RoleForm" />
	        		</s:if>
		        </form>
        	</div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
    	</div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
</body>
</html>