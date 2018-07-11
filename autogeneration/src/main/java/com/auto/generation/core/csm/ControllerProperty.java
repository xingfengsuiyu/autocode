package com.auto.generation.core.csm;

/**
 * Controller类中的各种属性
 *
 * @author zc
 **/
public class ControllerProperty {

	/**
	 *  类路径
	 */
	private String classUrl;

	/**
	 *  包名 ：如com.zc.testController,取com.zc
	 */
	private String packageName;

	/**
	 *  截取名；如testController 取test
	 */
	private String name;


	/**
	 *  controller请求路径
	 */
	private String url;

	public String getPackageName() {
		return packageName;
	}

	public ControllerProperty setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public ControllerProperty setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getClassUrl() {
		return classUrl;
	}

	public ControllerProperty setClassUrl(String classUrl) {
		this.classUrl = classUrl;
		return this;
	}

	public String getName() {
		return name;
	}

	public ControllerProperty setName(String name) {
		this.name = name;
		return this;
	}
}
