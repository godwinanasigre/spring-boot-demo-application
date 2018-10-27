package com.godwin.demo.application.mapper;

public interface ModelMapper <T> {
	
	public void add(T model);
	
	public T get(String id);
	
	public void update(T model);
	
	public void delete(String id);

}
