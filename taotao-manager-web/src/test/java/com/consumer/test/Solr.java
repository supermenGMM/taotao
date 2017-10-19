package com.consumer.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.solr.service.SearchService;

public class Solr {
	private String resource = "spring/spring-mvc.xml";
	private ApplicationContext context;
	SearchService bean;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
		 bean = (SearchService) context.getBean("searchService");
		System.out.println("-----------------"+bean);
	}
	
	@Test
	public void test()
	{
		System.out.println(bean);
	}
}
