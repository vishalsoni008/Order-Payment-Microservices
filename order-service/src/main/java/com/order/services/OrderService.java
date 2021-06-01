package com.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.common.Payment;
import com.order.common.TransactionResponse;
import com.order.common.TranscationRequest;
import com.order.model.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository oRepo;
	
	@Autowired
	private RestTemplate templet;

	public TransactionResponse saveOrder(TranscationRequest request) {
		// TODO Auto-generated method stub
		String responce="";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponce=templet.postForObject("http://PAYMENT-SERVICE/payment/add", payment, Payment.class);
		
		
		
		oRepo.save(order);
		
		return new TransactionResponse(order, paymentResponce.getAmount(), paymentResponce.getTransactionId(), responce);
	}
}
