package com.mtco.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryResponseDTO {

    private Long countryId;

    private String countryName;
}
