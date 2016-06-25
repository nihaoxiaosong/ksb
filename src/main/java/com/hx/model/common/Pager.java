package com.hx.model.common;

import java.util.List;

/**
 * 分页
 * @author song
 * @date 2016年6月23日上午9:20:43
 * @param <T>
 */
public class Pager<T> {
	/**
     * 总记录数。
     */
    private int totalCount;
    /**
     * 当前页的记录列表。
     */
    private List<T> list;

    /**
     * 构造函数。
     * @param totalCount 总记录数。
     * @param list 当前页的记录列表。
     */
    public Pager(int totalCount, List<T> list){
        this.totalCount=totalCount;
        this.list=list;
    }
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
    
}
