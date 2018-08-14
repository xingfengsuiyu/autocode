package com.framework.user.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 *
 * @author zc
 * @create 2018-08-14 20:36
 **/
@RestController
public class HelloWorldTest {

	@RequestMapping("/hello")
	public String helloWorld(String str) {
		return "Hello World" + str;
	}
}
