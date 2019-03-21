package com.example.demo.model;

public class PaymentCallback {
	private String txnid;
	private String mihpayid;
	private PaymentMode mode;
	private String status;
	private String hash;
	public PaymentCallback() {
		
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getMihpayid() {
		return mihpayid;
	}
	public void setMihpayid(String mihpayid) {
		this.mihpayid = mihpayid;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHush() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public PaymentCallback(String txnid, String mihpayid, PaymentMode mode, String status, String hash) {
		super();
		this.txnid = txnid;
		this.mihpayid = mihpayid;
		this.mode = mode;
		this.status = status;
		this.hash = hash;
	}
	
}
