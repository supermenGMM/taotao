/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mybatis.test;

import java.util.HashSet;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Created by liuzh on 2015/3/7.
 */
public class JedisTest extends BasicTest {
	/**
	 * jedis客户端集群测试
	 */
	@Test
	public void testJedisCluster(){
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.55.131", 7001));
		nodes.add(new HostAndPort("192.168.55.131", 7002));
		nodes.add(new HostAndPort("192.168.55.131", 7003));
		nodes.add(new HostAndPort("192.168.55.131", 7004));
		nodes.add(new HostAndPort("192.168.55.131", 7005));
		nodes.add(new HostAndPort("192.168.55.131", 7006));
		JedisCluster cluster  = new JedisCluster(nodes);
		cluster.set("key1", "你好");
		String string = cluster.get("key1");
		
		System.out.println(string);
		cluster.close();
	}
	
	/*
	 * 单机redis和spring整合的测试
	 */
	/*@Autowired
	private JedisPool jedisPool;
	@Test
	public void testRedisSpring(){
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get("key1");
		System.out.println("========="+string);
		
	}
*/
	/**
	 * redis-cluster和spring整合的测试
	 */
/*	@Autowired
	private JedisCluster cluster;
	@Test
	public void testJedisClueter(){
		cluster.set("a", "aaaa");
		System.out.println("-0--------------------"+cluster.get("a"));
	}*/
}
