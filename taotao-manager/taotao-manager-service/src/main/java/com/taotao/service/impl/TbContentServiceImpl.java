package com.taotao.service.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentQuery;
import com.taotao.service.TbContentService;
import com.taotao.vo.PageListVo;

public class TbContentServiceImpl 
extends BaseService<TbContent, TbContentQuery> 
implements TbContentService{

	private static Logger logger = Logger.getLogger(TbContentService.class);
	@Override
	public int deletBatchByIds(Long[] ids) {
		int del = 0;
		logger.info("ids.length"+ids.length+"---------");
		for (Long id : ids) {
			logger.info(id+"-------------");
			del+=baseDao.deleteByPrimaryKey(id);
		}
		return del;
	}
	@Override
	public PageListVo<TbContent> findByPage(Integer page, Integer rows,Long categoryId) {
		TbContentQuery query = new TbContentQuery();
		query.createCriteria().andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<TbContent> list = baseDao.selectByExample(query);
		
		PageListVo<TbContent> pageListVo = new PageListVo<>();
		pageListVo.setRows(list);
		
		pageListVo.setTotal(((int)((Page<TbContent>)list).getTotal()));
		return pageListVo;
	}
	
	
}
