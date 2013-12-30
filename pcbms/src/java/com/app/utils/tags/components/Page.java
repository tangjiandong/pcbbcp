/*
 * 文件名:Page.java
 * 作者：caiqifan
 * 完成日期：2012-06-12
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 * 前继版本：1.0
 */
package com.app.utils.tags.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Class: Page Description: 前台分页自定义组件
 * 
 * @author caiqifan
 * @version 10.0, 2010-11-27
 * @since JDK1.6
 */
public class Page extends UIBean {
	private static final String TEMPLATE = "page";
	private static final String TEMPLATEDIR = "components";
	protected String formId; // 默认名称为 formDefault
	protected int recordCount; // 总记录数
	protected int pageCount; // 总页数
	protected int pageNumber; // 当前页数
	protected String nonsynchronous; // 是否异步(非空为异步)
	protected String nondiv; // 异步显示的位置
	protected String pagetype; // 分页类型标识

	public Page(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	public String getTemplateDir() {
		return TEMPLATEDIR;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		formId = formId == null || formId.equals("") ? "formDefault" : formId;
		pageCount = pageCount > 0 ? pageCount : 1;

		int firstPage = (pageNumber > 2 && pageCount > 5) ? (pageCount
				- (pageNumber - 2) > 4 ? (pageNumber - 2) : pageCount - 4) : 1;
		int lastPage = (firstPage + 4) >= pageCount ? pageCount
				: (firstPage + 4);
		int prePage = (pageNumber - 1) <= 1 ? 1 : (pageNumber - 1);
		int nextPage = (pageNumber + 1) >= pageCount ? pageCount
				: (pageNumber + 1);

		if (nonsynchronous == null || nonsynchronous.equals("")) {
			nonsynchronous = "";
		}
		if (nondiv == null || nondiv.equals("")) {
			nondiv = "";
		}
		if (pagetype == null || pagetype.equals("")) {
			pagetype = "";
		}
		addParameter("formId", formId); // 表单ID
		addParameter("recordCount", recordCount); // 总记录数
		addParameter("pageCount", pageCount); // 总页数
		addParameter("pageNumber", pageNumber); // 当前页数
		addParameter("firstPage", firstPage); // 起始页数
		addParameter("lastPage", lastPage); // 结束页数
		addParameter("prePage", prePage); // 上一页
		addParameter("nextPage", nextPage); // 下一页
		addParameter("nonsynchronous", nonsynchronous); // 是否异步
		addParameter("nondiv", nondiv); // 异步显示数据的位置
		addParameter("pagetype", pagetype); // 分页类型标识
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
