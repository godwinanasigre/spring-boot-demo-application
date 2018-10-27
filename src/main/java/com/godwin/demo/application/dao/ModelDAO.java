package com.godwin.demo.application.dao;

public interface ModelDAO<T> {
	
	public void add(T model);
	
	public T get(String id);
	
	public void update(T model);
	
	public void delete(String id);

}
