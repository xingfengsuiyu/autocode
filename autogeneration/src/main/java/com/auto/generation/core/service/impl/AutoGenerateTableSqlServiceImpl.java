package com.auto.generation.core.service.impl;

import com.auto.generation.core.mapper.AutoGenerateTableMapper;
import com.auto.generation.core.service.AutoGenerateTableSqlService;
import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自动生成表结构实现类
 *
 * @author zc
 * @create 2018-06-28 17:45
 **/
@Service
public class AutoGenerateTableSqlServiceImpl implements AutoGenerateTableSqlService{

	@Autowired
	private AutoGenerateTableMapper autoGenerateTableMapper;
	/**
	 * @param sql 执行sql语句
	 */
	@Override
	public void executeSql(String sql) {
		autoGenerateTableMapper.executeSql(sql);
	}

	/**
	 * @param tableName
	 * @param databaseName
	 * @return 查询MYSQL表字段属性，除主键
	 */
	@Override
	public List<FieldProperty> queryTableFieldByMySql(String tableName, String databaseName) {
		return autoGenerateTableMapper.queryTableFieldByMySql(tableName,databaseName);
	}

	/**
	 * @param tableName
	 * @param databaseName
	 * @return 查询ORACLE表字段属性，除主键
	 */
	@Override
	public List<FieldProperty> queryTableFieldByOracle(String tableName, String databaseName) {
		return autoGenerateTableMapper.queryTableFieldByOracle(tableName,databaseName);
	}

	@Override
	public List<TableProperty> queryAllTableByMySql(String databaseName) {
		return autoGenerateTableMapper.queryAllTableByMySql(databaseName);
	}

	@Override
	public List<TableProperty> queryAllTableByOracle(String databaseName) {
		return autoGenerateTableMapper.queryAllTableByOracle(databaseName);
	}

	/**
	 * @param tableName
	 * @return 查找表索引
	 */
	@Override
	public List<FieldIndexProperty> queryTableFieldIndexByMySql(String tableName) {
		return autoGenerateTableMapper.queryTableFieldIndexByMySql(tableName);
	}

}
