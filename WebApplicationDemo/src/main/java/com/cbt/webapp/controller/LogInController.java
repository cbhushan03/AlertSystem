package com.cbt.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbt.webapp.model.Alert;
import com.cbt.webapp.service.LogInService;

@Controller
@SessionAttributes("name")
public class LogInController {
	@Autowired LogInService logInService;
	
	@GetMapping("/login")
	public String logInPage(ModelMap map) {
		return "login";
	}
	
	@PostMapping("/login")
	public String showWelcomePage(@ModelAttribute("alert") Alert alert,ModelMap map,@RequestParam String name,@RequestParam String password) {
		boolean isVaildUser = logInService.validateUser(name, password);
		if (!isVaildUser) {
			map.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		 map.put("alert",alert);
		 map.put("name", name);
	     map.put("password", password);

	        return "welcome";
	}
}
