package com.taotao.rest.service;
import java.util.List;

import com.taotao.rest.pojo.TbContent;

public interface TbContentService extends IService<TbContent>{
	/**
	 * 根据categoryId查询content
	 * 用于查询 轮播图
	 * @param categoryId
	 * @return
	 */
	public List<TbContent> selectByCategory(Long categoryId);
}
