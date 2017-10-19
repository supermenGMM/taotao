package com.taotao.solr.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.taotao.rest.mapper.TbItemMapper;
import com.taotao.rest.vo.ItemSolrVo;
import com.taotao.solr.service.SearchService;
import com.taotao.util.TaotaoResult;

public class SearchServiceImpl implements SearchService {
	@Autowired
	private TbItemMapper mapper;
	@Value("${SOLR_URL}")
	private String SOLR_URL;

	// 域名
	/*
	 * FIELD_ID=id FIELD_ITEM_TITLE=item_title
	 * FIELD_ITEM_SELL_POINT=item_sell_point FIELD_ITEM_PRICE=item_price
	 * FIELD_ITEM_IMAGE=item_image FIELD_ITEM_CATEGORY_NAME=item_category_name
	 * FIELD_ITEM_DESC =item_desc
	 */
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

	@Override
	public TaotaoResult addDocument() {
		List<ItemSolrVo> findBysolr = mapper.findBysolr();

		SolrServer server = null;
		try {
			server = new HttpSolrServer(SOLR_URL);
			List<SolrInputDocument> documentList = new ArrayList<>();
			for (ItemSolrVo item : findBysolr) {

				SolrInputDocument document = new SolrInputDocument();
				document.addField(FIELD_ID, item.getId());
				document.addField(FIELD_ITEM_TITLE, item.getTitle());
				document.addField(FIELD_ITEM_PRICE, item.getPrice());
				document.addField(FIELD_ITEM_SELL_POINT, item.getSellPoint());
				document.addField(FIELD_ITEM_IMAGE, item.getImage());
				document.addField(FIELD_ITEM_CATEGORY_NAME, item.getCatName());
				document.addField(FIELD_ITEM_DESC, item.getDesc());

				documentList.add(document);

			}
			server.add(documentList);
			return TaotaoResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.error(e);
		} finally {
			if (server != null) {

				try {
					server.commit();
				} catch (SolrServerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public TaotaoResult addIndexById(Long itemId) {
		ItemSolrVo item = mapper.findBysolrByItemId(itemId);
		if(item==null)return TaotaoResult.error("查找不到符合条件的item");
		SolrServer server = null;
		try {
			server = new HttpSolrServer(SOLR_URL);

			SolrInputDocument document = new SolrInputDocument();
			document.addField(FIELD_ID, item.getId());
			document.addField(FIELD_ITEM_TITLE, item.getTitle());
			document.addField(FIELD_ITEM_PRICE, item.getPrice());
			document.addField(FIELD_ITEM_SELL_POINT, item.getSellPoint());
			document.addField(FIELD_ITEM_IMAGE, item.getImage());
			document.addField(FIELD_ITEM_CATEGORY_NAME, item.getCatName());
			document.addField(FIELD_ITEM_DESC, item.getDesc());

			server.add(document);
			return TaotaoResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.error(e);
		} finally {
			if (server != null) {

				try {
					server.commit();
				} catch (SolrServerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
