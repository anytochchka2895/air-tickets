package org.example.controllers;

import org.example.dtos.CustomersDto;
import org.example.services.interfaces.CustomersService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomersController {
	private final CustomersService customersService;

	public CustomersController(CustomersService customersService) {this.customersService = customersService;}

	@PostMapping(value = "/customer")
	public CustomersDto saveCustomer(@RequestBody CustomersDto customersDto) {
		return customersService.saveCustomer(customersDto);
	}

	@GetMapping(value = "/customer")
	public List<CustomersDto> getAll() {
		return customersService.getAll();
	}

	@GetMapping(value = "/customer/{id}")
	public CustomersDto getById(@PathVariable UUID id) {
		return customersService.getById(id);
	}

	@DeleteMapping(value = "/customer/{id}")
	public CustomersDto deleteById(@PathVariable UUID id) {
		return customersService.deleteById(id);
	}

	@PostMapping(value = "/customer/get-by-ids")
	public List<CustomersDto> findByIds(@RequestBody List<UUID> customersIds) {
		return customersService.findByIds(customersIds);
	}

	@GetMapping(value = "/customer/get-by-count-tickets")
	public List<CustomersDto> findWhoHaveMore2Tickets(@RequestParam int countTickets){
		return customersService.findWhoHaveMoreThenCountTickets(countTickets);
	}



}
