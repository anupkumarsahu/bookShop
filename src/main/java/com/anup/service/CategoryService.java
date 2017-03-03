package com.anup.service;

import java.util.List;

import com.anup.domain.Category;

public interface CategoryService {

	public List<Category> findAll();
	public Category findById(Integer categoryNo);
	public Category save(Category category);
	public void delete(Integer categoryNo);
}
