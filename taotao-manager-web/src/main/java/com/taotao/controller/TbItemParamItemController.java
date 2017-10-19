package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.TbItemParamItemService;
import com.taotao.util.TaotaoResult;

@Controller
public class TbItemParamItemController {
	@Autowired
	private TbItemParamItemService itemParamItemService;
	
	@RequestMapping(value="/rest/item/param/item/query/{id}")
	@ResponseBody
	public TaotaoResult find(@PathVariable long id){
		
		try {
			TbItemParamItem itemParamItem = itemParamItemService.selectByItemId(id);
			return TaotaoResult.ok(itemParamItem);
		} catch (Exception e) {
			return TaotaoResult.build(500, "没有param或者param个数不止一个");
		}
		
	}
	
}
