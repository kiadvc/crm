package ch.zli3.ksh18a.andkli.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli3.ksh18a.andkli.crm.exceptions.HarbourNotFoundException;
import ch.zli3.ksh18a.andkli.crm.exceptions.InvalidArgumentException;
import ch.zli3.ksh18a.andkli.crm.model.Harbour;
import ch.zli3.ksh18a.andkli.crm.repository.HarbourRepository;

@Service
public class HarbourServiceImpl implements HarbourService{
	@Autowired
	HarbourRepository repository;

	@Override
	public List<Harbour> getAllHarbours() {
		List<Harbour> harbours = new ArrayList<>();
		
		for (var harbour : repository.findAll()) {
			harbours.add(harbour);
		}
		return harbours;
	}

	@Override
	public Harbour addHarbour(String harbourName, String harbourAddress) {
		if(harbourName == null || harbourAddress == null) {
			throw new InvalidArgumentException();
		}
		if(repository.findByHarbourName(harbourName).isPresent()) {
			throw new HarbourNotFoundException();
		}
		return repository.insertHarbour(harbourName, harbourAddress);
	}

	@Override
	public Harbour findHarbourByName(String harbourName) {
		if (harbourName == null) {
			throw new InvalidArgumentException();
		}
		return repository.findByHarbourName(harbourName).orElseThrow(HarbourNotFoundException::new);
	}

	@Override
	public Harbour getHarbourById(long harbourId) {
		return repository.findById(harbourId).orElseThrow(HarbourNotFoundException::new);
	}

	@Override
	public void deleteHarbourById() {
		// TODO Auto-generated method stub
		
	}

}
