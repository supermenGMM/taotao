package com.taotao.po;

import java.io.Serializable;

public class TbItemParamDeltePo implements Serializable{
	/**
	 * 用于删除的时候传递要用的数据
	 */
	private static final long serialVersionUID = 1L;
	private Long[] ids;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
}
