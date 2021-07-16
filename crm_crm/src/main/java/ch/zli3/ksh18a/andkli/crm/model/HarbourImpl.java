package ch.zli3.ksh18a.andkli.crm.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "harbour")
public class HarbourImpl implements Harbour {
	@Id
	@GeneratedValue
	private Long id;
	private String harbourName;
	private String harbourAddress;

	@OneToMany(mappedBy = "harbour", fetch = FetchType.EAGER)
	private List<BoatImpl> boats;
	
	protected HarbourImpl() {}
	
	public HarbourImpl(Long id, String harbourName, String harbourAddress) {
		this.id = id;
		this.harbourName = harbourName;
		this.harbourAddress = harbourAddress;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getHarbourName() {
		// TODO Auto-generated method stub
		return harbourName;
	}
	@Override
	public String getHarbourAddress() {
		// TODO Auto-generated method stub
		return harbourAddress;
	}
	@Override
	public List<Boat> getBoats() {
		// TODO Auto-generated method stub
		return boats.stream().collect(Collectors.toList());
	}
	
}
