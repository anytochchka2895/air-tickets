package org.example.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tickets")
public class TicketsEntity {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "price")
	private int price;
	@Column(name = "seat_number")
	private String seatNumber;
	@Column(name = "flight_id")
	private UUID flightId;
	@Column(name = "customer_id")
	private UUID customerId;

	public TicketsEntity() {
	}

	public TicketsEntity(UUID id, int price, String seatNumber, UUID flightId, UUID customerId) {
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
