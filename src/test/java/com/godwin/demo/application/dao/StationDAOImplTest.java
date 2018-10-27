package com.godwin.demo.application.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.godwin.demo.application.mapper.StationMapper;
import com.godwin.demo.application.model.Station;

@RunWith(SpringRunner.class)
public class StationDAOImplTest {
	
	@InjectMocks
	StationDAOImpl stationDAOImpl;
	
	@Mock
	StationMapper stationMapper;
	
	@Mock
	Station stationMock;
	
	private static final String STATION_ID = "testStationId"; 
	
	private static final String KEY = "testStationId"; 
	
	@Test
	public void addTest() {		
		stationDAOImpl.add(stationMock);
		verify(stationMapper).add(stationMock);
	}
	
	@Test
	public void getTest() {
		when(stationDAOImpl.get(STATION_ID)).thenReturn(stationMock);
		Station retrievedStation = stationDAOImpl.get(STATION_ID);
		verify(stationMapper).get(STATION_ID);
		assertEquals(stationMock, retrievedStation);
	}
	
	@Test
	public void updateTest() {
		stationDAOImpl.update(stationMock);
		verify(stationMapper).update(stationMock);
	}
	
	@Test
	public void deleteTest() {
		stationDAOImpl.delete(STATION_ID);
		verify(stationMapper).delete(STATION_ID);
	}
	
	@Test
	public void searchByStationIdOrNameTest() {
		List<Station> stations = new ArrayList<>();
		stations.add(stationMock);
		when(stationDAOImpl.searchByStationIdOrName(KEY)).thenReturn(stations);
		List<Station> returnedStations = stationDAOImpl.searchByStationIdOrName(KEY);
		verify(stationMapper).searchByStationIdOrName(KEY);
		assertEquals(returnedStations.size(), 1);
		assertEquals(stations.get(0), stationMock);
	}
	
	@Test
	public void searchHdEnabledStationsTest() {
		List<Station> stations = new ArrayList<>();
		stations.add(stationMock);
		when(stationDAOImpl.searchHdEnabledStations()).thenReturn(stations);
		List<Station> returnedStations = stationDAOImpl.searchHdEnabledStations();
		verify(stationMapper).searchHdEnabledStations();
		assertEquals(returnedStations.size(), 1);
		assertEquals(stations.get(0), stationMock);
	}
}
