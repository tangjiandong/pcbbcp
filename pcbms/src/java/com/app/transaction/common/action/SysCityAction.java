/**
 * 文件名: SysCityAction.java
 * 作者：caiqf
 * 完成日期：2012-7-5
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.app.module.sys.dto.TWxSysCityinfo;
import com.app.transaction.sys.service.SysService;



/**
 * Class: SysCityAction.java Description: 省市公用类Action
 * 
 * @author caiqf
 * @date 2012-7-5
 */
@SuppressWarnings("all")
public class SysCityAction extends BaseAction {
	private static final long serialVersionUID = 7686730027027702978L;
	@Resource
	private SysService sysService;
	private List provinceList = new ArrayList();
	private List cityList = new ArrayList();
	private List areaList = new ArrayList();
	private String parentId; // 父级编号
	private String type = "1"; // 1 省份；2 城市；3 县区
	private  TWxSysCityinfo  cityinfo;

	/**
	 * 
	 * @author caiqf
	 * @date 2012-7-5 下午07:09:45
	 * @describe 获取初始化省市县下拉列表
	 * @return String
	 */
	public String getSelectList() {
		try {
			cityinfo=new TWxSysCityinfo();
			if (null != this.parentId && !"".equals(this.parentId)) {
				cityinfo.setPid(Integer.parseInt(parentId));
		
				
				if ("1".equals(this.type)) {
					this.provinceList = this.sysService.listTWxSysCityinfo(cityinfo);
					return "province";
				} else if ("2".equals(this.type)) {
					this.cityList =this.sysService.listTWxSysCityinfo(cityinfo);
					return "city";
				} else if ("3".equals(this.type)) {
					this.areaList = this.sysService.listTWxSysCityinfo(cityinfo);
					return "area";
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "province";
	}

	public List getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List provinceList) {
		this.provinceList = provinceList;
	}

	public List getCityList() {
		return cityList;
	}

	public void setCityList(List cityList) {
		this.cityList = cityList;
	}

	public List getAreaList() {
		return areaList;
	}

	public void setAreaList(List areaList) {
		this.areaList = areaList;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public TWxSysCityinfo getCityinfo() {
		return cityinfo;
	}

	public void setCityinfo(TWxSysCityinfo cityinfo) {
		this.cityinfo = cityinfo;
	}

	public SysService getSysService() {
		return sysService;
	}

	public void setSysService(SysService sysService) {
		this.sysService = sysService;
	}
	
	
}
