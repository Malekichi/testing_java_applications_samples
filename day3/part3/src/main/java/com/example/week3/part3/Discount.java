package com.example.week3.part3;

public class Discount {

	private final String discountName;

	private final double rate;

	public Discount(String discountName, double rate) {
		this.discountName = discountName;
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public String getDiscountName() {
		return discountName;
	}
}
