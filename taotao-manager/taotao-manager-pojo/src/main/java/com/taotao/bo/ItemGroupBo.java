package com.taotao.bo;

import java.io.Serializable;
import java.util.List;

public class ItemGroupBo implements Serializable{
	/**
	 * 商品类型对应的商品规格
	 */
	private static final long serialVersionUID = 1L;
	private String group;
	private List<String> params;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<String> getParams() {
		return params;
	}
	public void setParams(List<String> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "ItemGroup [group=" + group + ", params=" + params + "]";
	}
	
}
