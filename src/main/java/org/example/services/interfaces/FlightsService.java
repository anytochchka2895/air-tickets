package org.example.services.interfaces;

import org.example.dtos.FlightsDto;

import java.util.*;

public interface FlightsService {
	FlightsDto saveFlight(FlightsDto flightsDto);

	List<FlightsDto> getAll();

	FlightsDto getById(UUID id);

	FlightsDto deleteById(UUID id);

	List<FlightsDto> getByFilter(String arrivalCity);

	List<FlightsDto> findAllByPriceMore300();
	List<FlightsDto> findAllByPriceMoreThan(int price);

//	List<FlightsDto> findAllFlightsFromNToM(String departureCity, String arrivalCity);

	List<FlightsDto> findAllByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

	List<FlightsDto> findAllByDepartureCity (String departureCity);



}
