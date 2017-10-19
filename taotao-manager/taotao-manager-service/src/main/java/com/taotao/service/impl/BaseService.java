package com.taotao.service.impl;


import java.util.List;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.taotao.dao.BaseDao;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserQuery;
import com.taotao.service.IService;
import com.taotao.util.TaotaoResult;

public class BaseService<T,W> implements IService<T,W>{
	@Autowired
	protected JmsTemplate JmsTemplate;
	@Autowired
	protected ActiveMQQueue queue;
	@Autowired
	protected ActiveMQTopic topic;
	
	@Autowired
	protected BaseDao<T,W> baseDao;

	@Override
	public int countByExample(W example) {
		return baseDao.countByExample(example);
	}

	@Override
	public int deleteByExample(W example) {
		return baseDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return baseDao.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return baseDao.insertSelective(record);
	}

	@Override
	public List<T> selectByExample(W example) {
		return baseDao.selectByExample(example);
	}

	@Override
	public T selectByPrimaryKey(Long id) {
		return this.baseDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(T record, W example) {
		return baseDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(T record, W example) {
		return baseDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
			
			return baseDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return baseDao.updateByPrimaryKey(record);
	}
	
	
}
