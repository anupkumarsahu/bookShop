package com.anup.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
	final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@RequestMapping(value="/admin/adminLogin", method = RequestMethod.GET)
	public String showAdminLogin(Model model){
		logger.info("Show user login");
		return "adminLogin";
	}
	
	@RequestMapping(value="/admin/adminLoginFailed", method = RequestMethod.GET)
	public String showAdminLoginError(Model model){
		logger.info("Show user login error");
		model.addAttribute("error", "true");
		return "adminLogin";
	}
	
	@RequestMapping(value="/admin/adminLogout", method = RequestMethod.GET)
	public String showAdminLoginAfterLogout(Model model){
		logger.info("Show user login after logout");
		return "adminLogin";
	}
	
	@RequestMapping(value="/admin/adminAccessDenied")
	public String showAccessDeniedPage(Model model){
		logger.info("Show access denied page");
		return "adminAccessDenied";
	}
}
