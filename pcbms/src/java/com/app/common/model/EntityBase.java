/*
 * 文件名:EntityBase.java
 * 作者：caiqifan
 * 完成日期：2010-11-26
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 * 前继版本：1.0
 */
package com.app.common.model;

import java.util.List;

/**
 * Class: EntityBase Description: 所有dto的父类
 * 
 * @author caiqifan
 * @version 10.0, 2010-11-26
 * @since JDK1.6
 */
@SuppressWarnings("all")
public class EntityBase implements java.io.Serializable {
	private static final long serialVersionUID = 6101410969642691289L;

	/** 从第几条数据开始 */
	private int start = 0;

	/** 从第几条数据结束 */
	private int end = 0;

	/** 每页显示条数 */
	private int pageSize = 10;

	/** 当前页数 */
	private int pageNumber = 0;

	/** 排序字段标识 */
	private String sorttype;

	/** 排序字段 */
	private String sortfield;

	/** 排序方向 */
	private String sortdir;
	
	/**特殊字段*/
	private String special;
	
	/**特殊字段列表*/
	private List<String> speciallist;

	public int getStart() {
		// Oracle : return pageSize * (pageNumber - 1) + 1;
		return pageSize * (pageNumber - 1);
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		// Oracle : return pageSize * (pageNumber - 1) + pageSize;
		return pageSize;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSorttype() {
		return sorttype;
	}

	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}

	public String getSortfield() {
		return sortfield;
	}

	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	public String getSortdir() {
		return sortdir;
	}

	public void setSortdir(String sortdir) {
		this.sortdir = sortdir;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public List<String> getSpeciallist() {
		return speciallist;
	}

	public void setSpeciallist(List<String> speciallist) {
		this.speciallist = speciallist;
	}
}
