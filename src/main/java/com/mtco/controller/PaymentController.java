package com.mtco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtco.dto.request.CreatePaymentInfoRequest;
import com.mtco.dto.response.PaymentResponseDTO;
import com.mtco.dto.response.VRResponse;
import com.mtco.service.abstracts.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private PaymentService paymentService;

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<PaymentResponseDTO>> getAllPaymentInfo(){
		List<PaymentResponseDTO> paymentDTOList = paymentService.getAllPaymentInfo();
		return ResponseEntity.ok(paymentDTOList);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<List<PaymentResponseDTO>> getPaymentInfosOfUser(){
		List<PaymentResponseDTO> paymentDTOList = paymentService.getPaymentInfosOfUser();
		return ResponseEntity.ok(paymentDTOList);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> createPaymentInfo(@Valid @RequestBody CreatePaymentInfoRequest createPaymentInfoRequest){
		paymentService.createPaymentInfo(createPaymentInfoRequest);
		
		VRResponse response = new VRResponse();
		response.setMessage("The payment information saved successfully.");
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);
	}
	
	// TODO
}
