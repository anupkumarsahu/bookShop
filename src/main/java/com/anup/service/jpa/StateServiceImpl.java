package com.anup.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anup.domain.State;
import com.anup.repositories.StateRepository;
import com.anup.service.StateService;


@Service("stateService")
@Repository
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<State> findAll() {
		return (List<State>) stateRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public State findById(Integer stateNo) {
		return stateRepository.findOne(stateNo);
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

	@Override
	public void delete(Integer stateNo) {
		stateRepository.delete(stateNo);
		
	}

}
