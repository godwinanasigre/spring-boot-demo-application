package com.godwin.demo.application.service;

import com.godwin.demo.application.dao.ModelDAO;

public abstract class AbstractModelService<T> implements ModelService<T>{
	
	abstract ModelDAO<T> getModelDAO();

	@Override
	public void add(T model) {
		getModelDAO().add(model);
	}

	@Override
	public T get(String id) {
		return getModelDAO().get(id);
	}

	@Override
	public void update(T model) {
		getModelDAO().update(model);
	}

	@Override
	public void delete(String id) {
		getModelDAO().delete(id);
	}
	
}
