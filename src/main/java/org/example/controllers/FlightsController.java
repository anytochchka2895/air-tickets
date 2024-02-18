package org.example.controllers;

import org.example.dtos.FlightsDto;
import org.example.services.interfaces.FlightsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FlightsController {
	private final FlightsService flightsService;

	public FlightsController(FlightsService flightsService) {this.flightsService = flightsService;}

	@PostMapping(value = "/flights")
	public FlightsDto saveCustomer(@RequestBody FlightsDto flightsDto) {
		return flightsService.saveFlight(flightsDto);
	}

	@GetMapping(value = "/flights")
	public List<FlightsDto> getAll() {
		return flightsService.getAll();
	}

	@GetMapping(value = "/flights/{id}")
	public FlightsDto getById(@PathVariable UUID id) {
		return flightsService.getById(id);
	}

	@DeleteMapping(value = "/flights/{id}")
	public FlightsDto deleteById(@PathVariable UUID id) {
		return flightsService.deleteById(id);
	}


	@GetMapping(value = "/flights/by-filters")
	public List<FlightsDto> getByFilter(@RequestParam String arrivalCity){
		return flightsService.getByFilter(arrivalCity);
	}

	@GetMapping(value = "/flights/price-more-300")
	public List<FlightsDto> findAllByPriceMore300(){
		return flightsService.findAllByPriceMore300();
	}

	@GetMapping(value = "/flights/price-more-than")
	public List<FlightsDto> findAllByPriceMoreThan(@RequestParam int price) {
		return flightsService.findAllByPriceMoreThan(price);
	}

//	@GetMapping(value = "/flights/by-city-filters")
//	public List<FlightsDto> findAllFlightsFromNToM(@RequestParam String departureCity, @RequestParam String arrivalCity) {
//		return flightsService.findAllFlightsFromNToM(departureCity, arrivalCity);
//	}

	@GetMapping (value = "/flights/by-citys-filters")
	public List<FlightsDto> findAllByDepartureCityAndArrivalCity(@RequestParam String departureCity, @RequestParam String arrivalCity) {
		return flightsService.findAllByDepartureCityAndArrivalCity(departureCity, arrivalCity);
	}

	@GetMapping (value = "/flights/by-city-filters")
	public List<FlightsDto> findAllByDepartureCity(@RequestParam String departureCity) {
		return flightsService.findAllByDepartureCity(departureCity);
	}


}
