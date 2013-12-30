package com.app.jdbc.util;



public class Pager implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalRows; // 总行数
	private int pageSize = 10; // 每页显示行数
	private int currentPage; // 当前页号
	private int totalPages; // 总页数
	private int startRow; // 当前页在数据库中的起始行

	public Pager() {

	}

	public Pager(int _totalRows, int setpageSize) {
		this.pageSize = setpageSize;
		totalRows = _totalRows;
		totalPages = totalRows / pageSize;
		int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
		if (totalRows == 0) {
			currentPage = 0;
		} else {
			currentPage = 1;
		}
		startRow = 0;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getTotalPages() {
		if (totalRows % pageSize == 0) {
			totalPages = (totalRows / pageSize);
		} else {
			totalPages = (totalRows / pageSize) + 1;
		}
		return totalPages;
	}

	public int getCurrentPage() {
		if (currentPage < 1) {
			currentPage = 1;
		}
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}

	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}

	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPages) {
			last();
		}
	}
}
