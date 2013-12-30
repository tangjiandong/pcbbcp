<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<select name="area" id="area_select">
	<option value="">--请选择--</option>
	<s:iterator value="areaList">
	 	<option value="${cid}">${cname}</option>
	</s:iterator>
</select>