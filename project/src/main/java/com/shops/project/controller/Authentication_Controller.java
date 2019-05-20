package com.shops.project.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.shops.project.message.response.JwtResponse;
import com.shops.project.message.response.ResponseMessage;

import com.shops.project.models.User;
import com.shops.project.repositories.ShopRepository;
import com.shops.project.repositories.UserRepository;
import com.shops.project.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/shop/auth")
public class Authentication_Controller {
	@Autowired
	AuthenticationManager authenticationManager;  // Authentication Manager

	@Autowired
	ShopRepository shop_repo;
	
	@Autowired
	UserRepository userRepository;  // User Repository

	@Autowired
	PasswordEncoder encoder;  // BCrypt Password Encoder

	@Autowired
	JwtProvider jwtProvider;  // JSON WEB TOKEN PROVIDER

	

	@RequestMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		
		// User Authentication
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(email, password));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Generating the JSON WEB TOKEN for the signed in user
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
	}

	@RequestMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		
		// Testing if the user is already signed up
		if (userRepository.existsByEmail(email)) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		// Creating user's account
		User user = new User(email, encoder.encode(password));
		
		userRepository.save(user);
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	
	@RequestMapping("/logout")
	public ResponseEntity<?> registerUser(HttpServletRequest request){
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
		request.getSession().invalidate();
		
		return new ResponseEntity<>(new ResponseMessage("User logged out successfully"), HttpStatus.OK);
	}
	
	
	
}
