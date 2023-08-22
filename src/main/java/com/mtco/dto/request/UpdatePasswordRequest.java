package com.mtco.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "Please provide your old password.")
    @Size(min = 4, max = 20, message="Password must be between {min} and {max} characters.")
	private String oldPassword;
	
    @NotBlank(message = "Please provide your new password.")
    @Size(min = 4, max = 20, message="Password must be between {min} and {max} characters.")
	private String newPassword;
}
