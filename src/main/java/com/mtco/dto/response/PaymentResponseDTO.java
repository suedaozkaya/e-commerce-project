package com.mtco.dto.response;

import java.util.Date;

import com.mtco.domain.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
	
	private Long payId;
	
	private PaymentMethod paymentMethod;

	private String provider;
	
	private String cardHolderName;
	
	private String accountNumber;
	
	private Date expiryDate; 

}
