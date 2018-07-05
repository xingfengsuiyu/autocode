package com.auto.generation.core.util;

import com.auto.generation.core.enump.DataBaseTypeEnum;
import com.auto.generation.core.enump.FieldTypeEnum;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 将Java类型转换成Jdbc类型
 *
 * @author zc
 * @create 2018-06-27 11:40
 **/
public class ConverJavaTypeToJdbcTypeUtil {

	/**
	 * @param type         字段类型
	 * @param databaseType 数据库类型
	 * @return 数据库字段类型
	 */
	public static String converToJdbcType(Field type, String databaseType) {
		String jdbcType = "";
		if (DataBaseTypeEnum.MySQL.name().equalsIgnoreCase(databaseType)) {
			jdbcType = converToMySqlType(type);
		} else if (DataBaseTypeEnum.Oracle.name().equalsIgnoreCase(databaseType)) {
			jdbcType = converToOracleType(type);
		}
		return jdbcType;
	}

	private static String converToMySqlType(Field type) {
		if (type.getType().equals(String.class)) {
			return FieldTypeEnum.String.getMysqlType();
		} else if (type.getType().equals(Date.class)) {
			return FieldTypeEnum.Date.getMysqlType();
		} else if (type.getType().equals(Time.class)) {
			return FieldTypeEnum.Time.getMysqlType();
		} else if (type.getType().equals(Timestamp.class)) {
			return FieldTypeEnum.Timestamp.getMysqlType();
		} else if (type.getType().equals(Long.class) || type.getType().equals(long.class)) {
			return FieldTypeEnum.Long.getMysqlType();
		} else if (type.getType().equals(Integer.class) || type.getType().equals(int.class)) {
			return FieldTypeEnum.Integer.getMysqlType();
		} else if (type.getType().equals(Double.class) || type.getType().equals(double.class)) {
			return FieldTypeEnum.Double.getMysqlType();
		} else if (type.getType().equals(Float.class) || type.getType().equals(float.class)) {
			return FieldTypeEnum.Float.getMysqlType();
		} else if (type.getType().equals(BigInteger.class)) {
			return FieldTypeEnum.BigInteger.getMysqlType();
		} else if (type.getType().equals(BigDecimal.class)) {
			return FieldTypeEnum.BigDecimal.getMysqlType();
		} else if (type.getType().equals(Boolean.class)) {
			return FieldTypeEnum.Boolean.getMysqlType();
		} else if (type.getType().equals(Short.class)) {
			return FieldTypeEnum.Short.getMysqlType();
		} else if (type.getType().equals(Clob.class)) {
			return FieldTypeEnum.Clob.getMysqlType();
		} else if (type.getType().equals(Blob.class)) {
			return FieldTypeEnum.Blob.getMysqlType();
		}
		return "VARCHAR";
	}

	private static String converToOracleType(Field type) {
		if (type.getType().equals(String.class)) {
			return FieldTypeEnum.String.getOracleType();
		} else if (type.getType().equals(Date.class)) {
			return FieldTypeEnum.Date.getOracleType();
		} else if (type.getType().equals(Time.class)) {
			return FieldTypeEnum.Time.getOracleType();
		} else if (type.getType().equals(Timestamp.class)) {
			return FieldTypeEnum.Timestamp.getOracleType();
		} else if (type.getType().equals(Long.class) || type.getType().equals(long.class)) {
			return FieldTypeEnum.Long.getOracleType();
		} else if (type.getType().equals(Integer.class) || type.getType().equals(int.class)) {
			return FieldTypeEnum.Integer.getOracleType();
		} else if (type.getType().equals(Double.class) || type.getType().equals(double.class)) {
			return FieldTypeEnum.Double.getOracleType();
		} else if (type.getType().equals(Float.class) || type.getType().equals(float.class)) {
			return FieldTypeEnum.Float.getOracleType();
		} else if (type.getType().equals(BigInteger.class)) {
			return FieldTypeEnum.BigInteger.getOracleType();
		} else if (type.getType().equals(BigDecimal.class)) {
			return FieldTypeEnum.BigDecimal.getOracleType();
		} else if (type.getType().equals(Boolean.class)) {
			return FieldTypeEnum.Boolean.getOracleType();
		} else if (type.getType().equals(Short.class)) {
			return FieldTypeEnum.Short.getOracleType();
		} else if (type.getType().equals(Clob.class)) {
			return FieldTypeEnum.Clob.getOracleType();
		} else if (type.getType().equals(Blob.class)) {
			return FieldTypeEnum.Blob.getOracleType();
		}
		return "VARCHAR";
	}


}
