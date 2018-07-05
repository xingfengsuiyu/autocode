package com.auto.generation.core.util;

import com.auto.generation.core.table.FieldIdProperty;
import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;

import java.util.List;

/**
 * 生成SQL建表，更新表语句
 *
 * @author zc
 * @create 2018-06-28 11:22
 **/
public class GenerateSqlByMySqlUtil {

	/**
	 * @param entityPropertyList
	 * @return 生成MYSQL创建语句
	 */
	public static String generationCreateSqlByMySQL(List<TableProperty> entityPropertyList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < entityPropertyList.size(); i++) {
			TableProperty tableProperty = entityPropertyList.get(i);
			FieldIdProperty fieldIdProperty = tableProperty.getFieldIdProperty();
			List<FieldProperty> fieldPropertyList = tableProperty.getFieldPropertyList();
			sb.append(" CREATE TABLE `" + tableProperty.getTableName() + "` ( ");
			// 主键字段
			sb.append(" `" + fieldIdProperty.getName() + "` ");
			if (ListTypeUtil.getDateList().contains(fieldIdProperty.getType())) {
				sb.append(" " + fieldIdProperty.getType() + " ");
			} else {
				//如果是数字类型
				sb.append(" " + fieldIdProperty.getType() + "(" + fieldIdProperty.getLength() + ") ");
			}
			sb.append(" NOT NULL ");
			sb.append(" COMMENT '" + fieldIdProperty.getDescription() + "' ,");
			// 其余字段
			for (int j = 0; j < fieldPropertyList.size(); j++) {
				FieldProperty fieldProperty = fieldPropertyList.get(j);
				sb.append(" `" + fieldProperty.getName() + "` ");
				if (ListTypeUtil.getDateList().contains(fieldProperty.getType())) {
					sb.append(" " + fieldProperty.getType() + " ");
				} else {
					//如果是数字类型
					if (ListTypeUtil.getNumberList().contains(fieldProperty.getType())) {
						sb.append(" " + fieldProperty.getType() + "(" + fieldProperty.getLength() + "," + fieldProperty.getDecimalPlaces() + ") ");
					} else {
						sb.append(" " + fieldProperty.getType() + "(" + fieldProperty.getLength() + ") ");
					}
				}
				sb.append(" " + fieldProperty.getIsNull() + "");
				sb.append(" DEFAULT " + fieldProperty.getDefaultValue() + "");
				sb.append(" COMMENT '" + fieldProperty.getDescription() + "', ");
			}
			sb.append(" PRIMARY KEY (`" + fieldIdProperty.getName() + "`) ");
			//主键默认创建索引
			//sb.append(" UNIQUE INDEX `IDX_ID` (`"+fieldIdProperty.getName()+"`) USING BTREE COMMENT '主键索引' ");
			sb.append(" ) ");
			sb.append(" ENGINE=InnoDB ");
			sb.append(" DEFAULT CHARACTER SET=" + tableProperty.getCharacter());
			sb.append(" ROW_FORMAT=DYNAMIC ;");
			//索引字段
			List<FieldIndexProperty> fieldIndexProperties = tableProperty.getFieldIndexProperties();
			if (fieldIndexProperties != null && !fieldIndexProperties.isEmpty()) {
				for (int j = 0; j < fieldIndexProperties.size(); j++) {
					FieldIndexProperty fieldIndexProperty = fieldIndexProperties.get(j);
					sb.append(" ALTER TABLE `" + tableProperty.getTableName() + "` ADD ");
					sb.append(" " + fieldIndexProperty.getIdxType() + " INDEX ");
					sb.append(" `" + fieldIndexProperty.getIdxName() + "` ");
					sb.append(" (`" + fieldIndexProperty.getName() + "`) ");
					sb.append(" USING " + fieldIndexProperty.getIdxMethod() + " ");
					sb.append(" COMMENT " + fieldIndexProperty.getIdxDescript() + ";");
				}
			}
		}
		return sb.toString();
	}


	/**
	 * @param propertyList
	 * @param sqlTablePropertyList
	 * @return 生成MYSQL更新语句
	 */
	public static String generationUpdateSqlByMySQL(List<TableProperty> propertyList, List<TableProperty> sqlTablePropertyList) {
		String addSql = getAddField(propertyList, sqlTablePropertyList);
		String delSql = getDeleteField(propertyList, sqlTablePropertyList);
		String modSql = getModifyField(propertyList, sqlTablePropertyList);
		return addSql + delSql + modSql;
	}

	/**
	 * @param propertyList
	 * @param sqlTablePropertyList
	 * @return 字段修改sql
	 */
	private static String getModifyField(List<TableProperty> propertyList, List<TableProperty> sqlTablePropertyList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < propertyList.size(); i++) {
			TableProperty entityProperty = propertyList.get(i);
			for (int j = 0; j < sqlTablePropertyList.size(); j++) {
				TableProperty sqlProperty = sqlTablePropertyList.get(j);
				if (entityProperty.getTableName().equalsIgnoreCase(sqlProperty.getTableName())) {
					// 判断普通字段
					List<FieldProperty> entityFields = entityProperty.getFieldPropertyList();
					List<FieldProperty> sqlFields = sqlProperty.getFieldPropertyList();
					for (int k = 0; k < entityFields.size(); k++) {
						FieldProperty fieldProperty = entityFields.get(k);
						if (sqlFields != null && !sqlFields.isEmpty()) {
							for (int l = 0; l < sqlFields.size(); l++) {
								FieldProperty property = sqlFields.get(l);
								if (fieldProperty.getName().equalsIgnoreCase(property.getName())) {
									if (!fieldProperty.getType().equalsIgnoreCase(property.getType())) {
										if (ListTypeUtil.getDateList().contains(fieldProperty.getType())) {
											sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + ";");
										} else {
											if (ListTypeUtil.getNumberList().contains(fieldProperty.getType())) {
												sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + "," + fieldProperty.getDecimalPlaces() + ");");
											} else {
												sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + ");");
											}
										}
									}
									if (fieldProperty.getLength() != property.getLength()) {
										if (!ListTypeUtil.getDateList().contains(fieldProperty.getType())) {
											if (ListTypeUtil.getNumberList().contains(fieldProperty.getType())) {
												sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + "," + fieldProperty.getDecimalPlaces() + ");");
											} else {
												sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + ");");
											}
										}
									}
									if (fieldProperty.getDecimalPlaces() != property.getDecimalPlaces()) {
										if (ListTypeUtil.getNumberList().contains(fieldProperty.getType())) {
											sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY COLUMN " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + "," + fieldProperty.getDecimalPlaces() + ");");
										}
									}
									if (!fieldProperty.getIsNull().equals(property.getIsNull())) {
										sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY " + fieldProperty.getName() + " " + fieldProperty.getType() + " " + fieldProperty.getIsNull() + ";");
									}
									if (!fieldProperty.getDefaultValue().equals(property.getDefaultValue())) {
										sb.append(" ALTER TABLE " + entityProperty.getTableName() + " ALTER COLUMN " + fieldProperty.getName() + " DROP DEFAULT ;");
										sb.append(" ALTER TABLE " + entityProperty.getTableName() + " ALTER COLUMN " + fieldProperty.getName() + " SET DEFAULT " + fieldProperty.getDefaultValue() + " ;");
									}
									if (!fieldProperty.getDescription().equals(property.getDescription())) {
										if ("VARCHAR".equalsIgnoreCase(fieldProperty.getType())) {
											sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY " + fieldProperty.getName() + " " + fieldProperty.getType() + "(" + fieldProperty.getLength() + ") COMMENT '" + fieldProperty.getDescription() + "';");
										} else {
											sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY " + fieldProperty.getName() + " " + fieldProperty.getType() + " COMMENT '" + fieldProperty.getDescription() + "';");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @param propertyList
	 * @param sqlTablePropertyList
	 * @return 更新时返回要删除的sql
	 */
	private static String getDeleteField(List<TableProperty> propertyList, List<TableProperty> sqlTablePropertyList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sqlTablePropertyList.size(); i++) {
			TableProperty sqlProperty = sqlTablePropertyList.get(i);
			for (int j = 0; j < propertyList.size(); j++) {
				TableProperty entityProperty = propertyList.get(j);
				if (sqlProperty.getTableName().equalsIgnoreCase(entityProperty.getTableName())) {
					int count = 0;
					//判断普通字段
					List<FieldProperty> sqlFields = sqlProperty.getFieldPropertyList();
					List<FieldProperty> entityFields = entityProperty.getFieldPropertyList();
					for (int k = 0; k < sqlFields.size(); k++) {
						FieldProperty fieldProperty = sqlFields.get(k);
						if (entityFields != null && !entityFields.isEmpty()) {
							for (int l = 0; l < entityFields.size(); l++) {
								FieldProperty property = entityFields.get(l);
								if (fieldProperty.getName().equalsIgnoreCase(property.getName())) {
									count = 0;
									break;
								} else {
									count++;
								}
							}
							if (count != 0) {
								sb.append("ALTER TABLE `" + entityProperty.getTableName() + "` DROP `" + fieldProperty.getName() + "` ; ");
								count = 0;
							}
						} else {
							sb.append("ALTER TABLE `" + entityProperty.getTableName() + "` DROP `" + fieldProperty.getName() + "` ; ");
						}
					}

					//判断索引
					List<FieldIndexProperty> sqlIndexFields = sqlProperty.getFieldIndexProperties();
					List<FieldIndexProperty> entityIndexFields = entityProperty.getFieldIndexProperties();
					for (int k = 0; k < sqlIndexFields.size(); k++) {
						FieldIndexProperty fieldProperty = sqlIndexFields.get(k);
						if (entityIndexFields != null && !entityIndexFields.isEmpty()) {
							for (int l = 0; l < entityIndexFields.size(); l++) {
								FieldIndexProperty property = entityIndexFields.get(l);
								if (fieldProperty.getIdxName().equalsIgnoreCase(property.getIdxName())) {
									count = 0;
									break;
								} else {
									count++;
								}
							}
							if (count != 0) {
								sb.append("ALTER TABLE `" + entityProperty.getTableName() + "` DROP INDEX `" + fieldProperty.getIdxName() + "` ; ");
								count = 0;
							}
						} else {
							sb.append("ALTER TABLE `" + entityProperty.getTableName() + "` DROP INDEX `" + fieldProperty.getIdxName() + "` ; ");
						}
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @param propertyList
	 * @param sqlTablePropertyList
	 * @return 更新时返回要新增的sql
	 */
	private static String getAddField(List<TableProperty> propertyList, List<TableProperty> sqlTablePropertyList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < propertyList.size(); i++) {
			TableProperty entityProperty = propertyList.get(i);
			for (int j = 0; j < sqlTablePropertyList.size(); j++) {
				TableProperty sqlProperty = sqlTablePropertyList.get(j);
				if (entityProperty.getTableName().equalsIgnoreCase(sqlProperty.getTableName())) {
					// 判断普通字段
					List<FieldProperty> entityFields = entityProperty.getFieldPropertyList();
					List<FieldProperty> sqlFields = sqlProperty.getFieldPropertyList();
					int count = 0;
					for (int k = 0; k < entityFields.size(); k++) {
						FieldProperty fieldProperty = entityFields.get(k);
						if (sqlFields != null && !sqlFields.isEmpty()) {
							for (int l = 0; l < sqlFields.size(); l++) {
								FieldProperty property = sqlFields.get(l);
								if (fieldProperty.getName().equalsIgnoreCase(property.getName())) {
									count = 0;
									break;
								} else {
									count++;
								}
							}
							if (count != 0) {
								appendFieldByMySql(entityProperty, fieldProperty, sb);
								count = 0;
							}
						} else {
							appendFieldByMySql(entityProperty, fieldProperty, sb);
						}

					}
					//判断索引
					List<FieldIndexProperty> entityIndexFields = entityProperty.getFieldIndexProperties();
					List<FieldIndexProperty> sqlIndexFields = sqlProperty.getFieldIndexProperties();
					for (int k = 0; k < entityIndexFields.size(); k++) {
						FieldIndexProperty fieldIndexProperty = entityIndexFields.get(k);
						if (sqlIndexFields != null && !sqlIndexFields.isEmpty()) {
							for (int l = 0; l < sqlIndexFields.size(); l++) {
								FieldIndexProperty property = sqlIndexFields.get(l);
								if (fieldIndexProperty.getIdxName().equalsIgnoreCase(property.getIdxName())) {
									count = 0;
									break;
								} else {
									count++;
								}
							}
							if (count != 0) {
								appendIndexByMySql(entityProperty, fieldIndexProperty, sb);
								count = 0;
							}
						} else {
							appendIndexByMySql(entityProperty, fieldIndexProperty, sb);
						}
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @param entityProperty
	 * @param fieldProperty
	 * @param sb             更新时要增加的字段
	 */
	private static void appendFieldByMySql(TableProperty entityProperty, FieldProperty fieldProperty, StringBuilder sb) {
		sb.append(" ALTER TABLE " + entityProperty.getTableName() + " ADD `" + fieldProperty.getName() + "` " + fieldProperty.getType() + "; ");
		sb.append(" ALTER TABLE " + entityProperty.getTableName() + " MODIFY `" + fieldProperty.getName() + "` ");
		if (ListTypeUtil.getDateList().contains(fieldProperty.getType())) {
			sb.append(" " + fieldProperty.getType() + " ");
		} else {
			//如果是数字类型
			if (ListTypeUtil.getNumberList().contains(fieldProperty.getType())) {
				sb.append(" " + fieldProperty.getType() + "(" + fieldProperty.getLength() + "," + fieldProperty.getDecimalPlaces() + ") ");
			} else {
				sb.append(" " + fieldProperty.getType() + "(" + fieldProperty.getLength() + ") ");
			}
		}
		sb.append(" DEFAULT " + fieldProperty.getDefaultValue() + " ");
		sb.append(" COMMENT '" + fieldProperty.getDescription() + "';");
	}

	/**
	 * @param entityProperty
	 * @param fieldIndexProperty
	 * @param sb                 更新时要增加的索引
	 */
	private static void appendIndexByMySql(TableProperty entityProperty, FieldIndexProperty fieldIndexProperty, StringBuilder sb) {
		sb.append(" ALTER TABLE `" + entityProperty.getTableName() + "` ADD ");
		sb.append(" " + fieldIndexProperty.getIdxType() + " INDEX ");
		sb.append(" `" + fieldIndexProperty.getIdxName() + "` ");
		sb.append(" (`" + fieldIndexProperty.getName() + "`) ");
		sb.append(" USING " + fieldIndexProperty.getIdxMethod() + " ");
		sb.append(" COMMENT '" + fieldIndexProperty.getIdxDescript() + "';");
	}
}
