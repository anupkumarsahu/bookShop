package com.anup.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anup.domain.Category;
import com.anup.repositories.CategoryRepository;
import com.anup.service.CategoryService;

@Service("categoryService")
@Repository
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;
	
	@Override
	@Transactional(readOnly=true)
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Category findById(Integer categoryNo) {
		return categoryRepository.findOne(categoryNo);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Integer categoryNo) {
		categoryRepository.delete(categoryNo);
	}

}
