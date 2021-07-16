package ch.zli3.ksh18a.andkli.crm.service;

import java.util.List;

import ch.zli3.ksh18a.andkli.crm.model.AppUser;
import ch.zli3.ksh18a.andkli.crm.model.Boat;
import ch.zli3.ksh18a.andkli.crm.model.Harbour;

public interface BoatService {

	List<Boat> getAllBoats();
	
	Boat addBoat(String name, int amtOfSeats, int pricePerDay, int fuelPerKm, int numberplate, AppUser hirer, Harbour harbour);
	
	Boat findBoatByName(String name);
	
	Boat getBoatById(long boatId);
	
	void deleteBoatById(long boatId);
}
