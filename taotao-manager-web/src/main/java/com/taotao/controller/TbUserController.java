package com.taotao.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.taotao.service.TbUserService;

@Controller
public class TbUserController {
	private Logger LOG = Logger.getLogger(TbUserController.class);
	
	@Autowired
	private TbUserService tbUserService;
	
	
}
