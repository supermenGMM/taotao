package com.taotao.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	private Logger LOG = Logger.getLogger(PageController.class);
	/*@RequestMapping("/index")
	public String login(String username,String password){
		
		return "/index";
	}*/
	@RequestMapping("/page/{path}")
	public String add(@PathVariable String path){
		LOG.info("path:"+path);
		return "/"+path;
	}
}
