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

import com.anup.domain.Country;
import com.anup.service.CountryService;

@Controller
@RequestMapping("/admin")
public class CountryControllers {
	final Logger logger = LoggerFactory.getLogger(CountryControllers.class);

	@Autowired
	private CountryService countryService;

	@RequestMapping("/manageCountries")
	public String showManageCountries(Model model) {
		logger.info("Country Listing");
		List<Country> countries = countryService.findAll();
		model.addAttribute("country", new Country());
		model.addAttribute("countryList", countries);
		logger.info("No of Countries " + countries.size());
		return "manageCountries";
	}

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(Model model, @ModelAttribute("country") Country country, @Valid Country countryValid,
			BindingResult result) {
		logger.info("Save Country");
		if (result.hasErrors()) {
			logger.info("Save country hase error");
			return "manageCountries";
		} else {
			try {
				logger.info("Save country");
				countryService.save(country);
				return "redirect:/admin/manageCountries";
			} catch (ConstraintViolationException exp) {
				model.addAttribute("dbError", exp.getMessage());
				return "manageCountries";
			}
		}
	}

	@RequestMapping("/deleteCountry/{countryNo}")
	public String deleteCountry(Model model, @PathVariable("countryNo") Integer countryNo){
		logger.info("Delete Country : "+countryNo);
		try {
			countryService.delete(countryNo);
			return "redirect:/admin/manageCountries";
		} catch (DataIntegrityViolationException exp) {
			model.addAttribute("dbError", "Cannot delete a parent row.");
			model.addAttribute("country", new Country());
			return "manageCountries";
		}
	}
	
	@RequestMapping("/editCountry/{countryNo}")
	public String editCountry(Model model, @PathVariable("countryNo") Integer countryNo){
		model.addAttribute("country", countryService.findById(countryNo));
		return "manageCountries";
	}
}
