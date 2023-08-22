package com.mtco.service.abstracts;

import java.util.List;

import com.mtco.dto.request.CreateAddressRequest;
import com.mtco.dto.request.UpdateAddressRequest;
import com.mtco.dto.response.AddressResponseDTO;

public interface AddressService {

	void createAddress(CreateAddressRequest createAddressRequest);

	List<AddressResponseDTO> getAllAddresses();

	List<AddressResponseDTO> getAddressesOfUser();

	void updateAddress(Long id, UpdateAddressRequest updateAddressRequest);

	void deleteAddress(Long id);

	AddressResponseDTO getAddressById(Long id);

}
