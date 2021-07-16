package ch.zli3.ksh18a.andkli.crm.model;

public interface Boat {
	public long getId();
	public String getName();
	public Integer getAmtOfSeats();
	public Integer getPricePerDay();
	public Integer getFuelPerKm();
	public AppUser getHirer();
	public Integer getNumberplate();
}
