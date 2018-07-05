package com.auto.generation.core.mapper;

import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zc
 * @date 2018/6/26 17:06
 * @description  自动生成数据库表
 */
public interface AutoGenerateTableMapper {

	/**
	 * @param sql 执行sql
	 */
	void executeSql(@Param("sql")String sql);

	/**
	 * @param tableName
	 * @param databaseName
	 * @return 查询mysql 表字段属性除主键外
	 */
	List<FieldProperty> queryTableFieldByMySql(@Param("tableName")String tableName, @Param("databaseName")String databaseName);

	/**
	 * @param tableName
	 * @param databaseName
	 * @return 查询ORACLE 表字段属性除主键外
	 */
	List<FieldProperty> queryTableFieldByOracle(String tableName, String databaseName);

	/**
	 * @param databaseName
	 * @return 查找所有表名
	 */
	List<TableProperty> queryAllTableByMySql(@Param("databaseName") String databaseName);

	/**
	 * @param databaseName
	 * @return 查找所有表名
	 */
	List<TableProperty> queryAllTableByOracle(@Param("databaseName") String databaseName);

	/**
	 * @param tableName
	 * @return 查找表索引
	 */
	List<FieldIndexProperty> queryTableFieldIndexByMySql(@Param("tableName")String tableName);
}
