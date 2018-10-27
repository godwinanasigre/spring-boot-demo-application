package com.godwin.demo.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.godwin.demo.application.model.Station;

@Mapper
public interface StationMapper extends ModelMapper<Station>{
	
	final String addStation = "insert into station(stationId, name, hdEnabled, callSign) "
						+ "values(#{stationId}, #{name}, #{hdEnabled}, #{callSign})";
	
	final String getStation = "select * from station where stationId=#{id}";
	
	final String updateStation =  "update station set name=#{name}, hdEnabled=#{hdEnabled}, callSign=#{callSign} where stationId=#{stationId}";
	
	final String deleteStation = "delete from station where stationId=#{id}";
	
	final String searchByStationIdOrName = "select * from station where stationId=#{key} or name=#{key}";
	
	final String searchHdEnabledStations = "select * from station where hdEnabled=1";
	
	@Insert(addStation)
	public void add(Station model);
	
	@Select(getStation)
	public Station get(String id);
	
	@Update(updateStation)
	public void update(Station model);
	
	@Delete(deleteStation)
	public void delete(String id);
	
	@Select(searchByStationIdOrName)
	public List<Station> searchByStationIdOrName(String key);
	
	@Select(searchHdEnabledStations)
	public List<Station> searchHdEnabledStations();
}
