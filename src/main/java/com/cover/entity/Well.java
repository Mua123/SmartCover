package com.cover.entity;

import java.sql.Timestamp;

public class Well {
	private String wellNo;
    private double fLong;
    private double fLati;
    private String province;
    private String city;
    private String district;
    private String street;
    private int wellId;
	private String signalIntensity;
	private String battery;
	private String temperature;
	private String humidity;
	private int upCoverStatus;
	private int downCoverStatus;
	private int vibratingStatus;
	private int authorizationStatus;
	private Timestamp recordTime;
	public String getWellNo() {
		return wellNo;
	}
	public void setWellNo(String wellNo) {
		this.wellNo = wellNo;
	}
	public double getfLong() {
		return fLong;
	}
	public void setfLong(double fLong) {
		this.fLong = fLong;
	}
	public double getfLati() {
		return fLati;
	}
	public void setfLati(double fLati) {
		this.fLati = fLati;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getWellId() {
		return wellId;
	}
	public void setWellId(int wellId) {
		this.wellId = wellId;
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
