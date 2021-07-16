package ch.zli3.ksh18a.andkli.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.zli3.ksh18a.andkli.crm.model.AppUser;
import ch.zli3.ksh18a.andkli.crm.model.Boat;
import ch.zli3.ksh18a.andkli.crm.model.BoatImpl;

public interface BoatRepository extends CrudRepository<BoatImpl, Long>{
	
	default Boat insertBoat( String name, int amtOfSeats, int pricePerDay, int fuelPerKm, int numberplate, AppUser hirer) {
		return save(new BoatImpl(null, name, amtOfSeats, pricePerDay, fuelPerKm, numberplate, hirer));
		
	}

	@Query
	Optional<Boat> findByName(String name);

}
