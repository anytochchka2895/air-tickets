package org.example.services;

import org.example.dtos.AirlinesDto;
import org.example.entities.AirlinesEntity;
import org.example.mappers.Mapper;
import org.example.repositories.AirlinesRepository;
import org.example.services.interfaces.AirlinesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AirlinesServiceImpl implements AirlinesService {
	private final AirlinesRepository airlinesRepository;

	public AirlinesServiceImpl(AirlinesRepository airlinesRepository) {this.airlinesRepository = airlinesRepository;}

	@Transactional
	@Override public AirlinesDto saveAirline(AirlinesDto airlinesDto) {
		if (Objects.isNull(airlinesDto.getId())) {
			airlinesDto.setId(UUID.randomUUID());
		}
		AirlinesEntity airlinesEntity = Mapper.airlinesToEntity(airlinesDto);
		AirlinesEntity save = airlinesRepository.save(airlinesEntity);
		return Mapper.airlinesToDto(save);
	}

	@Override public List<AirlinesDto> getAll() {
		List<AirlinesDto> airlinesDtos = new ArrayList<>();
		for (AirlinesEntity airlinesEntity : airlinesRepository.findAll()) {
			AirlinesDto airlinesDto = Mapper.airlinesToDto(airlinesEntity);
			airlinesDtos.add(airlinesDto);
		}
		return airlinesDtos;
	}

	@Override public AirlinesDto getById(UUID id) {
		Optional<AirlinesEntity> entityOptional = airlinesRepository.findById(id);
		return Mapper.airlinesToDto(entityOptional.get());
	}

	@Transactional
	@Override public AirlinesDto deleteById(UUID id) {
		AirlinesDto byId = getById(id);
		airlinesRepository.deleteById(id);
		return byId;
	}

	@Override public List<AirlinesDto> findAllAirlinesWithoutFlights() {
		List<AirlinesEntity> allAirlinesWithoutFlights = airlinesRepository.findAllAirlinesWithoutFlights();
		return Mapper.airlinesToListDtos(allAirlinesWithoutFlights);
	}

	@Override public List<String> findAllNameAirlinesWithoutFlights() {
		return airlinesRepository.findAllNameAirlinesWithoutFlights();
	}


}
