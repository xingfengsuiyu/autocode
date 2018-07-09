package com.auto.generation;

import com.auto.generation.core.service.AutoGenerateTableService;
import com.auto.generation.core.service.AutoGenerateTableSqlService;
import com.auto.generation.example2.entity2.TestEntity4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutogenerationApplicationTests {

	@Autowired
	private AutoGenerateTableService autoGenerateTableService;

	@Autowired
	private AutoGenerateTableSqlService autoGenerateTableSqlService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void tableTest() throws Exception {
		Long startTime = System.currentTimeMillis();
		autoGenerateTableService.generationTable();
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		//AutoGenerateTableServiceImpl autoGenerationService = new AutoGenerateTableServiceImpl();
		//List<Class<?>> list = autoGenerateTableService.scanPack("com.acme.autogeneration.example");
		//List<TableProperty> tablePropertyList = autoGenerateTableService.scanModel(list, "MySQL");
		//String str = autoGenerateTableService.generationCreateSql(tablePropertyList,"MySQL");
		//
		////String sql = str.replaceAll("'","\"");
		////System.out.println(sql);
		//String updateSql = autoGenerateTableService.generationUpdateSql(tablePropertyList,"mysql");
		//autoGenerateTableSqlService.executeSql(updateSql);
		//System.out.println(updateSql);
		//autoGenerateTableSqlService.executeSql(str);
	}

	@Test
	public void superClass() throws Exception {
		String superClassStr = TestEntity4.class.getGenericSuperclass().getTypeName();
		System.out.println(superClassStr.substring(superClassStr.lastIndexOf(".")+1));
		System.out.println(TestEntity4.class.getGenericSuperclass().getTypeName());
		System.out.println(TestEntity4.class.getGenericSuperclass().getClass().getName());
		System.out.println(TestEntity4.class.getName());
		System.out.println(TestEntity4.class.getSimpleName());
		String[] strings = new String[2];

	}

}
