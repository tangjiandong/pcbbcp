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
	        	<div class="c"><strong>您当前的位置：</strong>[系统管理]-[角色管理]-[创建角色]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="RoleCreateForm" action="role!createSub.do?nav=${nav}" method="post" onsubmit="return false">
		            	<ul>
		                	<li><span class="l"><span class="h">*</span>角色名称</span><input type="text" id="rolename" name="roleInfo.rolename" /></li>
		                    <li><span class="l"><span class="h">*</span>角色描述</span><input type="text" id="roledesc" name="roleInfo.roledesc" /></li>
		                    <li class="btn"><input type="submit" id="RoleCreateSubForm" value="确定"/><input type="button" value="返回" onclick="javascript:location.href='role!list.do?nav=${nav}'" /></li>
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
	<script type="text/javascript" src="../../js/sys/roleCreate.js"></script>
</body>
</html>