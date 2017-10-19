package com.taotao.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemUpdatePo;
import com.taotao.service.TbItemDescService;
import com.taotao.service.TbItemService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;

@Controller
public class TbItemController {
	private Logger logger = Logger.getLogger(TbItemController.class);
	@Resource(name = "tbItemService")
	private TbItemService tbItemService;

	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult add(TbItem tbItem, String desc) {
		return tbItemService.insert(tbItem, desc);
	}

	/**
	 * item/cat/list 查询所有类型 返回json数据。
	 */

	/**
	 * item/list 查询所有商品 返回json
	 */

	@RequestMapping("/item/list")
	@ResponseBody
	public PageListVo<TbItem> list(Integer page, Integer rows) {
		PageListVo<TbItem> findByPage = tbItemService.findByPage(page, rows);
		return findByPage;
	}

	/**
	 * 下架instock、上架reshelf
	 */
	@RequestMapping("/rest/item/{operation}")
	@ResponseBody
	public TaotaoResult updateStatus(Long[] ids, @PathVariable String operation) {

		byte status = 1;
		if (operation.equals("instock")) {
			status = 2;
		}
		logger.warn("operation:" + operation + ".status:" + status);
		return tbItemService.updateStatusByPrimaryKeySelectiveList(ids, status);

	}

	@RequestMapping(value = "/rest/item/delete")
	@ResponseBody
	public TaotaoResult delete(Long[] ids) {
		TbItemUpdatePo itemUpdatePo = new TbItemUpdatePo();
		itemUpdatePo.setIds(ids);
		return tbItemService.deleteByIds(itemUpdatePo);

	}

	/**
	 * 页面跳转到item-edit.jsp
	 * 
	 * @param tbItem
	 * @return
	 */
	@RequestMapping(value = "/rest/page/item-edit")
	public String edit() {
		return "/item-edit";
	}

	/**
	 * 更新tbitem
	 */
	@RequestMapping(value = "/rest/item/update")
	@ResponseBody
	public TaotaoResult update(TbItem tbItem) {

		try {
			tbItemService.updateByPrimaryKeySelective(tbItem);
			return TaotaoResult.ok();
		} catch (Exception e) {
			return TaotaoResult.build(500, "更新失败");
		}
	}

}
