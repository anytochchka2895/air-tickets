package org.example.services;

import org.example.dtos.TicketsDto;
import org.example.entities.TicketsEntity;
import org.example.mappers.Mapper;
import org.example.repositories.TicketsRepository;
import org.example.services.interfaces.TicketsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TicketsServiceImpl implements TicketsService {
	private final TicketsRepository ticketsRepository;

	public TicketsServiceImpl(TicketsRepository ticketsRepository) {this.ticketsRepository = ticketsRepository;}

	@Transactional
	@Override
	public TicketsDto saveTickets(TicketsDto ticketsDto) {
		if (Objects.isNull(ticketsDto.getId())) {
			ticketsDto.setId(UUID.randomUUID());
		}
		TicketsEntity ticketsEntity = Mapper.ticketsToEntity(ticketsDto);
		TicketsEntity save = ticketsRepository.save(ticketsEntity);
		return Mapper.ticketsToDto(save);
	}

	@Override public List<TicketsDto> getAll() {
		List<TicketsDto> ticketsDtos = new ArrayList<>();
		for (TicketsEntity ticketsEntity : ticketsRepository.findAll()) {
			TicketsDto ticketsDto = Mapper.ticketsToDto(ticketsEntity);
			ticketsDtos.add(ticketsDto);
		}
		return ticketsDtos;
	}

	@Override public TicketsDto getById(UUID id) {
		Optional<TicketsEntity> entityOptional = ticketsRepository.findById(id);
		return Mapper.ticketsToDto(entityOptional.get());
	}

	@Transactional
	@Override public TicketsDto deleteById(UUID id) {
		TicketsDto ticketsDto = getById(id);
		ticketsRepository.deleteById(id);
		return ticketsDto;
	}

	@Override public List<TicketsDto> findAllByMaxPrice() {
		Integer maxPrice = ticketsRepository.findMaxPrice();
		List<TicketsEntity> allByPrice = ticketsRepository.findAllByPrice(maxPrice);
		return Mapper.ticketsToListDtos(allByPrice);
	}

	@Override public Integer findAvgPrice() {
		return ticketsRepository.findAvgPrice();
	}

	@Override public List<TicketsDto> findAllTicketsFromDepartureCity(String departureCity) {
		List<TicketsEntity> tickets = ticketsRepository.findAllTicketsFromDepartureCity(departureCity);
		return Mapper.ticketsToListDtos(tickets);
	}

	@Override public List<TicketsDto> findAllByIds(List<UUID> ids) {
		List<TicketsEntity> allByIds = ticketsRepository.findAllByIdIn(ids);
		return Mapper.ticketsToListDtos(allByIds);
	}

	@Override public List<TicketsDto> findAllByFlightIds(List<UUID> flightIds) {
		List<TicketsEntity> ticketsEntities = ticketsRepository.findAllByFlightIdIn(flightIds);
		return Mapper.ticketsToListDtos(ticketsEntities);
	}
}
