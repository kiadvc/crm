package ch.zli3.ksh18a.andkli.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ch.zli3.ksh18a.andkli.crm.service.HarbourService;

@RestController()
@RequestMapping("rest/v1/harbour")
public class HarbourController {
	@Autowired
		private HarbourService harbourService;
	
	
	
	@GetMapping("")
	List<HarbourDto> getAllHarbours() {
		return harbourService.getAllHarbours()
			.stream()
			.map(harbour -> new HarbourDto(harbour))
			.collect(Collectors.toList());
	}
	
	@PostMapping("")
	HarbourDto insertHarbour(@RequestBody  HarbourInputDto harbourInput) {
		
		return new HarbourDto(
				harbourService.addHarbour(
						harbourInput.harbourName, 
						harbourInput.harbourAddress)
			);
	}

}
