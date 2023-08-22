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
public class LogInRequest {

	@NotBlank(message = "Please provide your email.")
	@Size(min = 2, max = 100, message = "Email must not exceed {max} characters.")
	@Email(message = "Please provide a valid email.")
	private String email;
	
    @NotBlank(message = "Please provide your password.")
    @Size(min = 4, max = 20, message="Password must be between {min} and {max} characters.")
	private String password;
    
}
