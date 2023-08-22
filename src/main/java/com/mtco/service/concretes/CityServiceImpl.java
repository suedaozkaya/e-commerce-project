package com.mtco.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtco.domain.City;
import com.mtco.domain.Country;
import com.mtco.dto.request.CreateCityRequest;
import com.mtco.dto.request.UpdateCityRequest;
import com.mtco.dto.response.CityResponseDTO;
import com.mtco.exception.ConflictException;
import com.mtco.exception.ResourceNotFoundException;
import com.mtco.mapper.CityMapper;
import com.mtco.repository.CityRepository;
import com.mtco.repository.CountryRepository;
import com.mtco.service.abstracts.CityService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
	
	private CityRepository cityRepository;
	
	private CountryRepository countryRepository;
	
	private CityMapper cityMapper;
	
	@Override
	public List<CityResponseDTO> getAllCities() {
		List<City> cityList = cityRepository.findAll();
		List<CityResponseDTO> cityDTOList = cityMapper.map(cityList);
		return cityDTOList;
	}

	@Override
	public void createCity(CreateCityRequest createCityRequest) {
		
		Country country = countryRepository.findByCountryName(createCityRequest.getCountryName());

		if(cityRepository.existsByCityName(createCityRequest.getCityName()) && createCityRequest.getCountryName().equals(country.getCountryName())) {
			throw new ConflictException("City already exists.");
		}else if(country!=null) {
			City city = new City();
			city.setCityName(createCityRequest.getCityName());
			city.setCountry(country);
			
			cityRepository.save(city);
		}
	}

	@Override
	public CityResponseDTO getCityById(Long id) {
		City city = cityRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("City not found with the id: " + id)); 
		return cityMapper.cityToCityDTO(city);
	}

	@Override
	public void updateCity(Long id, UpdateCityRequest updateCityRequest) {
		City city = cityRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("City not found with the id: " + id)); 

	    Country country = countryRepository.findByCountryName(updateCityRequest.getCountryName());

	    if (country == null) {
	        throw new ResourceNotFoundException("Country not found with name: " + updateCityRequest.getCountryName());
	    }
	    
	    if (cityRepository.existsByCityNameAndCountry(updateCityRequest.getCityName(), country)) {
	        throw new ConflictException("City with the same name already exists in the selected country.");
	    }

	    city.setCityName(updateCityRequest.getCityName());
	    city.setCountry(country);

	    cityRepository.save(city);
		
	}

	@Override
	public void deleteCity(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));

        cityRepository.delete(city);
		
	}

	
	@Override
	public List<CityResponseDTO> searchCities(String keyword) {
        List<City> matchingCities = cityRepository.findByCityNameContainingIgnoreCase(keyword);
        return cityMapper.map(matchingCities);
	}

	@Override
	public List<CityResponseDTO> getCitiesByCountry(String countryName) {
		Country country = countryRepository.findByCountryName(countryName);
        List<City> cities = cityRepository.findByCountry(country);
        return cityMapper.map(cities);
	}

	
}
