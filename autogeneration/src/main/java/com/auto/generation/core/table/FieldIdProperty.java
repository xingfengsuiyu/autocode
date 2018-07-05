package com.auto.generation.core.table;

/**
 * ID类
 *
 * @author zc
 * @create 2018-06-28 9:33
 **/
public class FieldIdProperty {

	/**
	 *  主键名
	 */
	private String name;
	/**
	 *  长度
	 */
	private int length;
	/**
	 *  类型
	 */
	private String type;
	/**
	 *  字段描述
	 */
	private String description;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FieldIdProperty that = (FieldIdProperty) o;

		if (length != that.length) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		return description != null ? description.equals(that.description) : that.description == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + length;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}

	public String getName() {
		return name;
	}

	public FieldIdProperty setName(String name) {
		this.name = name.toUpperCase();
		return this;
	}

	public int getLength() {
		return length;
	}

	public FieldIdProperty setLength(int length) {
		this.length = length;
		return this;
	}

	public String getType() {
		return type;
	}

	public FieldIdProperty setType(String type) {
		this.type = type;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FieldIdProperty setDescription(String description) {
		this.description = description;
		return this;
	}
}
