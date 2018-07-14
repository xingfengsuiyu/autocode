package com.auto.generation.core.util;

import com.auto.generation.core.csm.ClazzProperty;

import java.io.File;

/**
 * 自动生成service类
 *
 * @author zc
 * @create 2018-07-12 19:46
 **/
public class GenerateServiceUtil {

	public static void generateService(ClazzProperty c) {
		generateIService(c);
		generateServiceImpl(c);
	}

	/***
	 * @author zc
	 * @date 2018/7/12 19:57
	 * @param [clazzProperty]
	 * @return void
	 * @description 自动生成service接口
	 */
	private static void generateIService(ClazzProperty clazzProperty) {
		//判断包是否存在
		File dir = new File(clazzProperty.getClassUrl() + File.separator + "service");
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Service是否存在
		File file = new File(clazzProperty.getClassUrl() + File.separator + "service" + File.separator + clazzProperty.getName() + "Service.java");
		if (!file.isFile()) {
			StringBuilder sb = new StringBuilder();
			sb.append("package ");
			sb.append(clazzProperty.getPackageName() + ".service;");
			sb.append("\r\n\r\n");
			sb.append("import java.util.List;");
			sb.append("\r\n");
			sb.append("import "+ clazzProperty.getPackageName()+".entity."+ clazzProperty.getName()+"Entity;");
			sb.append("\r\n\r\n\r\n\r\n");
			sb.append("public interface "+ clazzProperty.getName()+"Service" + " {");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("List<"+clazzProperty.getName()+"Entity> page(int pageNum, int pageSize);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append(clazzProperty.getName()+"Entity queryById(Long id);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("void add("+ clazzProperty.getName()+"Entity entity);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("void update("+ clazzProperty.getName()+"Entity entity);");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("void delete(Long id);");
			sb.append("\r\n");
			sb.append("}");
			WriteJavaFileUtil.writeJavaFile(file, sb);
		}
	}
	/**
	 * @author zc
	 * @date 2018/7/12 19:58
	 * @param [clazzProperty]
	 * @return void
	 * @description 自动生成service实现类
	 */
	private static void generateServiceImpl(ClazzProperty clazzProperty) {
		//判断包是否存在
		File dir = new File(clazzProperty.getClassUrl() + File.separator + "service"+File.separator+"impl");
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Service是否存在
		File file = new File(clazzProperty.getClassUrl() + File.separator + "service" + File.separator +"impl"+File.separator+ clazzProperty.getName() + "ServiceImpl.java");
		if (!file.isFile()) {
			String mapperLowCaseFirst = ConverUpOrLowerUtil.toLowerCaseFirstOne(clazzProperty.getName() + "Mapper");
			StringBuilder sb = new StringBuilder();
			sb.append("package ");
			sb.append(clazzProperty.getPackageName() + ".service.impl;");
			sb.append("\r\n\r\n");
			sb.append("import java.util.List;");
			sb.append("\r\n");
			sb.append("import org.springframework.beans.factory.annotation.Autowired;");
			sb.append("\r\n");
			sb.append("import org.springframework.stereotype.Service;");
			sb.append("\r\n");
			sb.append("import com.github.pagehelper.PageHelper;");
			sb.append("\r\n");
			//sb.append("import org.springframework.data.redis.core.RedisTemplate;");
			//sb.append("\r\n");
			//sb.append("import org.springframework.data.redis.core.ValueOperations;");
			//sb.append("\r\n");
			//sb.append("import java.util.concurrent.TimeUnit;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".service." + clazzProperty.getName() + "Service;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".entity." + clazzProperty.getName() + "Entity;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".mapper." + clazzProperty.getName() + "Mapper;");
			sb.append("\r\n\r\n\r\n\r\n");
			sb.append("@Service ");
			sb.append("\r\n");
			sb.append("public class " + clazzProperty.getName() + "ServiceImpl implements " +clazzProperty.getName()+"Service "+ "{");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@Autowired");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("private " + clazzProperty.getName() + "Mapper" + " " + mapperLowCaseFirst + ";");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public List<" + clazzProperty.getName() + "Entity> page(int pageNum, int pageSize) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("PageHelper.startPage(pageNum, pageSize);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("List<" + clazzProperty.getName() + "Entity> listEntity = "+ mapperLowCaseFirst + ".page();");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return listEntity;");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public " + clazzProperty.getName() + "Entity queryById(Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return " + mapperLowCaseFirst + ".queryById(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public void add(" + clazzProperty.getName() + "Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(mapperLowCaseFirst + ".add(entity);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public void update(" + clazzProperty.getName() + "Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(mapperLowCaseFirst + ".update(entity);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("public void delete(Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(mapperLowCaseFirst + ".delete(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n");
			sb.append("}");
			WriteJavaFileUtil.writeJavaFile(file, sb);
		}
	}
}
