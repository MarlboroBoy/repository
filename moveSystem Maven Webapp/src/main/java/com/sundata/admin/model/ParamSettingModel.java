package com.sundata.admin.model;

public class ParamSettingModel {

	private String workType;
	private int resendTimes;
	private int timeOut;
	private String messageId;
	
	private  String callTimeOut;
	private  String callTimes;
	private  String callTimeLater;
	
	
	public String getCallTimeOut() {
		return callTimeOut;
	}
	public void setCallTimeOut(String callTimeOut) {
		this.callTimeOut = callTimeOut;
	}
	public String getCallTimes() {
		return callTimes;
	}
	public void setCallTimes(String callTimes) {
		this.callTimes = callTimes;
	}
	public String getCallTimeLater() {
		return callTimeLater;
	}
	public void setCallTimeLater(String callTimeLater) {
		this.callTimeLater = callTimeLater;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public int getResendTimes() {
		return resendTimes;
	}
	public void setResendTimes(int resendTimes) {
		this.resendTimes = resendTimes;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
