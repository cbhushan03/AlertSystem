package com.cbt.webapp.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbt.webapp.entity.AlertMonitor;
import com.cbt.webapp.repository.AlertRepository;


/*@RestController
@RequestMapping("job-services")*/
public class WebClientRestController {
	
	/*
	 * @Autowired private AlertRepository alertRepository;
	 * 
	 * @GetMapping("job/{id}") public ResponseEntity<AlertMonitor>
	 * getAlertDetails(@PathVariable("id") Integer jobID) { AlertMonitor monitor =
	 * alertRepository.findById(jobID).get();
	 * 
	 * return new ResponseEntity<AlertMonitor>(monitor,HttpStatus.OK); }
	 */
}
