package com.auto.generation.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表字段自定义注解类
 *
 * @author zc
 * @create 2018-06-27 10:31
 * 自定义注解
 *@Documented:指明该注解可以用于生成doc
 *@Inherited：该注解可以被自动继承
 *@Retention:指明在什么级别显示该注解：
 *  RetentionPolicy.SOURCE 注解存在于源代码中，编译时会被抛弃
RetentionPolicy.CLASS 注解会被编译到class文件中，但是JVM会忽略
RetentionPolicy.RUNTIME JVM会读取注解，同时会保存到class文件中
 @Target:指明该注解可以注解的程序范围
 ElementType.TYPE 用于类，接口，枚举但不能是注解
 ElementType.FIELD 作用于字段，包含枚举值
 ElementType.METHOD 作用于方法，不包含构造方法
 ElementType.PARAMETER 作用于方法的参数
 ElementType.CONSTRUCTOR 作用于构造方法
 ElementType.LOCAL_VERIABLE 作用于本地变量或者catch语句
 ElementType.ANNOTATION_TYPE 作用于注解
 ElementType.PACKAGE 作用于包
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableFieldAnnotation {

	/**
	 * @return 字段名
	 */
	String name();

	/**
	 * @return 字段长度
	 */
	int length();

	/**
	 * @return 小数位
	 */
	int decimalPlaces() default 2;
	/**
	 * @return 是否允许为空 ，NOT NULL不允许，默认为NULL
	 */
	String isNull() default "NULL";

	/**
	 * @return 默认值
	 */
	String defaultValue() default "NULL";

	/**
	 * @return 字段描述
	 */
	String description();
}
