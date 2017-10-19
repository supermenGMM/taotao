package com.taotao.item.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.taotao.constant.ActiveMQConstant;
import com.taotao.item.vo.Item;
import com.taotao.rest.pojo.TbItem;
import com.taotao.rest.service.TbItemDescService;
import com.taotao.rest.service.TbItemParamItemService;
import com.taotao.rest.service.TbItemService;
import com.taotao.util.FreeMarkerUtil;

import freemarker.template.TemplateException;

public class AddItemMessageListener implements MessageListener{
	private Logger LOG = Logger.getLogger(AddItemMessageListener.class);
	
	@Value(value="${BASE_PATH}")
	private String BASE_PATH;
	@Value(value="${TEMPLATE}")
	private String TEMPLATE;
	@Value("${OUT_PATH}")
	private String OUT_PATH;
	
	@Autowired
	private TbItemService itemService;
	@Autowired
	private TbItemDescService descService;
	@Autowired
	private TbItemParamItemService paramService;
	
	@Override
	public void onMessage(Message message) {
		try {
			LOG.info("item-web受到消息===========");
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Thread.sleep(1000);
			if(ActiveMQConstant.ADD_ITEM.toString().equals(text)){//如果是添加了item，添加模板
				long id = textMessage.getLongProperty("itemId");
				
//				1.创建数据集
				Map<Object, Object> map = new HashMap<>();
				TbItem tbItem = itemService.selectByPrimaryKey(id);
				Item item = new Item(tbItem);
				String itemDesc = descService.selectById(id);
				String param = paramService.selectByItemId(id);
				map.put("item", item);
				map.put("itemDesc", itemDesc);
				map.put("itemParam", param);
				map.put("query", "手机");
				//生成
				LOG.info("生成位置："+ OUT_PATH+"/"+id+".html");
				FreeMarkerUtil.generateHTMl(map, BASE_PATH, TEMPLATE, OUT_PATH+"/"+id+".html");
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
