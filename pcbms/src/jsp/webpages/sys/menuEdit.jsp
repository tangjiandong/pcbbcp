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
	        	<div class="c"><strong>您当前的位置：</strong>[系统管理]-[菜单管理]-[编辑菜单]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="MenuEditForm" action="menu!editSub.do?nav=${nav}" method="post" onsubmit="return false">
	        			<input type="hidden" name="menuInfo.mid" value="${menuInfo.mid}" />
		            	<ul>
		                	<li><span class="l"><span class="h">*</span>菜单名称</span><input type="text" id="mname" name="menuInfo.mname" value="${menuInfo.mname}" /></li>
		                    <li><span class="l"><span class="h">*</span>菜单描述</span><input type="text" id="mdesc" name="menuInfo.mdesc" value="${menuInfo.mdesc}" /></li>
		                    <li><span class="l">链接地址</span><input type="text" id="actionurl" name="menuInfo.actionurl" value="${menuInfo.actionurl}" /></li>
		                    <li><span class="l"><span class="h">*</span>排序号</span><input type="text" id="msort" name="menuInfo.msort" value="${menuInfo.msort}" onkeyup="javascript:edit.changeNum();" /></li>
		                    <li class="rad"><span class="l">是否有效</span><input type="radio" name="menuInfo.isvalid" value="1" ${menuInfo.isvalid == 1?'checked="checked"':''} /><label>是</label><input type="radio" name="menuInfo.isvalid" value="0" ${menuInfo.isvalid == 0?'checked="checked"':''} /><label>否</label></li>
		                    <li><span class="l">备注</span><textarea rows="6" cols="40" id="remark" name="menuInfo.remark">${menuInfo.remark}</textarea></li>
		                    <li class="btn"><input type="submit" id="MenuEditSubForm" value="确定"/><input type="button" value="返回" onclick="javascript:location.href='menu!list.do?nav=${nav}'" /></li>
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
	<script type="text/javascript" src="../../js/sys/menuEdit.js"></script>
</body>
</html>