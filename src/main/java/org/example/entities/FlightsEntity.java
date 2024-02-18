package org.example.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "flights")
public class FlightsEntity {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "departure_city")
	private String departureCity;
	@Column(name = "arrival_city")
	private String arrivalCity;
	@Column(name = "departure_time")
	private String departureTime;
	@Column(name = "arrival_time")
	private String arrivalTime;
	@Column(name = "airlines_id")
	private UUID airlinesId;

	public FlightsEntity() {
	}

	public FlightsEntity(UUID id, String departureCity, String arrivalCity, String departureTime, String arrivalTime, UUID airlinesId) {
		this.id = id;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airlinesId = airlinesId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public UUID getAirlinesId() {
		return airlinesId;
	}

	public void setAirlinesId(UUID airlinesId) {
		this.airlinesId = airlinesId;
	}
}
