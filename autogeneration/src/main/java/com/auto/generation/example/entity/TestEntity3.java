package com.auto.generation.example.entity;

import com.auto.generation.core.annotation.TableFieldAnnotation;
import com.auto.generation.core.annotation.TableIdAnnotation;
import com.auto.generation.core.annotation.TableNameAnnotation;

import java.math.BigDecimal;
import java.util.Date;

@TableNameAnnotation(value = "test8")
public class TestEntity3 {

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

	@TableFieldAnnotation(name = "add3", length = 20, description = "Long")
	private Long add3;

	@TableFieldAnnotation(name = "dd",defaultValue = "2",length = 20, description = "")
	private int dd;
	public int getId() {
		return id;
	}

	public TestEntity3 setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TestEntity3 setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescripetor() {
		return descripetor;
	}

	public TestEntity3 setDescripetor(String descripetor) {
		this.descripetor = descripetor;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public TestEntity3 setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public TestEntity3 setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
		return this;
	}

	public Long getAdd3() {
		return add3;
	}

	public TestEntity3 setAdd3(Long add3) {
		this.add3 = add3;
		return this;
	}
}
