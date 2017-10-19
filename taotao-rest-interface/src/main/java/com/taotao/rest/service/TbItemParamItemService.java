package com.taotao.rest.service;
import com.taotao.rest.pojo.TbItemParamItem;

public interface TbItemParamItemService extends IService<TbItemParamItem>{
	/**
	 * 根据itemId查询itemParam
	 * @param 
	 * @return
	 */
	String selectByItemId(Long itemId);
}
