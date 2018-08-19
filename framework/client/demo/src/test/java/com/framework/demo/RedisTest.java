package com.framework.demo;

import com.framework.common.redis.RedisUtil;
import com.framework.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zc
 * @create 2018-08-19 16:53
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisTest {
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void redisTest(){
		redisTemplate.opsForValue().set("test:set","testValue1");

		redisUtil.set("redutil","redutil");
	}
}
