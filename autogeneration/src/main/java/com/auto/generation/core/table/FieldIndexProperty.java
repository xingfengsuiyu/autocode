package com.auto.generation.core.table;

/**
 * 索引类
 *
 * @author zc
 * @create 2018-07-03 11:03
 **/
public class FieldIndexProperty {

	/**
	 * @return 索引名称
	 */
	private String idxName;
	/**
	 * @return 字段名称
	 */
	private String name;
	/**
	 * @return 索引类型
	 */
	private String idxType;
	/**
	 * @return 索引方法
	 */
	private String idxMethod;
	/**
	 * @return 索引注释
	 */
	private String idxDescript;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FieldIndexProperty)) return false;

		FieldIndexProperty that = (FieldIndexProperty) o;

		if (idxName != null ? !idxName.equals(that.idxName) : that.idxName != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (idxType != null ? !idxType.equals(that.idxType) : that.idxType != null) return false;
		if (idxMethod != null ? !idxMethod.equals(that.idxMethod) : that.idxMethod != null) return false;
		return idxDescript != null ? idxDescript.equals(that.idxDescript) : that.idxDescript == null;
	}

	@Override
	public int hashCode() {
		int result = idxName != null ? idxName.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (idxType != null ? idxType.hashCode() : 0);
		result = 31 * result + (idxMethod != null ? idxMethod.hashCode() : 0);
		result = 31 * result + (idxDescript != null ? idxDescript.hashCode() : 0);
		return result;
	}

	public String getIdxName() {
		return idxName.toUpperCase();
	}

	public FieldIndexProperty setIdxName(String idxName) {
		this.idxName = idxName;
		return this;
	}

	public String getName() {
		return name.toUpperCase();
	}

	public FieldIndexProperty setName(String name) {
		this.name = name;
		return this;
	}

	public String getIdxType() {
		return idxType;
	}

	public FieldIndexProperty setIdxType(String idxType) {
		this.idxType = idxType;
		return this;
	}

	public String getIdxMethod() {
		return idxMethod;
	}

	public FieldIndexProperty setIdxMethod(String idxMethod) {
		this.idxMethod = idxMethod;
		return this;
	}

	public String getIdxDescript() {
		return idxDescript;
	}

	public FieldIndexProperty setIdxDescript(String idxDescript) {
		this.idxDescript = idxDescript;
		return this;
	}
}
