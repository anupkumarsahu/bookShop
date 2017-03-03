package com.anup.service;

import java.util.List;

import com.anup.domain.Country;

public interface CountryService {

	public List<Country> findAll();
	public Country findById(Integer country);
	public Country save(Country country);
	public void delete(Integer country);
}
