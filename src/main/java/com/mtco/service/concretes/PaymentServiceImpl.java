package com.mtco.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtco.domain.PaymentInfo;
import com.mtco.domain.User;
import com.mtco.domain.enums.PaymentMethod;
import com.mtco.domain.enums.PaymentProvider;
import com.mtco.dto.request.CreatePaymentInfoRequest;
import com.mtco.dto.response.PaymentResponseDTO;
import com.mtco.exception.BadRequestException;
import com.mtco.mapper.PaymentMapper;
import com.mtco.repository.PaymentRepository;
import com.mtco.service.abstracts.PaymentService;
import com.mtco.service.abstracts.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentRepository paymentRepository;
	
	private PaymentMapper paymentMapper;
	
	private UserService userService;
	
	@Override
	public List<PaymentResponseDTO> getAllPaymentInfo() {
		List<PaymentInfo> paymentList = paymentRepository.findAll();
		List<PaymentResponseDTO> paymentDTOList = paymentMapper.map(paymentList);
		return paymentDTOList;
		
	}

	@Override
	public List<PaymentResponseDTO> getPaymentInfosOfUser() {
		User user = userService.getCurrentUser();
		List<PaymentInfo> paymentInfoList = paymentRepository.findByUser(user);
		return paymentMapper.map(paymentInfoList);
	}

	@Override
	public void createPaymentInfo(CreatePaymentInfoRequest createPaymentInfoRequest) {
		User currentUser = userService.getCurrentUser();
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setPaymentMethod(PaymentMethod.valueOf(createPaymentInfoRequest.getPaymentMethod()));
		
	    String bin = extractBIN(createPaymentInfoRequest.getAccountNumber());
	    PaymentProvider provider = lookupProviderFromBIN(bin);

	    paymentInfo.setProvider(provider);
	    paymentInfo.setCardHolderName(createPaymentInfoRequest.getCardHolderName());
	    paymentInfo.setAccountNumber(createPaymentInfoRequest.getAccountNumber());
	    paymentInfo.setExpiryDate(createPaymentInfoRequest.getExpiryDate());
	    paymentInfo.setUser(currentUser);

	    paymentRepository.save(paymentInfo);
	}

	private String extractBIN(String accountNumber) {
	    if (accountNumber != null && accountNumber.length() >= 6) {
	        return accountNumber.substring(0, 6);
	    }
	    else {
	    	throw new BadRequestException("Provide a valid account number.");
	    }
	}

	private PaymentProvider lookupProviderFromBIN(String bin) {
		if (bin.startsWith("4")) {
	    	return PaymentProvider.MASTERCARD;     
	    } else if (bin.startsWith("5")) {
	        return PaymentProvider.VISA;
	    }else if (bin.startsWith("7")) {
	        return PaymentProvider.PAYPAL;
	    }else {
	        return PaymentProvider.UNKNOWN;

	    }
	  
	} 

	
	
	
	
	
	
}