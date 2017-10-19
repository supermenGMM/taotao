package com.taotao.service;

import com.taotao.po.ItemParamVo;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamQuery;
import com.taotao.vo.PageListVo;

public interface TbItemParamService extends IService<TbItemParam, TbItemParamQuery>{
	 TbItemParam selectByItemCatId(Long id);
	 int delteBatchByIds(Long[] ids);
	 PageListVo<ItemParamVo> findByPage(Integer page,Integer rows);
}
