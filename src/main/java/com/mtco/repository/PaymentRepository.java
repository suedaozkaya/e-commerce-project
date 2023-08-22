package com.mtco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtco.domain.PaymentInfo;
import com.mtco.domain.User;

public interface PaymentRepository extends JpaRepository<PaymentInfo, Long> {

	List<PaymentInfo> findByUser(User user);

}
