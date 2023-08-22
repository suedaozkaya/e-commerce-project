package com.mtco.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mtco.domain.City;
import com.mtco.dto.response.CityResponseDTO;

@Mapper(componentModel = "spring")
public interface CityMapper {

	CityResponseDTO cityToCityDTO(City city);
	
	List<CityResponseDTO> map(List<City> cityList);
}

 
