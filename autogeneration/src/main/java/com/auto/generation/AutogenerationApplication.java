package com.auto.generation;

import com.auto.generation.core.ApplicationStartup;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.auto.generation.core.mapper")
public class AutogenerationApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AutogenerationApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
		//SpringApplication.run(AutogenerationApplication.class, args);
	}
}
