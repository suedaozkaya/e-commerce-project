package com.mtco.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCountryRequest {

    @NotNull(message = "Country ID is required.")
    private Long id;

    @NotBlank(message = "Country name is required.")
    @Size(max = 50, message = "Country name must not exceed {max} characters.")
    private String countryName;

}
