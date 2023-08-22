package com.mtco.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mtco.domain.Country;
import com.mtco.dto.response.CountryResponseDTO;

@Mapper(componentModel = "spring")
public interface CountryMapper {

	CountryResponseDTO countryToCountryDTO(Country country);
	
	List<CountryResponseDTO> map(List<Country> countryList);
}
