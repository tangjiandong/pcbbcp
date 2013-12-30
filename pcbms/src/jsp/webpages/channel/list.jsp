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
	    			<strong>您当前的位置：</strong>[渠道管理]-[渠道信息]<div class="tab_btn"><span><a href="channel!gotoAddChannel.do?nav=${nav}"><img src="../../images/22.gif" />新增</a></span></div>
		    	</div>
		    </div>
        	<div class="box">
        		<form id="serchFrom" action="channel!getChannelList.do?nav=${nav}" method="post">
        		<input type="hidden" id="pageNumber" name="pageNumber" value="0" />
        	    <div class="join_time">
        	    	渠道名称：<input name="ttgChannelInfo.chlname" value="${ttgChannelInfo.chlname}"  type="text"/>
        	    	企业名称：<input name="ttgChannelInfo.chlcomname" value="${ttgChannelInfo.chlcomname}"  type="text"/>
        	    	状态：<select name="ttgChannelInfo.chlstauts">
        	    		<option value="" ${ttgChannelInfo.chlstauts==''?"selected":"" }>请选择</option>
        	    		<option value="1" ${ttgChannelInfo.chlstauts==1?"selected":"" }>正常</option>
        	    		<option value="0" ${ttgChannelInfo.chlstauts==0?"selected":"" }>停用</option>
        	    	</select>
        	    	类型：<select name="ttgChannelInfo.chltype">
        	    			<option value="" ${ttgChannelInfo.chltype==''?"selected":"" }>请选择</option>
        	    			<option value="1" ${ttgChannelInfo.chltype==1?"selected":"" }>收费</option>
        	    			<option value="2" ${ttgChannelInfo.chltype==2?"selected":"" }>免费</option>
        	    			<option value="3" ${ttgChannelInfo.chltype==3?"selected":"" }>其它</option>
        	    	</select>
        	    	<input name="submit" id="submit" type="submit" value="查询"/>
        	    	<!--  <input name="submit" id="submit" type="submit" value="导出"/>-->
        	    </div>
        	    </form>
        		<form id="ChannelForm" action="channel!getChannelList.do" method="post">
        			<input type="hidden" id="pageNumber" name="pageNumber" value="${rd.pageNumber}" />
	        		<table class="tab" width="100%" bgcolor="#b5d6e6" border="0" cellspacing="1" cellpadding="0">
	          			<tbody>
	          				<tr height="25" bgcolor="#CDEAFB" align="center">
					            <th width="15%">渠道名称</th>
					            <th width="15%">企业名称</th>
					            <th width="10%">联系人电话</th>
					            <th width="10%">移动电话</th>
					            <th width="10%">邮箱</th>
					            <th width="5%">类型</th>
					            <th width="5%">状态</th>
					             <th width="10%">加入时间</th>
					            <th width="10%">操作</th>
	          				</tr>
	          				<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	          					<s:iterator value="rd.resultlist" status="v">
			          				<tr height="25" bgcolor="#FFFFFF" align="center">
							            <td>${chlname}</td>
							            <td>${chlcomname}</td>
							            <td>${chltel}</td>
							            <td>${chlmobile}</td>
							            <td>${chlemail}</td>
							            <td>
							            <s:if test="chltype == 1">收费</s:if>
							            <s:elseif test="chltype==2">免费</s:elseif>
							            <s:elseif test="chltype==3">其它</s:elseif>
							            </td>
							            <td>
							            <s:if test="chlstauts == 1">正常</s:if>
							            <s:else>停用</s:else>
							            </td>
							            <td><s:date name="joindate" format="yyyy-MM-dd HH:mm:ss" /></td>
							            <td><span class="bj"><a href="channel!gotoUpChannel.do?nav=${nav}&ttgChannelInfo.id=${id}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span></td>
			          				</tr>
		          				</s:iterator>
	          				</s:if>
	          				<s:else>
	          					<tr>
						            <td height="20" bgcolor="#FFFFFF" colspan="9">暂无数据</div></td>
		          				</tr>
	          				</s:else>
	        			</tbody>
	        		</table>
	        		<s:if test="null != rd.resultlist && rd.resultlist.size() > 0">
	        			<app:paging pageNumber="${rd.pageNumber}" pageCount="${rd.pageCount}" recordCount="${rd.recordCount}" formId="ChannelForm" />
	        		</s:if>
		        </form>
        	</div>
        	<div class="confoot"><div class="l"></div><div class="r"></div></div>
    	</div>
		<!--右边结束-->
	</div>
	<!--主要内容结束-->
	<%@ include file="../foot.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("#submit").click(function(){
				$("#serchFrom").submit();
			});
		})
	</script>
</body>
</html>