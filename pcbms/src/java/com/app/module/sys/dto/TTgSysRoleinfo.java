/**
 * @Filename: TTgSysRoleinfo.java
 * @Author：caiqf
 * @Date：2013-6-21
 */
package com.app.module.sys.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

/**
 * @Class: TTgSysRoleinfo.java
 * @Description: 角色信息
 * @Author：caiqf
 * @Date：2013-6-21
 */
public class TTgSysRoleinfo extends EntityBase {
	private static final long serialVersionUID = 1375632726465926607L;
	
	private Integer id; // 主键
	private String rolename; // 角色名称
	private String roledesc; // 角色描述
	private Integer optuserid; // 操作人编号
	private String optusername; // 操作人名称
	private Date optdate; // 操作时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
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
