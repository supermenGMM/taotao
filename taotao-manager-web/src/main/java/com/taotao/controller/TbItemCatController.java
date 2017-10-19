package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.TbItemCatService;
import com.taotao.vo.EasyUITreeVo;

@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
	@Autowired
	private TbItemCatService tbItemcatSerivce;
	
	@RequestMapping(value="/list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<EasyUITreeVo> list(@RequestParam(defaultValue="0",required=false,name="id") Long parentId){
		return tbItemcatSerivce.findTreeList(parentId);
	}
}
