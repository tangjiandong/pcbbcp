package com.app.module.news.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

//新闻中心
public class TAppNewscenter extends EntityBase{
	private Integer id;// 主键
	private String title;// 新闻标题
	private String oldhref;//原地址
	private String author;// 作者
	private String summary;// 新闻摘要
	private String content;// 新闻内容
	private String comefrom;// 来源
	private String isrelease;// 是否发布[1是0否]
	private String timeline;// 发布时间
	private Integer userid;// 发布人编号
	private String username;// 发布人姓名
	private Date addtime;// 添加时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComefrom() {
		return comefrom;
	}

	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}

	public String getIsrelease() {
		return isrelease;
	}

	public void setIsrelease(String isrelease) {
		this.isrelease = isrelease;
	}

	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "TAppNewscenter [id=" + id + ", title=" + title + ", author="
				+ author + ", summary=" + summary + ", content=" + content.substring(0, 20)
				+ ", comefrom=" + comefrom + ", isrelease=" + isrelease
				+ ", timeline=" + timeline + ", userid=" + userid
				+ ", username=" + username + ", addtime=" + addtime + "]";
	}

	public String getOldhref() {
		return oldhref;
	}

	public void setOldhref(String oldhref) {
		this.oldhref = oldhref;
	}
	
	

}