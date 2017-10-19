package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatQuery;
import com.taotao.vo.EasyUITreeVo;

public interface TbItemCatService  extends IService<TbItemCat, TbItemCatQuery> {
	List<EasyUITreeVo> findTreeList(long parentId);
}
