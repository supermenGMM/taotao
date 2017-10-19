package com.taotao.service.impl;

import java.util.Date;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.constant.ActiveMQConstant;
import com.taotao.dao.TbItemDao;
import com.taotao.dao.TbItemDescDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbItemUpdatePo;
import com.taotao.service.TbItemService;
import com.taotao.util.IDUtils;
import com.taotao.util.TaotaoResult;
import com.taotao.vo.PageListVo;
@Service("tbItemService")
public class TbItemServiceImpl extends BaseService<TbItem, TbItemQuery> implements TbItemService {
	private Logger logger = Logger.getLogger(TbItemService.class);
	@Autowired
	private TbItemDescDao tbItemDescDao;
	@Autowired
	private TbItemDao tbItemDao;
	@Override
	public PageListVo<TbItem> findByPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItem> list = baseDao.selectByExample(new TbItemQuery());

		// PageInfo<TbItem> pageInfo = new PageInfo<>(list);

		PageListVo<TbItem> pageVo = new PageListVo<>();
		pageVo.setRows(list);

		// 获取数
		long total = ((Page<TbItem>) list).getTotal();
		pageVo.setTotal((int) total);
		return pageVo;
	}

	@Override
	public TaotaoResult insert(TbItem record, String desc) {
//		现存record。
		//1.获取id
		final long genItemId = IDUtils.genItemId();
		record.setId(genItemId);
		record.setStatus((byte) 1);
		Date date = new Date();
		record.setCreated(date);
		record.setUpdated(date);
		baseDao.insert(record);

		
//		添加商品详情
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(genItemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		int insert = tbItemDescDao.insert(itemDesc);
		logger.info("insert:---itemid-"+insert);
		
//		activeMQ通知消费者像solr中添加索引
		JmsTemplate.send(topic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage(ActiveMQConstant.ADD_ITEM.toString());
				message.setLongProperty("itemId", genItemId);
				return message;
			}
		});
		
		return TaotaoResult.ok();
	}

	/**
	 * 更新商品的状态
	 * @param ids 商品id数组
	 * @param status 要改成什么状态  1，正常2，下架 3.删除
	 * @return TaotaoResule类型。返回状态
	 */
	@Override
	public TaotaoResult updateStatusByPrimaryKeySelectiveList(Long[] ids,byte status) {
		if(ids.length==1){
			TbItem tbItem = new TbItem();
			tbItem.setId(ids[0]);
			tbItem.setStatus(status);
			baseDao.updateByPrimaryKeySelective(tbItem);
			return TaotaoResult.ok();
		}
		TbItemUpdatePo tbItemUpdatePo = new TbItemUpdatePo();
		tbItemUpdatePo.setIds(ids);
		tbItemUpdatePo.setStatus(status);
		tbItemDao.updateStatusBatch(tbItemUpdatePo);
		
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteByIds(TbItemUpdatePo itemUpdatePo) {
		 int deleteByIds = tbItemDao.deleteByIds(itemUpdatePo);
		 if(deleteByIds>0){
			 return TaotaoResult.ok();
		 }else{
			 return TaotaoResult.build(500, "抱歉！删除错误，请重试");
		 }
	}

}
