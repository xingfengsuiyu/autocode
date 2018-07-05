package com.auto.generation.example2.entity2;

import com.auto.generation.core.annotation.TableFieldAnnotation;
import com.auto.generation.core.annotation.TableIndexAnnotataion;
import com.auto.generation.core.annotation.TableNameAnnotation;
import com.auto.generation.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

@TableNameAnnotation(value = "test4")
public class TestEntity4 extends BaseEntity{


	@TableFieldAnnotation(name = "name", length = 30,  description = "名称")
	private String name;

	@TableIndexAnnotataion(idxName = "idx_descripetor", name = "descripetor", idxType = "", idxDescript = "descripetor")
	@TableFieldAnnotation(name = "descripetor", length = 20,  description = "描述增加")
	private String descripetor;

	@TableFieldAnnotation(name = "date", length = 20, description = "日期")
	private Date date;

	@TableFieldAnnotation(name = "bigDecimal", length = 20,description = "bigDecimal")
	private BigDecimal bigDecimal;

	@TableFieldAnnotation(name = "add3", length = 20, description = "Long")
	private Long add3;

	@TableFieldAnnotation(name = "dd",defaultValue = "2",length = 20, description = "")
	private int dd;

	public String getName() {
		return name;
	}

	public TestEntity4 setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescripetor() {
		return descripetor;
	}

	public TestEntity4 setDescripetor(String descripetor) {
		this.descripetor = descripetor;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public TestEntity4 setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public TestEntity4 setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
		return this;
	}

	public Long getAdd3() {
		return add3;
	}

	public TestEntity4 setAdd3(Long add3) {
		this.add3 = add3;
		return this;
	}
}
