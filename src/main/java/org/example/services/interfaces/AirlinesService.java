package org.example.services.interfaces;

import org.example.dtos.AirlinesDto;

import java.util.*;

public interface AirlinesService {
	AirlinesDto saveAirline(AirlinesDto airlinesDto);

	List<AirlinesDto> getAll();

	AirlinesDto getById(UUID id);

	AirlinesDto deleteById(UUID id);

	List<AirlinesDto> findAllAirlinesWithoutFlights();
	List<String> findAllNameAirlinesWithoutFlights();
}
