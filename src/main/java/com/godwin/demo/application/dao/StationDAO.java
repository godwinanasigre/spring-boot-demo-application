package com.godwin.demo.application.dao;

import java.util.List;

import com.godwin.demo.application.model.Station;

public interface StationDAO extends ModelDAO<Station>{
	
	public List<Station> searchByStationIdOrName(String key);
	
	public List<Station> searchHdEnabledStations();

}
