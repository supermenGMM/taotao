package com.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.taotao.dao.TbContentDao;
import com.taotao.dao.TbUserDao;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserQuery;

public class MybatiesTes1 {
	
	private String resource = "mybaties/sqlMapConfig.xml";
	private SqlSession sqlsession;
	@Before
	public void before() throws IOException{
		InputStream in = Resources.getResourceAsStream(resource );
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		sqlsession = sqlSessionFactory.openSession();
	}
	@Test
	public void login(){
		System.out.println("----");
		TbUserDao userDao = sqlsession.getMapper(TbUserDao.class);
		TbUserQuery query1 =new TbUserQuery();
		query1.setDistinct(true);
		query1.setFields("username,password,id,email");
		query1.setOrderByClause("id");
		query1.setPageNo(1);
		query1.setStartRow(0);
		query1.setPageSize(5);
		
//		Criteria criteria = query1.createCriteria();
//		criteria.andEmailLike("%a%");
//		criteria.andUsernameLike("zhang%");
//		int countByExample = userDao.countByExample(query1);
		List<TbUser> selectByExample = userDao.selectByExample(query1);
		System.out.println(selectByExample.size()+"---");
		for (TbUser tbUser : selectByExample) {
			System.out.println(tbUser);
		}
//		System.out.println(countByExample);
		
		//		添加
		/*TbUser tbuser = new TbUser();
		tbuser.setUsername("赵meng");
		tbuser.setEmail("8524585501@qq.com");
		tbuser.setPassword("000");
		tbuser.setPhone("3335");
		tbuser.setCreated(new Date());
		tbuser.setUpdated(new Date());
		int insert = userDao.insert(tbuser);
		System.out.println(insert+"----");
		
		tbuser.setUsername("哈哈");
		tbuser.setPhone("3333");
		tbuser.setEmail("85245855021@qq.com");
		int insertSelective = userDao.insertSelective(tbuser);
		System.out.println(insertSelective);*/
		
	}
	@Test
	public void baseDaoTest(){
		TbUserDao userDao = sqlsession.getMapper(TbUserDao.class);
		TbUserQuery example = new TbUserQuery();
		PageHelper.startPage(2, 3);
		List<TbUser> selectByExample = userDao.selectByExample(example );
		for (TbUser tbUser : selectByExample) {
			System.out.println(tbUser);
		}
	}
	@Test
	public void contentTest(){
		TbContentDao mapper = sqlsession.getMapper(TbContentDao.class);
		TbContent record = new TbContent();
		record.setCategoryId(1L);
		record.setContent("ffff");
		record.setPic("22");;
		int insert = mapper.insert(record );
		System.out.println(record.getId());
	}
	
	@After
	public void after(){
		sqlsession.commit();
		sqlsession.close();
		
	}
}
