package com.flyAway.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight implements Serializable {
	private String name;
	private double price;
	private int number;
	private String fromCity;
	private String toCity;
	private LocalTime depatureTime;
	private LocalTime arrivalTime;
	private int totalSeats;
	private int bookedSeats;
	private int seatAvailability;
	private LocalDate travelDate;
	private String flightClass;

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public LocalTime getDepatureTime() {
		return depatureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public int getSeatAvailability() {
		return seatAvailability;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void setSeatAvailability(int seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
