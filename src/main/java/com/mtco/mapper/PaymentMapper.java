package com.mtco.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mtco.domain.PaymentInfo;
import com.mtco.dto.response.PaymentResponseDTO;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

	PaymentResponseDTO paymentToPaymentDTO(PaymentInfo payment);
	
	List<PaymentResponseDTO> map(List<PaymentInfo> paymentList);
}
