package com.solr;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.mapper.TbItemMapper;
import com.taotao.rest.vo.ItemSolrVo;
import com.taotao.rest.vo.SearchResult;
import com.taotao.solr.service.ItemSearchService;
import com.taotao.solr.service.SearchService;

public class SearchServiceTest extends BasicTest{
	@Autowired
	private TbItemMapper mapper;
	@Test
	public void test1()
	{
		List<ItemSolrVo> findBysolr = mapper.findBysolr();
		System.err.println("0------------------"+findBysolr.size()+"");
		
	}
	
	@Autowired
	private SearchService service;
	@Test
	public void test(){
//		service.addDocument();
		service.addIndexById(562379L);
	}
	
	@Autowired
	private ItemSearchService itemSearchService;
	@Test
	public void test2(){
		SearchResult findBypage = itemSearchService.findBypage("手机", 1, 10);
		List<ItemSolrVo> itemList = findBypage.getItemList();
		for (ItemSolrVo itemSolrVo : itemList) {
			System.out.println("-----------"+itemSolrVo);
		}
	}
}
