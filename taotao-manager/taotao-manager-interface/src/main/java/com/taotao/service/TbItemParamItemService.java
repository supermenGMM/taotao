package com.taotao.service;

import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemQuery;

public interface TbItemParamItemService extends IService<TbItemParamItem,TbItemParamItemQuery>{
	TbItemParamItem selectByItemId(Long itemId);
}
