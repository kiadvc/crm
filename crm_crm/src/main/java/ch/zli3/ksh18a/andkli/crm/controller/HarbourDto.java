package ch.zli3.ksh18a.andkli.crm.controller;

import ch.zli3.ksh18a.andkli.crm.model.Harbour;

public class HarbourDto {
	public Long id;
	public final String harbourName;
	public final String harbourAddress;

	public HarbourDto(Harbour harbour) {
		this.id = harbour.getId();
		this.harbourName = harbour.getHarbourName();
		this.harbourAddress = harbour.getHarbourAddress();
	}
}
