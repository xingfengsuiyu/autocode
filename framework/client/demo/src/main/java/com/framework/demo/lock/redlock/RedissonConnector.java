package com.framework.demo.lock.redlock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取redissonClient链接类
 *
 * @author zc
 * @create 2018-07-22 16:23
 **/
@Component
public class RedissonConnector {
	RedissonClient redissonClient;
	@PostConstruct
	public void init() {
		redissonClient = Redisson.create();
	}

	public RedissonClient getRedissonClient() {
		return redissonClient;
	}
}
