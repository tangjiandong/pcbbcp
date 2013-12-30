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
	        	<div class="c"><strong>您当前的位置：</strong>[系统管理]-[角色管理]-[分配菜单]</div>
	        </div>
	        <div class="box">
	        	<s:if test="null != dataList && dataList.size() > 0">
		        	<div class="list_form" style="margin-top:0px;">
		        		<form id="RoleMenuForm" action="role!menuSub.do?nav=${nav}" method="post" onsubmit="return false">
		        			<input type="hidden" name="roleInfo.id" value="${roleInfo.id}" />
		        			<input type="hidden" name="ids" id="ids" />
			            	<ul>
			            		<li class="rad" style="background-color:#6aa1c6;padding-top:12px;"><span class="l"><input type="checkbox" id="selectAll" onclick="javascript:menu.selectAll(this);" /></span>全选</li>
			            		<s:iterator value="dataList" status="v">
			                		<li class="rad" style="background-color:#a3ceea;padding-top:12px;"><span style="margin-left:20px;">&nbsp;</span><span class="l"><s:if test="ids.contains('[' + mid + ']')"><input type="checkbox" name="menuIds" value="${mid}" checked="checked" onclick="javascript:menu.level1All(this);" /></s:if><s:else><input type="checkbox" name="menuIds" value="${mid}" onclick="javascript:menu.level1All(this);" /></s:else></span>${mname}</li>
			                		<s:iterator value="dataMap[mid]" status="v">
			                			<li class="rad" style="background-color:#d1e5f3;padding-top:12px;"><span style="margin-left:50px;">&nbsp;</span><span class="l"><s:if test="ids.contains('[' + mid + ']')"><input type="checkbox" name="menuIds" mpid="${parentid}" value="${mid}" checked="checked" onclick="javascript:menu.level2All(this);" /></s:if><s:else><input type="checkbox" name="menuIds" mpid="${parentid}" value="${mid}" onclick="javascript:menu.level2All(this);" /></s:else></span>${mname}</li>
			                		</s:iterator>
			                    </s:iterator>
			                    <li class="btn" style="margin-top:20px;text-align:center;"><input type="submit" id="RoleMenuSubForm" value="确定"/><input type="button" value="返回" onclick="javascript:location.href='role!list.do?nav=${nav}'" /></li>
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
	<script type="text/javascript" src="../../js/sys/menu.js"></script>
</body>
</html>