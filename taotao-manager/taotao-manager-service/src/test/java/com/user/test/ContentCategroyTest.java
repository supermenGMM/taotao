package com.user.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.pojo.TbContentCategory;
import com.taotao.service.TbContentCategroyService;
import com.taotao.service.TbContentService;
import com.taotao.service.impl.TbContentServiceImpl;
import com.taotao.vo.EasyUITreeVo;

public class ContentCategroyTest {
	private String resource = "spring/spring.xml";
	private ApplicationContext context;
	TbContentCategroyService bean;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
		 bean = (TbContentCategroyService) context.getBean("tbContentCategroyService");
		
	}
	
	@Test
	public void test(){
		 
		TbContentCategroyService bean = (TbContentCategroyService) context.getBean("tbContentCategroyService");
		List<EasyUITreeVo> selectByParentId = bean.selectByParentId(96);
		System.out.println("------------------"+selectByParentId.size()+"----------------");
		for (EasyUITreeVo easyUITreeVo : selectByParentId) {
			System.out.println("------"+easyUITreeVo);
		}
	}
	
	@Test
	public void test2(){
		TbContentCategroyService bean = (TbContentCategroyService) context.getBean("tbContentCategroyService");
		TbContentCategory add = bean.add(99L, "首页轮播");
		System.out.println("=========="+add);
	}
	@Test
	public void test3(){
		bean.delete(98L, 100L);
		bean.delete(99L, 102L);
		
	}
	@Test
	public void test4(){
		bean.delete(98L, 101L);
		
	}
}
