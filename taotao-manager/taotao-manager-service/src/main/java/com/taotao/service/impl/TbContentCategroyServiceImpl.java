package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryQuery;
import com.taotao.pojo.TbContentCategoryQuery.Criteria;
import com.taotao.service.TbContentCategroyService;
import com.taotao.vo.EasyUITreeVo;

public class TbContentCategroyServiceImpl 
extends BaseService<TbContentCategory, TbContentCategoryQuery>
implements TbContentCategroyService{

	/**
	 * 根据parentid查找
	 */
	@Override
	public List<EasyUITreeVo> selectByParentId(long parentId) {
		TbContentCategoryQuery example = new TbContentCategoryQuery();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> selectByExample = baseDao.selectByExample(example );
		
//		转为需要的数据类型
		List<EasyUITreeVo> list = new ArrayList<>();
		for (TbContentCategory category : selectByExample) {
			EasyUITreeVo treeVo = new EasyUITreeVo();
			treeVo.setId(category.getId());
			treeVo.setText(category.getName());
			treeVo.setState(category.getIsParent()?"closed":"open");
			list.add(treeVo);
		}
		
		return list;
	}

	@Override
	public TbContentCategory add(Long parentId, String name) {
		//添加category
		TbContentCategory record = new TbContentCategory();
		record.setParentId(parentId);
		record.setName(name);
		record.setStatus(1);
		record.setSortOrder(1);
		record.setIsParent(false);
		Date date = new Date();
		record.setCreated(date );
		record.setUpdated(date);
		
		baseDao.insert(record );
		
//		修改父节点的isParent
		TbContentCategory parent  =new TbContentCategory();
		parent.setId(parentId);
		parent.setIsParent(true);
		baseDao.updateByPrimaryKeySelective(parent);
		
		return record;
		
		
	}

	@Override
	public int delete(Long parentId, Long id) {
		
//		更新父节点
		//获取父节点所有的子节点个数
		TbContentCategoryQuery example = new TbContentCategoryQuery();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		int count = baseDao.countByExample(example);
		//子节点个数是1，就设为false
		if(count<=1){
			TbContentCategory parent = new TbContentCategory();
			parent.setId(parentId);
			parent.setIsParent(false);
			baseDao.updateByPrimaryKeySelective(parent );
		}
		
//		删除本节点
		return baseDao.deleteByPrimaryKey(id);
	
		
	}

}
