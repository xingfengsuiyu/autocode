package com.auto.generation.core.entity;

import com.auto.generation.core.annotation.TableIdAnnotation;
import com.auto.generation.core.annotation.TableIndexAnnotataion;

/**
 * 通用实体类字段
 *
 * @author zc
 * @create 2018-07-02 10:37
 **/
public class BaseEntity {

	@TableIndexAnnotataion(idxName = "IDX_ID", name = "ID", idxType = "UNIQUE", idxDescript = "主键")
	@TableIdAnnotation(length = 20, decription = "主键")
	private Long id;

	public Long getId() {
		return id;
	}

	public BaseEntity setId(Long id) {
		this.id = id;
		return this;
	}
}
