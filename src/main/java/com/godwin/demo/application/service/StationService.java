package com.godwin.demo.application.service;

import java.util.List;

import com.godwin.demo.application.model.Station;

public interface StationService extends ModelService<Station>{
	
	public List<Station> searchByStationIdOrName(String key);
	
	public List<Station> searchHdEnabledStations();

}
