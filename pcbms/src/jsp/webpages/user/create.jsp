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
	        	<div class="c"><strong>您当前的位置：</strong>[系统管理]-[用户管理]-[创建用户]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="UserCreateForm" action="user!createSub.do?nav=${nav}" method="post" onsubmit="return false">
		            	<ul>
		                	<li><span class="l"><span class="h">*</span>用户帐号</span><input type="text" id="username" name="userInfo.username" /></li>
		                    <li><span class="l"><span class="h">*</span>真实姓名</span><input type="text" id="realname" name="userInfo.realname" /></li>
		                    <li><span class="l"><span class="h">*</span>用户密码</span><input type="text" id="password" name="userInfo.password" /></li>
		                    <li><span class="l">联系电话</span><input type="text" id="uphone" name="userInfo.uphone" /></li>
		                    <li class="rad"><span class="l">用户类别</span><input type="radio" name="userInfo.utype" value="2" checked="checked" /><label>普通用户</label><input type="radio" name="userInfo.utype" value="1" /><label>管理员</label></li>
		                    <li><span class="l">备注说明</span><textarea rows="6" cols="40" id="remark" name="userInfo.remark"></textarea></li>
		                    <li class="rad"><span class="l">是否有效</span><input type="radio" name="userInfo.isvalid" value="1" checked="checked" /><label>是</label><input type="radio" name="userInfo.isvalid" value="0" /><label>否</label></li>
		                    <li class="btn"><input type="submit" id="UserCreateSubForm" value="确定"/><input type="button" value="返回" onclick="javascript:location.href='user!list.do?nav=${nav}'" /></li>
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
	<script type="text/javascript" src="../../js/user/create.js"></script>
</body>
</html>