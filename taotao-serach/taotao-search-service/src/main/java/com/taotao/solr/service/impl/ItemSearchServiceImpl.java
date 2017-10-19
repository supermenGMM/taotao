package com.taotao.solr.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.rest.vo.SearchResult;
import com.taotao.solr.dao.ItemSearchDao;
import com.taotao.solr.service.ItemSearchService;
@Service(value="itemSearchService")
public class ItemSearchServiceImpl implements ItemSearchService{
	@Autowired
	private ItemSearchDao dao ;
	@Override
	public SearchResult findBypage(String q, Integer page, Integer rows) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(q);
		solrQuery.set("df", "item_keywords");
		
		solrQuery.setStart((page-1)*rows);
		solrQuery.setRows(rows);
		
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("item_title");
		solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
		solrQuery.setHighlightSimplePost("</em>");
		
		
		SearchResult fingByPage = null;
		try {
			fingByPage = dao.fingByPage(solrQuery);
			fingByPage.setQuery(q);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return fingByPage;
	}
}
