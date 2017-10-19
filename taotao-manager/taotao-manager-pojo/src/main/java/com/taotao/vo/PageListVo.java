package com.taotao.vo;

import java.io.Serializable;
import java.util.List;

public class PageListVo<T> implements Serializable {
	/**
	 * 分页显示
	 */
	private static final long serialVersionUID = -5514500257508585937L;
	private int total;
	private List<T> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
