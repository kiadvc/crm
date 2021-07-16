package ch.zli3.ksh18a.andkli.crm.model;

import java.util.List;

public interface Harbour {
	public Long getId();
	public String getHarbourName();
	public String getHarbourAddress();
	public List<Boat> getBoats();
}
