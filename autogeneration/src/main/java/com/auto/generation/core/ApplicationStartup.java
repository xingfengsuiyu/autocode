package com.auto.generation.core;

import com.auto.generation.core.service.AutoGenerateTableService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 启动完成加载类
 *
 * @author zc
 * @create 2018-07-03 17:46
 **/
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent>{
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		AutoGenerateTableService autoGenerateTableService = contextRefreshedEvent.getApplicationContext().getBean(AutoGenerateTableService.class);
		autoGenerateTableService.generationTable();
	}
}
