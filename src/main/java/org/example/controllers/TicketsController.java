package org.example.controllers;

import org.example.dtos.TicketsDto;
import org.example.services.interfaces.TicketsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TicketsController {
	private final TicketsService ticketsService;

	public TicketsController(TicketsService ticketsService) {this.ticketsService = ticketsService;}


	@PostMapping(value = "/ticket")
	public TicketsDto saveTickets(@RequestBody TicketsDto ticketsDto) {
		return ticketsService.saveTickets(ticketsDto);
	}

	@GetMapping(value = "/ticket")
	public List<TicketsDto> getAll() {
		return ticketsService.getAll();
	}

	@GetMapping(value = "/ticket/{id}")
	public TicketsDto getById(@PathVariable UUID id) {
		return ticketsService.getById(id);
	}

	@DeleteMapping(value = "/ticket/{id}")
	public TicketsDto deleteById(@PathVariable UUID id) {
		return ticketsService.deleteById(id);
	}

	@GetMapping(value = "/ticket/by-max-price")
	public List<TicketsDto> findAllByMaxPrice() {
		return ticketsService.findAllByMaxPrice();
	}

	@GetMapping(value = "/ticket/by-avg-price")
	public Integer findAvgPrice() {
		return ticketsService.findAvgPrice();
	}

	@GetMapping(value = "/ticket/by-departure-city")
	public List<TicketsDto> findAllTicketsFromDepartureCity(@RequestParam String departureCity){
		return ticketsService.findAllTicketsFromDepartureCity(departureCity);
	}

	@PostMapping(value = "/ticket/by-ids")
	public List<TicketsDto> findAllById(@RequestBody List<UUID> ids){
		return ticketsService.findAllByIds(ids);
	}

	@PostMapping(value = "/ticket/by-flights-ids")
	public List<TicketsDto> findAllByFlightIds(@RequestBody List<UUID> flightIds) {
		return ticketsService.findAllByFlightIds(flightIds);
	}

}
