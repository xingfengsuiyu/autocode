package com.auto.generation.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 输出java文件
 *
 * @author zc
 * @create 2018-07-12 21:07
 **/
public class WriteJavaFileUtil {

	public static void writeJavaFile(File file , StringBuilder sb){
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
