package com.sundata.common.base;

public class BaseModel {
	private String sundataEditType; // 编辑方式，新增/修改，前台pageForm的needEditFlag为true时自动维护

	//此变量由前台维护，不是每次请求都会传递给后台，也不能保证每次返回时都有值，因此不能带回前台，不能编写get方法
	public String fetchSundataEditType() {
		return sundataEditType;
	}
	public void setSundataEditType(String sundataEditType) {
		this.sundataEditType = sundataEditType;
	}
}
