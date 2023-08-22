package com.mtco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
@Entity
public class City {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long cityId;

	 @Column
	 private String cityName;

	 @ManyToOne
	 @JoinColumn(name = "country_id")
	 private Country country;

}
