package com.mtco.service.abstracts;

import java.util.List;

import com.mtco.dto.request.CreateCityRequest;
import com.mtco.dto.request.UpdateCityRequest;
import com.mtco.dto.response.CityResponseDTO;

public interface CityService {

	List<CityResponseDTO> getAllCities();

	void createCity(CreateCityRequest createCityRequest);

	CityResponseDTO getCityById(Long id);

	void updateCity(Long id, UpdateCityRequest updateCityRequest);

	void deleteCity(Long id);

	List<CityResponseDTO> searchCities(String keyword);

	List<CityResponseDTO> getCitiesByCountry(String countryName);


}
