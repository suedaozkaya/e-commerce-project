package com.mtco.dto.response;

import com.mtco.domain.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO {

    private Long addressId;
    
    private String addressLine1;
    
    private String addressLine2;
    
    private String zipCode;
    
    private City city;
    
    
}
