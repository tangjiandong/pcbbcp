<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<s:if test="null != menuList && menuList.size() > 0">
	<s:iterator value="menuList" status="v">
		<tr class="add_list" pid="${pid}">
			<td class="tit" style="padding-left:${(levelno - 1) * 18}px;"><i></i><s:if test="isleaf == 1"><a href="javascript:void(0);" mid="${mid}" mname="${mname}" onclick="javascript:menuList.open(this);"><img src="../../images/on.gif">${mname}</a></s:if><s:else>${mname}</s:else></td>
			<td>${mid}</td>
			<td>${actionurl}</td>
            <td>${msort}</td>
            <td><s:if test="isvalid == 1">是</s:if><s:else>否</s:else></td>
			<td><span class="bj"><a href="menu!edit.do?nav=${nav}&menuInfo.mid=${mid}"><img width="14" height="14" src="../../images/33.gif">编辑</a></span><s:if test="parentid == 0"><span class="bj"><a href="menu!create.do?nav=${nav}&pid=${mid}"><img width="14" height="14" src="../../images/22.gif">新增子菜单</a></span></s:if></td>
		</tr>
	</s:iterator>
</s:if>
