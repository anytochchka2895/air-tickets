package org.example.mappers;

import org.example.dtos.*;
import org.example.entities.*;

import java.util.*;

public class Mapper {
	public static CustomersDto customersToDto(CustomersEntity customersEntity) {
		return new CustomersDto(customersEntity.getId(),
		                        customersEntity.getName(),
		                        customersEntity.getLastName(),
		                        customersEntity.getEmail());
	}

	public static CustomersEntity customersToEntity(CustomersDto customersDto) {
		return new CustomersEntity(customersDto.getId(),
		                           customersDto.getName(),
		                           customersDto.getLastName(),
		                           customersDto.getEmail());
	}

	public static List<CustomersDto> customersToListDtos(List<CustomersEntity> customersEntities){
		List<CustomersDto> customersDtos = new ArrayList<>();
		for (CustomersEntity customersEntity : customersEntities){
			CustomersDto customersDto = customersToDto(customersEntity);
			customersDtos.add(customersDto);
		}
		return customersDtos;
	}



	public static AirlinesDto airlinesToDto(AirlinesEntity airlinesEntity) {
		return new AirlinesDto(airlinesEntity.getId(),
		                       airlinesEntity.getName(),
		                       airlinesEntity.getInfo());
	}

	public static AirlinesEntity airlinesToEntity(AirlinesDto airlinesDto) {
		return new AirlinesEntity(airlinesDto.getId(),
		                          airlinesDto.getName(),
		                          airlinesDto.getInfo());
	}

	public static List<AirlinesDto> airlinesToListDtos(List<AirlinesEntity> airlinesEntities){
		List<AirlinesDto> airlinesDtos = new ArrayList<>();
		for (AirlinesEntity airlinesEntity : airlinesEntities){
			AirlinesDto airlinesDto = airlinesToDto(airlinesEntity);
			airlinesDtos.add(airlinesDto);
		}
		return airlinesDtos;
	}





	public static FlightsDto flightsToDto(FlightsEntity flightsEntity) {
		return new FlightsDto(flightsEntity.getId(),
		                      flightsEntity.getDepartureCity(),
		                      flightsEntity.getArrivalCity(),
		                      flightsEntity.getDepartureTime(),
		                      flightsEntity.getArrivalTime(),
		                      flightsEntity.getAirlinesId());
	}

	public static FlightsEntity flightsToEntity(FlightsDto flightsDto) {
		return new FlightsEntity(flightsDto.getId(),
		                         flightsDto.getDepartureCity(),
		                         flightsDto.getArrivalCity(),
		                         flightsDto.getDepartureTime(),
		                         flightsDto.getArrivalTime(),
		                         flightsDto.getAirlinesId());
	}

	public static List<FlightsDto> flightsToListDtos(List<FlightsEntity> flightsEntities){
		List<FlightsDto> flightsDtos = new ArrayList<>();
		for (FlightsEntity flightsEntity : flightsEntities){
			FlightsDto customersDto = flightsToDto(flightsEntity);
			flightsDtos.add(customersDto);
		}
		return flightsDtos;
	}





	public static TicketsDto ticketsToDto(TicketsEntity ticketsEntity) {
		return new TicketsDto(ticketsEntity.getFlightId(),
		                      ticketsEntity.getPrice(),
		                      ticketsEntity.getSeatNumber(),
		                      ticketsEntity.getFlightId(),
		                      ticketsEntity.getCustomerId());
	}

	public static TicketsEntity ticketsToEntity(TicketsDto ticketsDto) {
		return new TicketsEntity(ticketsDto.getFlightId(),
		                         ticketsDto.getPrice(),
		                         ticketsDto.getSeatNumber(),
		                         ticketsDto.getFlightId(),
		                         ticketsDto.getCustomerId());
	}

	public static List<TicketsDto> ticketsToListDtos(List<TicketsEntity> ticketsEntities){
		List<TicketsDto> ticketsDtos = new ArrayList<>();
		for (TicketsEntity ticketsEntity : ticketsEntities){
			TicketsDto ticketsDto = ticketsToDto(ticketsEntity);
			ticketsDtos.add(ticketsDto);
		}
		return ticketsDtos;
	}


}
