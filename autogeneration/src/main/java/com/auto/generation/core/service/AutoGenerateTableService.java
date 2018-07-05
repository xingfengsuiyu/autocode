package com.auto.generation.core.service;


import com.auto.generation.core.table.TableProperty;

import java.util.List;

/**
 * @param
 * @author zc
 * @date 2018/6/26 16:31
 * @return
 * @description 自动生成数据库表类
 */
public interface AutoGenerateTableService {

	/*
	 * @author zc
	 * @date 2018/6/28 15:21
	 * @param []
	 * @return void
	 * @description  自动生成表
	 */
	void generationTable();

	/**
	 * @param
	 * @return
	 * @author zc
	 * @date 2018/6/26 16:31
	 * @description 扫描实体类的包获取所有实体类
	 */
	List<Class<?>> scanPack(String packageName);

	/**
	 * @param
	 * @param classList
	 * @param mysql
	 * @return
	 * @author zc
	 * @date 2018/6/26 16:32
	 * @description 扫描实体类获取所有实体类的字段属性
	 */
	List<TableProperty> scanModel(List<Class<?>> classList, String mysql);

	/**
	 * @param [tablePropertyList, databaseType, generationMethod]
	 * @return java.lang.String
	 * @author zc
	 * @date 2018/6/28 14:59
	 * @description 生成SQL语句
	 */
	String generationSql(List<TableProperty> tablePropertyList, String databaseType, String generationMethod);

	/*
	 * @author zc
	 * @date 2018/6/28 11:25
	 * @param [tablePropertyList, databaseType]
	 * @return java.lang.String
	 * @description 生成sql建表语句
	 */
	String generationCreateSql(List<TableProperty> tablePropertyList, String databaseType);

	/*
	 * @author zc
	 * @date 2018/6/28 11:25
	 * @param [tablePropertyList, databaseType]
	 * @return java.lang.String
	 * @description 生成sql更新语句,有字段则不变，新增字段则新增，实体中删除的字段则数据库删除
	 */
	String generationUpdateSql(List<TableProperty> tablePropertyList, String databaseType);

	/**
	 * @param
	 * @return
	 * @author zc
	 * @date 2018/6/26 16:32
	 * @description 根据实体类的字段属性生成创建SQL表语句 MYSQL
	 */
	String generationCreateSqlByMySQL(List<TableProperty> tablePropertyList);

	/*
	 * @author zc
	 * @date 2018/6/28 11:16
	 * @param [tablePropertyList]
	 * @return java.lang.String
	 * @description 根据实体类的字段属性生成创建SQL表语句 ORACLE
	 */
	String generationCreateSqlByOracle(List<TableProperty> tablePropertyList);

}
