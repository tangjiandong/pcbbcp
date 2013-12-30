<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
	<meta charset="utf-8">
	<title>系统错误</title>
</head>
<body>
	<s:property value="exceptionStack"/>    
 	<s:property value="exception.message"/>
</body>
</html>
 