package com.taotao.rest.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.jedis.JedisClientPool;
import com.taotao.rest.pojo.TbItemDesc;
import com.taotao.rest.service.TbItemDescService;
import com.taotao.util.JsonUtils;

@Service(value="tbItemDescService")
public class TbItemDescServiceImpl extends BaseService<TbItemDesc> implements TbItemDescService{
	@Autowired
	private JedisClientPool JedisClientPool; 
	/**
	 * 根据id查询itemDesc
	 * @param 
	 * @return
	 */
	@Override
	public String selectById(Long itemId) {
		//从redis取
		try {
			String descStr = JedisClientPool.get("item:"+itemId+"desc");
			if(null!=descStr){
				TbItemDesc desc = JsonUtils.jsonToPojo(descStr, TbItemDesc.class);
				return desc.getItemDesc();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//从数据库获取
		TbItemDesc desc = myMapper.selectByPrimaryKey(itemId);
		
		//存到redis
		try {
			JedisClientPool.set("item:"+itemId+":desc", JsonUtils.objectToJson(desc));
			JedisClientPool.expire("item:"+itemId+":desc", 60*60*60*24);//缓存一天
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return desc.getItemDesc();
	}
	
	
}
