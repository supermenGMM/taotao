package com.user.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.pojo.TbItem;
import com.taotao.service.TbItemCatService;
import com.taotao.service.TbItemService;
import com.taotao.vo.PageListVo;
import com.taotao.vo.EasyUITreeVo;

public class ItemCatTest {
	private Logger logger = Logger.getLogger(ItemCatTest.class);
	private String resource = "spring/spring.xml";
	private ApplicationContext context;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
		logger.warn(this.getClass()+"---log  test");
	}
	/*@Test
	public void item(){
		 TbItemCatService bean = (TbItemCatService) context.getBean("tbItemCatService");
		 List<TbItemCatVo> findTreeList = bean.findTreeList(0);
		 System.out.println(findTreeList.size()+"--");
		 for (TbItemCatVo tbItemCatVo : findTreeList) {
			System.out.println(tbItemCatVo);
		}
	}*/
}
