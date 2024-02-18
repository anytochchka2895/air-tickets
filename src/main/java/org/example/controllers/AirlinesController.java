package org.example.controllers;

import org.example.dtos.AirlinesDto;
import org.example.services.interfaces.AirlinesService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AirlinesController {
	private final AirlinesService airlinesService;

	public AirlinesController(AirlinesService airlinesService) {this.airlinesService = airlinesService;}

	@PostMapping(value = "/airline")
	public AirlinesDto saveAirline(@RequestBody AirlinesDto airlinesDto) {
		return airlinesService.saveAirline(airlinesDto);
	}

	@GetMapping(value = "/airline")
	public List<AirlinesDto> getAll() {
		return airlinesService.getAll();
	}

	@GetMapping(value = "/airline/{id}")
	public AirlinesDto getById(@PathVariable UUID id) {
		return airlinesService.getById(id);
	}

	@DeleteMapping(value = "/airline/{id}")
	public AirlinesDto deleteById(@PathVariable UUID id) {
		return airlinesService.deleteById(id);
	}

	@GetMapping(value = "/airline/empty-fligts")
	public List<AirlinesDto> findAllAirlinesWithoutFlights() {
		return airlinesService.findAllAirlinesWithoutFlights();
	}

	@GetMapping(value = "/airline/name-empty-fligts")
	public List<String> findAllNameAirlinesWithoutFlights() {
		return airlinesService.findAllNameAirlinesWithoutFlights();
	}
}
