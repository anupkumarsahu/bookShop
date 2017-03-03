package com.anup.service;

import java.util.List;

import com.anup.domain.State;

public interface StateService {
	public List<State> findAll();
	public State findById(Integer stateNo);
	public State save(State state);
	public void delete(Integer stateNo);
}
