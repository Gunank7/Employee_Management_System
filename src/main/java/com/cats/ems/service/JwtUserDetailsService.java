package com.cats.ems.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cats.ems.dto.CredentialManagerDTO;
import com.cats.ems.model.CredentialManager;
import com.cats.ems.repo.CredentialsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		CredentialManager user = credentialsRepository.findByUserId(userId);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userId);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
				new ArrayList<>());
	}

	public CredentialManager save(CredentialManagerDTO user) {
		CredentialManager newUser = new CredentialManager();
		newUser.setUserId(user.getUserId());
		
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return credentialsRepository.save(newUser);
	}
}