package com.godwin.demo.application.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.godwin.demo.application.model.Station;
import com.godwin.demo.application.service.StationService;

@RunWith(SpringRunner.class)
public class StationConrollerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private StationController stationController;
	
	@Mock
	private StationService stationService;
	
	private Station stationMock;
	
	private static final String STATION_JSON = "{\r\n" + 
			"	\"stationId\":\"stationId\",\r\n" + 
			"	\"name\":\"TestName\",\r\n" + 
			"	\"hdEnabled\":true,\r\n" + 
			"	\"callSign\":\"AA2B\"\r\n" + 
			"}";
	
	private static final String STATIONS_JSON = "[{\r\n" + 
			"	\"stationId\":\"stationId\",\r\n" + 
			"	\"name\":\"TestName\",\r\n" + 
			"	\"hdEnabled\":true,\r\n" + 
			"	\"callSign\":\"AA2B\"\r\n" + 
			"}]";
	
	private static final String STATION_ID = "stationId";
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(stationController).build();
		
		stationMock = new Station();
		stationMock.setCallSign("AA2B");
		stationMock.setHdEnabled(true);
		stationMock.setName("TestName");
		stationMock.setStationId("stationId");
		
		List<Station> stations = new ArrayList<>();
		stations.add(stationMock);
		
		when(stationService.get(STATION_ID)).thenReturn(stationMock);
		when(stationService.searchByStationIdOrName(STATION_ID)).thenReturn(stations);
		when(stationService.searchHdEnabledStations()).thenReturn(stations);
	}
	
	@Test
	public void addStationTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(
				"/rest/station/add").accept(MediaType.APPLICATION_JSON).content(STATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		JSONAssert.assertEquals(STATION_JSON, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void removeStationTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(
				"/rest/station/remove/" + STATION_ID).accept(MediaType.APPLICATION_JSON)).andReturn();
		JSONAssert.assertEquals(STATION_JSON, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void updateStationTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(
				"/rest/station/update").accept(MediaType.APPLICATION_JSON).content(STATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		JSONAssert.assertEquals(STATION_JSON, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void searchByStationIdOrNameTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
				"/rest/station/search/stationidorname/" + STATION_ID).accept(MediaType.APPLICATION_JSON)).andReturn();
		JSONAssert.assertEquals(STATIONS_JSON, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void searchHdEnabledTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
				"/rest/station/search/hdenabled").accept(MediaType.APPLICATION_JSON)).andReturn();
		JSONAssert.assertEquals(STATIONS_JSON, result.getResponse()
				.getContentAsString(), false);
	}

}
