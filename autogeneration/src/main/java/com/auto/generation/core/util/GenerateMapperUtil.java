package com.auto.generation.core.util;

import com.auto.generation.core.csm.ClazzProperty;

import java.io.File;

/**
 * 生成Mapper工具类
 *
 * @author zc
 * @create 2018-07-14 16:34
 **/
public class GenerateMapperUtil {

	public static void generateMapper(ClazzProperty clazzProperty) {
		generateMapperIntercace(clazzProperty);
		generateMapperXml(clazzProperty);
	}

	/**
	 * @param [clazzProperty]
	 * @return void
	 * @author zc
	 * @date 2018/7/14 17:17
	 * @description 生成mapper接口
	 */
	private static void generateMapperIntercace(ClazzProperty clazzProperty) {
		//判断包是否存在
		File dir = new File(clazzProperty.getClassUrl() + File.separator + "mapper");
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Service是否存在
		File file = new File(clazzProperty.getClassUrl() + File.separator + "mapper" + File.separator + clazzProperty.getName() + "Mapper.java");
		if (!file.isFile()) {
			StringBuilder sb = new StringBuilder();
			sb.append("package ");
			sb.append(clazzProperty.getPackageName() + ".mapper;");
			sb.append("\r\n\r\n");
			sb.append("import java.util.List;");
			sb.append("\r\n");
			sb.append("import org.apache.ibatis.annotations.Param;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".entity." + clazzProperty.getName() + "Entity;");
			sb.append("\r\n\r\n\r\n\r\n");
			sb.append("\r\n");
			sb.append("public interface " + clazzProperty.getName() + "Mapper " + "{");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("List<" + clazzProperty.getName() + "Entity> page();");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append(clazzProperty.getName() + "Entity queryById(@Param(\"id\") Long id);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public void add(@Param(\"entity\") " + clazzProperty.getName() + "Entity entity);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("void update(@Param(\"entity\") " + clazzProperty.getName() + "Entity entity);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("void delete(@Param(\"id\") Long id);");
			sb.append("\r\n");
			sb.append("}");

			WriteJavaFileUtil.writeJavaFile(file, sb);
		}
	}

	/**
	 * @param [clazzProperty]
	 * @return void
	 * @author zc
	 * @date 2018/7/14 17:17
	 * @description 生成mapperXml
	 */
	private static void generateMapperXml(ClazzProperty clazzProperty) {
		//判断包是否存在
		File dir = new File(clazzProperty.getMapperUrl());
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Service是否存在
		File file = new File(clazzProperty.getMapperUrl() + File.separator + clazzProperty.getName() + "Mapper.xml");
		if (!file.isFile()) {
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			sb.append("\r\n");
			sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
			sb.append("\r\n");
			sb.append("<mapper namespace=\""+clazzProperty.getPackageName()+".mapper."+clazzProperty.getName() + "Mapper\">");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("<select id=\"page\" resultMap=\"" + clazzProperty.getPackageName() + ".entity." + clazzProperty.getName() + "Entity\">");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("SELECT * FROM " + clazzProperty.getTableName());
			sb.append("\r\n");
			sb.append("\t");
			sb.append("</select>");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("<select id=\"queryById\" resultMap=\"" + clazzProperty.getPackageName() + ".entity." + clazzProperty.getName() + "Entity\">");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("SELECT * FROM " + clazzProperty.getTableName() + " WHERE ID = #{id}");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("</select>");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("<insert id=\"add\">");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			//sb.append("SELECT * FROM "+clazzProperty.getTableName()+" WHERE ID = #{id}");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("</insert>");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("<update id=\"update\">");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			//sb.append("SELECT * FROM "+clazzProperty.getTableName()+" WHERE ID = #{id}");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("</update>");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("<delete id=\"delete\">");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("DELETE FROM  " + clazzProperty.getTableName() + " WHERE ID = #{id}");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("</delete>");
			sb.append("\r\n");
			sb.append("</mapper>");

			WriteJavaFileUtil.writeJavaFile(file, sb);
		}
	}
}
