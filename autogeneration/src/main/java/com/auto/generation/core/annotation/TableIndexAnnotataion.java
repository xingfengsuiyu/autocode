package com.auto.generation.core.annotation;

import java.lang.annotation.*;

/**
 * 索引注解
 *
 * @author zc
 * @create 2018-07-03 10:55
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableIndexAnnotataion {

	/**
	 * @return 索引名称
	 */
	String idxName();

	/**
	 * @return 字段名称
	 */
	String name();

	/**
	 * @return 索引类型
	 */
	String idxType();

	/**
	 * @return 索引方法
	 */
	String idxMethod() default "BTREE";

	/**
	 * @return 索引注释
	 */
	String idxDescript();
}
