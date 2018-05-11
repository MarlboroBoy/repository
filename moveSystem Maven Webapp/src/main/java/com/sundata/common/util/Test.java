package com.sundata.common.util;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		System.out.println(DateUtil.getNowTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		System.out.println(df.format(DateUtil.getNowLaterTime(1)));
		
	}
}
