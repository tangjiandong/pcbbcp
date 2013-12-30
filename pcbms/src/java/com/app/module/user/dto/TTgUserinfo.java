/**
 * @Filename: TTgUserinfo.java
 * @Author：caiqf
 * @Date：2013-6-21
 */
package com.app.module.user.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

/**
 * @Class: TTgUserinfo.java
 * @Description: 用户信息
 * @Author：caiqf
 * @Date：2013-6-21
 */
public class TTgUserinfo extends EntityBase {
	private static final long serialVersionUID = -1104083992665458800L;

	private Integer userid; // 主键(用户编号)
	private String username; // 用户名称
	private String realname; // 真实姓名
	private String password; // 密码
	private String utype; // 用户类别(1管理员2普通用户)
	private String uphone; // 联系电话
	private String remark; // 说明
	private String isvalid; // 是否有效(1是0否)
	private Date regclsdate; // 注册/失效时间
	private Integer optuserid; // 操作人编号
	private String optusername; // 操作人名称
	private Date optdate; // 操作时间
	
	//查询字段
	private Integer roleid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public Date getRegclsdate() {
		return regclsdate;
	}

	public void setRegclsdate(Date regclsdate) {
		this.regclsdate = regclsdate;
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

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
}
