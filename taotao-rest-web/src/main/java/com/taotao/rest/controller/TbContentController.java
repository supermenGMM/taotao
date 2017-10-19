package com.taotao.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.rest.pojo.TbContent;
import com.taotao.rest.service.TbContentService;
import com.taotao.rest.vo.ADVo;
import com.taotao.util.JsonUtils;

@Controller
public class TbContentController {
	@Resource(name="tbContentService")
	private TbContentService service;

	@Value("${AD1_CID}")
	private Long AD1_CID;
	@Value("${AD1_HEIGHT}")
	private Integer AD1_HEIGHT;
	@Value("${AD1_WIDTH}")
	private Integer AD1_WIDTH;
	@Value("${AD1_HEIGHT_B}")
	private Integer AD1_HEIGHT_B;
	@Value("${AD1_WIDTH_B}")
	private Integer AD1_WIDTH_B;

	@RequestMapping(value = "/index")
	public String getAd(Model model) {

		List<TbContent> list = service.selectByCategory(AD1_CID);

		// 创建页面显示广告的集合 因为只用于添加所以用linklist
		List<ADVo> adList = new ArrayList<>();
		for (TbContent content : list) {
			ADVo adVo = new ADVo();
			adVo.setAlt(content.getSubTitle());
			adVo.setHeight(240);
			adVo.setHeigthB(240);
			adVo.setHref(content.getUrl());
			adVo.setSrc(content.getPic());
			adVo.setSrcB(content.getPic2());
			adVo.setWidth(670);
			adVo.setWidth(550);
			adList.add(adVo);
		}
		String json = JsonUtils.objectToJson(adList);
		model.addAttribute("ad1",json);
		return "/index";
	}
}
