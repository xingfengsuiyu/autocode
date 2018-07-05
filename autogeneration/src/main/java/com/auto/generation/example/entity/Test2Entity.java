package com.auto.generation.example.entity;

import com.auto.generation.core.annotation.TableFieldAnnotation;
import com.auto.generation.core.annotation.TableIdAnnotation;
import com.auto.generation.core.annotation.TableNameAnnotation;

import java.math.BigDecimal;
import java.util.Date;

@TableNameAnnotation(value = "test7")
public class Test2Entity {

	@TableIdAnnotation(length = 40, decription = "主键")
	private int id;

	@TableFieldAnnotation(name = "descripetor", length = 20,  description = "描述")
	private String descripetor;

	@TableFieldAnnotation(name = "date", length = 20, description = "日期")
	private Date date;

	@TableFieldAnnotation(name = "bigDecimal", length = 20,description = "bigDecimal")
	private BigDecimal bigDecimal;

	@TableFieldAnnotation(name = "aLong", length = 20, description = "Long")
	private Long aLong;

	@TableFieldAnnotation(name = "add1", length = 20, description = "Long")
	private Long add1;

	public Long getAdd1() {
		return add1;
	}

	public Test2Entity setAdd1(Long add1) {
		this.add1 = add1;
		return this;
	}

	public int getId() {
		return id;
	}

	public Test2Entity setId(int id) {
		this.id = id;
		return this;
	}


	public String getDescripetor() {
		return descripetor;
	}

	public Test2Entity setDescripetor(String descripetor) {
		this.descripetor = descripetor;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public Test2Entity setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public Test2Entity setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
		return this;
	}

	public Long getaLong() {
		return aLong;
	}

	public Test2Entity setaLong(Long aLong) {
		this.aLong = aLong;
		return this;
	}
}
