package com.godwin.demo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godwin.demo.application.dao.ModelDAO;
import com.godwin.demo.application.dao.StationDAO;
import com.godwin.demo.application.model.Station;

@Service
public class StationServiceImpl extends AbstractModelService<Station> implements StationService{
	
	@Autowired
	private StationDAO stationDAO;
	
	@Override
	ModelDAO<Station> getModelDAO() {
		return stationDAO;
	}

	@Override
	public List<Station> searchByStationIdOrName(String key) {
		return stationDAO.searchByStationIdOrName(key);
	}

	@Override
	public List<Station> searchHdEnabledStations() {
		return stationDAO.searchHdEnabledStations();
	}

}
