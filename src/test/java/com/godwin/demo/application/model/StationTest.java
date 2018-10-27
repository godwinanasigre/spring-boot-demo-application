package com.godwin.demo.application.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StationTest {
	
	private static final String STATION_ID = "stationIdTest";
	private static final String NAME = "Name Test";
	private static final boolean HD_ENABLED = true;
	private static final String CALL_SIGN = "A3AA";
	
	private Station station;
	
	@Before
	public void setUp() {
		station = new Station();
		station.setStationId(STATION_ID);
		station.setName(NAME);
		station.setCallSign(CALL_SIGN);
		station.setHdEnabled(HD_ENABLED);
	}
	
	@Test
    public void stationDetailsTest() throws Exception {
        assertEquals(STATION_ID, station.getStationId());
        assertEquals(NAME, station.getName());
        assertEquals(HD_ENABLED, station.isHdEnabled());
        assertEquals(CALL_SIGN, station.getCallSign());

    }

}
