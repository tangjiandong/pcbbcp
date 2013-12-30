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
	        	<div class="c">
	        		<s:if test="d == 'qd'"><strong>您当前的位置：</strong>[营销管理]-[销售渠道用户管理]-[分配角色]</s:if>
	        		<s:else><strong>您当前的位置：</strong>[系统管理]-[用户管理]-[分配角色]</s:else>
	        	</div>
	        </div>
	        <div class="box">
	        	<s:if test="null != dataList && dataList.size() > 0">
		        	<div class="list_form" style="margin-top:0px;">
		        		<form id="UserRoleForm" action="user!roleSub.do?nav=${nav}" method="post" onsubmit="return false">
		        			<input type="hidden" name="userInfo.userid" value="${userInfo.userid}" />
		        			<input type="hidden" name="ids" id="ids" />
			            	<ul>
			            		<li class="rad" style="background-color:#6aa1c6;padding-top:12px;"><span class="l"><input type="checkbox" id="selectAll" onclick="javascript:role.selectAll(this);" /></span>全选</li>
			            		<s:iterator value="dataList" status="v">
			                		<li class="rad" style="background-color:#a3ceea;padding-top:12px;"><span class="l" style="margin-left:20px;"><s:if test="ids.contains('[' + id + ']')"><input type="checkbox" name="roleIds" value="${id}" checked="checked" onclick="javascript:role.selectRole();" /></s:if><s:else><input type="checkbox" name="roleIds" value="${id}" onclick="javascript:role.selectRole();" /></s:else></span>${rolename}</li>
			                    </s:iterator>
			                    <li class="btn" style="margin-top:20px;text-align:center;">
			                    	<input type="submit" id="UserRoleSubForm" value="确定"/>
			                    	<s:if test="d == 'qd'"><input type="button" value="返回" onclick="javascript:location.href='channeluser!list.do?nav=${nav}'" /></s:if>
	        						<s:else><input type="button" value="返回" onclick="javascript:location.href='user!list.do?nav=${nav}'" /></s:else>
			                    </li>
			                </ul>
		                </form>
		            </div>
	            </s:if>
	        </div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
	    </div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
	<script type="text/javascript" src="../../js/user/role.js"></script>
</body>
</html>