package com.taotao.rest.bo;

import java.io.Serializable;
import java.util.List;

public class ItemCatResult implements Serializable{
	private List<CategroyBo> data;

	public List<CategroyBo> getData() {
		return data;
	}

	public void setData(List<CategroyBo> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ItemCatResult [data=" + data + "]";
	}
	
	
}
