package com.auto.generation.core.service.impl;

import com.auto.generation.core.conf.TableConfig;
import com.auto.generation.core.enump.DataBaseTypeEnum;
import com.auto.generation.core.mapper.AutoGenerateTableMapper;
import com.auto.generation.core.service.AutoGenerateTableService;
import com.auto.generation.core.service.AutoGenerateTableSqlService;
import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;
import com.auto.generation.core.util.GenerateSqlByMySqlUtil;
import com.auto.generation.core.util.GenerateSqlByOracleUtil;
import com.auto.generation.core.util.ScanAnnoUtil;
import com.auto.generation.core.util.ScanPackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc
 * @date 2018/6/26 17:07
 * @description 自动生成数据库表
 */
@Service
public class AutoGenerateTableServiceImpl implements AutoGenerateTableService {

	@Autowired
	private TableConfig tableConfig;

	@Autowired
	private AutoGenerateTableMapper autoGenerateTableMapper;

	@Autowired
	private AutoGenerateTableSqlService autoGenerateTableSqlService;

	/**
	 * 自动生成表
	 */
	@Override
	@Transactional
	public void generationTable() {
		if ("true".equalsIgnoreCase(tableConfig.getGenerationMethod())) {
			List<Class<?>> classList = this.scanPack(tableConfig.getModelPack());
			List<TableProperty> tablePropertyList = this.scanModel(classList, tableConfig.getDatabaseType());
			String sql = this.generationSql(tablePropertyList, tableConfig.getDatabaseType(), "update");
			if (sql != null && !"".equals(sql)) {
				autoGenerateTableSqlService.executeSql(sql);
			}
		}
	}

	/**
	 * @param packageName
	 * @return 扫描实体类包，返回包下的所有实体类
	 */
	@Override
	public List<Class<?>> scanPack(String packageName) {
		return ScanPackUtil.getClassesByPackages(packageName);
	}

	/**
	 * @param classList
	 * @param databaseType
	 * @return 解析所有实体类的注解字段，返回数据库表属性及表字段属性
	 */
	@Override
	public List<TableProperty> scanModel(List<Class<?>> classList, String databaseType) {
		return ScanAnnoUtil.scanEntityAnno(classList, databaseType);
	}

	/**
	 * @param tablePropertyList 表属性字段属性
	 * @param databaseType      数据库类型
	 * @param generationMethod  生成方式，CREATE,UPDATE
	 * @return 生成SQL语句
	 */
	@Override
	public String generationSql(List<TableProperty> tablePropertyList, String databaseType, String generationMethod) {
		if ("create".equalsIgnoreCase(generationMethod)) {
			return this.generationCreateSql(tablePropertyList, databaseType);
		} else if ("update".equalsIgnoreCase(generationMethod)) {
			return this.generationUpdateSql(tablePropertyList, databaseType);
		}
		return null;
	}

	/**
	 * @param tablePropertyList
	 * @param databaseType
	 * @return 生成Sql建表语句
	 */
	@Override
	public String generationCreateSql(List<TableProperty> tablePropertyList, String databaseType) {
		if (DataBaseTypeEnum.MySQL.name().equalsIgnoreCase(databaseType)) {
			return this.generationCreateSqlByMySQL(tablePropertyList);
		} else if (DataBaseTypeEnum.Oracle.name().equalsIgnoreCase(databaseType)) {
			return this.generationCreateSqlByOracle(tablePropertyList);
		}
		return null;
	}

	/**
	 * @param tablePropertyList 循环数据库字段列表生成创建表的sql语句
	 */
	@Override
	public String generationCreateSqlByMySQL(List<TableProperty> tablePropertyList) {
		return GenerateSqlByMySqlUtil.generationCreateSqlByMySQL(tablePropertyList);
	}

	/**
	 * @param tablePropertyList
	 * @return 循环数据库字段列表生成创建表的sql语句
	 */
	@Override
	public String generationCreateSqlByOracle(List<TableProperty> tablePropertyList) {
		return GenerateSqlByOracleUtil.generationCreateSqlByOracle(tablePropertyList);
	}

