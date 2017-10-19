package com.user.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.dao.TbItemParamDao;
import com.taotao.po.ItemParamVo;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamQuery;
import com.taotao.pojo.TbItemUpdatePo;
import com.taotao.service.TbItemParamService;
import com.taotao.service.TbItemService;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;

public class ItemTest {
	private Logger logger = Logger.getLogger(ItemTest.class);
	private String resource = "spring/spring.xml";
	private ApplicationContext context;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext(resource);
		logger.warn(this.getClass() + "---log  test");
	}

	@Test
	public void item() {
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		PageListVo<TbItem> findByPage = bean.findByPage(1, 10);
		// logger.info("findBypage---size:"+findByPage.getRows().size()+"",new
		// Throwable("分页错误") );
		System.out.println(findByPage.getTotal());
		System.out.println(findByPage.getRows());
	}

	@Test
	public void itemsave2() {
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TbItem item = new TbItem();
		item.setNum(2);
		item.setCid(3L);
		item.setImage("fdf");
		item.setPrice(33L);
		item.setSellPoint("就是好");
		item.setTitle("title");
		item.setBarcode("333");

		bean.insert(item, "就好");

	}

	@Test
	public void itemUpdate() {
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TbItem item = new TbItem();
		item.setId(536563L);
		item.setStatus((byte) 2);
		bean.updateByPrimaryKeySelective(item);

	}

	@Test
	public void itemUpdateStatus() {
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TaotaoResult result = bean.updateStatusByPrimaryKeySelectiveList(new Long[] { 536563L, 562379L, 605616L },
				(byte) 2);
		logger.info(result);

	}

	@Test
	public void itemdeleteIds() {
		TbItemService bean = (TbItemService) context.getBean("tbItemService");
		TbItemUpdatePo itemUpdatePo = new TbItemUpdatePo();
		itemUpdatePo.setIds(new Long[] { 150760557612237L, 150760572650042L, 150760616924457L });
		bean.deleteByIds(itemUpdatePo);

	}

	@Test
	public void itemParamQuery() {
		TbItemParamService itemParamService = (TbItemParamService) context.getBean("itemParamService");
		/*
		 * TbItem item = bean.selectByPrimaryKey(988834L);
		 * 
		 * TbItemParamQuery example = new TbItemParamQuery(); Criteria criteria
		 * = example.createCriteria();
		 * criteria.andItemCatIdEqualTo(item.getCid()); List<TbItemParam>
		 * itemParams = itemParamService.selectByExample(example);
		 * System.out.println(itemParams);
		 * 
		 */

		// TbItemParam selectByPrimaryKey =
		// itemParamService.selectByPrimaryKey(560L);
		// System.out.println(selectByPrimaryKey);

		/*TbItemParamQuery example = new TbItemParamQuery();
		TbItemParam record = new TbItemParam();
		record.setItemCatId(560L);*/
		// itemParamService.selectByExample(new TbItemParamQuery());
//		TbItemParam selectByItemCatId = itemParamService.selectByItemCatId(560L);
//		logger.info(selectByItemCatId+"===============");
		TbItemParamDao bean = (TbItemParamDao) context.getBean("tbItemParamDao");
		
		List<ItemParamVo> selectItemParamVo = bean.selectItemParamVo(new TbItemParamQuery());
		logger.info(selectItemParamVo);
	}
	@Test
	public void itemParamcrud() {
		
		TbItemParamService itemParamService = (TbItemParamService) context.getBean("itemParamService");
		//		int delteBatchByIds = itemParamService.delteBatchByIds(new Long[]{27L});
//		增加
		/*TbItemParam record =  new TbItemParam();
		record.setItemCatId(560L);
		record.setParamData("fdasfd");
		Date date = new Date();
		
		record.setCreated(date );
		record.setUpdated(date);
		itemParamService.insert(record);*/
		//查询
		PageListVo<ItemParamVo> findByPage = itemParamService.findByPage(1, 10);
		logger.warn(findByPage.getTotal());
		for (ItemParamVo vo: findByPage.getRows()) {
			
			logger.warn(vo);
		}
	}

}
