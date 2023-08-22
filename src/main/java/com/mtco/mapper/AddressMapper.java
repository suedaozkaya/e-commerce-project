package com.mtco.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mtco.domain.Address;
import com.mtco.dto.response.AddressResponseDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	AddressResponseDTO addressToAddressDTO(Address address);
	
	List<AddressResponseDTO> map(List<Address> addressList);
}
