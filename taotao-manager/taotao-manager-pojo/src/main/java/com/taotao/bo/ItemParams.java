package com.taotao.bo;

import java.io.Serializable;

public class ItemParams implements Serializable {
	/**
	 *  商品对应的商品规格每组的param
	 */
	private static final long serialVersionUID = 1L;
	private String k;
	private String v;
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	@Override
	public String toString() {
		return "ItemParams [k=" + k + ", v=" + v + "]";
	}
	
}
