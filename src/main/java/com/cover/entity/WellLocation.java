package com.cover.entity;

public class WellLocation {
	private String WellNO;
    private double fLong;
    private double fLati;
    private String Province;
    private String City;
    private String District;
    private String Road;
    
	public String getWellNO() {
		return WellNO;
	}
	public void setWellNO(String wellNO) {
		WellNO = wellNO;
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
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getRoad() {
		return Road;
	}
	public void setRoad(String road) {
		Road = road;
	}       
}
