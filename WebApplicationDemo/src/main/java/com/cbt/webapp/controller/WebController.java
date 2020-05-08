package com.cbt.webapp.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbt.webapp.entity.AlertMonitor;
import com.cbt.webapp.model.Alert;
import com.cbt.webapp.repository.AlertRepository;

@Controller
public class WebController {
	
	@Autowired private AlertRepository alertRepository;
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("message", "Hello World");
		return "welcome";
	}
	
	@PostMapping("/savealert")
	public String savealert(@ModelAttribute("alert") Alert alert, Model model) {
		
		AlertMonitor moniter = new AlertMonitor();
		moniter.setHostname(alert.getHostname());
		moniter.setSrcpath(alert.getSrcpath());
		if(alert.getDescpath()!=null && alert.getDescpath().length()>0) {
			moniter.setCheckflag(true);
			moniter.setDescpath(alert.getDescpath());
			moniter.setFileextm(alert.getFileextm());
		}
		moniter.setEmailrecpt(alert.getEmailrecpt());
		moniter.setCreatedBy("CBhushan");
		moniter.setCreationDate(new Date());
		
		AlertMonitor result = alertRepository.save(moniter);
		
		model.addAttribute("message", "Job created successfully for host: "+alert.getHostname()+" and JobID is "+result.getJobid());
		
		return "welcome";
	}
}
