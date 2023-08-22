package com.mtco.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtco.domain.City;
import com.mtco.domain.Country;
import com.mtco.dto.request.CreateCountryRequest;
import com.mtco.dto.request.UpdateCountryRequest;
import com.mtco.dto.response.CountryResponseDTO;
import com.mtco.exception.ConflictException;
import com.mtco.exception.ResourceNotFoundException;
import com.mtco.mapper.CountryMapper;
import com.mtco.repository.CityRepository;
import com.mtco.repository.CountryRepository;
import com.mtco.service.abstracts.CountryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService{
	
	private CountryRepository countryRepository;
	
	private CityRepository cityRepository;
	
	private CountryMapper countryMapper;
	
	@Override
	public List<CountryResponseDTO> getAllCountries() {
		List<Country> countryList = countryRepository.findAll();
		List<CountryResponseDTO> countryDTOList = countryMapper.map(countryList);
		return countryDTOList;
	}

	@Override
	public void createCountry(CreateCountryRequest createCountryRequest) {

		if(countryRepository.existsByCountryName(createCountryRequest.getCountryName())) {
			throw new ConflictException("Country already exists.");
		}else {
			
			Country country = new Country();
			country.setCountryName(createCountryRequest.getCountryName());
			
			countryRepository.save(country);
		}
		
	}

	@Override
	public CountryResponseDTO getCountryById(Long id) {
		Country country = countryRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Country not found with the id: " + id)); 
		return countryMapper.countryToCountryDTO(country);
	}

	@Override
	public void updateCountry(Long id, UpdateCountryRequest updateCountryRequest) {
		Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));

        country.setCountryName(updateCountryRequest.getCountryName());

        countryRepository.save(country);		
	}

	@Override
	public void deleteCountry(Long id) {
		Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
		
		List<City> cities = cityRepository.findByCountry(country);
        
        cityRepository.deleteAll(cities);
        countryRepository.delete(country);
	}

	@Override
	public List<CountryResponseDTO> searchCountries(String keyword) {
        List<Country> matchingCountries = countryRepository.findByCountryNameContainingIgnoreCase(keyword);
        return countryMapper.map(matchingCountries);
	}

}
