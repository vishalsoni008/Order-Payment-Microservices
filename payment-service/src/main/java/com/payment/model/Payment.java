package com.payment.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "paymentid")
	private int paymentId;
	
	@Column(name = "paymentstatus")
	private String paymentStatus;
	
	@Column(name = "transactionid")
	private String transactionId;
	
	@Column(name = "orderid")
	private int orderId;
	
	@Column(name = "amount")
	private double amount;

}
