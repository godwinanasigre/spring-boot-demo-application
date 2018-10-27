package com.godwin.demo.application.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godwin.demo.application.model.Station;
import com.godwin.demo.application.service.StationService;

@RestController
@RequestMapping("/rest/station")
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@PostMapping(value="/add", 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Station addStation(@Valid @RequestBody Station station){	
		stationService.add(station);
		return stationService.get(station.getStationId());
	}
	
	@DeleteMapping(value="/remove/{stationId}", produces=MediaType.APPLICATION_JSON_VALUE)
	private Station removeStation(@PathVariable("stationId") String stationId){
		Station station = stationService.get(stationId);
		stationService.delete(stationId);
		return station;
	}
	
	@PutMapping(value="/update", 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Station updateStation(@Valid @RequestBody Station station){	
		stationService.update(station);
		return stationService.get(station.getStationId());
	}
	
	@GetMapping(value="/search/stationidorname/{key}", produces=MediaType.APPLICATION_JSON_VALUE)
	private List<Station> searchByStationIdOrName(@PathVariable("key") String key){
		return stationService.searchByStationIdOrName(key);
	}
	
	@GetMapping(value="/search/hdenabled", produces=MediaType.APPLICATION_JSON_VALUE)
	private List<Station> searchHdEnabled(){
		return stationService.searchHdEnabledStations();
	}

}
