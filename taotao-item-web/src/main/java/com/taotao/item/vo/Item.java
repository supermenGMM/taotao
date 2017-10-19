package com.taotao.item.vo;

import com.taotao.rest.pojo.TbItem;

public class Item extends TbItem{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Item(TbItem tbItem) {
		this.setBarcode(tbItem.getBarcode());
		this.setCid(tbItem.getCid());
		this.setCreated(tbItem.getCreated());
		this.setId(tbItem.getId());
		this.setImage(tbItem.getImage());
		this.setNum(tbItem.getNum());
		this.setSellPoint(tbItem.getSellPoint());
		this.setNum(tbItem.getNum());
		this.setStatus(tbItem.getStatus());
		this.setTitle(tbItem.getTitle());
		this.setUpdated(tbItem.getUpdated());
		this.setPrice(tbItem.getPrice());
	}
	
	public String[] getImg() {
		if(null!=super.getImage()&&""!=super.getImage()){
			String[] split = super.getImage().split(",");
			return split;
		}
		return null;
	}
}
