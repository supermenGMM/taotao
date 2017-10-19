package com.taotao.rest.bo;

import java.io.Serializable;

public class ItemParams implements Serializable {
	/**
	 *  商品对应的商品规格每组的param
	 */
	private transient static final long serialVersionUID = 1L;
	
	public ItemParams() {
		super();
		// TODO Auto-generated constructor stub
	}
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
