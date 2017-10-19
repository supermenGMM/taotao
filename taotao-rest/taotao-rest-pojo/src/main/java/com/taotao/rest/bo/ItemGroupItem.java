package com.taotao.rest.bo;

import java.io.Serializable;
import java.util.List;

public class ItemGroupItem implements Serializable{
	/**
	 * 商品对应的商品规格
	 */
	private transient static final long serialVersionUID = 1L;
	
	public ItemGroupItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String group;
	private  ItemParams[] params;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}

	public ItemParams[] getParams() {
		return params;
	}
	public void setParams(ItemParams[] params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "ItemGroupItem [group=" + group + ", params=" + params + "]";
	}
	
	
}
