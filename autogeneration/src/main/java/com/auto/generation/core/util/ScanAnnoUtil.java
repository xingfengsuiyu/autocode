package com.auto.generation.core.util;

import com.auto.generation.core.annotation.TableFieldAnnotation;
import com.auto.generation.core.annotation.TableIdAnnotation;
import com.auto.generation.core.annotation.TableIndexAnnotataion;
import com.auto.generation.core.annotation.TableNameAnnotation;
import com.auto.generation.core.exception.MyException;
import com.auto.generation.core.table.FieldIdProperty;
import com.auto.generation.core.table.FieldIndexProperty;
import com.auto.generation.core.table.FieldProperty;
import com.auto.generation.core.table.TableProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描实体类注解
 *
 * @author zc
 * @create 2018-06-28 11:08
 **/
public class ScanAnnoUtil {

	/*
	 * @author zc
	 * @date 2018/6/28 11:14
	 * @param [classList, databaseType]
	 * @return java.util.List<TableProperty>
	 * @description 扫描实体类的注解，返回数据库表属性，字段属性
	 */
	public static List<TableProperty> scanEntityAnno(List<Class<?>> classList, String databaseType) {
		List<TableProperty> tablePropertyList = new ArrayList<>();
		for (int i = 0; i < classList.size(); i++) {
			TableProperty tableProperty = new TableProperty();
			Class aClass = classList.get(i);
			//获取类注解
			boolean clzHasAnno = aClass.isAnnotationPresent(TableNameAnnotation.class);
			if (clzHasAnno) {
				TableNameAnnotation annotation = (TableNameAnnotation) aClass.getAnnotation(TableNameAnnotation.class);
				tableProperty.setTableName(annotation.value());
				tableProperty.setCharacter(annotation.character());
			}
			List<FieldProperty> fieldPropertyList = new ArrayList<>();
			List<FieldIndexProperty> fieldIndexPropertyList = new ArrayList<>();
			// 获取BaseEntity 注解
			String superClassStr = aClass.getGenericSuperclass().getTypeName();
			if (superClassStr != null && "BaseEntity".equals(superClassStr.substring(superClassStr.lastIndexOf(".") + 1))) {
				Class superClass = null;
				try {
					superClass = Class.forName(superClassStr);
				} catch (ClassNotFoundException e) {
					throw new MyException("找不到BaseEntity");
				}
				Field[] superFields = superClass.getDeclaredFields();
				for (int j = 0; j < superFields.length; j++) {
					Field superField = superFields[j];
					//获取注解的字段
					getAnno(tableProperty,fieldPropertyList, superField, databaseType,fieldIndexPropertyList);
				}
				tableProperty.setFieldIndexProperties(fieldIndexPropertyList);
				tableProperty.setFieldPropertyList(fieldPropertyList);
			}
			//获取字段注解
			Field[] fields = aClass.getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				getAnno(tableProperty,fieldPropertyList, field, databaseType,fieldIndexPropertyList);
			}
			tableProperty.setFieldIndexProperties(fieldIndexPropertyList);
			tableProperty.setFieldPropertyList(fieldPropertyList);
			if (tableProperty.getFieldIdProperty() == null) {
				throw new MyException("主键不能为空");
			}
 			tablePropertyList.add(tableProperty);
		}
		return tablePropertyList;
	}

	private static void getAnno(TableProperty tableProperty, List<FieldProperty> fieldPropertyList, Field field, String databaseType, List<FieldIndexProperty> fieldIndexPropertyList) {
		//主键注解
		boolean fieldIdHasAnno = field.isAnnotationPresent(TableIdAnnotation.class);
		if (fieldIdHasAnno) {
			getFieldIdAnno(tableProperty, field, databaseType);
		}
		//普通字段注解
		boolean fieldHasAnno = field.isAnnotationPresent(TableFieldAnnotation.class);
		if (fieldHasAnno) {
			getFieldAnno(fieldPropertyList, field, databaseType);
		}
		//索引字段注解
		boolean fieldIdxHasAnno = field.isAnnotationPresent(TableIndexAnnotataion.class);
		if (fieldIdxHasAnno) {
			getFieldIdxAnno(fieldIndexPropertyList, field, databaseType);
		}
	}

	private static void getFieldIdxAnno(List<FieldIndexProperty> fieldIndexPropertyList, Field field, String databaseType) {
		FieldIndexProperty fieldIndexProperty = new FieldIndexProperty();
		TableIndexAnnotataion tableIndexAnnotataion = field.getAnnotation(TableIndexAnnotataion.class);
		fieldIndexProperty.setIdxName(tableIndexAnnotataion.idxName());
		fieldIndexProperty.setName(tableIndexAnnotataion.name());
		fieldIndexProperty.setIdxType(tableIndexAnnotataion.idxType());
		fieldIndexProperty.setIdxMethod(tableIndexAnnotataion.idxMethod());
		fieldIndexProperty.setIdxDescript(tableIndexAnnotataion.idxDescript());
		fieldIndexPropertyList.add(fieldIndexProperty);
	}

	private static void getFieldIdAnno(TableProperty tableProperty, Field superField, String databaseType) {
		FieldIdProperty fieldIdProperty = new FieldIdProperty();
		TableIdAnnotation tableIdAnnotation = superField.getAnnotation(TableIdAnnotation.class);
		fieldIdProperty.setName(tableIdAnnotation.value());
		fieldIdProperty.setLength(tableIdAnnotation.length());
		fieldIdProperty.setType(ConverJavaTypeToJdbcTypeUtil.converToJdbcType(superField, databaseType));
		fieldIdProperty.setDescription(tableIdAnnotation.decription());
		tableProperty.setFieldIdProperty(fieldIdProperty);
	}

	private static void getFieldAnno(List<FieldProperty> fieldPropertyList, Field field, String databaseType) {
		FieldProperty fieldProperty = new FieldProperty();
		TableFieldAnnotation fieldAnnotation = field.getAnnotation(TableFieldAnnotation.class);
		fieldProperty.setName(fieldAnnotation.name());
		fieldProperty.setLength(fieldAnnotation.length());
		//字段注解返回jdbc类型
		fieldProperty.setType(ConverJavaTypeToJdbcTypeUtil.converToJdbcType(field, databaseType));
		fieldProperty.setIsNull(fieldAnnotation.isNull());
		fieldProperty.setDefaultValue(fieldAnnotation.defaultValue());
		fieldProperty.setDescription(fieldAnnotation.description());
		fieldProperty.setDecimalPlaces(fieldAnnotation.decimalPlaces());
		fieldPropertyList.add(fieldProperty);
	}
}
