package com.cats.ems.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.Data;

@Entity
@Data
public class CredentialManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;
	private String userId;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	

}
