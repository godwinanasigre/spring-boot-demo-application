package com.godwin.demo.application.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StationTest {
	
	private static final String STATION_ID = "stationIdTest";
	private static final String NAME = "Name Test";
	private static final boolean HD_ENABLED = true;
	private static final String CALL_SIGN = "A3AA";
	
	private Station station;
	
	private Station anotherStation;
	
	@Before
	public void setUp() {
		station = new Station();
		station.setStationId(STATION_ID);
		station.setName(NAME);
		station.setCallSign(CALL_SIGN);
		station.setHdEnabled(HD_ENABLED);
		
		anotherStation = new Station();
	}
	
	@Test
    public void stationDetailsTest() throws Exception {
        assertEquals(STATION_ID, station.getStationId());
        assertEquals(NAME, station.getName());
        assertEquals(HD_ENABLED, station.isHdEnabled());
        assertEquals(CALL_SIGN, station.getCallSign());

    }
	
	@Test
    public void stationHashCodeTest() throws Exception {
        assertNotEquals("0", station.hashCode());
    }
	
	@Test
    public void stationEqualsTest() throws Exception {
       assertFalse(station.equals(anotherStation));
    }
	
	@Test
    public void stationCanEqualTest() throws Exception {
		assertTrue(station.canEqual(anotherStation));
    }
	
	@Test
    public void stationToStringTest() throws Exception {
		String stationToString = "Station(stationId=stationIdTest, name=Name Test, hdEnabled=true, callSign=A3AA)";
		assertEquals(stationToString, station.toString());

    }

}
