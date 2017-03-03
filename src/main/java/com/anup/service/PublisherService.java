package com.anup.service;

import java.util.List;

import com.anup.domain.Book;
import com.anup.domain.Publisher;

public interface PublisherService {

	public Publisher savePublisher(Publisher publisher);
    public List<Publisher> findAll();
    public void delete(Integer publisherNo);
    public Publisher findById(Integer publisherNo);
    public List<Publisher> listOurPublishers();
    public List<Book> getAllBooksByPublisher(Integer publisherNo);
}
