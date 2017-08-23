package com.thtf.util;

public class StringUtil {

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String getFirstUpCase(String str) {
		char[] cs = str.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	public static void main(String[] args) {
		System.out.println(StringUtil.getFirstUpCase("zkyx"));
	}
}
