/**
 * @Filename: TTgSysRolemenuRel.java
 * @Author：caiqf
 * @Date：2013-7-11
 */
package com.app.module.sys.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

/**
 * @Class: TTgSysRolemenuRel.java
 * @Description: 角色菜单关联信息
 * @Author：caiqf
 * @Date：2013-7-11
 */
public class TTgSysRolemenuRel extends EntityBase {
	private static final long serialVersionUID = 7651539159751803743L;

	private Integer id; // 主键
	private Integer roleid; // 角色编号
	private Integer menuid; // 菜单编号
	private Integer optuserid; // 操作人编号
	private String optusername; // 操作人名称
	private Date optdate; // 操作时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
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
}
