package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryQuery;
import com.taotao.vo.EasyUITreeVo;

public interface TbContentCategroyService 
extends IService<TbContentCategory, TbContentCategoryQuery>{
	List<EasyUITreeVo> selectByParentId(long parentId);
	TbContentCategory add( Long parentId,String name);
	int delete(Long parentId,Long id);
}
