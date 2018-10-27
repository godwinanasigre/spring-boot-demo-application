package com.godwin.demo.application.dao;

import com.godwin.demo.application.mapper.ModelMapper;

public abstract class AbstractModelDAO<T> implements ModelDAO<T>{
	
	abstract ModelMapper<T> getModelMapper();

	@Override
	public void add(T model) {
		getModelMapper().add(model);
	}

	@Override
	public T get(String id) {
		return getModelMapper().get(id);
	}

	@Override
	public void update(T model) {
		getModelMapper().update(model);
	}

	@Override
	public void delete(String id) {
		getModelMapper().delete(id);
	}
	
}
