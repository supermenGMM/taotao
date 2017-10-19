package com.taotao.rest.mapper;

import java.util.List;

import com.taotao.rest.mapper.util.MyMapper;
import com.taotao.rest.pojo.TbItem;
import com.taotao.rest.vo.ItemSolrVo;

public interface TbItemMapper extends MyMapper<TbItem> {
	List<ItemSolrVo> findBysolr();//查询所有

	ItemSolrVo findBysolrByItemId(Long itemId);//根据id查找
}