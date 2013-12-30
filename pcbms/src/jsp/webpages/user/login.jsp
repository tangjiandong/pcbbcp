<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>CRM管理系统</title>
	<style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #016aa9;
			overflow:hidden;
		}
		.STYLE1 {
			color: #000000;
			font-size: 12px;
		}
		.login_submitbtn input{
			text-indent:1000px; 
			overflow:hidden; 
			width:49px; 
			height:42px; 
			background:url(../../images/dl.gif) no-repeat; 
			border:none; 
			cursor:pointer;
		}
	</style>
</head>
<body>
	<form id="UserLoginForm" action="login!loginSub.do" method="post" onsubmit="return false">
   		<input type="hidden" id="fromurl" name="fromurl" value="${fromurl}"/>
		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
		    	<td>
		    		<table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
				        	<td height="235" background="../../images/login_03.gif">&nbsp;</td>
				      	</tr>
				      	<tr>
				        	<td height="53">
				        		<table width="100%" border="0" cellspacing="0" cellpadding="0">
						          	<tr>
						            	<td width="394" height="53" background="../../images/login_05.gif">&nbsp;</td>
						            	<td width="206" background="../../images/login_06.gif">
						            		<table width="100%" border="0" cellspacing="0" cellpadding="0">
								              	<tr>
									                <td width="16%" height="25"><div align="right"><span class="STYLE1">用户</span></div></td>
									                <td width="57%" height="25">
									                	<div align="center"><input type="text" id="username" name="username" tabindex="1" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"></div>
									            	</td>
									            	<td rowspan="2" class="login_submitbtn"><input type="submit" id="UserLoginSubForm" /></td>
								              	</tr>
								              	<tr>
								                	<td height="25"><div align="right"><span class="STYLE1">密码</span></div></td>
								                	<td height="25">
								                		<div align="center"><input type="password" id="password" name="password" oncopy="return false" oncut="return false" onpaste="return false" tabindex="2" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"></div>
								                	</td>
								              	</tr>
						            		</table>
						            	</td>
						            	<td width="362" background="../../images/login_07.gif">&nbsp;</td>
						          	</tr>
				        		</table>
				        	</td>
				      	</tr>
				      	<tr>
				        	<td height="213" background="../../images/login_08.gif">&nbsp;</td>
				      	</tr>
		    		</table>
		    	</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="../foot.jsp" %>
	<script type="text/javascript" src="../../js/user/login.js"></script>
</body>
</html>