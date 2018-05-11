package com.sundata.login.admin;

import java.io.Serializable;

public class ActiveUser implements Serializable {
	
	private static final long serialVersionUID = 2426849951968743990L;
private String managerLevel;
	public String getManagerLevel() {
	return managerLevel;
}
public void setManagerLevel(String managerLevel) {
	this.managerLevel = managerLevel;
}
	private String account;		//操作员编号	//操作员名称
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}



	




	
	}
