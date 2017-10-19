/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mybatis.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.bo.CategroyBo;
import com.taotao.rest.mapper.TbItemCatMapper;
import com.taotao.rest.pojo.TbItemCat;
import com.taotao.rest.service.TbItemCatService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageMapperTest extends BasicTest {

//    @Autowired
//    private CountryMapper countryMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test(){
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	TbItemCatMapper mapper = sqlSession.getMapper(TbItemCatMapper.class);
    	Example example = new Example(TbItemCat.class);
    	Criteria criteria = example.createCriteria();
    	criteria.andEqualTo("parentId", 0);
    	List<TbItemCat> selectByExample = mapper.selectByExample(example);
    	for (TbItemCat tbItemCat : selectByExample) {
			System.out.println("-----------------"+tbItemCat);
		}
    	sqlSession.close();
    }
    @Resource(name="tbItemCatService")
    private TbItemCatService tbItemCatService;
    @Test
    public void test2()
    {
    }
}
