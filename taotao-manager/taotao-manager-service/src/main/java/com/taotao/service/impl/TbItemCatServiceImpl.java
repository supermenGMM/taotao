package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatQuery;
import com.taotao.pojo.TbItemCatQuery.Criteria;
import com.taotao.service.TbItemCatService;
import com.taotao.vo.EasyUITreeVo;

public class TbItemCatServiceImpl extends BaseService<TbItemCat,TbItemCatQuery> implements TbItemCatService{
	
	@Override
	public List<EasyUITreeVo> findTreeList(long parentId) {
		TbItemCatQuery example = new TbItemCatQuery();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = baseDao.selectByExample(example );
		
//		创建vo集合
		List<EasyUITreeVo> volist = new ArrayList<>();
		for (TbItemCat itemCat : list) {
			EasyUITreeVo tbItemCatVo = new EasyUITreeVo();
			tbItemCatVo.setId(itemCat.getId());
			tbItemCatVo.setText(itemCat.getName());
			tbItemCatVo.setState(itemCat.getIsParent()?"closed":"open");
			volist.add(tbItemCatVo);
		}
		return volist;
	}

}
