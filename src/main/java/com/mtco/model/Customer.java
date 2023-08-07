package com.mtco.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 14, nullable = false)
	private String phoneNumber;
	
	@Column(length = 120, nullable = false)
	private String password;
	
	@CreationTimestamp
	@Column
	private LocalDate createdAt;
	
	@OneToMany(mappedBy = "customer", orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();
	
	@OneToOne(mappedBy = "customer", orphanRemoval = true)
	private ShoppingCart shoppingCart;
}
