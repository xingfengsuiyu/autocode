package com.auto.generation.core.table;

import java.util.List;

/**
 * 数据库表属性
 *
 * @author zc
 **/
public class TableProperty {


	/**
	 *  表名
	 */
	private String tableName;

	/**
	 *  字符编码
	 */
	private String character;

	/**
	 *  ID属性
	 */
	private FieldIdProperty fieldIdProperty;

	/**
	 *  表字段属性
	 */
	private List<FieldProperty> fieldPropertyList;

	/**
	 *  索引属性
	 */
	private List<FieldIndexProperty> fieldIndexProperties;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TableProperty)) return false;

		TableProperty that = (TableProperty) o;

		if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
		if (character != null ? !character.equals(that.character) : that.character != null) return false;
		if (fieldIdProperty != null ? !fieldIdProperty.equals(that.fieldIdProperty) : that.fieldIdProperty != null)
			return false;
		return fieldPropertyList != null ? fieldPropertyList.equals(that.fieldPropertyList) : that.fieldPropertyList == null;
	}

	@Override
	public int hashCode() {
		int result = tableName != null ? tableName.hashCode() : 0;
		result = 31 * result + (character != null ? character.hashCode() : 0);
		result = 31 * result + (fieldIdProperty != null ? fieldIdProperty.hashCode() : 0);
		result = 31 * result + (fieldPropertyList != null ? fieldPropertyList.hashCode() : 0);
		return result;
	}

	public List<FieldIndexProperty> getFieldIndexProperties() {
		return fieldIndexProperties;
	}

	public TableProperty setFieldIndexProperties(List<FieldIndexProperty> fieldIndexProperties) {
		this.fieldIndexProperties = fieldIndexProperties;
		return this;
	}

	public FieldIdProperty getFieldIdProperty() {
		return fieldIdProperty;
	}

	public TableProperty setFieldIdProperty(FieldIdProperty fieldIdProperty) {
		this.fieldIdProperty = fieldIdProperty;
		return this;
	}

	public String getTableName() {
		return tableName.toUpperCase();
	}

	public TableProperty setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public String getCharacter() {
		return character;
	}

	public TableProperty setCharacter(String character) {
		this.character = character;
		return this;
	}

	public List<FieldProperty> getFieldPropertyList() {
		return fieldPropertyList;
	}

	public TableProperty setFieldPropertyList(List<FieldProperty> fieldPropertyList) {
		this.fieldPropertyList = fieldPropertyList;
		return this;
	}
}
