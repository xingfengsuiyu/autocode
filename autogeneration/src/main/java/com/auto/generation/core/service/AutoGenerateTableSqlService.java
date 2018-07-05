package com.auto.generation.core.service;

import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;

import java.util.List;

/**
 * 自动生成数据库表Sql逻辑代码
 *
 * @author zc
 * @create 2018-06-28 17:43
 **/
public interface AutoGenerateTableSqlService {

	/**
	 * @param sql 执行sql语句
	 */
	void executeSql(String sql);

	/*
	 * @author zc
	 * @date 2018/6/28 16:46
	 * @param [tableName, databaseName]  表名，数据库名
	 * @return java.util.List<FieldProperty>
	 * @description 查询MYSQL表字段属性
	 */
	List<FieldProperty> queryTableFieldByMySql(String tableName, String databaseName);

	/*
	 * @author zc
	 * @date 2018/6/28 16:46
	 * @param [tableName, databaseName]  表名，数据库名
	 * @return java.util.List<FieldProperty>
	 * @description 查询ORACLE表字段属性
	 */
	List<FieldProperty> queryTableFieldByOracle(String tableName, String databaseName);

	/**
	 * @param databaseName
	 * @return 查找所有表名MYSQL
	 */
	List<TableProperty> queryAllTableByMySql(String databaseName);

	/**
	 * @param databaseName
	 * @return 查找所有表名ORACLE
	 */
	List<TableProperty> queryAllTableByOracle(String databaseName);

	/**
	 * @param tableName
	 * @return 查找表索引
	 */
	List<FieldIndexProperty> queryTableFieldIndexByMySql(String tableName);
}
