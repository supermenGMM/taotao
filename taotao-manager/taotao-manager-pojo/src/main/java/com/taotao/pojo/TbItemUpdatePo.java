package com.taotao.pojo;

import java.io.Serializable;

public class TbItemUpdatePo implements Serializable {
	//更加id更新状态
	private Long[] ids;
	private byte status;
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	
	
}
