package com.consumer.test;

import java.util.List;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.page.PageHandler;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbUser;
import com.taotao.service.TbItemCatService;
import com.taotao.service.TbItemParamItemService;
import com.taotao.service.TbItemParamService;
import com.taotao.service.TbItemService;
import com.taotao.service.TbUserService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.EasyUITreeVo;

public class ConsumerTest {
	
	private ApplicationContext context;
	private Logger logger = Logger.getLogger(ConsumerTest.class);
	private static final String resource = "spring/spring-mvc.xml";
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
	}
	
	@Test
	public void test()
	{
		TbUserService bean = (TbUserService) context.getBean("tbUserService");
		TbUser tbUser = bean.selectByPrimaryKey(7L);
		System.out.println(tbUser);
	}
	@Test
	public void test2()
	{
		TbItemService	 bean = (TbItemService) context.getBean("tbItemService");
		bean.findByPage(1, 10);
		TbItem item 
		= new TbItem();
		item.setNum(2);
		item.setCid(3L);
		item.setImage("fdf");
		item.setPrice(33L);
		item.setSellPoint("就是好");
		item.setTitle("title");
		item.setBarcode("333");
		
		bean.insert(item, "就好");
//		System.out.println(findByPage);
	}
	@Test
	public void test3()
	{
		TbItemCatService bean = (TbItemCatService) context.getBean("tbItemCatService");
		List<EasyUITreeVo> findTreeList = bean.findTreeList(0);
		
	}
	
	@Test
	public void itemUpdateStatus(){
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TaotaoResult result = bean.updateStatusByPrimaryKeySelectiveList(new Long[]{536563L,562379L,605616L}, (byte)2);
		System.out.println(result);
		
	}
	@Test
	public void querItemParamItem(){
		 TbItemParamItemService bean = (TbItemParamItemService) context.getBean("tbItemParamItemService");
		
		 TbItemParamItem selectByItemId = bean.selectByItemId(536563L);
		 System.out.println("---------------------"+selectByItemId);
		
	}
	@Test
	public void querItemParam(){
		TbItemParamService itemService = (TbItemParamService) context.getBean("tbItemParamService");
		 TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TbItem item = bean.selectByPrimaryKey(988834L);
		TbItemParam itemParam = itemService.selectByItemCatId(item.getCid());	
		logger .info(itemParam);
	}
}
