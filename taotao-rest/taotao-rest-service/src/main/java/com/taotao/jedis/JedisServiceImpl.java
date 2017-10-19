package com.taotao.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.taotao.rest.service.JedisService;
import com.taotao.util.TaotaoResult;

public class JedisServiceImpl implements JedisService {
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT}")
	private String INDEX_CONTENT;
	
	@Override
	public TaotaoResult delete(Long id) {
		try {
			jedisClient.hdel(INDEX_CONTENT, id+"");
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "失败");
		}
		return TaotaoResult.ok();
	}

}
