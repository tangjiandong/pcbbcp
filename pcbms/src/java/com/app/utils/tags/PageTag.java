/*
 * 文件名:PageTag.java
 * 作者：caiqifan
 * 完成日期：2012-06-12
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 * 前继版本：1.0
 */
package com.app.utils.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.app.utils.tags.components.Page;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Class: PageTag Description: 前台分页自定义标签
 * 
 * @author caiqifan
 * @version 10.0, 2010-11-27
 * @since JDK1.6
 */
public class PageTag extends AbstractUITag {
	private static final long serialVersionUID = 3393782579964795293L;

	protected String formId; // 默认名称为 formDefault
	protected int recordCount; // 总记录数
	protected int pageCount; // 总页数
	protected int pageNumber; // 当前页数
	protected String nonsynchronous; // 是否异步(非空为异步)
	protected String nondiv; // 异步显示的位置
	protected String pagetype;// 分页类型标识

	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		return new Page(arg0, arg1, arg2);
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		/** 分页组件类 */
		Page page = (Page) component;
		page.setFormId(formId);
		page.setRecordCount(recordCount);
		page.setPageCount(pageCount);
		page.setPageNumber(pageNumber);
		page.setNonsynchronous(nonsynchronous);
		page.setNondiv(nondiv);
		page.setPagetype(pagetype);
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

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

	public String getNonsynchronous() {
		return nonsynchronous;
	}

	public void setNonsynchronous(String nonsynchronous) {
		this.nonsynchronous = nonsynchronous;
	}

	public String getNondiv() {
		return nondiv;
	}

	public void setNondiv(String nondiv) {
		this.nondiv = nondiv;
	}

	public String getPagetype() {
		return pagetype;
	}

	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}
}
