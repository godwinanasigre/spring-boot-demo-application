package com.godwin.demo.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.godwin.demo.application.mapper.ModelMapper;
import com.godwin.demo.application.mapper.StationMapper;
import com.godwin.demo.application.model.Station;

@Repository
public class StationDAOImpl extends AbstractModelDAO<Station> implements StationDAO{
	
	@Autowired
	private StationMapper stationMapper;
	
	@Override
	ModelMapper<Station> getModelMapper() {
		return stationMapper;
	}

	@Override
	public List<Station> searchByStationIdOrName(String key) {
		return stationMapper.searchByStationIdOrName(key);
	}

	@Override
	public List<Station> searchHdEnabledStations() {
		return stationMapper.searchHdEnabledStations();
	}

}
