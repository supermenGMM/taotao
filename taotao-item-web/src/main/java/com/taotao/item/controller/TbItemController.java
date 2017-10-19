package com.taotao.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.item.vo.Item;
import com.taotao.rest.pojo.TbItem;
import com.taotao.rest.service.TbItemDescService;
import com.taotao.rest.service.TbItemParamItemService;
import com.taotao.rest.service.TbItemService;
import com.taotao.util.TaotaoResult;
import com.taotao.util.exception.MyException;

@Controller
public class TbItemController {
	@Autowired
	private TbItemService itemService;
	@Autowired
	private TbItemDescService descService;
	@Autowired
	private TbItemParamItemService paramService;

	@RequestMapping(value = "item/{itemId}.html")
	public ModelAndView item(@PathVariable Long itemId) {
		TbItem tbitem = itemService.selectByPrimaryKey(itemId);
		Item item =new Item(tbitem);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", item);
		modelAndView.setViewName("/item");
		return modelAndView;
	}

	@RequestMapping(value = "/item/desc/{itemId}.html")
	@ResponseBody
	public String itemdesc(@PathVariable Long itemId) {
		String desc = descService.selectById(itemId);
		if(null!=desc){
			return desc;
		}else{
			TaotaoResult.error(new MyException("商品描述为空,item_id="+itemId));
		}
		return "";
	}
	//
	@RequestMapping(value = "/item/param/{itemId}.html",produces={"text/html; charset=UTF-8"} )
	@ResponseBody
	public String itemPram(@PathVariable Long itemId) {
		String param = paramService.selectByItemId(itemId);
		if(null!=param){
			
			return param;
		}else{
			TaotaoResult.error(new MyException("商品规格为空,item_id="+itemId));
		}
		return "";
	}
}
