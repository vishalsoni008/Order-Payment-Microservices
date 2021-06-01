package com.payment.services;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.model.Payment;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository pRepo;
	
	public Payment doPayment(@RequestBody Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return pRepo.save(payment);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"sucess":"false";
	}
}
