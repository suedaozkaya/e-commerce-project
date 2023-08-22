package com.mtco.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtco.domain.Address;
import com.mtco.domain.City;
import com.mtco.domain.Country;
import com.mtco.domain.User;
import com.mtco.dto.request.CreateAddressRequest;
import com.mtco.dto.request.UpdateAddressRequest;
import com.mtco.dto.response.AddressResponseDTO;
import com.mtco.exception.BadRequestException;
import com.mtco.exception.ResourceNotFoundException;
import com.mtco.mapper.AddressMapper;
import com.mtco.repository.AddressRepository;
import com.mtco.repository.CityRepository;
import com.mtco.repository.CountryRepository;
import com.mtco.service.abstracts.AddressService;
import com.mtco.service.abstracts.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdressServiceImpl implements AddressService{
	
	private AddressRepository addressRepository;
	
	private UserService userService;
	
	private CityRepository cityRepository;
	
	private CountryRepository countryRepository;
	
	private AddressMapper addressMapper;
	
	@Override
	public void createAddress(CreateAddressRequest createAddressRequest) {
		User user = userService.getCurrentUser();
		
		Address address = new Address();
		address.setAddressName(createAddressRequest.getAddressName());
		address.setName(createAddressRequest.getName());
		address.setSurname(createAddressRequest.getSurname());
		address.setPhoneNumber(createAddressRequest.getPhoneNumber());
		address.setAddressLine1(createAddressRequest.getAddressLine1());
		address.setAddressLine2(createAddressRequest.getAddressLine2());
		address.setZipCode(createAddressRequest.getZipCode());
		address.setUser(user);
		
	    City city = cityRepository.findByCityName(createAddressRequest.getCityName());
	    Country country = countryRepository.findByCountryName(createAddressRequest.getCountryName());
	    
	    if (city != null && country != null) {
	        address.setCity(city);
	        city.setCountry(country);
	        
	        addressRepository.save(address);
	    } else {
	    	throw new ResourceNotFoundException("Such country or city is not found.");
	    }
		
	}

	@Override
	public List<AddressResponseDTO> getAllAddresses() {
		List<Address> addressList = addressRepository.findAll();
		return addressMapper.map(addressList);
		
	}

	@Override
	public List<AddressResponseDTO> getAddressesOfUser() {
		User currentUser = userService.getCurrentUser();
		List<Address> addressList = addressRepository.findByUser(currentUser);
		return addressMapper.map(addressList);
	}
	

	@Override
	public AddressResponseDTO getAddressById(Long id) {
		User currentUser = userService.getCurrentUser();
		
		Address existingAddress = addressRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Address not found with id: " + id));
		
		if(!currentUser.getId().equals(existingAddress.getUser().getId())) {
			throw new BadRequestException("You are not authorized to view this address.");
		}
		
		return addressMapper.addressToAddressDTO(existingAddress);
		
	}

	@Override
	public void updateAddress(Long id, UpdateAddressRequest updateAddressRequest) {
		User currentUser = userService.getCurrentUser();
		Address existingAddress = addressRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Address not found with id: " + id));
		
		if(!currentUser.getId().equals(existingAddress.getUser().getId())) {
			throw new BadRequestException("You are not authorized to update this address.");
		}
		
		existingAddress.setAddressName(updateAddressRequest.getAddressName());
		existingAddress.setName(updateAddressRequest.getName());
		existingAddress.setSurname(updateAddressRequest.getSurname());
		
		existingAddress.setAddressLine1(updateAddressRequest.getAddressLine1());
		existingAddress.setAddressLine2(updateAddressRequest.getAddressLine2());
		existingAddress.getCity().setCityName(updateAddressRequest.getCityName());
		existingAddress.getCity().getCountry().setCountryName(updateAddressRequest.getCountryName());
		existingAddress.setPhoneNumber(updateAddressRequest.getPhoneNumber());
		existingAddress.setZipCode(updateAddressRequest.getZipCode());
		
		addressRepository.save(existingAddress);
		
	}

	@Override
	public void deleteAddress(Long id) {
		User currentUser = userService.getCurrentUser();
		
		Address address = addressRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Address not found with id: " + id));
		
		if(!currentUser.getId().equals(address.getUser().getId())) {
			throw new BadRequestException("You are not authorized to delete this address.");
		}
		
		addressRepository.delete(address);
		
		
	}



}
