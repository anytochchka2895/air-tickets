package org.example.repositories;

import org.example.entities.AirlinesEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface AirlinesRepository extends JpaRepository<AirlinesEntity, UUID> {

	@Query(value = "select a from AirlinesEntity a " +
			" left join FlightsEntity f on a.id = f.airlinesId " +
			" where f.id is null")
	List<AirlinesEntity> findAllAirlinesWithoutFlights();

	@Query(value = "select a.name from AirlinesEntity a " +
			" left join FlightsEntity f on a.id = f.airlinesId " +
			" where f.id is null")
	List<String> findAllNameAirlinesWithoutFlights();

}
