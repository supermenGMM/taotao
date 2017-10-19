package com.taotao.rest.service;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface IService<T> {

	
	List<T> selectByRowBounds(T record, RowBounds rowBounds);

	
	List<T> selectAll();

	
	int updateByExample(T record, Object example);

	
	int insert(T record);

	
	int updateByPrimaryKey(T record);

	
	List<T> select(T record);

	
	List<T> selectByExample(Object example);

	
	int deleteByPrimaryKey(Object key);

	
	List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	
	int selectCountByExample(Object example);

	
	int delete(T record);

	
	int insertSelective(T record);

	
	int updateByExampleSelective(T record, Object example);

	
	T selectOne(T record);

	
	int deleteByExample(Object example);

	
	int selectCount(T record);

	
	int insertList(List<T> recordList);

	
	T selectByPrimaryKey(Object key);

	
	int insertUseGeneratedKeys(T record);

	
	int updateByPrimaryKeySelective(T record);

}
