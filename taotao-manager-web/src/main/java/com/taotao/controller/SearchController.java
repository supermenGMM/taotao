package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.solr.service.SearchService;
import com.taotao.util.TaotaoResult;

@Controller
public class SearchController {
	@Autowired
	private SearchService service ;
	
	@RequestMapping("/index/importall")
	@ResponseBody
	public TaotaoResult importAll(){
		return service.addDocument();
	}
}
