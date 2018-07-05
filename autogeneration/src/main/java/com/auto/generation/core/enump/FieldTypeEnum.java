package com.auto.generation.core.enump;

/**
 * 字段类型枚举类
 *
 * @author zc
 * @create 2018-06-27 14:16
 **/
public enum FieldTypeEnum {
	String("VARCHAR","VARCHAR"),
	Date("DATE","DATE"),
	Time("DATATIME","DATATIME"),
	Timestamp("TIMESTAMP","TIMESTAMP"),
	Short("TINYINT","NUMBER"),
	Integer("INT","NUMBER"),
	Float("FLOAT","NUMBER"),
	Double("DOUBLE","NUMBER"),
	Long("BIGINT","NUMBER"),
	BigInteger("BIGINT","NUMBER"),
	BigDecimal("DECIMAL","NUMBER"),
	Boolean("TINYINT","NUMBER"),
	Clob("CLOB","CLOB"),
	Blob("BLOB","BLOB");

	private String mysqlType ;

	private String oracleType;

	private FieldTypeEnum(String mysqlType,String oracleType) {
		this.mysqlType = mysqlType;
		this.oracleType = oracleType;
	}

	public java.lang.String getMysqlType() {
		return mysqlType;
	}

	public FieldTypeEnum setMysqlType(java.lang.String mysqlType) {
		this.mysqlType = mysqlType;
		return this;
	}

	public java.lang.String getOracleType() {
		return oracleType;
	}

	public FieldTypeEnum setOracleType(java.lang.String oracleType) {
		this.oracleType = oracleType;
		return this;
	}
}
