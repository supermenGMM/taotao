package com.taotao.rest.service;
import com.taotao.rest.bo.ItemCatResult;
import com.taotao.rest.pojo.TbItemCat;
public interface TbItemCatService extends IService<TbItemCat>{
	public ItemCatResult getCategroyJsno();
}
