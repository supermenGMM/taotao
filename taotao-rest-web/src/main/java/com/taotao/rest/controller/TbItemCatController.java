package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.taotao.rest.bo.ItemCatResult;
import com.taotao.rest.service.TbItemCatService;
import com.taotao.util.JsonUtils;

@Controller
public class TbItemCatController {
	@Autowired
	private TbItemCatService itemCatService;
	
	/**
	 * 返回门户页面商品分类js--json
	 * @param callback
	 * @return
	 */
//	使用MappingJacksonValue对象包装返回结果，并设置jsonp的回调方法。也可以使用普通方式
	@RequestMapping(value="/rest/itemcat/all",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public MappingJacksonValue getCategroyJS(@RequestParam String callback){
		ItemCatResult result = itemCatService.getCategroyJsno();
//		包装jsonp
		MappingJacksonValue jacksonValue  = new MappingJacksonValue(result);
//		设置包装的回调方法
		jacksonValue.setJsonpFunction(callback);
		
		return jacksonValue;
		
	}
}
