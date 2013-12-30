/**
 * @Filename: TWxSysCityinfo.java
 * @Author：caiqf
 * @Date：2013-6-21
 */
package com.app.module.sys.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

/**
 * @Class: TWxSysCityinfo.java
 * @Description: 全国省份城市区县信息
 * @Author：caiqf
 * @Date：2013-6-21
 */
public class TWxSysCityinfo extends EntityBase {
	private static final long serialVersionUID = -6004522492038808249L;

	private Integer id; // 主键
	private Integer cid; // 省份、城市、区县编号
	private String cname; // 省份、城市、区县名称
	private Integer pid; // 父级省份、城市、区县编号
	private String pname; // 父级省份、城市、区县名称
	private Integer orderby; // 排序
	private String spell; // 字母排序
	private Date credate; // 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}
}
