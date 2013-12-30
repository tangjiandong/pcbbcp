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
	    			<strong>您当前的位置：</strong>[系统管理]-[用户管理]<div class="tab_btn"><span><a href="user!create.do?nav=${nav}"><img src="../../images/22.gif" />新增</a></span></div>
		    	</div>
		    </div>
        	<div class="box">
        		<form id="UserForm" action="user!list.do?nav=${nav}" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<table class="tab" width="100%" bgcolor="#b5d6e6" border="0" cellspacing="1" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="10%">用户名</th>
					            <th width="10%">真实姓名</th>
					            <th width="10%">用户类别</th>
					            <th width="10%">联系电话</th>
					            <th width="25%">说明</th>
					            <th width="8%">是否有效</th>
					            <th width="12%">注册时间</th>
					            <th width="15%">操作</th>
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr height="25" bgcolor="#FFFFFF" align="center">
							            <td>${username}</td>
							            <td>${realname}</td>
							            <td><s:if test="utype == 1">管理员</s:if><s:else>普通用户</s:else></td>
							            <td>${uphone}</td>
							            <td>${remark}</td>
							            <td><s:if test="isvalid == 1">是</s:if><s:else>否</s:else></td>
							            <td><s:date name="regclsdate" format="yyyy-MM-dd HH:mm:ss" /></td>
							            <td><span class="bj"><a href="user!edit.do?nav=${nav}&userInfo.userid=${userid}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span><span class="sc"><a href="user!role.do?nav=${nav}&userInfo.userid=${userid}"><img width="14" height="14" src="../../images/22.gif">分配角色</a></span><span class="bj"><a href="javascript:search.resetPwd(${userid});">密码重置</a></span></td>
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="8">暂无数据</div></td>
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
	<script type="text/javascript" src="../../js/user/list.js"></script>
</body>
</html>