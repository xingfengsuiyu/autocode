package com.auto.generation.core.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zc
 * @date 2018/6/26 17:05
 * @description  获取配置文件
 */
@Component
public class TableConfig {

	@Value("${mybatis.table.auto}")
	private String generationMethod;

	@Value("${mybatis.model.pack}")
	private String modelPack;

	@Value("${mybatis.database.type}")
	private String databaseType;

	@Value("${mybatis.database.name}")
	private String databaseName;

	public String getDatabaseName() {
		return databaseName;
	}

	public TableConfig setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
		return this;
	}

	public String getGenerationMethod() {
		return generationMethod;
	}

	public TableConfig setGenerationMethod(String generationMethod) {
		this.generationMethod = generationMethod;
		return this;
	}

	public String getModelPack() {
		return modelPack;
	}

	public TableConfig setModelPack(String modelPack) {
		this.modelPack = modelPack;
		return this;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public TableConfig setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
		return this;
	}
}
