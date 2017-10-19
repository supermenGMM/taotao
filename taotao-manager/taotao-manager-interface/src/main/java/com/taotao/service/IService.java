package com.taotao.service;

import java.util.List;

import com.taotao.util.TaotaoResult;

public interface IService<T,W> {
    int countByExample(W example);

    int deleteByExample(W example);

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(W example);

    T selectByPrimaryKey(Long id);

    int updateByExampleSelective(T record, W example);

    int updateByExample( T record, W example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
	
}
