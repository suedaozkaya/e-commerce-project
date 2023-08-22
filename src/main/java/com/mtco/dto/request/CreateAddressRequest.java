package com.mtco.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
	
    @NotBlank(message = "Please provide the address name.")
    @Size (max = 50, message = "The name must not exceed {max} characters.")
    private String addressName;
    
    @NotBlank(message = "Please provide the name.")
    @Size (max = 100, message = "The name must not exceed {max} characters.")
    private String name;
    
    @NotBlank(message = "Please provide the surname.")
    @Size (max = 100, message = "The surname must not exceed {max} characters.")
    private String surname;
    
    @NotBlank(message = "Please provide the phone number.")
    @Size (min = 14, max = 14, message = "The phone number must be {max} characters.")
    private String phoneNumber;
	
    @NotBlank(message = "Please provide the address.")
    @Size (max = 150, message = "The first address line must not exceed {max} characters.")
	private String addressLine1;
	
    @Size (max = 150, message = "The second address line must not exceed {max} characters.")
	private String addressLine2;
	
    @NotBlank(message = "Please provide the zipcode.")
    @Size (max = 10, message = "The zipcode must not exceed {max} characters.")
	private String zipCode;
    
    @NotBlank(message = "Please provide the country name.")
    @Size (max = 50, message = "The country name must not exceed {max} characters.")
    private String countryName;
    
    @NotBlank(message = "Please provide the city name.")
    @Size (max = 50, message = "The city name must not exceed {max} characters.")
    private String cityName;
}
