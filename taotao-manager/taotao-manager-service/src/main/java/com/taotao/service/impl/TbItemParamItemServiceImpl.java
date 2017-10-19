package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.dao.TbItemParamItemDao;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemQuery;
import com.taotao.service.TbItemParamItemService;

public class TbItemParamItemServiceImpl extends BaseService<TbItemParamItem, TbItemParamItemQuery> 
implements TbItemParamItemService{
	@Autowired
	private TbItemParamItemDao tbItemParamItemDao;
	@Override
	public TbItemParamItem selectByItemId(Long itemId) {
		return tbItemParamItemDao.selectByItemId(itemId);
	}
}
