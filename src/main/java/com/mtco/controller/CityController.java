package com.mtco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtco.dto.request.CreateCityRequest;
import com.mtco.dto.request.UpdateCityRequest;
import com.mtco.dto.response.CityResponseDTO;
import com.mtco.dto.response.VRResponse;
import com.mtco.service.abstracts.CityService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/cities")
public class CityController {
	
	private CityService cityService;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<List<CityResponseDTO>> getAllCities(){
		List<CityResponseDTO> allCities = cityService.getAllCities();
		return ResponseEntity.ok(allCities);
	}
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> createCity(@Valid @RequestBody CreateCityRequest createCityRequest){
		cityService.createCity(createCityRequest);
		
		VRResponse response = new VRResponse();
		response.setMessage("City created successfully.");
		response.setSuccess(true);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CityResponseDTO> getCityById(@PathVariable Long id) {
	    CityResponseDTO cityDTO = cityService.getCityById(id);
	    return ResponseEntity.ok(cityDTO);
	}
	
    @GetMapping("/by-country/{countryName}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
    public ResponseEntity<List<CityResponseDTO>> getCitiesByCountry(@PathVariable String countryName) {
        List<CityResponseDTO> citiesByCountry = cityService.getCitiesByCountry(countryName);
        return ResponseEntity.ok(citiesByCountry);
    }
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> updateCity(@PathVariable Long id, @RequestBody UpdateCityRequest updateCityRequest) {
	    cityService.updateCity(id, updateCityRequest);
	    
	    VRResponse response = new VRResponse();
	    response.setMessage("City updated successfully.");
	    response.setSuccess(true);
	    return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> deleteCity(@PathVariable Long id) {
	    cityService.deleteCity(id);

	    VRResponse response = new VRResponse();
	    response.setMessage("City deleted successfully.");
	    response.setSuccess(true);

	    return ResponseEntity.ok(response);
	}
	
    @GetMapping("/search")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
    public ResponseEntity<List<CityResponseDTO>> searchCities(@RequestParam("keyword") String keyword) {
        List<CityResponseDTO> cities = cityService.searchCities(keyword);
        return ResponseEntity.ok(cities);
    }
	
}
