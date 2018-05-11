package com.sundata.admin.model;

public class MessageModel {
private int messageId;
private String title;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
private String cont;
private String addTime;
private String isUse;


public int getMessageId() {
	return messageId;
}
public void setMessageId(int messageId) {
	this.messageId = messageId;
}
public String getCont() {
	return cont;
}
public void setCont(String cont) {
	this.cont = cont;
}
public String getAddTime() {
	return addTime;
}
public void setAddTime(String addTime) {
	this.addTime = addTime;
}
public String getIsUse() {
	return isUse;
}
public void setIsUse(String isUse) {
	this.isUse = isUse;
}

}
