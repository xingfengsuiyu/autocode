package com.auto.generation.core.annotation;

import java.lang.annotation.*;

/**
 * ID注解
 *
 * @author zc
 * @create 2018-06-28 9:17
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableIdAnnotation {

	/**
	 * @return 主键名
	 */
	String value() default "ID";

	/**
	 * @return 长度
	 */
	int length();

	/**
	 * @return 描述
	 */
	String decription();

}
