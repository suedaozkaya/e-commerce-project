package com.mtco.service.abstracts;

import java.util.List;

import com.mtco.dto.request.CreateCountryRequest;
import com.mtco.dto.request.UpdateCountryRequest;
import com.mtco.dto.response.CountryResponseDTO;

public interface CountryService {

	List<CountryResponseDTO> getAllCountries();

	void createCountry(CreateCountryRequest createCountryRequest);

	CountryResponseDTO getCountryById(Long id);

	void updateCountry(Long id, UpdateCountryRequest updateCountryRequest);

	void deleteCountry(Long id);

	List<CountryResponseDTO> searchCountries(String keyword);

}
