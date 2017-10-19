package com.consumer.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.pojo.TbContent;
import com.taotao.service.TbContentService;
import com.taotao.vo.PageListVo;

public class ContentTest {
	private String resource = "spring/spring-mvc.xml";
	private ApplicationContext context;
	TbContentService bean;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
		 bean = (TbContentService) context.getBean("tbContentService");
		System.out.println("-----------------"+bean);
	}
	
	@Test
	public void test(){
		/*TbContent record = new TbContent();
		record.setContent("缴费");
		record.setCategoryId(105L);
		bean.insert(record );*/
		int deletBatchByIds = bean.deletBatchByIds(new Long[]{40L});
		System.out.println("++++=============="+deletBatchByIds);
	}
	@Test
	public void test2(){
		PageListVo<TbContent> findByPage = bean.findByPage(1, 3,89L);
		System.out.println("-------------"+findByPage.getTotal());
		List<TbContent> rows = findByPage.getRows();
		for (TbContent tbContent : rows) {
			System.out.println("-----------"+tbContent);
		}
	}
}
