package com.app.utils.test;

import java.util.Date;

//商户活动信息表
public class TShBgActivityinfo {
	private Integer id;// 主键(活动编号)
	private String actname;// 活动名称
	private String shopid;// 商户编号
	private Date begindate;// 活动开始时间
	private Date enddate;// 活动结束时间
	private String actdesc;// 活动描述
	private String actstatus;// 活动状态(1未开始2进行中3已过期4已删除)
	private String isdisplay;// 是否前台展示(1是0否)
	private Date edate;// 编辑时间
	private Integer euserid;// 编辑人编号
	private String eusername;// 编辑人名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getActdesc() {
		return actdesc;
	}

	public void setActdesc(String actdesc) {
		this.actdesc = actdesc;
	}

	public String getActstatus() {
		return actstatus;
	}

	public void setActstatus(String actstatus) {
		this.actstatus = actstatus;
	}

	public String getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(String isdisplay) {
		this.isdisplay = isdisplay;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public Integer getEuserid() {
		return euserid;
	}

	public void setEuserid(Integer euserid) {
		this.euserid = euserid;
	}

	public String getEusername() {
		return eusername;
	}

	public void setEusername(String eusername) {
		this.eusername = eusername;
	}

}