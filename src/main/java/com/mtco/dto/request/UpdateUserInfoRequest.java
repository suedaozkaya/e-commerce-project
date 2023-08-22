package com.mtco.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserInfoRequest {
	
	@NotBlank(message = "Please provide your name.")
	@Size(min = 2, max = 100, message = "Name must be between {min} and {max} long.")
	private String name;
	
	@NotBlank(message = "Please provide your email.")
	@Size(min = 2, max = 100, message = "Email must not exceed {max} characters.")
	@Email(message = "Please provide a valid email.")
	private String email;
	
    @NotBlank(message = "Please provide your phone number.")
    @Size(min = 14, max = 14, message = "Phone number must be in the length of {min}.")
	private String phoneNumber;
    
}
