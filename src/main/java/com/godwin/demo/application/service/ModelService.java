package com.godwin.demo.application.service;

public interface ModelService<T> {
	
	public void add(T model);
	
	public T get(String id);
	
	public void update(T model);
	
	public void delete(String id);

}
