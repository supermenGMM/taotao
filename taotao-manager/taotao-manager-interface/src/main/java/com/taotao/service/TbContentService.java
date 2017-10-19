package com.taotao.service;

import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentQuery;
import com.taotao.vo.PageListVo;

public interface TbContentService extends IService<TbContent, TbContentQuery>{
	int deletBatchByIds(Long[] ids);

	PageListVo<TbContent> findByPage(Integer page, Integer rows, Long categoryId);
}
