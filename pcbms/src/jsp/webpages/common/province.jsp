<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<select name="province" id="province_select" onchange="javascript:syscity.changeProvince();">
	<option value="">--请选择--</option>
	<s:iterator value="provinceList">
	 	<option value="${cid}">${cname}</option>
	</s:iterator>
</select>