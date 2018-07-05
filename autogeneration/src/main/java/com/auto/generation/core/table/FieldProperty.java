package com.auto.generation.core.table;

/**
 * 数据库表字段属性
 *
 * @author zc
 * @create 2018-06-27 9:03
 **/
public class FieldProperty {
	/**
	 * 字段名
	 */
	private String name;

	/**
	 * 长度
	 */
	private int length;

	/**
	 * 小位数
	 */
	private int decimalPlaces;
	/**
	 * 类型
	 */
	private String type;

	/**
	 * 是否为空
	 */
	private String isNull;

	/**
	 * 默认值
	 */
	private String defaultValue;

	/**
	 * 字段描述
	 */
	private String description;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FieldProperty that = (FieldProperty) o;

		if (length != that.length) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (isNull != null ? !isNull.equals(that.isNull) : that.isNull != null) return false;
		if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
		return description != null ? description.equals(that.description) : that.description == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + length;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (isNull != null ? isNull.hashCode() : 0);
		result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public FieldProperty setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
		return this;
	}

	public String getName() {
		return name.toUpperCase();
	}

	public FieldProperty setName(String name) {
		this.name = name;
		return this;
	}

	public int getLength() {
		return length;
	}

	public FieldProperty setLength(int length) {
		this.length = length;
		return this;
	}

	public String getType() {
		return type;
	}

	public FieldProperty setType(String type) {
		this.type = type;
		return this;
	}

	public String getIsNull() {
		return isNull;
	}

	public FieldProperty setIsNull(String isNull) {
		this.isNull = isNull;
		return this;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public FieldProperty setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FieldProperty setDescription(String description) {
		this.description = description;
		return this;
	}
}
