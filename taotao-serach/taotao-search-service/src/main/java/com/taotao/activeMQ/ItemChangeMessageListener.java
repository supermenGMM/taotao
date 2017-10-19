package com.taotao.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.constant.ActiveMQConstant;
import com.taotao.solr.service.SearchService;

public class ItemChangeMessageListener implements MessageListener {
	private Logger LOG = Logger.getLogger(ItemChangeMessageListener.class);
	@Autowired
	private SearchService searchService;

	@Override
	public void onMessage(Message message) {
		LOG.info("active消费者接受到message");
		
		try {
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Thread.sleep(1000);
			if(ActiveMQConstant.ADD_ITEM.toString().equals(text)){
				Long itemId = textMessage.getLongProperty("itemId");
				LOG.info("itemId:"+itemId);
				searchService.addIndexById(itemId);
				
				message.acknowledge();
				
			}
		} catch (JMSException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
