package com.hx.model.common;

public class PageParam {
	/**
     * 当前页码，从1开始。
     */
    private int pageIndex;
    /**
     * 每页记录数。
     */
    private int pageSize;
    /**
     * 开始条数
     */
    private int startIndex;
    
    public PageParam(int pageIndex, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
    
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return (pageIndex-1)*pageSize;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
    
}
