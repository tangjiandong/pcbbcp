package com.app.module.channel.dto;

import java.util.Date;
import java.util.List;

import com.app.common.model.EntityBase;

@SuppressWarnings("all")
//渠道信息表
public class TTgChannelInfo  extends EntityBase{
	private Integer id;// 主键(渠道编号)
	private String chlname;// 渠道名称
	private String chlcomname;// 渠道企业名称
	private String chltel;// 渠道联系人电话(固话)
	private String chlmobile;// 渠道移动电话
	private String chlemail;// 渠道邮箱
	private String chlkey;// 渠道KEY(渠道私钥+渠道编号+渠道名称+加入时间四者md532位)
	private String chlprikey;// 渠道私钥(渠道编号+渠道名称+加入时间三者md5-16位加密)
	private String chltype;// 渠道类别(1收费2免费3其他)
	private String chldesc;// 渠道描述
	private String chlamount;// 渠道收费金额
	private Date joindate;// 渠道加入时间
	private String chlstauts;// 状态(1正常0停用)
	
	//辅助字段
	private  Integer num;//条数
	private String setstatus;// 设置状态(4续费开启3到期关闭2欠费关闭1开启0关闭),
	private String shopid;//店铺ID
	private List<String> spidlist;//店铺ID集合


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChlname() {
		return chlname;
	}

	public void setChlname(String chlname) {
		this.chlname = chlname;
	}

	public String getChlcomname() {
		return chlcomname;
	}

	public void setChlcomname(String chlcomname) {
		this.chlcomname = chlcomname;
	}

	public String getChltel() {
		return chltel;
	}

	public void setChltel(String chltel) {
		this.chltel = chltel;
	}

	public String getChlmobile() {
		return chlmobile;
	}

	public void setChlmobile(String chlmobile) {
		this.chlmobile = chlmobile;
	}

	public String getChlemail() {
		return chlemail;
	}

	public void setChlemail(String chlemail) {
		this.chlemail = chlemail;
	}

	public String getChlkey() {
		return chlkey;
	}

	public void setChlkey(String chlkey) {
		this.chlkey = chlkey;
	}

	public String getChlprikey() {
		return chlprikey;
	}

	public void setChlprikey(String chlprikey) {
		this.chlprikey = chlprikey;
	}

	public String getChltype() {
		return chltype;
	}

	public void setChltype(String chltype) {
		this.chltype = chltype;
	}

	public String getChldesc() {
		return chldesc;
	}

	public void setChldesc(String chldesc) {
		this.chldesc = chldesc;
	}

	public String getChlamount() {
		return chlamount;
	}

	public void setChlamount(String chlamount) {
		this.chlamount = chlamount;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getChlstauts() {
		return chlstauts;
	}

	public void setChlstauts(String chlstauts) {
		this.chlstauts = chlstauts;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSetstatus() {
		return setstatus;
	}

	public void setSetstatus(String setstatus) {
		this.setstatus = setstatus;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public List<String> getSpidlist() {
		return spidlist;
	}

	public void setSpidlist(List<String> spidlist) {
		this.spidlist = spidlist;
	}
	
	

}