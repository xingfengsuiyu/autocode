package com.auto.generation.core.enump;

/**
 * 数据库类型枚举类
 *
 * @author zc
 * @create 2018-06-27 13:38
 **/
public enum DataBaseTypeEnum {
	MySQL("MySQL"),Oracle("Oracle");

	private String name;

	private DataBaseTypeEnum(String name) {
		this.name = name;
	}

	@Override

	public String toString() {
		return String.valueOf(this.name);
	}
}
