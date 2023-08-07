package com.mtco.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mtco.model.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop_order")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	@Column
	private BigDecimal orderTotal;
	
	@Enumerated(EnumType.STRING)
	@Column
	private OrderStatus orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "shipping_company", nullable = false)
	private ShippingCompany shippingCompany;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "payment_id", nullable = false)
	private PaymentInfo paymentInfo;
	
	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	
}
