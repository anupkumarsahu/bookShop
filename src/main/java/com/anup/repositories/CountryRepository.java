package com.anup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.anup.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
