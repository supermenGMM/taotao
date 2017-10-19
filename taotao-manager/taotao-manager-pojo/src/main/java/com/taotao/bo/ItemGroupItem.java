package com.taotao.bo;

import java.io.Serializable;
import java.util.List;

public class ItemGroupItem implements Serializable{
	/**
	 * 商品对应的商品规格
	 */
	private static final long serialVersionUID = 1L;
	private String group;
	private List< ItemParams> params;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<ItemParams> getParams() {
		return params;
	}
	public void setParams(List<ItemParams> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "ItemGroupItem [group=" + group + ", params=" + params + "]";
	}
	
	
}
