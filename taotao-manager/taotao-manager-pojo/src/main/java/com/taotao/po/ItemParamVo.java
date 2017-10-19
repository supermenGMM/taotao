package com.taotao.po;

import java.io.Serializable;
import java.util.Date;

public class ItemParamVo implements Serializable {
	/**
	 * 商品规格的显示
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long itemCatId;

	private String itemCatName;

	private Date created;

	private Date updated;

	private String paramData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getItemCatName() {
		return itemCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	@Override
	public String toString() {
		return "ItemParamVo [id=" + id + ", itemCatId=" + itemCatId + ", itemCatName=" + itemCatName + ", created="
				+ created + ", updated=" + updated + ", paramData=" + paramData + "]";
	}

}
