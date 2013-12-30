/**
 * @Filename: TTgSysMenuinfo.java
 * @Author：caiqf
 * @Date：2013-7-11
 */
package com.app.module.sys.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

/**
 * @Class: TTgSysMenuinfo.java
 * @Description: 菜单信息
 * @Author：caiqf
 * @Date：2013-7-11
 */
public class TTgSysMenuinfo extends EntityBase {
	private static final long serialVersionUID = -5047460372276919142L;

	private Integer mid; // 主键(菜单编号|权限编号)
	private Integer parentid; // 上级菜单编号
	private String mname; // 菜单名称
	private String mdesc; // 菜单描述
	private String actionurl; // 链接地址
	private Integer msort; // 排序
	private String isvalid; // 是否有效(1是0否)
	private String remark; // 备注
	private Integer optuserid; // 操作人编号
	private String optusername; // 操作人名称
	private Date optdate; // 操作时间
	private String isleaf; // 是否有下级节点(1是0否)
	private Integer levelno; // 分类级别数

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public String getActionurl() {
		return actionurl;
	}

	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}

	public Integer getMsort() {
		return msort;
	}

	public void setMsort(Integer msort) {
		this.msort = msort;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOptuserid() {
		return optuserid;
	}

	public void setOptuserid(Integer optuserid) {
		this.optuserid = optuserid;
	}

	public String getOptusername() {
		return optusername;
	}

	public void setOptusername(String optusername) {
		this.optusername = optusername;
	}

	public Date getOptdate() {
		return optdate;
	}

	public void setOptdate(Date optdate) {
		this.optdate = optdate;
	}

	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public Integer getLevelno() {
		return levelno;
	}

	public void setLevelno(Integer levelno) {
		this.levelno = levelno;
	}
}
