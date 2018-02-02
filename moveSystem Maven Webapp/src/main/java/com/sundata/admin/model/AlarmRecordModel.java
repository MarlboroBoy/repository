package com.sundata.admin.model;

public class AlarmRecordModel {
	private int id;//报警信息id
	private int alarmid;
	private int carmessage;
	private int ownerid;//车主id
	private String uptime;//报警时间
	private int userId;//报警人id
	private String licensePlate;//车牌号
	private String alarmAdress;
	private  String alarmTime;
	private String imgUrl;
	private String processingState;//处理状态
	private String userName; //报警人姓名
	private String carOwnName;//车主姓名
	private String telphone;//车主电话
	private String tel;//报警人电话
	
	
	
	
	
	
	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCarOwnName() {
		return carOwnName;
	}
	public void setCarOwnName(String carOwnName) {
		this.carOwnName = carOwnName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		return processingState;
	}
	public void setProcessingState(String processingState) {
		this.processingState = processingState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAlarmid() {
		return alarmid;
	}
	public void setAlarmid(int alarmid) {
		this.alarmid = alarmid;
	}
	public int getCarmessage() {
		return carmessage;
	}
	public void setCarmessage(int carmessage) {
		this.carmessage = carmessage;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	

}
