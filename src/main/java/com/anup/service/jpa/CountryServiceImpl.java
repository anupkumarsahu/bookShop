package com.anup.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anup.domain.Country;
import com.anup.repositories.CountryRepository;
import com.anup.service.CountryService;

@Service("countryService")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Country findById(Integer country) {
		return countryRepository.findOne(country);
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void delete(Integer countryNo) {
		countryRepository.delete(countryNo);
	}

}
