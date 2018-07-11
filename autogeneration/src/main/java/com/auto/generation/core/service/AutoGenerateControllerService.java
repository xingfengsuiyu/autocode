package com.auto.generation.core.service;

import java.util.List;

/**
 * @author zc
 * @date 2018/7/9 20:19
 * @description  自动生成Controller
 */
public interface AutoGenerateControllerService {

	/**
	 * @author zc
	 * @date 2018/7/10 19:29
	 * @param [classList] 所有带注解的实体类
	 * @return void
	 * @description 自动生成Controller类
	 */
	public void generateController(List<Class<?>> classList);
}
