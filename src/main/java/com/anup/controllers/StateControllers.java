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
import com.anup.domain.State;
import com.anup.service.StateService;

@Controller
@RequestMapping("/admin")
public class StateControllers {
	final Logger logger = LoggerFactory.getLogger(StateControllers.class);

	@Autowired
	private StateService stateService;
	
	@RequestMapping("/manageStates")
	public String showManageStates(Model model){
		logger.info("State Listing");
		
		List<State> states = stateService.findAll();
		model.addAttribute("state", new State());
		model.addAttribute("stateList", states);
		logger.info("No of States " + states.size());
		return "manageStates";
	}
	
	@RequestMapping(value = "/saveState", method = RequestMethod.POST)
	public String saveCountry(Model model, @ModelAttribute("state") State state, @Valid State stateValid,
			BindingResult result) {
		logger.info("Save State");
		if (result.hasErrors()) {
			logger.info("Save state hase error");
			return "manageStates";
		} else {
			try {
				logger.info("Save State");
				stateService.save(state);
				return "redirect:/admin/manageStates";
			} catch (ConstraintViolationException exp) {
				model.addAttribute("dbError", exp.getMessage());
				return "manageStates";
			}
		}
	}

	@RequestMapping("/deleteState/{stateNo}")
	public String deleteState(Model model, @PathVariable("stateNo") Integer stateNo){
		logger.info("Delete State : "+stateNo);
		try {
			stateService.delete(stateNo);
			return "redirect:/admin/manageStates";
		} catch (DataIntegrityViolationException exp) {
			model.addAttribute("dbError", "Cannot delete a parent row.");
			model.addAttribute("state", new State());
			return "manageStates";
		}
	}
	
	@RequestMapping("/editState/{stateNo}")
	public String editCountry(Model model, @PathVariable("stateNo") Integer stateNo){
		model.addAttribute("state", stateService.findById(stateNo));
		return "manageStates";
	}
}
