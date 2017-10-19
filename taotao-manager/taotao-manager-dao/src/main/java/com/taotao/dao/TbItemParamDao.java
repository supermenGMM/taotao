package com.taotao.dao;

import com.taotao.po.ItemParamVo;
import com.taotao.po.TbItemParamDeltePo;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamDao extends BaseDao<TbItemParam,TbItemParamQuery>{
    int countByExample(TbItemParamQuery example);

    int deleteByExample(TbItemParamQuery example);

    int deleteByPrimaryKey(Long id);
    
    int delteBatchByIds(TbItemParamDeltePo deletePo);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    List<TbItemParam> selectByExampleWithBLOBs(TbItemParamQuery example);

    List<TbItemParam> selectByExample(TbItemParamQuery example);

    TbItemParam selectByPrimaryKey(Long id);
    
    TbItemParam selectByItemCatId(Long itemCatId);

    List<ItemParamVo> selectItemParamVo(TbItemParamQuery example);
    
    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamQuery example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParamQuery example);

    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamQuery example);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);
}