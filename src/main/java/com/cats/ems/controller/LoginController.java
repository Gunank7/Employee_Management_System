package com.cats.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cats.ems.model.CredentialManager;
import com.cats.ems.model.Employee;
import com.cats.ems.repo.CredentialsRepository;
import com.cats.ems.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class LoginController {
	
	@Autowired
	CredentialsRepository credentialsRepository;

	@PostMapping("/login")
	public ResponseEntity<String> saveCredentialManager(@RequestBody CredentialManager credentialManager)
	{
		credentialsRepository.save(credentialManager);
		return ResponseEntity.ok("credential successfull");
	}
	
	
}
