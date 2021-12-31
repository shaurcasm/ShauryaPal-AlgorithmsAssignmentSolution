package com.shaurya.service.company;

public class Company {

	private double stock;
	private boolean priceRose;
	
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getStock() {
		return stock;
	}
	
	public void setPriceRose(boolean priceRose) {
		this.priceRose = priceRose;
	}
	public boolean getPriceRose() {
		return priceRose;
	}
}
