package org.example.dtos;

import java.util.UUID;

public class FlightsDto {
	private UUID id;
	private String departureCity;
	private String arrivalCity;
	private String departureTime;
	private String arrivalTime;
	private UUID airlinesId;

	public FlightsDto() {
	}

	public FlightsDto(UUID id, String departureCity, String arrivalCity, String departureTime, String arrivalTime, UUID airlinesId) {
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
