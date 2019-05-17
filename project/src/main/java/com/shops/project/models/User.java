package com.shops.project.models;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;

// User entity

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = { "email" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@NotBlank
	@Size(min = 8, max = 100)
	private String password;

	public User() {

	}

	// Fields constructor

	public User(@NotBlank @Email String email,
			@NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}

	// Getters & Setters

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}