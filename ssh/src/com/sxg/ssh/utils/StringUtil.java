package com.sxg.ssh.utils;

import java.util.Random;

public class StringUtil {
	
	private static Random random = new Random();
	private static final int DEFAULT_MAX_NUM = 100;
	
	/** 
	 * ����ĸ��д 
	 *  
	 * @param string 
	 * @return 
	 */  
	public static String toUpperCase4Index(String string) {  
	    char[] methodName = string.toCharArray();  
	    methodName[0] = toUpperCase(methodName[0]);  
	    return String.valueOf(methodName);  
	}
	
	/** 
	 * �ַ�ת�ɴ�д 
	 *  
	 * @param chars 
	 * @return 
	 */  
	public static char toUpperCase(char chars) {  
	    if (97 <= chars && chars <= 122) {  
	        chars ^= 32;  
	    }  
	    return chars;  
	}  
	
	/**
	 * ����ĸ��д 
	 * 
	 * @param str
	 * @return
	 */
    public static String toUpperCaseForFirst(String str) {
//    	StringBuffer strBuffer = new StringBuffer();
//    	
//    	strBuffer.append(str.substring(0, 1).toUpperCase());
//    	strBuffer.append(str.substring(1));
//    	
//    	return strBuffer.toString();
    	
    	return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    /**
     * �Ƿ�������ַ���
     */
    public static boolean isContainSubstring(String str, String substring) {
    	return 0 != str.indexOf(substring);
    }
    
    /**
     * �Ƿ�Ϊ���ַ���
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
    	if (str == null || str == "") {
    		return true;
    	}
    	
    	return false;
    }
    
    /**
	 * ֻҪ��һ��Ϊnull���ʱ�ͷ���true
     * @param strs
     * @return
     */
    public static boolean isNullOrEmptyForMultiStr(String... strs)  {
    	for (String str : strs) {
    		if (isNullOrEmpty(str)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * �Ƿ�����Ӵ�
     * @param str
     * @param subStr
     * @return
     */
    public static boolean isContain(String str, String subStr) {
    	return str.contains(subStr);
    }
    
	/**
	 * 生成当前纳秒值的字符串
	 * */
	public static String createTimestamp() {
	    return String.valueOf(System.nanoTime())
	    		.concat(String.valueOf(random.nextInt(DEFAULT_MAX_NUM)));
	}
    
}
