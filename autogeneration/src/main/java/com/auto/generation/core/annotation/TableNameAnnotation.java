package com.auto.generation.core.annotation;

import java.lang.annotation.*;

/**
 * 表类名注解类
 *
 * @author zc
 * @create 2018-06-27 10:56
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableNameAnnotation {

	/**
	 * @return 表名
	 */
	String value();

	/**
	 * @return 字符编码
	 */
	String character() default "UTF8";
}
