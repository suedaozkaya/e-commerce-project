package com.mtco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mtco.model.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Entity
public class PaymentInfo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payId;
	
    @Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private PaymentMethod paymentMethod;
	
	@Column(length = 50, nullable = false)
	private String provider;
	
	@Column(length = 100, nullable = false)
	private String cardHolderName;
	
	@Column(length = 17, nullable = false)
	private String accountNumber;
	
	@Type(type = "date")
	private Date expiryDate; // dd/MM/yyyy olarak

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
}
