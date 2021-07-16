package ch.zli3.ksh18a.andkli.crm.service;

import java.util.List;

import ch.zli3.ksh18a.andkli.crm.model.Harbour;

public interface HarbourService {
	
	List<Harbour> getAllHarbours();
	
	Harbour addHarbour(String harbourName, String harbourAddress);
	
	Harbour findHarbourByName(String harbourName);
	
	Harbour getHarbourById(long id);
	
	void deleteHarbourById();
}
