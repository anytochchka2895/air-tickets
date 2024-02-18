package org.example.repositories;

import org.example.entities.CustomersEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, UUID> {

	List<CustomersEntity> findCustomersEntitiesByIdIn (List<UUID> customersId);

	@Query(value = "select c.id from CustomersEntity c " +
			" join TicketsEntity t on t.customerId = c.id " +
			" group by c.id " +
			" having count(c) >= :countTickets")
	List<UUID> findAllWIdithMoreThenCountTickets(int countTickets);


}
