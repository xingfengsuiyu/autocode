package com.auto.generation.core.util;

import com.auto.generation.core.table.FieldIdProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;

import java.util.List;

/**
 * oracle生成语句工具类
 *
 * @author zc
 * @create 2018-07-03 16:44
 **/
public class GenerateSqlByOracleUtil {

	public static String generationCreateSqlByOracle(List<TableProperty> tablePropertyList) {
		StringBuilder sbComment = new StringBuilder();
		StringBuilder sbAlert = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tablePropertyList.size(); i++) {
			TableProperty tableProperty = tablePropertyList.get(i);
			FieldIdProperty fieldIdProperty = tableProperty.getFieldIdProperty();
			List<FieldProperty> fieldPropertyList = tableProperty.getFieldPropertyList();
			sb.append(" CREATE TABLE " + tableProperty.getTableName() + " ( ");
			// 主键字段
			sb.append(" " + fieldIdProperty.getName() + " ");
			if (ListTypeUtil.getDateList().contains(fieldIdProperty.getType())) {
				sb.append(" " + fieldIdProperty.getType() + " ");
			} else {
				//如果是数字类型
				sb.append(" " + fieldIdProperty.getType() + "(" + fieldIdProperty.getLength() + ") ");
			}
			sb.append(" NOT NULL ");
			sbComment.append(" COMMENT ON COLUMN " + tableProperty.getTableName() + "." + fieldIdProperty.getName() + " IS " + fieldIdProperty.getDescription() + "; ");
			sbAlert.append(" ALTER TABLE `" + tableProperty.getTableName() + "` ADD CONSTRAINT PK_ID PRIMARY KEY (" + fieldIdProperty.getName() + ") ");
			// 其余字段
			for (int j = 0; j < fieldPropertyList.size(); j++) {
				FieldProperty fieldProperty = fieldPropertyList.get(j);
				sb.append(" " + fieldProperty.getName() + " ");
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
				sb.append(" " + fieldProperty.getIsNull() + " ");
				sb.append(" DEFAULT " + fieldProperty.getDefaultValue() + " ");
				sbComment.append(" COMMENT ON COLUMN " + tableProperty.getTableName() + "." + fieldProperty.getName() + " IS " + fieldIdProperty.getDescription() + "; ");
			}
		}
		sb.append(sbComment);
		sb.append(sbAlert);
		return sb.toString();
	}

	/**
	 * @param tablePropertyList
	 * @param sqlTablePropertyList
	 * @return 生成ORACLE更新语句
	 */
	public static String generationUpdateSqlByOracle(List<TableProperty> tablePropertyList, List<TableProperty> sqlTablePropertyList) {
		return null;
	}
}
