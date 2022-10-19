package com.cats.ems.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cats.ems.model.Employee;

import lombok.Data;

@Data
public class CredentialManagerDTO {

	private int loginId;
	private String userId;
	private String password;
	private Employee employee;

}
