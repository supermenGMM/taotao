package com.taotao.rest.vo;

import java.io.Serializable;

/**
 * @author lemon
 *
 */
public class ADVo implements Serializable{
	/**
	 * 轮播显示json对于的vo
	 */
	private static final long serialVersionUID = 1L;
	private String srcB;
	private Integer height;
	private String alt;
	private Integer width;
	private String src;
	private Integer widthB;
	private String href;
	private Integer heigthB;
	public String getSrcB() {
		return srcB;
	}
	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getWidthB() {
		return widthB;
	}
	public void setWidthB(Integer widthB) {
		this.widthB = widthB;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getHeigthB() {
		return heigthB;
	}
	public void setHeigthB(Integer heigthB) {
		this.heigthB = heigthB;
	}
	
}
