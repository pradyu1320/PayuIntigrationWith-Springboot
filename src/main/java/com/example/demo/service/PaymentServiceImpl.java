package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentCallback;
import com.example.demo.model.PaymentDetail;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repo.PaymentRepo;
import com.example.demo.util.PaymentUtil;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepo paymentRepo;
	@Override
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
		PaymentUtil paymentUtil = new PaymentUtil();
		paymentDetail = paymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);		
		return paymentDetail;
	}

	private void savePaymentDetail(PaymentDetail paymentDetail) {
		Payment payment = new Payment();
		payment.setAmount(Double.parseDouble(paymentDetail.getAmount()));
		payment.setEmail(paymentDetail.getEmail());
		payment.setName(paymentDetail.getName());
		payment.setPaymentDate(new Date());
		payment.setPaymentStatus(PaymentStatus.Pending);
		payment.setPhone(paymentDetail.getPhone());
		payment.setProductInfo(paymentDetail.getProductInfo());
		payment.setTxnId(paymentDetail.getTxnId());
		paymentRepo.save(payment);
	}

	@Override
	public String payuCallback(PaymentCallback paymentResponse) {
		String msg ="Transaction failed";
		Payment payment = paymentRepo.findByTxnId(paymentResponse.getTxnid());
		if(payment != null) {
			//Validate hash
			PaymentStatus paymentStatus = null;
			if(paymentResponse.getStatus().equals("failure")) {
				paymentStatus = paymentStatus.Failed;
			}else if(paymentResponse.getStatus().equals("success")) {
				paymentStatus = paymentStatus.Success;
				msg = "Transaction Success";
			}
			payment.setPaymentStatus(paymentStatus);
			payment.setMihpayId(paymentResponse.getMihpayid());
			payment.setMode(paymentResponse.getMode());
			paymentRepo.save(payment);
		}
		
		return msg;
	}

}
