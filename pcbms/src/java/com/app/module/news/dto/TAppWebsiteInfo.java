package com.app.module.news.dto;

import java.util.Date;

import com.app.common.model.EntityBase;

//新闻采集规则
public class TAppWebsiteInfo extends EntityBase{
	private Integer id;//
	private String webname;// 名称
	private String link;// 原链接
	private String forwardlink;// 链接前缀
	private String plink;// 新闻列表连接
	private String phref;// 新闻列表连接规则
	private String title;// 标题规则
	private String author;// 作者规则
	private String source;// 来源规则
	private String timeline;// 发布时间规则
	private String content;// 内容规则
	private String summary;// 简介规则
	private Integer userid;// 用户ID
	private String username;// 用户名
	private Date addtime;// 添加时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWebname() {
		return webname;
	}

	public void setWebname(String webname) {
		this.webname = webname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getForwardlink() {
		return forwardlink;
	}

	public void setForwardlink(String forwardlink) {
		this.forwardlink = forwardlink;
	}

	public String getPlink() {
		return plink;
	}

	public void setPlink(String plink) {
		this.plink = plink;
	}

	public String getPhref() {
		return phref;
	}

	public void setPhref(String phref) {
		this.phref = phref;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

}