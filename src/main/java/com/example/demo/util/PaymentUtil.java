package com.example.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.example.demo.model.PaymentDetail;

public class PaymentUtil {
	private static final String paymentKey = "frygktbj";
	private static final String paymentSalt ="eQkHgyrilB";
	private static final String sUrl = "http://localhost:8080/payment/payment-response";
	private static final String fUrl = "http://localhost:8080/payment-response";
	public static PaymentDetail populatePaymentDetail(PaymentDetail paymentDetail) {
		String hashString="";
		Random rand = new Random();
		String randomId = Integer.toString(rand.nextInt()) + (System.currentTimeMillis()/1000L);
		String txnId = "Dev" + hashCal("SHA-256",randomId).substring(0,12);
		paymentDetail.setTxnId(txnId);
		String hash="";
		String hashSequence = "key|txnid|amount|productInfo|firstname|email|||||||||||";
		hashString = hashSequence.concat(paymentSalt);
		hashString = hashSequence.replace("key", paymentKey);
		hashString = hashSequence.replace("txnid", txnId);
		hashString = hashSequence.replace("amount", paymentDetail.getAmount());
		hashString = hashSequence.replace("productInfo",paymentDetail.getProductInfo());
		hashString = hashSequence.replace("firstname", paymentDetail.getName());
		hashString = hashSequence.replace("email",paymentDetail.getEmail());
		hash = hashCal("SHA-512",hashString);
		paymentDetail.setHash(hash);
		paymentDetail.setfUrl(fUrl);
		paymentDetail.setsUrl(sUrl);
		paymentDetail.setKey(paymentKey);
		return paymentDetail;
	}
	public static String hashCal(String type,String str) {
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest algo = MessageDigest.getInstance(type);
			algo.reset();
			algo.update(hashseq);
			byte messageDigest[] = algo.digest();
			for(int i = 0;i<messageDigest.length;i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if(hex.length() ==1) {
					hexString.append("0");
				}
				hexString.append(hex);
			}
			
		}catch(NoSuchAlgorithmException nsae) {
			
		}
		return hexString.toString();
	}
}
