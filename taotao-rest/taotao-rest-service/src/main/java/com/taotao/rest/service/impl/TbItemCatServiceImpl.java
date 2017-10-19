package com.taotao.rest.service.impl;

import java.util.LinkedList;

import java.util.List;

import com.taotao.rest.bo.CategroyBo;
import com.taotao.rest.bo.ItemCatResult;
import com.taotao.rest.pojo.TbItemCat;
import com.taotao.rest.service.TbItemCatService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class TbItemCatServiceImpl extends BaseService<TbItemCat> implements TbItemCatService {

	@Override
	public ItemCatResult getCategroyJsno() {
		List<CategroyBo> sons = getSons(0);
		ItemCatResult catResult = new ItemCatResult();
		catResult.setData(sons);
		return catResult;

	}
/**
 * 递归获取所有子类型
 * @param parentId
 * @return
 */
	private List getSons(long parentId) {
		Example example = new Example(TbItemCat.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("parentId", parentId);
		List<TbItemCat> tbItemCats = myMapper.selectByExample(example);

		// 创建categroyBo集合
		List list = new LinkedList();
		for (TbItemCat tbItemCat : tbItemCats) {
			// 格式："u": "/products/1.html",
			String url = "/products/" + tbItemCat.getId() + ".html";
//			如果不是父节点。那么urls就为  "/products/3.html|电子书"=url+|+name
			if(tbItemCat.getIsParent()){
				
				CategroyBo categroyBo = new CategroyBo();
				categroyBo.setUrl(url);
				// 格式："n": "<a href='/products/1.html'>图书、音像、电子书刊</a>",
				categroyBo.setTarger("<a href='" + url + "'>" + tbItemCat.getName() + "</a>");
				categroyBo.setUrls(getSons(tbItemCat.getId()));
				list.add(categroyBo);
			}else{
				list.add(url+"|"+tbItemCat.getName());
			}
		}
		return list;
	}
}
