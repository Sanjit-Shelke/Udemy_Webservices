package com.in28minutes.mircroservices.limits_service.bean;

public class Limits {
	private int minimum;
	private int maxmimum;
	
	
	public Limits() {
		super();
	}
	
	public Limits(int minimum, int maxmimum) {
		super();
		this.minimum = minimum;
		this.maxmimum = maxmimum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaxmimum() {
		return maxmimum;
	}
	public void setMaxmimum(int maxmimum) {
		this.maxmimum = maxmimum;
	}
	
	

}
