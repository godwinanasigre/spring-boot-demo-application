package com.godwin.demo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.godwin.demo.application.dao.ModelDAO;
import com.godwin.demo.application.dao.StationDAO;
import com.godwin.demo.application.model.Station;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StationServiceImpl extends AbstractModelService<Station> implements StationService{
	
	@Autowired
	private StationDAO stationDAO;
	
	@Override
	ModelDAO<Station> getModelDAO() {
		return stationDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	@Override
	public List<Station> searchByStationIdOrName(String key) {
		return stationDAO.searchByStationIdOrName(key);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	@Override
	public List<Station> searchHdEnabledStations() {
		return stationDAO.searchHdEnabledStations();
	}

}
