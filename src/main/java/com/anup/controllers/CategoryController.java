package com.anup.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anup.domain.Category;
import com.anup.domain.Country;
import com.anup.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	final Logger logger = LoggerFactory.getLogger(CountryControllers.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/manageCategories")
	public String showManageCategories(Model model) {
		logger.info("Category Listing");
		List<Category> category = categoryService.findAll();
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", category);
		logger.info("No of Category " + category.size());
		return "manageCategories";
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCountry(Model model, @ModelAttribute("category") Category category, @Valid Category categoryValid,
			BindingResult result) {
		logger.info("Save Category");
		if (result.hasErrors()) {
			logger.info("Save category hase error");
			return "manageCategories";
		} else {
			try {
				logger.info("Save category");
				categoryService.save(category);
				return "redirect:/admin/manageCategories";
			} catch (ConstraintViolationException exp) {
				model.addAttribute("dbError", exp.getMessage());
				return "manageCategories";
			}
		}
	}

	@RequestMapping("/deleteCategory/{categoryNo}")
	public String deleteCategory(Model model, @PathVariable("categoryNo") Integer categoryNo){
		logger.info("Delete Category : "+categoryNo);
		try {
			categoryService.delete(categoryNo);
			return "redirect:/admin/manageCategories";
		} catch (DataIntegrityViolationException exp) {
			model.addAttribute("dbError", "Cannot delete a parent row.");
			model.addAttribute("category", new Category());
			return "manageCategories";
		}
	}
	
	@RequestMapping("/editCategory/{categoryNo}")
	public String editCategory(Model model, @PathVariable("categoryNo") Integer categoryNo){
		model.addAttribute("category", categoryService.findById(categoryNo));
		return "manageCategories";
	}
}
