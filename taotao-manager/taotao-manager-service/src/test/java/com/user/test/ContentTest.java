package com.user.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.service.TbContentService;
import com.taotao.service.impl.TbContentServiceImpl;

public class ContentTest {
	private String resource = "spring/spring.xml";
	private ApplicationContext context;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
	}
	
	@Test
	public void test(){
		 
		TbContentService bean = (TbContentService) context.getBean("tbContentService");
		Long[] ids = {35L,36L};
		bean.deletBatchByIds(ids );
		
	}
}
