package com.user.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserQuery;
import com.taotao.service.TbItemService;
import com.taotao.service.TbUserService;
import com.taotao.vo.PageListVo;

public class UserTest {
	private String resource = "spring/spring.xml";
	private ApplicationContext context;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(resource );
	}
	
	@Test
	public void test(){
		TbUserService bean = (TbUserService) context.getBean("tbUserService");
		List<TbUser> selectByExample = bean.selectByExample(new TbUserQuery());
		for (TbUser tbUser : selectByExample) {
			System.out.println(tbUser);
		}
		
	}
}
