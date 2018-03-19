package com.sundata.mobile.model;
public class MobileAlarmModel {

	private String alarmSheetID;
	private String userid;
	private String licensePlate;
	private String alarmAdress;
	private String alarmTime;
	private String imgUrl;
	private String ProcessingState;
	private String describ;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlarmSheetID() {
		return alarmSheetID;
	}
	public void setAlarmSheetID(String alarmSheetID) {
		this.alarmSheetID = alarmSheetID;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getAlarmAdress() {
		return alarmAdress;
	}
	public void setAlarmAdress(String alarmAdress) {
		this.alarmAdress = alarmAdress;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getProcessingState() {
		return ProcessingState;
	}
	public void setProcessingState(String processingState) {
		ProcessingState = processingState;
	}
	public String getDescrib() {
		return describ;
	}
	public void setDescrib(String describ) {
		this.describ = describ;
	}
}
