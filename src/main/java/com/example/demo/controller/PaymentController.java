package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PaymentCallback;
import com.example.demo.model.PaymentDetail;
import com.example.demo.model.PaymentMode;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/payment-details")
	public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail) {
		return paymentService.proceedPayment(paymentDetail);
	}
	@PostMapping("/payment-response")
	public @ResponseBody String payuCallback(@RequestParam String mihpayid,@RequestParam String status,@RequestParam PaymentMode mode,@RequestParam String txnid,@RequestParam String hash) {
		PaymentCallback paymentCallback = 	new PaymentCallback();
		paymentCallback.setMihpayid(mihpayid);
		paymentCallback.setTxnid(txnid);
		paymentCallback.setMode(mode);
		paymentCallback.setStatus(status);
		paymentCallback.setHash(hash);
		return paymentService.payuCallback(paymentCallback);
	}
}
