package com.data;


public class Order {
	
	private int securityID;
	private int position;
	private long time;
	private double price;
	private int volume;
	
	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public Order(int securityID, int position, long time, double price, int volume) {
		super();
		this.securityID = securityID;
		this.position = position;
		this.time = time;
		this.price = price;
		this.volume = volume;
	}


	public Order(int securityID, int position, long time, double price) {
		super();
		this.securityID = securityID;
		this.position = position;
		this.time = time;
		this.price = price;
	}
	
	
	public int getSecurityID() {
		return securityID;
	}
	public void setSecurityID(int securityID) {
		this.securityID = securityID;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String printOrder() {
		return "SECID: " + securityID + ", Position = " + position + ", Time = " + time + ", Price = " + price + ", Volume = " + volume; 
	}

}
