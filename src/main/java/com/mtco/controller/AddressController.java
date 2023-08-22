package com.mtco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtco.dto.request.CreateAddressRequest;
import com.mtco.dto.request.UpdateAddressRequest;
import com.mtco.dto.response.AddressResponseDTO;
import com.mtco.dto.response.VRResponse;
import com.mtco.service.abstracts.AddressService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/addresses")
public class AddressController {

	private AddressService addressService;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<AddressResponseDTO>> getAllAddresses(){
		List<AddressResponseDTO> addressDTOList = addressService.getAllAddresses();
		return ResponseEntity.ok(addressDTOList);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<List<AddressResponseDTO>> getAddressesOfUser(){
		List<AddressResponseDTO> addressDTOList = addressService.getAddressesOfUser();
		return ResponseEntity.ok(addressDTOList);
	}
	
	@GetMapping("/{addressId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable Long id) {
		AddressResponseDTO addressDTO = addressService.getAddressById(id);
		return ResponseEntity.ok(addressDTO);
		
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> createAddressInfo(@Valid @RequestBody CreateAddressRequest createAddressRequest){
		addressService.createAddress(createAddressRequest);
		
		VRResponse response = new VRResponse();
		response.setMessage("The address created successfully.");
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/edit/{addressId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> updateAddress(@PathVariable Long id, @Valid @RequestBody UpdateAddressRequest updateAddressRequest){
		addressService.updateAddress(id, updateAddressRequest);
		
		VRResponse response = new VRResponse();
		response.setMessage("The address updated successfully.");
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("delete/{addressId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> deleteAddress(@PathVariable Long id) {
	    addressService.deleteAddress(id);

	    VRResponse response = new VRResponse();
	    response.setMessage("The address deleted successfully.");
	    response.setSuccess(true);

	    return ResponseEntity.ok(response);
	}
	//
}
