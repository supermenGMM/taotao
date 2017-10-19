package com.taotao.rest.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.taotao.jedis.JedisClientPool;
import com.taotao.rest.pojo.TbContent;
import com.taotao.rest.service.TbContentService;
import com.taotao.util.JsonUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class TbContentServiceImpl extends BaseService<TbContent> implements TbContentService {
	private Logger logger = Logger.getLogger(TbContentServiceImpl.class);
	@Resource(name="JedisClientPool")
	private JedisClientPool jedisClient;

	@Value("${INDEX_CONTENT}")
	private String INDEX_CONTENT;
	
	@Override
	public List<TbContent> selectByCategory(Long categoryId) {
		/*
		 * 三步走 1.从换从中读取，有return。没有执行2 2.从数据库获取 3.将数据库数据存入缓存
		 */

		// 1.
		try {
			String hget = jedisClient.hget(INDEX_CONTENT, categoryId + "");
			if(hget!=null){
				List<TbContent> jsonToList = JsonUtils.jsonToList(hget, TbContent.class);
				logger.info("使用缓存");
				return jsonToList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("没有使用缓存");
		// 2.
		Example example = new Example(TbContent.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("categoryId", categoryId);
		List<TbContent> list = myMapper.selectByExample(example);

		// 3
		try {
			jedisClient.hset(INDEX_CONTENT, categoryId + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
