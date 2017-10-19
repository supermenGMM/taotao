package com.taotao.solr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.activemq.store.kahadb.FilteredKahaDBPersistenceAdapter;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.taotao.rest.vo.ItemSolrVo;
import com.taotao.rest.vo.SearchResult;

@Repository
public class ItemSearchDao {
	//solr中数据的域名
	@Value("${FIELD_ID}")
	private String FIELD_ID;
	@Value("${FIELD_ITEM_TITLE}")
	private String FIELD_ITEM_TITLE;
	@Value("${FIELD_ITEM_SELL_POINT}")
	private String FIELD_ITEM_SELL_POINT;
	@Value("${FIELD_ITEM_PRICE}")
	private String FIELD_ITEM_PRICE;
	@Value("${FIELD_ITEM_IMAGE}")
	private String FIELD_ITEM_IMAGE;
	@Value("${FIELD_ITEM_CATEGORY_NAME}")
	private String FIELD_ITEM_CATEGORY_NAME;
	@Value("${FIELD_ITEM_DESC}")
	private String FIELD_ITEM_DESC;
	
	@Autowired
	private SolrServer solrServer;
	public SearchResult fingByPage(SolrQuery query) throws SolrServerException{
		QueryResponse response= solrServer.query(query);
//		取出商品列表
		SolrDocumentList results = response.getResults();
		List<ItemSolrVo> itemList  = new ArrayList<>();
		for (SolrDocument solrDocument: results) {
			ItemSolrVo item = new ItemSolrVo();
			Long id = Long.parseLong((String) solrDocument.get(FIELD_ID));
			item.setId(id);
			item.setCatName((String)solrDocument.get(FIELD_ITEM_CATEGORY_NAME));
			item.setSellPoint((String) solrDocument.get(FIELD_ITEM_TITLE));
			String images = (String) solrDocument.get(FIELD_ITEM_IMAGE);
			
			item.setImage(getImage(images));
			item.setPrice( (Long) solrDocument.get(FIELD_ITEM_PRICE));
			
//			获取高亮
			String title = (String) solrDocument.get(FIELD_ITEM_TITLE);
			//获取高亮
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			if(null!=highlighting){
				Map<String, List<String>> map = highlighting.get(id);
				if(null!=map){
					title = map.get("item_title").get(0);
				}
			}
			
			item.setTitle(title);
			itemList.add(item);
		}
		
		SearchResult result = new SearchResult();
		result.setItemList(itemList);;
		long  totalPages= (long) Math.floor((results.getNumFound()*1.0/query.getRows()));
		result.setTotalPages(totalPages);
		return result;
		
	}
	private String getImage(String images) {
		String[] split = images.split(",");
		
		return split[0];
	}
	
	
	
}
