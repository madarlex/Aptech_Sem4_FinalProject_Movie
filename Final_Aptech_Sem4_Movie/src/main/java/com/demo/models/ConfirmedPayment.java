package com.demo.models;

public class ConfirmedPayment {
	
	private int bookingSeats;
	
	private double price;
	private double paymentAmount;
	public int getBookingSeats() {
		return bookingSeats;
	}
	public void setBookingSeats(int bookingSeats) {
		this.bookingSeats = bookingSeats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public ConfirmedPayment(int bookingSeats, double price, double paymentAmount) {
		super();
		this.bookingSeats = bookingSeats;
		this.price = price;
		this.paymentAmount = paymentAmount;
	}
	public ConfirmedPayment() {
		super();
	}
	
	
	
}
