package com.demo.models;

import java.util.List;

public class TransferTickets {
	private List<Integer> bookingSeats;

	public List<Integer> getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(List<Integer> bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

	public TransferTickets(List<Integer> bookingSeats) {
		super();
		this.bookingSeats = bookingSeats;
	}

	public TransferTickets() {
		super();
	}
	
}
