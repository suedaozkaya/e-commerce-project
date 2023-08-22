package com.mtco.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {

    @NotBlank(message = "Please provide the city name.")
    @Size (max = 50, message="City name must not exceed {max} characters.")
	private String cityName;
	
    @NotBlank(message = "Please provide the country name.")
    @Size (max = 50, message="Country name must not exceed {max} characters.")
	private String countryName;
}
