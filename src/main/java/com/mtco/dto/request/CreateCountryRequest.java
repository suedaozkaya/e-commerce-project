package com.mtco.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCountryRequest {
	
    @NotBlank(message = "Please provide the country name.")
    @Size (max = 50, message="Country name must not exceed {max} characters.")
    private String countryName;
    
}
