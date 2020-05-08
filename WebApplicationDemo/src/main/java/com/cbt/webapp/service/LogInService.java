package com.cbt.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class LogInService {
	public boolean validateUser(String username, String password) {
		return username.equals("test") 
				&& password.equals("test");
	}
}
