package com.taotao.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbContent;
import com.taotao.service.TbContentService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;

@Controller
@RequestMapping("/content")
public class TbContentController {
	@Autowired
	private TbContentService service;

	@RequestMapping(value = "/query/list")
	@ResponseBody
	public PageListVo<TbContent> list(@RequestParam(required = false, defaultValue = "1") Integer page, Integer rows,
			@RequestParam(required=false,defaultValue="0") Long categoryId) {
		PageListVo<TbContent> pageListVo = service.findByPage(page, rows,categoryId);
		return pageListVo;

	}
	/*
	 * /content-add TaotaoResult add(TbContent tbcontent)
	 */

	@RequestMapping(value = "/delete")
	@ResponseBody
	public TaotaoResult delete(Long[] ids) {
		int deletCount = service.deletBatchByIds(ids);
		
		return TaotaoResult.ok(deletCount);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public TaotaoResult save(TbContent content){
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		service.insert(content);
		return TaotaoResult.ok();
	}
}
