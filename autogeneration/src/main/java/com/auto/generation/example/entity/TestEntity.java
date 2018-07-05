package com.auto.generation.example.entity;

import com.auto.generation.core.annotation.TableFieldAnnotation;
import com.auto.generation.core.annotation.TableIdAnnotation;
import com.auto.generation.core.annotation.TableNameAnnotation;

import java.math.BigDecimal;
import java.util.Date;

@TableNameAnnotation(value = "test6")
public class TestEntity {

	@TableIdAnnotation(length = 40, decription = "主键")
	private int id;

	@TableFieldAnnotation(name = "name", length = 20,  description = "名称")
	private String name;

	@TableFieldAnnotation(name = "descripetor", length = 20,  description = "描述")
	private String descripetor;

	@TableFieldAnnotation(name = "date", length = 20, description = "日期")
	private Date date;

	@TableFieldAnnotation(name = "bigDecimal", length = 20,description = "bigDecimal")
	private BigDecimal bigDecimal;


	public int getId() {
		return id;
	}

	public TestEntity setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TestEntity setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescripetor() {
		return descripetor;
	}

	public TestEntity setDescripetor(String descripetor) {
		this.descripetor = descripetor;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public TestEntity setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public TestEntity setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
		return this;
	}
}
