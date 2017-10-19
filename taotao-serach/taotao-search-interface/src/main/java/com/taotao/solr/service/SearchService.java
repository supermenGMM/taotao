package com.taotao.solr.service;

import com.taotao.util.TaotaoResult;

public interface SearchService {
	/**
	 * 将所有的数据添加到solr.建立索引
	 * @return
	 */
	TaotaoResult addDocument();
	/**
	 * 像索引库中添加索引
	 * @return
	 */
	TaotaoResult addIndexById(Long itemId);
	
}
