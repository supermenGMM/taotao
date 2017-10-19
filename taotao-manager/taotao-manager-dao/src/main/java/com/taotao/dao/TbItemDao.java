package com.taotao.dao;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbItemUpdatePo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemDao extends BaseDao<TbItem,TbItemQuery>{
    int countByExample(TbItemQuery example);

    int deleteByExample(TbItemQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemQuery example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    /**
     * 批量更新状态
     * @param itemUpdatePo
     * @return
     */
	int updateStatusBatch(TbItemUpdatePo itemUpdatePo);
	
	/**
	 * 批量删除
	 * @param itemUpdatePo
	 * @return
	 */
	int deleteByIds(TbItemUpdatePo itemUpdatePo);
	
}