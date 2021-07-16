package ch.zli3.ksh18a.andkli.crm.controller;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli3.ksh18a.andkli.crm.model.AppUser;
import ch.zli3.ksh18a.andkli.crm.model.Harbour;
import ch.zli3.ksh18a.andkli.crm.service.BoatService;
import ch.zli3.ksh18a.andkli.crm.service.HarbourService;
import ch.zli3.ksh18a.andkli.crm.service.UserService;

@RestController()
@RequestMapping("rest/v1/boats")
public class BoatController {
	@Autowired
	private BoatService boatService;
	@Autowired
	private UserService userService;
	@Autowired
	private HarbourService harbourService;

	/**
	 * Diese Methode extrahiert alle Boote in eine Liste
	 * @return der Return ist eine Liste der Boot-Map
	 */
	@GetMapping("")
	List<BoatDto> getAllBoats() {
		return boatService.getAllBoats().stream().map(boat -> new BoatDto(boat)).collect(Collectors.toList());
	}


	@PostMapping("")
	BoatDto insertBoat(@RequestBody BoatInputDto boatInput) {
		AppUser hirer = userService.getUserById(boatInput.hirerId);
		Harbour harbour = harbourService.getHarbourById(boatInput.hirerId);
		return new BoatDto(boatService.addBoat(boatInput.name, boatInput.amtOfSeats, boatInput.pricePerDay,
				boatInput.fuelPerKm, boatInput.numberplate, hirer, harbour

		));
	}
}
