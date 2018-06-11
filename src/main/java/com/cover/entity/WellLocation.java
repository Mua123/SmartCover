package com.cover.entity;

public class WellLocation {
	private String wellNo;
    private double fLong;
    private double fLati;
    private String province;
    private String city;
    private String district;
    private String street;
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
}
