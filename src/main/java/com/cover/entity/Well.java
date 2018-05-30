package com.cover.entity;

public class Well {
	private int id;
    private double fLong;
    private double fLati;
    private String orderON;
    private int UpCoverStatus;
    private int VibratingStatus;
    private int DownCoverStatus;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUpCoverStatus() {
		return UpCoverStatus;
	}
	public void setUpCoverStatus(int upCoverStatus) {
		UpCoverStatus = upCoverStatus;
	}
	public int getVibratingStatus() {
		return VibratingStatus;
	}
	public void setVibratingStatus(int vibratingStatus) {
		VibratingStatus = vibratingStatus;
	}
	public int getDownCoverStatus() {
		return DownCoverStatus;
	}
	public void setDownCoverStatus(int downCoverStatus) {
		DownCoverStatus = downCoverStatus;
	}
	public String getOrderON() {
		return orderON;
	}
	public void setOrderON(String orderON) {
		this.orderON = orderON;
	}    
}
