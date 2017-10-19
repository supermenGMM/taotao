package com.taotao.solr.service;

import com.taotao.rest.vo.SearchResult;

public interface ItemSearchService {
	SearchResult	findBypage(String q,Integer page,Integer rows) ;//根据条件分页查询
}