	/**
	 * @param tablePropertyList
	 * @param databaseType
	 * @return 生成sql更新语句
	 */
	@Override
	public String generationUpdateSql(List<TableProperty> tablePropertyList, String databaseType) {
		//先查询数据库中的所有表，找出实体中新建的表，并且调用createSQL方法
		createSql(tablePropertyList, databaseType);
		if (DataBaseTypeEnum.MySQL.name().equalsIgnoreCase(databaseType)) {
			List<TableProperty> sqlTablePropertyList = this.queryTableFieldByMySql(tablePropertyList);
			return GenerateSqlByMySqlUtil.generationUpdateSqlByMySQL(tablePropertyList, sqlTablePropertyList);
		} else if (DataBaseTypeEnum.Oracle.name().equalsIgnoreCase(databaseType)) {
			List<TableProperty> sqlTablePropertyList = this.queryTableFieldByOracle(tablePropertyList);
			return GenerateSqlByOracleUtil.generationUpdateSqlByOracle(tablePropertyList, sqlTablePropertyList);
		}
		return null;
	}

	/**
	 * @param tablePropertyList
	 * @param databaseType
	 * 如果有新建表，则调用新建方法
	 */
	private void createSql(List<TableProperty> tablePropertyList, String databaseType) {
		if (DataBaseTypeEnum.MySQL.name().equalsIgnoreCase(databaseType)) {
			List<TableProperty> sqlTableList = autoGenerateTableSqlService.queryAllTableByMySql(tableConfig.getDatabaseName());
			List<TableProperty> creTableList = getCreateTable(sqlTableList, tablePropertyList);
			if (creTableList != null && !creTableList.isEmpty()) {
				String sql = generationSql(creTableList, databaseType, "create");
				autoGenerateTableSqlService.executeSql(sql);
			}
		} else if (DataBaseTypeEnum.Oracle.name().equalsIgnoreCase(databaseType)) {
			List<TableProperty> sqlTableList = autoGenerateTableSqlService.queryAllTableByOracle(tableConfig.getDatabaseName());
			List<TableProperty> creTableList = getCreateTable(sqlTableList, tablePropertyList);
			if (creTableList != null && !creTableList.isEmpty()) {
				String sql = generationSql(creTableList, databaseType, "create");
				autoGenerateTableSqlService.executeSql(sql);
			}
		}
	}

	private List<TableProperty> getCreateTable(List<TableProperty> sqlTableList, List<TableProperty> tablePropertyList) {
		List<TableProperty> createTableList = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < tablePropertyList.size(); i++) {
			TableProperty tableProperty = tablePropertyList.get(i);
			for (int j = 0; j < sqlTableList.size(); j++) {
				TableProperty property = sqlTableList.get(j);
				if (tableProperty.getTableName().equalsIgnoreCase(property.getTableName())) {
					count = 0;
					break;
				} else {
					count++;
				}
			}
			if (count != 0) {
				createTableList.add(tableProperty);
				count = 0;
			}
		}
		return createTableList;
	}

	/**
	 * @param tablePropertyList
	 * @return 返回ORACLE 数据库表字段属性
	 */
	private List<TableProperty> queryTableFieldByOracle(List<TableProperty> tablePropertyList) {
		return null;
	}

	/**
	 * @param tablePropertyList
	 * @return 返回MYSQL数据库表字段属性
	 */
	private List<TableProperty> queryTableFieldByMySql(List<TableProperty> tablePropertyList) {
		List<TableProperty> sqlTablePropertyies = new ArrayList<>();
		for (int i = 0; i < tablePropertyList.size(); i++) {
			TableProperty sqlTableProperty = new TableProperty();
			TableProperty tableProperty = tablePropertyList.get(i);
			List<FieldProperty> fieldPropertyList = autoGenerateTableSqlService.queryTableFieldByMySql(tableProperty.getTableName(), tableConfig.getDatabaseName());
			List<FieldIndexProperty> fieldIndexPropertyList = autoGenerateTableSqlService.queryTableFieldIndexByMySql(tableProperty.getTableName());
			sqlTableProperty.setTableName(tableProperty.getTableName());
			sqlTableProperty.setFieldPropertyList(fieldPropertyList);
			sqlTableProperty.setFieldIndexProperties(fieldIndexPropertyList);
			sqlTablePropertyies.add(sqlTableProperty);
		}
		return sqlTablePropertyies;
	}
}
