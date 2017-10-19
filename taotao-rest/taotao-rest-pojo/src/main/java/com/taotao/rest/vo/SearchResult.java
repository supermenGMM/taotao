package com.taotao.rest.vo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
	/**
	 * 搜索显示
	 */
	private static final long serialVersionUID = 1L;
	private String query;//查询条件	
	private Long totalPages;
	private List<ItemSolrVo> itemList;
	private Integer page;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public List<ItemSolrVo> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemSolrVo> itemList) {
		this.itemList = itemList;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "SearchResult [query=" + query + ", totalPages=" + totalPages + ", itemList=" + itemList + "]";
	}
	
	
}