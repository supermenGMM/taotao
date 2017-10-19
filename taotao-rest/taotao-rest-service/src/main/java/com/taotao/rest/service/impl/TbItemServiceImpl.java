package com.taotao.rest.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.jedis.JedisClientPool;
import com.taotao.rest.pojo.TbItem;
import com.taotao.rest.service.TbItemService;
import com.taotao.util.JsonUtils;

@Service(value="tbItemService")
public class TbItemServiceImpl extends BaseService<TbItem> implements TbItemService{
	
	@Autowired
	private JedisClientPool jedisPool;
	
	/**
	 * 根据id查询item
	 * @param 
	 * @return
	 */
	@Override
	public TbItem selectByPrimaryKey(Object key) {
		/*
		 * 从redis获取
		 */
		try {
			String itemstr = jedisPool.get("item:"+key+":base");
			if(null!=itemstr){
				TbItem item= JsonUtils.jsonToPojo(itemstr, TbItem.class);
				return item;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbItem item = myMapper.selectByPrimaryKey(key);
		
		/*
		 * 存到redis
		 */
		try {
			jedisPool.set("item:"+key+":base", JsonUtils.objectToJson(item));
			jedisPool.expire("item:"+key+":base", 60*60*60*24);//缓存一天
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return item;
	}
}
