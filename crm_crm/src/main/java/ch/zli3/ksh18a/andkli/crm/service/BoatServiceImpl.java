package ch.zli3.ksh18a.andkli.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli3.ksh18a.andkli.crm.exceptions.InvalidArgumentException;
import ch.zli3.ksh18a.andkli.crm.exceptions.UserNotFoundException;
import ch.zli3.ksh18a.andkli.crm.model.AppUser;
import ch.zli3.ksh18a.andkli.crm.model.Boat;
import ch.zli3.ksh18a.andkli.crm.model.Harbour;
import ch.zli3.ksh18a.andkli.crm.repository.BoatRepository;

@Service
public class BoatServiceImpl implements BoatService{

	BoatRepository boatRepo;

	@Override
	public List<Boat> getAllBoats() {
		List<Boat> boats = new ArrayList<>();
		
		for(var boat : boatRepo.findAll()) {
			boats.add(boat);
		}
		return boats;
	}

	@Override
	public Boat addBoat(String name, int amtOfSeats, int pricePerDay, int fuelPerKm, int numberplate, AppUser hirer, Harbour harbour) {
		// TODO Auto-generated method stub
		return boatRepo.insertBoat(name, amtOfSeats, pricePerDay, fuelPerKm, numberplate, hirer);
	}

	@Override
	public Boat findBoatByName(String name) {
		if(name == null) {
			throw new InvalidArgumentException();
		}
		// TODO Auto-generated method stub
		return boatRepo.findByName(name)
				.orElseThrow(UserNotFoundException::new);
	}

	@Override
	public Boat getBoatById(long boatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoatById(long boatId) {
		// TODO Auto-generated method stub
		
	}


}
