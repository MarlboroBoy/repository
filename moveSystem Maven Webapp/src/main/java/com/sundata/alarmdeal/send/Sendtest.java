package com.sundata.alarmdeal.send;

public class Sendtest {

	public static String  sendModel(String tel,String plateNumber) {
		try {
		Thread.sleep(5000);
		System.out.println("发送车主"+"++++++++++++++++++++++++++++++++++++++"+tel);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return "2";
}}
