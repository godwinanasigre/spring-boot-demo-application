package com.godwin.demo.application.service;

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

import com.godwin.demo.application.dao.StationDAO;
import com.godwin.demo.application.model.Station;

@RunWith(SpringRunner.class)
public class StationServiceImplTest {
	
	@InjectMocks
	StationServiceImpl stationServiceImpl;
	
	@Mock
	StationDAO stationDAO;
	
	@Mock
	Station stationMock;
	
	private static final String STATION_ID = "testStationId"; 
	
	private static final String KEY = "testStationId"; 
	
	@Test
	public void addTest() {		
		stationServiceImpl.add(stationMock);
		verify(stationDAO).add(stationMock);
	}
	
	@Test
	public void getTest() {
		when(stationServiceImpl.get(STATION_ID)).thenReturn(stationMock);
		Station retrievedStation = stationServiceImpl.get(STATION_ID);
		verify(stationDAO).get(STATION_ID);
		assertEquals(stationMock, retrievedStation);
	}
	
	@Test
	public void updateTest() {
		stationServiceImpl.update(stationMock);
		verify(stationDAO).update(stationMock);
	}
	
	@Test
	public void deleteTest() {
		stationServiceImpl.delete(STATION_ID);
		verify(stationDAO).delete(STATION_ID);
	}
	
	@Test
	public void searchByStationIdOrNameTest() {
		List<Station> stations = new ArrayList<>();
		stations.add(stationMock);
		when(stationServiceImpl.searchByStationIdOrName(KEY)).thenReturn(stations);
		List<Station> returnedStations = stationServiceImpl.searchByStationIdOrName(KEY);
		verify(stationDAO).searchByStationIdOrName(KEY);
		assertEquals(returnedStations.size(), 1);
		assertEquals(stations.get(0), stationMock);
	}
	
	@Test
	public void searchHdEnabledStationsTest() {
		List<Station> stations = new ArrayList<>();
		stations.add(stationMock);
		when(stationServiceImpl.searchHdEnabledStations()).thenReturn(stations);
		List<Station> returnedStations = stationServiceImpl.searchHdEnabledStations();
		verify(stationDAO).searchHdEnabledStations();
		assertEquals(returnedStations.size(), 1);
		assertEquals(stations.get(0), stationMock);
	}
}
