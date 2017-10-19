package com.taotao.vo;

import java.io.Serializable;

public class EasyUITreeVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 344202357731496101L;
	private transient int version;//测试变量
	private Long id;
	private String text;
	private String state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "TbItemCatVo [id=" + id + ", text=" + text + ", state=" + state + "]";
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
}
