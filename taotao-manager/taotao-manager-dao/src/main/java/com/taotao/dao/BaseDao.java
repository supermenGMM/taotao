package com.taotao.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BaseDao<T,W> extends Serializable{
	   int countByExample(W example);

	    int deleteByExample(W example);

	    int deleteByPrimaryKey(Long id);

	    int insert(T record);

	    int insertSelective(T record);

	    List<T> selectByExample(W example);

	    T selectByPrimaryKey(Long id);

	    int updateByExampleSelective(@Param("record") T record, @Param("example") W example);

	    int updateByExample(@Param("record") T record, @Param("example") W example);

	    int updateByPrimaryKeySelective(T record);

	    int updateByPrimaryKey(T record);
}
