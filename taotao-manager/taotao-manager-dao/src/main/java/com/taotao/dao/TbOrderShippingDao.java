package com.taotao.dao;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderShipping;
import com.taotao.pojo.TbOrderShippingQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderShippingDao extends BaseDao<TbOrderShipping,TbOrderShippingQuery> {
    int countByExample(TbOrderShippingQuery example);

    int deleteByExample(TbOrderShippingQuery example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShippingQuery example);

    TbOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingQuery example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingQuery example);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}