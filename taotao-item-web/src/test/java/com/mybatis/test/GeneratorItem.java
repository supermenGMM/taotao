package com.mybatis.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.taotao.item.vo.Item;
import com.taotao.rest.pojo.TbItem;
import com.taotao.rest.service.TbItemDescService;
import com.taotao.rest.service.TbItemParamItemService;
import com.taotao.rest.service.TbItemService;
import com.taotao.util.FreeMarkerUtil;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class GeneratorItem extends BasicTest{
	@Autowired
	private FreeMarkerConfigurer  configurer;
	@Autowired
	private TbItemService itemService;
	@Autowired
	private TbItemDescService descService;
	@Autowired
	private TbItemParamItemService paramService;
	
	@Test
	public void test1() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		long id = 562379L;
		String template  = "item.ftl";
		
//		4.创建数据集
		Map<Object, Object> map = new HashMap<>();
		TbItem tbItem = itemService.selectByPrimaryKey(id);
		Item item = new Item(tbItem);
		String itemDesc = descService.selectById(id);
		String param = paramService.selectByItemId(id);
		map.put("item", item);
		map.put("itemDesc", itemDesc);
		map.put("itemParam", param);
		map.put("query", "手机");
		
		FreeMarkerUtil.generateHTMl(map, "src/main/webapp/WEB-INF/ftl",template, "src/main/webapp/WEB-INF/item/"+id+".html");
		
	}
	
}
