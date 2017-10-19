package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbContentCategory;
import com.taotao.service.TbContentCategroyService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.EasyUITreeVo;

@Controller
@RequestMapping("/content/category")
public class TbContentCategoryController 
{
	@Autowired
	private TbContentCategroyService service;
	@RequestMapping("/list")
	@ResponseBody
	List<EasyUITreeVo> list(@RequestParam(required = false,defaultValue="0") Long id){
		return service.selectByParentId(id);
	}
	
	/**
	 * 插入数据。并将新增的category的id返回
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/create")
	@ResponseBody
	TaotaoResult create(@RequestParam Long parentId,@RequestParam String name){
		TbContentCategory add = service.add(parentId, name);
		return TaotaoResult.ok(add);
	}
		
	@RequestMapping("/update")
	@ResponseBody
	TaotaoResult update(Long id,String name){
		TbContentCategory record = new TbContentCategory();
		record.setId(id);
		record.setName(name);
		service.updateByPrimaryKeySelective(record );
		return TaotaoResult.ok();
	}
	
	//根据id删除。
	@RequestMapping("/delete")
	@ResponseBody
	TaotaoResult delete(Long parentId,Long id){
		service.delete(parentId, id);
		return TaotaoResult.ok();
		
	}
}
