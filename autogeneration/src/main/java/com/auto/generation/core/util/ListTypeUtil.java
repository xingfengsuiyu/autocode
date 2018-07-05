package com.auto.generation.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型集合
 *
 * @author zc
 * @create 2018-06-29 9:39
 **/
public class ListTypeUtil {

	/**
	 * 日期字符串
	 */
	private static List<String> dateList = new ArrayList<>();

	/**
	 * 数字字符串,可以添加小数位的
	 */
	private static List<String> numberList = new ArrayList<>();

	static {
		dateList.add("DATE");
		dateList.add("DATATIME");
		dateList.add("TIMESTAMP");
		numberList.add("FLOAT");
		numberList.add("DOUBLE");
		numberList.add("DECIMAL");
		numberList.add("NUMBER");
	}

	public static List<String> getDateList() {
		return dateList;
	}

	public static List<String> getNumberList() {
		return numberList;
	}
}
