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
	        	<div class="c"><strong>您当前的位置：</strong>[新闻采集管理]-[查看新闻]</div>
	        </div>
	        
	        

	
	        <div class="box">
	        	<div class="list_form">
	        
		            	<ul>
	                   <li><span class="l">编号:</span>${modelinfo.id}</li>
	                    <li><span class="l">新闻标题:</span>${modelinfo.title}</li>
	                    <li><span class="l">原地址:</span>${modelinfo.oldhref}</li>
	                     <li><span class="l">作者:</span>${modelinfo.author}</li>
	                      <li><span class="l">新闻摘要:</span>${modelinfo.summary}</li>
	                       <li><span class="l">来源:</span>${modelinfo.comefrom}</li>
	                       <li><span class="l">是否发布:</span><s:if test="isrelease==1"><span style="color: red">是</span></s:if><s:else>否</s:else></li>
	                       <li><span class="l">采集用户编号:</span>${modelinfo.userid}</li>
	                        <li><span class="l">采集用户名:</span>${modelinfo.username}</li>
	                        <li><span class="l">采集时间:</span><s:date name="modelinfo.addtime" format="yyyy-MM-dd HH:mm:ss" /></li>
	                       <li><span class="l">新闻内容:</span>${modelinfo.content}</li>
		                </ul>
	           
	            </div>
	        </div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
	    </div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	
	<%@ include file="../foot.jsp" %>
	
		

</body>
</html>