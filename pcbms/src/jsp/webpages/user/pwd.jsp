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
	        	<div class="c"><strong>您当前的位置：</strong>[密码修改]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="UserPwdForm" action="user!pwdSub.do" method="post" onsubmit="return false">
	        			<input type="hidden" name="userInfo.userid" value="${userInfo.userid}" />
		            	<ul>
		            		<li><span class="l">用户帐号</span>${userInfo.username}</li>
		                	<li><span class="l"><span class="h">*</span>旧密码</span><input type="password" id="password" name="password" oncopy="return false" oncut="return false" onpaste="return false" /></li>
		                    <li><span class="l"><span class="h">*</span>新密码</span><input type="password" id="passwordnew" name="passwordnew" oncopy="return false" oncut="return false" onpaste="return false" /></li>
		                    <li><span class="l"><span class="h">*</span>确认密码</span><input type="password" id="passwordconfirm" name="passwordconfirm" oncopy="return false" oncut="return false" onpaste="return false" /></li>
		                    <li class="btn"><input type="submit" id="UserPwdSubForm" value="确定"/></li>
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
	<script type="text/javascript" src="../../js/user/pwd.js"></script>
</body>
</html>