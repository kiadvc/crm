package ch.zli3.ksh18a.andkli.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.zli3.ksh18a.andkli.crm.model.Harbour;
import ch.zli3.ksh18a.andkli.crm.model.HarbourImpl;

public interface HarbourRepository extends CrudRepository<HarbourImpl, Long>{
	
	default Harbour insertHarbour(String harbourName, String harbourAddress) {
		return save(new HarbourImpl(null, harbourName, harbourAddress));
		
	}

	@Query
	Optional<Harbour> findByHarbourName(String harbourName);

}
