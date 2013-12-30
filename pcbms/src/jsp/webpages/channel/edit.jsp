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
	        	<div class="c"><strong>您当前的位置：</strong>[渠道管理]-[修改渠道]</div>
	        </div>
	        <div class="box">
	        	<div class="list_form">
	        		<form id="channelEditForm" action="channel!upChannel.do?nav=${nav}" method="post" onsubmit="return false">
	        			<input type="hidden" name="ttgChannelInfo.id" value="${ttgChannelInfo.id}"/>
		            	<ul>
		                	<li><span class="l"><span class="h">*</span>渠道名称</span><input type="text" id="chlname" name="ttgChannelInfo.chlname" value="${ttgChannelInfo.chlname}"/></li>
		                	<li><span class="l"><span class="h">*</span>渠道企业名称</span><input type="text" id="chlcomname" name="ttgChannelInfo.chlcomname" value="${ttgChannelInfo.chlcomname}"/></li>
		                	<li><span class="l"><span class="h">*</span>联系人电话</span><input type="text" id="chltel" name="ttgChannelInfo.chltel" value="${ttgChannelInfo.chltel}"/></li>
		                	<li><span class="l"><span class="h">*</span>移动电话</span><input type="text" id="chlmobile" name="ttgChannelInfo.chlmobile" value="${ttgChannelInfo.chlmobile}"/></li>
		                	<li><span class="l"><span class="h">*</span>渠道邮箱</span><input type="text" id=chlemail name="ttgChannelInfo.chlemail" value="${ttgChannelInfo.chlemail}"/></li>
		                	<li><span class="l"><span class="h">*</span>收费金额</span><input type="text" id="chlamount" name="ttgChannelInfo.chlamount" value="${ttgChannelInfo.chlamount}"/></li>
		                    <li class="rad"><span class="l">类型</span>
		                    <input type="radio" name="ttgChannelInfo.chltype" value="1" ${ttgChannelInfo.chltype==1?"checked":""} /><label>收费</label>
		                    <input type="radio" name="ttgChannelInfo.chltype" value="2" ${ttgChannelInfo.chltype==2?"checked":""}/><label>免费</label>
		                    <input type="radio" name="ttgChannelInfo.chltype" value="3" ${ttgChannelInfo.chltype==3?"checked":""}/><label>其它</label></li>
		                    <li class="rad"><span class="l">状态</span>
		                    <input type="radio" name="ttgChannelInfo.chlstauts" value="1" ${ttgChannelInfo.chlstauts==1?"checked":""} /><label>正常</label>
		                    <input type="radio" name="ttgChannelInfo.chlstauts" value="0" ${ttgChannelInfo.chlstauts==0?"checked":""}/><label>停用</label></li>
		                    <li><span class="l">渠道描述</span><textarea rows="6" cols="40" id="chldesc" name="ttgChannelInfo.chldesc">${ttgChannelInfo.chldesc}</textarea></li>
		                    <li class="btn"><input type="submit" id="editChannel" value="确定"/><input type="button" value="返回" onclick="location.href='channel!getChannelList.do?nav=${nav}'" /></li>
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
	<script type="text/javascript" src="../../js/channel/edit.js"></script>
</body>
</html>