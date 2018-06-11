package com.cover.entity;

import java.sql.Timestamp;

public class WellStatus {
	private int wellId;
	private String WellNo;
	private String signalIntensity;
	private String battery;
	private String temperature;
	private String humidity;
	private int upCoverStatus;
	private int downCoverStatus;
	private int vibratingStatus;
	private int authorizationStatus;
	private Timestamp recordTime;
	public int getWellId() {
		return wellId;
	}
	public void setWellId(int wellId) {
		this.wellId = wellId;
	}
	public String getWellNo() {
		return WellNo;
	}
	public void setWellNo(String wellNo) {
		WellNo = wellNo;
	}
	public String getSignalIntensity() {
		return signalIntensity;
	}
	public void setSignalIntensity(String signalIntensity) {
		this.signalIntensity = signalIntensity;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public int getUpCoverStatus() {
		return upCoverStatus;
	}
	public void setUpCoverStatus(int upCoverStatus) {
		this.upCoverStatus = upCoverStatus;
	}
	public int getDownCoverStatus() {
		return downCoverStatus;
	}
	public void setDownCoverStatus(int downCoverStatus) {
		this.downCoverStatus = downCoverStatus;
	}
	public int getVibratingStatus() {
		return vibratingStatus;
	}
	public void setVibratingStatus(int vibratingStatus) {
		this.vibratingStatus = vibratingStatus;
	}
	public int getAuthorizationStatus() {
		return authorizationStatus;
	}
	public void setAuthorizationStatus(int authorizationStatus) {
		this.authorizationStatus = authorizationStatus;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
