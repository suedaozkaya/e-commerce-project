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

import com.mtco.dto.request.CreateCountryRequest;
import com.mtco.dto.request.UpdateCountryRequest;
import com.mtco.dto.response.CountryResponseDTO;
import com.mtco.dto.response.VRResponse;
import com.mtco.service.abstracts.CountryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/countries")
public class CountryController {

	private CountryService countryService;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<List<CountryResponseDTO>> getAllCountries(){
		List<CountryResponseDTO> allCountries = countryService.getAllCountries();
		return ResponseEntity.ok(allCountries);
	}
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> createCountry(@Valid @RequestBody CreateCountryRequest createCountryRequest){
		countryService.createCountry(createCountryRequest);
		
		VRResponse response = new VRResponse();
		response.setMessage("Country created successfully.");
		response.setSuccess(true);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CountryResponseDTO> getCountryById(@PathVariable Long id) {
	    CountryResponseDTO countryDTO = countryService.getCountryById(id);
	    return ResponseEntity.ok(countryDTO);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> updateCountry(@PathVariable Long id, @RequestBody UpdateCountryRequest updateCountryRequest) {
	    countryService.updateCountry(id, updateCountryRequest);
	    
	    VRResponse response = new VRResponse();
	    response.setMessage("Country updated successfully.");
	    response.setSuccess(true);
	    return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> deleteCountry(@PathVariable Long id) {
	    countryService.deleteCountry(id);

	    VRResponse response = new VRResponse();
	    response.setMessage("Country deleted successfully.");
	    response.setSuccess(true);

	    return ResponseEntity.ok(response);
	}
	
    @GetMapping("/search")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
    public ResponseEntity<List<CountryResponseDTO>> searchCountries(@RequestParam("keyword") String keyword) {
        List<CountryResponseDTO> countries = countryService.searchCountries(keyword);
        return ResponseEntity.ok(countries);
    }
	
}
