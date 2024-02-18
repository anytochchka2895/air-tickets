package org.example.services;

import org.example.dtos.CustomersDto;
import org.example.entities.CustomersEntity;
import org.example.mappers.Mapper;
import org.example.repositories.CustomersRepository;
import org.example.services.interfaces.CustomersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomersServiceImpl implements CustomersService {
	private final CustomersRepository customersRepository;

	public CustomersServiceImpl(CustomersRepository customersRepository) {this.customersRepository = customersRepository;}

	@Transactional
	@Override public CustomersDto saveCustomer(CustomersDto customersDto) {
		if (Objects.isNull(customersDto.getId())) {
			customersDto.setId(UUID.randomUUID());
		}
		CustomersEntity customersEntity = Mapper.customersToEntity(customersDto);
		CustomersEntity save = customersRepository.save(customersEntity);
		return Mapper.customersToDto(save);
	}

	@Override public List<CustomersDto> getAll() {
		return Mapper.customersToListDtos(customersRepository.findAll());
	}

	@Override public CustomersDto getById(UUID id) {
		Optional<CustomersEntity> entityOptional = customersRepository.findById(id);
		return Mapper.customersToDto(entityOptional.get());
	}

	@Transactional
	@Override public CustomersDto deleteById(UUID id) {
		CustomersDto customersDto = getById(id);
		customersRepository.deleteById(id);
		return customersDto;
	}

	@Override
	public List<CustomersDto> findByIds(List<UUID> customersIds) {
		List<CustomersEntity> customersEntitiesById = customersRepository.findCustomersEntitiesByIdIn(customersIds);
		return Mapper.customersToListDtos(customersEntitiesById);
	}

	@Override public List<CustomersDto> findWhoHaveMoreThenCountTickets(int countTickets) {
		List<UUID> allWIdithMore2tickets = customersRepository.findAllWIdithMoreThenCountTickets(countTickets);
		List<CustomersEntity> entities = customersRepository.findCustomersEntitiesByIdIn(allWIdithMore2tickets);
		return Mapper.customersToListDtos(entities);
	}


}
