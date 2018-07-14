package com.auto.generation.core.csm;

/**
 * 自动生成类中的各种属性
 *
 * @author zc
 **/
public class ClazzProperty {

	/**
	 * 类物理路径
	 */
	private String classUrl;

	/**
	 * 包名 ：如com.zc.testController,取com.zc
	 */
	private String packageName;

	/**
	 * 类截取名；如TestController 取Test
	 */
	private String name;

	/**
	 * mapper目录
	 */
	private String mapperUrl;

	/**
	 *  表名
	 */
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public ClazzProperty setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public String getMapperUrl() {
		return mapperUrl;
	}

	public ClazzProperty setMapperUrl(String mapperUrl) {
		this.mapperUrl = mapperUrl;
		return this;
	}

	public String getPackageName() {
		return packageName;
	}

	public ClazzProperty setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	public String getClassUrl() {
		return classUrl;
	}

	public ClazzProperty setClassUrl(String classUrl) {
		this.classUrl = classUrl;
		return this;
	}

	public String getName() {
		return name;
	}

	public ClazzProperty setName(String name) {
		this.name = name;
		return this;
	}
}
