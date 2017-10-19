package com.taotao.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.bo.ItemGroupBo;
import com.taotao.dao.TbItemParamDao;
import com.taotao.po.ItemParamVo;
import com.taotao.po.TbItemParamDeltePo;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamQuery;
import com.taotao.service.TbItemParamService;
import com.taotao.util.JsonUtils;
import com.taotao.vo.PageListVo;
@org.springframework.stereotype.Service(value="itemParamService")
public class TbItemParamServiceImpl extends BaseService<TbItemParam, TbItemParamQuery> implements TbItemParamService{
	@Autowired
	private TbItemParamDao itemParamDao;
	@Override
	public TbItemParam selectByItemCatId(Long id) {
		return itemParamDao.selectByItemCatId(id);
	}
	@Override
	public int delteBatchByIds(Long[] ids) {
		if(ids.length==1){
			return itemParamDao.deleteByPrimaryKey(ids[0]);
		}
		TbItemParamDeltePo deletePo = new TbItemParamDeltePo();
		deletePo.setIds(ids);
		int delteBatchByIds = itemParamDao.delteBatchByIds(deletePo );
		return delteBatchByIds;
	}
	/**
	 * 分页查找
	 */
	@Override
	public PageListVo<ItemParamVo> findByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<ItemParamVo> list = itemParamDao.selectItemParamVo(new TbItemParamQuery());
		
//		处理dataParam。只显示group
		/*for (ItemParamVo itemParamVo : list) {
			String paramData = itemParamVo.getParamData();
			if(paramData!=null){
				List<ItemGroupBo> jsonToList = JsonUtils.jsonToList(paramData, ItemGroupBo.class);
				StringBuilder groups = new StringBuilder("");
				for (ItemGroupBo itemGroupBo : jsonToList) {
					groups.append(itemGroupBo.getGroup()+"");
				}
				itemParamVo.setParamData(groups.toString().replace("\uFEFF", ""));
			}
		}
		*/
//		创建pageListVo
		PageListVo<ItemParamVo> pageListVo = new PageListVo<>();
		pageListVo.setRows(list);
		long total = ((Page<ItemParamVo>)list).getTotal();
		pageListVo.setTotal((int)total);//传入总数
		return pageListVo;
	}
	
}
