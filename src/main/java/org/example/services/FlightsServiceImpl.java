package org.example.services;

import org.example.dtos.FlightsDto;
import org.example.entities.FlightsEntity;
import org.example.mappers.Mapper;
import org.example.repositories.FlightsRepository;
import org.example.services.interfaces.FlightsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FlightsServiceImpl implements FlightsService {
	private final FlightsRepository flightsRepository;

	public FlightsServiceImpl(FlightsRepository flightsRepository) {this.flightsRepository = flightsRepository;}

	@Transactional
	@Override
	public FlightsDto saveFlight(FlightsDto flightsDto) {
		if (Objects.isNull(flightsDto.getId())) {
			flightsDto.setId(UUID.randomUUID());
		}
		FlightsEntity flightsEntity = Mapper.flightsToEntity(flightsDto);
		FlightsEntity save = flightsRepository.save(flightsEntity);
		return Mapper.flightsToDto(save);
	}

	@Override public List<FlightsDto> getAll() {
		List<FlightsDto> flightsDtos = new ArrayList<>();
		for (FlightsEntity flightsEntity : flightsRepository.findAll()) {
			FlightsDto flightsDto = Mapper.flightsToDto(flightsEntity);
			flightsDtos.add(flightsDto);
		}
		return flightsDtos;
	}

	@Override public FlightsDto getById(UUID id) {
		Optional<FlightsEntity> entityOptional = flightsRepository.findById(id);
		return Mapper.flightsToDto(entityOptional.get());
	}

	@Transactional
	@Override public FlightsDto deleteById(UUID id) {
		FlightsDto flightsDto = getById(id);
		flightsRepository.deleteById(id);
		return flightsDto;
	}


	@Override public List<FlightsDto> getByFilter(String arrivalCity) {
		List<FlightsDto> flightsDtos = new ArrayList<>();
		for (FlightsEntity flightsEntity : flightsRepository.findAllByArrivalCity(arrivalCity)) {
			FlightsDto flightsDto = Mapper.flightsToDto(flightsEntity);
			flightsDtos.add(flightsDto);
		}
		return flightsDtos;
	}

	@Override public List<FlightsDto> findAllByPriceMore300() {
		List<FlightsEntity> allByPriceMore300 = flightsRepository.findAllByPriceMore300();
		return Mapper.flightsToListDtos(allByPriceMore300);
	}

	@Override public List<FlightsDto> findAllByPriceMoreThan(int price) {
		List<FlightsEntity> allByPriceMoreThan = flightsRepository.findAllByPriceMoreThan(price);
		return Mapper.flightsToListDtos(allByPriceMoreThan);
	}

//	@Override public List<FlightsDto> findAllFlightsFromNToM(String departureCity, String arrivalCity) {
//		List<FlightsEntity> allFlightsFromNToM = flightsRepository.findAllFlightsFromNToM(departureCity, arrivalCity);
//		return Mapper.flightsToListDtos(allFlightsFromNToM);
//	}

	@Override public List<FlightsDto> findAllByDepartureCityAndArrivalCity(String departureCity, String arrivalCity) {
		List<FlightsEntity> flights = flightsRepository.findAllByDepartureCityAndArrivalCity(departureCity, arrivalCity);
		return Mapper.flightsToListDtos(flights);
	}

	@Override public List<FlightsDto> findAllByDepartureCity(String departureCity) {
		List<FlightsEntity> byDepartureCity = flightsRepository.findAllByDepartureCity(departureCity);
		return Mapper.flightsToListDtos(byDepartureCity);
	}




}
