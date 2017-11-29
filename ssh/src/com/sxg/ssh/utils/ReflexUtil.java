package com.sxg.ssh.utils;

import java.lang.reflect.Method;


public class ReflexUtil {
	
	public static Method getMethod(String className, String methodName, Class... classes) throws Exception {
		  Class<?> clz = Class.forName(className);
		  //��ȡ����ʵ��
		  Object obj = clz.newInstance();
		  //��ȡ����  
		  return obj.getClass().getDeclaredMethod(methodName, classes);
	}
	
	public static String getFullPath(Class<?> cla) {
		return cla.getClass().getClassLoader().getResource("").getPath();
	}
}
