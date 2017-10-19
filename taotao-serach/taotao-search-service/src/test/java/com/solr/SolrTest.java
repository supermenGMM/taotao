package com.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public class SolrTest {
	@Value(value="${SOLR_URL}")
	private String SOLR_URL ="http://192.168.55.133:8080/solr";
	@Test
	public void addDocument() throws SolrServerException, IOException{
		/*步骤
		 * 1.把solr的jar包添加到工程中
		 * 2.创建一个solrServer。使用HttpSolrServer创建对象
		 * 3.创建一个文档对象SolrInputDocument
		 * 4.向稳定中添加域。必须有id。域的名称必须在schema.xml中定义
		 */
		SolrServer server = new HttpSolrServer(SOLR_URL);
		List<SolrInputDocument> docs = new ArrayList<>();
		int i = 0;
		while(i<100) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", "test"+i);
			document.addField("item_title", "title"+i);
			document.addField("item_desc", "desc"+i);
			document.addField("item_sell_point", "title,"+"name"+",title");
			docs.add(document);
			i++;
		}
		server.add(docs );
		server.commit();
	}
	@Test
	public void delByid() throws SolrServerException, IOException{
		SolrServer solrServer = new HttpSolrServer(SOLR_URL);
		solrServer.deleteById("test01");
		solrServer.commit();
	}
	
	/*
	 * 根据查询删除
	 */
	@Test
	public void delByQuery() throws SolrServerException, IOException{
		SolrServer server = new HttpSolrServer(SOLR_URL);
		server.deleteByQuery("*:*");
		server.commit();
	}
	
	//查询索引库
	/*
	 * 1.创建solrServer
	 * 2.创建solrQuery
	 * 3.通过solrServer查询获取QueryResponse
	 * 4.获取结果集
	 * 5.编辑结果集
	 */
	@Test
	public void query() throws SolrServerException{
		SolrServer solrServer = new HttpSolrServer(SOLR_URL);
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		QueryResponse response =solrServer.query(query);
		SolrDocumentList results = response.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
		}
	}
	
	@Test
	public void queryWithHightLighting() throws SolrServerException{
		//
		SolrServer server = new HttpSolrServer(SOLR_URL);
		SolrQuery query = new SolrQuery();
		///3.想query中添加查询条件、过滤条件
		query.setQuery("desc");
		//设置默认搜索域
		query.set("df", "item_keywords");
		//设置高亮显示
		query.setHighlight(true);
		//高亮的域
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font color='red'><em>");
		query.setHighlightSimplePost("</em></font>");
		QueryResponse query2 = server.query(query);
		SolrDocumentList results = query2.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.print(solrDocument.getFieldValue("id")+",");
			Map<String, Map<String, List<String>>> highlighting = query2.getHighlighting();
			List<String> list = null;
			if(null!=highlighting&&0!=highlighting.size()){
				list = highlighting.get(solrDocument.get("id")).get("item_title");
			}
			String item_title  = null;
			if(null!=list&&0!=list.size()){
				item_title= list.get(0);
			}else{
				item_title=(String) solrDocument.get("item_title");
			}
			
			System.err.print(item_title);
			System.out.println();
		}
	}
}
