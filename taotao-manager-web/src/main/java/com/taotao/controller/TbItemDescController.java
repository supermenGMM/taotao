package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItemDesc;
import com.taotao.service.TbItemDescService;
import com.taotao.util.TaotaoResult;

@Controller
public class TbItemDescController {
	@Resource(name="tbItemDescService")
	private TbItemDescService tbItemDescServie;
//	获取商品描述
	@RequestMapping(value="/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public TaotaoResult find(@PathVariable long itemId){
		TbItemDesc tbDesc = tbItemDescServie.selectByPrimaryKey(itemId);
		return  TaotaoResult.ok(tbDesc);
	}
}
