package ch.zli3.ksh18a.andkli.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name = "Boat")
public class BoatImpl implements Boat{
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	public int amtOfSeats;
	public int pricePerDay;
	public int fuelPerKm;
	public int numberplate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AppUserImpl hirer;
	@ManyToOne(cascade = CascadeType.DETACH)
	private HarbourImpl harbour;
	protected BoatImpl() {}
	
	public BoatImpl(Long id, String name, int amtOfSeats, int pricePerDay, int fuelPerKm, int numberplate, AppUser hirer) {
		this.id = id;
		this.name = name;
		this.amtOfSeats = amtOfSeats;
		this.pricePerDay = pricePerDay;
		this.fuelPerKm = fuelPerKm;
		this.numberplate = numberplate;
		this.hirer = (AppUserImpl) hirer;
		this.harbour = (HarbourImpl) harbour;
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Integer getAmtOfSeats() {
		// TODO Auto-generated method stub
		return amtOfSeats;
	}

	@Override
	public Integer getPricePerDay() {
		// TODO Auto-generated method stub
		return pricePerDay;
	}

	@Override
	public Integer getFuelPerKm() {
		return fuelPerKm;
	}

	@Override
	public Integer getNumberplate() {
		// TODO Auto-generated method stub
		return numberplate;
	}
	
	@Override
	public AppUser getHirer() {
		return hirer;
	}

}
