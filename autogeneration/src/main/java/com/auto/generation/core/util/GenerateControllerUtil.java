package com.auto.generation.core.util;

import com.auto.generation.core.csm.ClazzProperty;

import java.io.*;

/**
 * 自动生成Controller工具类
 *
 * @author zc
 * @create 2018-07-10 19:50
 **/
public class GenerateControllerUtil {

	public static void generateController(ClazzProperty clazzProperty) {
		//判断包是否存在
		File dir = new File(clazzProperty.getClassUrl() + File.separator + "controller");
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Controller是否存在
		File file = new File(clazzProperty.getClassUrl() + "controller" + File.separator + clazzProperty.getName() + "Controller.java");
		if (!file.isFile()) {
			String serviceLowCaseFirst = ConverUpOrLowerUtil.toLowerCaseFirstOne(clazzProperty.getName() + "Service");
			StringBuilder sb = new StringBuilder();
			sb.append("package ");
			sb.append(clazzProperty.getPackageName() + ".controller;");
			sb.append("\r\n\r\n");
			sb.append("import java.util.List;");
			sb.append("\r\n");
			sb.append("import org.springframework.web.bind.annotation.*;");
			sb.append("\r\n");
			sb.append("import org.springframework.beans.factory.annotation.Autowired;");
			sb.append("\r\n");
			sb.append("import org.springframework.stereotype.Controller;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".service." + clazzProperty.getName() + "Service;");
			sb.append("\r\n");
			sb.append("import " + clazzProperty.getPackageName() + ".entity." + clazzProperty.getName() + "Entity;");
			sb.append("\r\n\r\n\r\n\r\n");
			sb.append("@Controller ");
			sb.append("\r\n");
			sb.append("@RequestMapping(\"/" + ConverUpOrLowerUtil.toLowerCaseFirstOne(clazzProperty.getName()) + "\") ");
			sb.append("\r\n");
			sb.append("public class " + clazzProperty.getName() + "Controller" + " {");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@Autowired");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("private " + clazzProperty.getName() + "Service" + " " + serviceLowCaseFirst + ";");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/list\") ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public List<" + clazzProperty.getName() + "Entity> page(int pageNum, int pageSize) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return " + serviceLowCaseFirst + ".page(pageNum, pageSize);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/query/{id}\", method = RequestMethod.GET) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public " + clazzProperty.getName() + "Entity queryById(@PathVariable(\"id\") Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return " + serviceLowCaseFirst + ".queryById(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/add\", method = RequestMethod.POST) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public void add(@RequestBody " + clazzProperty.getName() + "Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(serviceLowCaseFirst + ".add(add);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/update\", method = RequestMethod.PUT) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public void update(@RequestBody " + clazzProperty.getName() + "Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(serviceLowCaseFirst + ".update(add);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/delete/{id}\", method = RequestMethod.DELETE) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public void delete(@PathVariable(\"id\") Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append(serviceLowCaseFirst + ".delete(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n");
			sb.append("}");
			WriteJavaFileUtil.writeJavaFile(file, sb);
		}
	}

	public static void main(String[] args) {
		ClazzProperty clazzProperty = new ClazzProperty();
		clazzProperty.setClassUrl("E:\\workspace\\idea\\auto\\autogeneration\\src\\main\\java\\com\\auto\\generation\\core\\util\\");
		clazzProperty.setPackageName("com.auto.generation.core.util");
		clazzProperty.setName("Test");
		generateController(clazzProperty);

	}
}
