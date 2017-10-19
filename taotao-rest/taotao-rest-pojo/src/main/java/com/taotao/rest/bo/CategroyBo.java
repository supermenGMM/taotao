package com.taotao.rest.bo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategroyBo implements Serializable{
	/**
	 * 用于返回门户商品类别的json串
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(value="u")
	private String url;
	@JsonProperty(value="n")
	private String targer;
	@JsonProperty(value="i")
	private List<?> urls;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarger() {
		return targer;
	}
	public void setTarger(String targer) {
		this.targer = targer;
	}
	public List getUrls() {
		return urls;
	}
	public void setUrls(List urls) {
		this.urls = urls;
	}
	@Override
	public String toString() {
		return "CategroyBo [url=" + url + ", targer=" + targer + ", urls=" + urls + "]";
	}
	
}
