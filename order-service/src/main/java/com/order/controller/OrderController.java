package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.TransactionResponse;
import com.order.common.TranscationRequest;
import com.order.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService oService;
	
	@PostMapping("/add")
	public TransactionResponse add(@RequestBody TranscationRequest request) {
		return oService.saveOrder(request);
	}
}
