package com.taotao.jedis;

public interface JedisClient {

	String set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	/**
	 * 在seconds秒后删除key
	 * @param key
	 * @param seconds
	 * @return
	 */
	Long expire(String key, int seconds);
	/**获取存活时间
	 * @see
	 * 没有设置expire时间的默认ttl是-1.如果设置了expire，但是到期的，ttl值为-2
		意味着：ttl 为-2的key，代表这个key不存在
		ttl为-1的key，代表这个key一直存活（只要不关闭服务）
	 * @param key
	 * @return
	 */
	Long ttl(String key);
	Long incr(String key);
	Long hset(String key, String field, String value);
	String hget(String key, String field);
	Long hdel(String key, String... field);
}
