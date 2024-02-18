package org.example.repositories;

import org.example.entities.TicketsEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TicketsRepository extends JpaRepository<TicketsEntity, UUID> {

	@Query(value = "SELECT max(t.price) from TicketsEntity t")
	Integer findMaxPrice();

	List<TicketsEntity> findAllByPrice(Integer price);

	@Query(value = "select avg(t.price) from TicketsEntity t")
	Integer findAvgPrice();

	@Query(value = "select t from TicketsEntity t " +
			" join FlightsEntity f on f.id = t.flightId " +
			"where f.departureCity = :departureCity")
	List<TicketsEntity> findAllTicketsFromDepartureCity(String departureCity);

	List<TicketsEntity> findAllByIdIn(List<UUID> ids);

	List<TicketsEntity> findAllByFlightIdIn(List<UUID> flightIds);


}
