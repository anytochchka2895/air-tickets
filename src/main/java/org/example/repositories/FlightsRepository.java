package org.example.repositories;

import org.example.entities.FlightsEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FlightsRepository extends JpaRepository<FlightsEntity, UUID> {

	List<FlightsEntity> findAllByArrivalCity(String cityName);

	// HQL-language
	@Query(value = "select f from FlightsEntity f " +
			" join AirlinesEntity a on a.id = f.airlinesId " +
			" where f.arrivalCity = :city")
	List<FlightsEntity> getFiniki(String city);

	@Query(nativeQuery = true, value = "select * from flights f " +
			" where f.arrival_city = :cityName")
	List<FlightsEntity> getFiniki2(@Param(value = "cityName") String city);

	@Query(value = "select f from FlightsEntity f " +
			" join TicketsEntity t on f.id = t.flightId " +
			" where t.price > 300")
	List<FlightsEntity> findAllByPriceMore300();

	@Query(value = "select f from FlightsEntity f " +
			" join TicketsEntity t on f.id = t.flightId " +
			" where t.price > :price")
	List<FlightsEntity> findAllByPriceMoreThan(int price);

//	@Query (value = "select f from FlightsEntity f " +
//			" where f.departureCity = :departureCity and  f.arrivalCity = :arrivalCity")
//	List<FlightsEntity> findAllFlightsFromNToM(String departureCity, String arrivalCity);

	List<FlightsEntity> findAllByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

	List<FlightsEntity> findAllByDepartureCity (String departureCity);

}
