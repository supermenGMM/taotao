package com.taotao.rest.service;
import com.taotao.rest.pojo.TbItemDesc;

public interface TbItemDescService extends IService<TbItemDesc>{
	/**
	 * 根据itemId查询itemDesc
	 * @param 
	 * @return
	 */
	String selectById(Long itemId);
}
