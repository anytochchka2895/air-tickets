package org.example.services.interfaces;


import org.example.dtos.TicketsDto;

import java.util.*;

public interface TicketsService {
	TicketsDto saveTickets(TicketsDto ticketsDto);

	List<TicketsDto> getAll();

	TicketsDto getById(UUID id);

	TicketsDto deleteById(UUID id);

	List<TicketsDto> findAllByMaxPrice();

	Integer findAvgPrice();

	List<TicketsDto> findAllTicketsFromDepartureCity(String departureCity);

	List<TicketsDto> findAllByIds(List<UUID> ids);

	List<TicketsDto> findAllByFlightIds(List<UUID> flightIds);

}
