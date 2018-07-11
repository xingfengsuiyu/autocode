package com.auto.generation.core.util;

import com.auto.generation.core.csm.ControllerProperty;

import java.io.*;

/**
 * 自动生成Controller工具类
 *
 *@author zc
 *@create 2018-07-10 19:50
 **/
public class GenerateControllerUtil {

	public static  void generateController(ControllerProperty controllerProperty){
		//判断包是否存在
		File dir = new File(controllerProperty.getClassUrl()+"controller");
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		//判断Controller是否存在
		File file = new File(controllerProperty.getClassUrl()+"controller" + File.separator + controllerProperty.getName()+"Controller.java");
		if (!file.isFile()) {
			String serviceLowCaseFirst = ConverUpOrLowerUtil.toLowerCaseFirstOne(controllerProperty.getName()+"Service");
			StringBuilder sb = new StringBuilder();
			sb.append("package \t");
			sb.append(controllerProperty.getPackageName() + ".controller;");
			sb.append("\r\n\r\n");
			sb.append("import java.util.List;");
			sb.append("\r\n");
			sb.append("import org.springframework.web.bind.annotation.*;");
			sb.append("\r\n");
			sb.append("import org.springframework.beans.factory.annotation.Autowired;");
			sb.append("\r\n");
			sb.append("import org.springframework.stereotype.Controller;");
			sb.append("\r\n");
			sb.append("import "+ controllerProperty.getPackageName()+".service."+controllerProperty.getName()+"Service;");
			sb.append("\r\n");
			sb.append("import "+ controllerProperty.getPackageName()+".entity."+controllerProperty.getName()+"Entity;");
			sb.append("\r\n\r\n\r\n\r\n");
			sb.append("@Controller ");
			sb.append("\r\n");
			sb.append("@RequestMapping(\"/"+ConverUpOrLowerUtil.toLowerCaseFirstOne(controllerProperty.getName())+"\") ");
			sb.append("\r\n");
			sb.append("public class "+controllerProperty.getName()+"Controller" + " {");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@Autowired");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("private "+controllerProperty.getName()+"Service" + " " + serviceLowCaseFirst+";");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/list\") ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public List<"+controllerProperty.getName()+"Entity> page(int pageNum, int pageSize) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return "+serviceLowCaseFirst+".page(pageNum, pageSize);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/query/{id}\", method = RequestMethod.GET) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public "+controllerProperty.getName()+"Entity queryById(@PathVariable(\"id\") Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return "+serviceLowCaseFirst+".queryById(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/add\", method = RequestMethod.POST) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public "+controllerProperty.getName()+"Entity add(@RequestBody "+controllerProperty.getName()+"Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return "+serviceLowCaseFirst+".add(add);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/update\", method = RequestMethod.PUT) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public "+controllerProperty.getName()+"Entity update(@RequestBody "+controllerProperty.getName()+"Entity entity) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return "+serviceLowCaseFirst+".update(add);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n\r\n");
			sb.append("\t");
			sb.append("@RequestMapping(value = \"/delete/{id}\", method = RequestMethod.DELETE) ");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("public "+controllerProperty.getName()+"Entity delete(@PathVariable(\"id\") Long id) {");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("\t");
			sb.append("return "+serviceLowCaseFirst+".delete(id);");
			sb.append("\r\n");
			sb.append("\t");
			sb.append("}");
			sb.append("\r\n");
			sb.append("}");
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				try {
					fileOutputStream.write(sb.toString().getBytes());
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ControllerProperty controllerProperty = new ControllerProperty();
		controllerProperty.setClassUrl("E:\\workspace\\idea\\auto\\autogeneration\\src\\main\\java\\com\\auto\\generation\\core\\util\\");
		controllerProperty.setPackageName("com.auto.generation.core");
		controllerProperty.setName("Test");
		generateController(controllerProperty);

	}
}
