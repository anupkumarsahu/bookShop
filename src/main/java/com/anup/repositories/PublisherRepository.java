package com.anup.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.anup.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

	@Query("select p from Publisher p")
	public List<Publisher> listOurPublisher();
	
	@Query("select p from Publisher p where p.publisherNo = :publishNo")
	public List<Publisher> getAllBooksByPublisher(@Param("publishNo") Integer publisherNo);
}
