package com.demo.models;

import java.util.Date;

public class PriceByDate {
	private String date;
	private double total;
	
	public PriceByDate() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public PriceByDate(String date, double total) {
		super();
		this.date = date;
		this.total = total;
	}
	
	
}
