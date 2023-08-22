package com.mtco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtco.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

	Country findByCountryName(String countryName);

	boolean existsByCountryName(String countryName);

	List<Country> findByCountryNameContainingIgnoreCase(String keyword);

	//Country findByCountryNameIgnoreCase(String countryName);

}
