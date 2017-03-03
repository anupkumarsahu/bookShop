package com.anup.service.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anup.domain.Book;
import com.anup.domain.Publisher;
import com.anup.repositories.PublisherRepository;
import com.anup.service.PublisherService;

@Service("publisherService")
@Repository
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	final Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);
	
	@Autowired
	private PublisherRepository publisherRepository; 

	@Override
	public Publisher savePublisher(Publisher publisher) {
		logger.info("Save publisher service");
		return publisherRepository.save(publisher);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Publisher> findAll() {
		return (List<Publisher>) publisherRepository.findAll();
	}

	@Override
	public void delete(Integer publisherNo) {
		publisherRepository.delete(publisherNo);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Publisher findById(Integer publisherNo) {
		return publisherRepository.findOne(publisherNo);
	}

	@Override
	public List<Publisher> listOurPublishers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooksByPublisher(Integer publisherNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
