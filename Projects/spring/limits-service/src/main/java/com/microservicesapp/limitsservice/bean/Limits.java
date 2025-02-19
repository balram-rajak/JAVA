package com.microservicesapp.limitsservice.bean;

public class Limits {

	int minimum;
	int maximum;
	
	public Limits() {
		super();
	}
	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
