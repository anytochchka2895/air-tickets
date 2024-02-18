package org.example.dtos;

import java.util.UUID;

public class TicketsDto {
	private UUID id;
	private int price;
	private String seatNumber;
	private UUID flightId;
	private UUID customerId;

	public TicketsDto() {
	}

	public TicketsDto(UUID id, int price, String seatNumber, UUID flightId, UUID customerId) {
		this.id = id;
		this.price = price;
		this.seatNumber = seatNumber;
		this.flightId = flightId;
		this.customerId = customerId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public UUID getFlightId() {
		return flightId;
	}

	public void setFlightId(UUID flightId) {
		this.flightId = flightId;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
}
