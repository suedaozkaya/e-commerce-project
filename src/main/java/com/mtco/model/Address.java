package com.mtco.model;

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
@Table(name = "address")
@Entity
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
    
	@Column(length = 120, nullable = false)
	private String addressLine1;
	
	@Column(length = 120)
	private String addressLine2;
	
	@Column(length = 10, nullable = false)
	private String zipCode;
	
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

}
