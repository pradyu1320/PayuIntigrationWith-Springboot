package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.PaymentCallback;
import com.example.demo.model.PaymentDetail;
@Service
public interface PaymentService {
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail);
	public 	String payuCallback(PaymentCallback paymentResponse);	
}
