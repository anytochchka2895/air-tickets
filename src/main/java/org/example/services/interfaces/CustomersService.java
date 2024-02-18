package org.example.services.interfaces;

import org.example.dtos.CustomersDto;

import java.util.*;

public interface CustomersService  {
	CustomersDto saveCustomer(CustomersDto customersDto);

	List<CustomersDto> getAll();

	CustomersDto getById(UUID id);

	CustomersDto deleteById(UUID id);

	List<CustomersDto> findByIds(List<UUID> customersIds);

	List<CustomersDto> findWhoHaveMoreThenCountTickets(int countTickets);


}
