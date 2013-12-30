/*
 * 文件名:ReturnData.java
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
 * Class: ReturnData Description: 数据列表分页返回结果集的封装类
 * 
 * @author caiqifan
 * @version 10.0, 2010-11-26
 * @since JDK1.6
 */

public class ReturnData {
	/** 记录总数 */
	private int recordCount = 0;

	/** 总页数 */
	private int pageCount = 0;

	/** 当前页数 */
	private int pageNumber = 1;

	/** 每页显示多少条 */
	private int pageSize = 10;

	private Object entity;

	/** 页面显示的数据集 */
	private List<EntityBase> resultlist;
	/** 页面显示的数据集:(object集合) */
	private List<Object>  objectList;

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public List<EntityBase> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<EntityBase> resultlist) {
		this.resultlist = resultlist;
	}

	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
	
}
