package com.taotao.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.po.ItemParamVo;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.TbItemParamItemService;
import com.taotao.service.TbItemParamService;
import com.taotao.service.TbItemService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;

@Controller
public class TbItemParamController {
	@Autowired
	private TbItemParamService itemParamService;
	@Autowired
	private TbItemService itemService;
	// 加载商品规格
	// /rest/item/param/item/query/
	// public TaotaoResult

	@RequestMapping(value = "/rest/item/param/query/{id}")
	@ResponseBody
	public TaotaoResult find(@PathVariable long id) {

		try {
			// 先查询出item，再通过item的cid查出itemParam
			TbItem item = itemService.selectByPrimaryKey(id);
			TbItemParam itemParam = itemParamService.selectByItemCatId(item.getCid());
			return TaotaoResult.ok(itemParam);
		} catch (Exception e) {
			return TaotaoResult.build(500, "没有param或者param个数不止一个");
		}

	}

	/**
	 * 分页查找 返回json数据，tbItemParam的集合
	 */
	@RequestMapping(value = "/item/param/list")
	@ResponseBody
	public PageListVo<ItemParamVo> list(Integer page, Integer rows) {
		try {
			return itemParamService.findByPage(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return null;// todo
		}

	}

	/**
	 * 通过cid查找ItemParam。并装载到taotaoResult.有返回200.没有返回其他
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/item/param/query/itemcatid/{cid}")
	public TaotaoResult queryItemcatId(@PathVariable Long cid) {
		try {
			TbItemParam itemParam = itemParamService.selectByItemCatId(cid);
			if (itemParam != null) {
				return TaotaoResult.ok(itemParam);
			} else {
				return TaotaoResult.build(400, "没有这个商品类型 的规格");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "服务器错误请重试");
		}

	}

	/**
	 * id自动递增. 保存.并设置update、create等其他属性。
	 * 
	 * @param cid
	 * @param paramData
	 * @return
	 */
	@RequestMapping(value = "/item/param/save/{cid}")
	@ResponseBody
	public TaotaoResult save(@PathVariable Long cid, @RequestParam String paramData) {
		try {
			TbItemParam record = new TbItemParam();
			record.setItemCatId(cid);
			record.setParamData(paramData);
			Date date = new Date();
			record.setUpdated(date);
			record.setCreated(date);
			itemParamService.insert(record);
			return TaotaoResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "服务器错误");
		}
	}

	/**
	 * 
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */

	@RequestMapping(value="/item/param/delete")
	@ResponseBody
	public TaotaoResult delete(Long[] ids) {
		
		itemParamService.delteBatchByIds(ids);
		return TaotaoResult.ok();
	}
	
	@RequestMapping("/item-param-add")
	public String toAdd(){
		return "/item-param-add";
	}
}
