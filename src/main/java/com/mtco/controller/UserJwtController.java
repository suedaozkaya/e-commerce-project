package com.mtco.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtco.dto.request.LogInRequest;
import com.mtco.dto.request.RegisterRequest;
import com.mtco.dto.response.LogInResponse;
import com.mtco.dto.response.VRResponse;
import com.mtco.security.jwt.JwtUtils;
import com.mtco.service.abstracts.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserJwtController {
	// bu classda sadece log in ve register methodlari yapilacak
	
	private UserService userService;
	
	private AuthenticationManager authenticationManager;
	
	private JwtUtils jwtUtils;
	
	@PostMapping("/register")
	public ResponseEntity<VRResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
		userService.saveUser(registerRequest);
		VRResponse response = new VRResponse();
		response.setMessage("User has registered successfully.");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<LogInResponse> authenticate(@Valid @RequestBody LogInRequest logInRequest){
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(logInRequest.getEmail(), logInRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); // mevcut giris yapan kullaniciyi getirir
		
		String jwtToken = jwtUtils.generateJwtToken(userDetails);
		
		LogInResponse logInResponse = new LogInResponse(jwtToken);
		
		return new ResponseEntity<>(logInResponse,HttpStatus.OK);
	}
}
