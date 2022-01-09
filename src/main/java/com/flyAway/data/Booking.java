package com.flyAway.data;

public class Booking {
	private int bookingId;
	private String username;
	private int flightNumber;

	public int getBookingId() {
		return bookingId;
	}

	public String getUsername() {
		return username;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
}
