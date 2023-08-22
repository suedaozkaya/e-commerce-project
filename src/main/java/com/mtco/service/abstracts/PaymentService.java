package com.mtco.service.abstracts;

import java.util.List;

import javax.validation.Valid;

import com.mtco.dto.request.CreatePaymentInfoRequest;
import com.mtco.dto.response.PaymentResponseDTO;

public interface PaymentService {

	List<PaymentResponseDTO> getAllPaymentInfo();

	List<PaymentResponseDTO> getPaymentInfosOfUser();

	void createPaymentInfo(CreatePaymentInfoRequest createPaymentInfoRequest);

	
}
