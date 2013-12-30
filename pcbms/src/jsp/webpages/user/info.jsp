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
	        	<div class="c"><strong>您当前的位置：</strong>[个人资料修改]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="UserInfoForm" action="user!infoSub.do" method="post" onsubmit="return false">
	        			<input type="hidden" name="userInfo.userid" value="${userInfo.userid}" />
		            	<ul>
		                	<li><span class="l">用户帐号</span>${userInfo.username}</li>
		                    <li><span class="l"><span class="h">*</span>真实姓名</span><input type="text" id="realname" name="userInfo.realname" value="${userInfo.realname}" /></li>
		                    <li><span class="l">联系电话</span><input type="text" id="uphone" name="userInfo.uphone" value="${userInfo.uphone}" /></li>
		                    <li><span class="l">备注说明</span><textarea rows="6" cols="40" id="remark" name="userInfo.remark">${userInfo.remark}</textarea></li>
		                    <li class="btn"><input type="submit" id="UserInfoSubForm" value="确定"/></li>
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
	<script type="text/javascript" src="../../js/user/info.js"></script>
</body>
</html>