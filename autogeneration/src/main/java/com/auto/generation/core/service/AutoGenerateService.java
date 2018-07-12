package com.auto.generation.core.service;

import java.util.List;

/**
 * @author zc
 * @date 2018/7/9 19:19
 * @description  自动生成service类
 */
public interface AutoGenerateService {

	/***
	 * @author zc
	 * @date 2018/7/12 19:38
	 * @param [classList]
	 * @return void
	 * @description 自动生成Service
	 */
	public void generateSevice(List<Class<?>> classList);
}
