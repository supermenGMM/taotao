package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbItemUpdatePo;
import com.taotao.pojo.TbUser;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;

public interface TbItemService extends IService<TbItem, TbItemQuery>{
	public PageListVo<TbItem> findByPage(int page,int rows);
	TaotaoResult insert(TbItem record,String desc);
	/**
	 * 根据id批量跟新status
	 * @param ids
	 * @param status
	 * @return
	 */
	TaotaoResult updateStatusByPrimaryKeySelectiveList(Long[] ids, byte status);
	/**
	 * 批量删除
	 * @param itemUpdatePo
	 * @return
	 */
	TaotaoResult deleteByIds(TbItemUpdatePo itemUpdatePo);
	
	
}
