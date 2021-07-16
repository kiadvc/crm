package ch.zli3.ksh18a.andkli.crm.controller;

import ch.zli3.ksh18a.andkli.crm.model.Boat;

public class BoatDto {
	public Long id;
	public final String name;
	public Integer amtOfSeats;
	public Integer pricePerDay;
	public Integer fuelPerKm;
	public Integer numberplate;
	
	public BoatDto(Boat boat) {
		this.id = boat.getId();
		this.name = boat.getName();
		this.amtOfSeats = boat.getAmtOfSeats();
		this.pricePerDay = boat.getPricePerDay();
		this.fuelPerKm = boat.getFuelPerKm();
		this.numberplate = boat.getNumberplate();
	}
}
