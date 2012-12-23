package com.movieRecommender;

public class Ratings {
	int user;
	int rateValue;
	
	public Ratings(int user, int rateValue) {
		super();
		this.user = user;
		this.rateValue = rateValue;
	}
	@Override
	public String toString() {
		return "Ratings [user=" + user + ", rateValue=" + rateValue + "]";
	}
	protected int getUser() {
		return user;
	}
	protected void setUser(int user) {
		this.user = user;
	}
	protected int getRateValue() {
		return rateValue;
	}
	protected void setRateValue(int rateValue) {
		this.rateValue = rateValue;
	}
	  
}
