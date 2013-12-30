package com.app.utils.test;

import java.util.Date;

//商户图片信息表
public class TShBgShoppicInfo {
	private Integer id;// 主键
	private String shopid;// 商户编号
	private String pictitle;// 图片标题
	private String picpath;// 图片地址
	private String isvaild;// 是否可用(1是0否)
	private String isdisplay;// 是否微站显示(1是0否)
	private Date modifytime;// 上传时间
	private Integer euserid;// 编辑人编号
	private String eusername;// 编辑人名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getPictitle() {
		return pictitle;
	}

	public void setPictitle(String pictitle) {
		this.pictitle = pictitle;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getIsvaild() {
		return isvaild;
	}

	public void setIsvaild(String isvaild) {
		this.isvaild = isvaild;
	}

	public String getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(String isdisplay) {
		this.isdisplay = isdisplay;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
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