package com.taotao.search.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.rest.vo.SearchResult;
import com.taotao.solr.service.ItemSearchService;

@Controller
public class ItemSearchController {
	@Autowired
	private ItemSearchService service;
	@Value("${SEARCH_ROWS}")
	private Integer SEARCH_ROWS ;
	
	@RequestMapping("/search.html")
	public ModelAndView search(String q,@RequestParam(required=false,defaultValue="1")Integer page) throws UnsupportedEncodingException{
		String query = new String(q.getBytes("iso8859-1"),"utf-8");
		SearchResult findBypage = service.findBypage(query, page, SEARCH_ROWS );
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/search");
		modelAndView.addObject("query", findBypage.getPage());
		modelAndView.addObject("itemList",findBypage.getItemList());
		modelAndView.addObject("query",	findBypage.getQuery());
		modelAndView.addObject("totalPages",findBypage.getTotalPages());
		
		return modelAndView;
	}
	
}
