/**
 * @author caiqifan
 * @deprecated 加载省份、城市、区县下拉框
 * @date 2012-6-25
 */
var syscity = {
	init : function() {
		syscity.setDefaultValue();
	},
	/** 加载时设置已选的省份、城市、区县信息 */
	setDefaultValue : function() {
		syscity.initProvince(0);
		var p = $("#province_default");
		if (p && null != p.val() && p.val() != "") {
			syscity.initCity(p.val());
			var c = $("#city_default");
			if (c && null != c.val() && c.val() != "") {
				syscity.initArea(c.val());
			}
		} else {
			syscity.initCity(-1);
			syscity.initArea(-1);
		}
	},
	/** 加载省份信息 */
	initProvince : function(parentId) {
		$.get(	"sysCity!getSelectList.do?parentId=" + parentId
						+ "&type=1&d=" + new Date().getTime(), function(t) {
					$("#provinceDiv").html(t);
					syscity.selectedProvince();
				});
	},
	/** 加载城市信息 */
	initCity : function(parentId) {
		$.get(	"sysCity!getSelectList.do?parentId=" + parentId
						+ "&type=2&d=" + new Date().getTime(), function(t) {
					$("#cityDiv").html(t);
					syscity.selectedCity();
				});
	},
	/** 加载区县信息 */
	initArea : function(parentId) {
		$.get(	"sysCity!getSelectList.do?parentId=" + parentId
						+ "&type=3&d=" + new Date().getTime(), function(t) {
					$("#areaDiv").html(t);
					syscity.selectedArea();
				});
	},
	/** 选择省份 */
	changeProvince : function() {
		syscity.cleanCity();
		syscity.cleanArea();
		var province = $("#province_select").val();
		if (null != $("#province_select").val()
				&& $("#province_select").val() != "") {
			syscity.initCity(province);
		}
	},
	/** 选择城市 */
	changeCity : function() {
		syscity.cleanArea();
		var city = $("#city_select").val();
		if (null != $("#city_select").val() && $("#city_select").val() != "") {
			syscity.initArea(city);
		}
	},
	/** 选中所选择的省份 */
	selectedProvince : function() {
		var p1 = $("#province_default");
		if (p1 && null != p1.val() && p1.val() != "") {
			$("#province_select > option").each(function() {
						if ($(this).attr("value") == p1.val()) {
							$(this).attr("selected", "selected");
						}
					});
		}
	},
	/** 选中所选择的城市 */
	selectedCity : function() {
		var c1 = $("#city_default");
		if (c1 && null != c1.val() && c1.val() != "") {
			$("#city_select > option").each(function() {
						if ($(this).attr("value") == c1.val()) {
							$(this).attr("selected", "selected");
						}
					});
		}
	},
	/** 选中所选择的区县 */
	selectedArea : function() {
		var a1 = $("#area_default");
		if (a1 && null != a1.val() && a1.val() != "") {
			$("#area_select > option").each(function() {
						if ($(this).attr("value") == a1.val()) {
							$(this).attr("selected", "selected");
						}
					});
		}
	},
	/** 清空城市信息 */
	cleanCity : function() {
		$("#city_select").html("<option value=\"\">--请选择--</option>");
	},
	/** 清空区县信息 */
	cleanArea : function() {
		$("#area_select").html("<option value=\"\">--请选择--</option>");
	}
};

$(document).ready(function() {
			syscity.init();
		});