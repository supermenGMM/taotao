package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.mapper.util.MyMapper;
import com.taotao.rest.service.IService;

public class BaseService<T> implements IService<T>{
	@Autowired
	protected MyMapper<T> myMapper;
	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		
		return myMapper.selectByRowBounds(record, rowBounds);
	}

	@Override
	public List<T> selectAll() {
		return myMapper.selectAll();
	}

	@Override
	public int updateByExample(T record, Object example) {
		// TODO Auto-generated method stub
		return myMapper.updateByExample(record, example);
	}

	@Override
	public int insert(T record) {
		// TODO Auto-generated method stub
		return myMapper.insert(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return myMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<T> select(T record) {
		// TODO Auto-generated method stub
		return myMapper.select(record);
	}

	@Override
	public List<T> selectByExample(Object example) {
		// TODO Auto-generated method stub
		return myMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return myMapper.deleteByPrimaryKey(key);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return myMapper.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public int selectCountByExample(Object example) {
		// TODO Auto-generated method stub
		return myMapper.selectCountByExample(example);
	}

	@Override
	public int delete(T record) {
		// TODO Auto-generated method stub
		return myMapper.delete(record);
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return myMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(T record, Object example) {
		// TODO Auto-generated method stub
		return myMapper.updateByExampleSelective(record, example);
	}

	@Override
	public T selectOne(T record) {
		// TODO Auto-generated method stub
		return myMapper.selectOne(record);
	}

	@Override
	public int deleteByExample(Object example) {
		// TODO Auto-generated method stub
		return myMapper.deleteByExample(example);
	}

	@Override
	public int selectCount(T record) {
		// TODO Auto-generated method stub
		return myMapper.selectCount(record);
	}

	@Override
	public int insertList(List<T> recordList) {
		// TODO Auto-generated method stub
		return myMapper.insertList(recordList);
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(key);
	}

	@Override
	public int insertUseGeneratedKeys(T record) {
		// TODO Auto-generated method stub
		return myMapper.insertUseGeneratedKeys(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return myMapper.updateByPrimaryKeySelective(record);
	}

}
