<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<select name="city" id="city_select" onchange="javascript:syscity.changeCity();">
	<option value="">--请选择--</option>
	<s:iterator value="cityList">
	 	<option value="${cid}">${cname}</option>
	</s:iterator>
</select>