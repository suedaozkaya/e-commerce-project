package com.mtco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtco.domain.City;
import com.mtco.domain.Country;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	City findByCityName(String cityName);

	boolean existsByCityName(String cityName);

	boolean existsByCityNameAndCountry(String cityName, Country country);

	List<City> findByCityNameContainingIgnoreCase(String keyword);

	List<City> findByCountry(Country country);


}
