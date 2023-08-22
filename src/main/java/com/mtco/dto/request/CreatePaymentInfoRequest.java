package com.mtco.dto.request;

import java.util.Date;

import com.mtco.domain.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentInfoRequest {

	private String paymentMethod;
	
	private String cardHolderName;

	private String accountNumber;
	
	private Date expiryDate; // dd/MM/yyyy olarak

}
