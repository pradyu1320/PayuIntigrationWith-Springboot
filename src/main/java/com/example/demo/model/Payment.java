package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String productInfo;
	@Column
	private Double amount;
	@Column
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	@Column
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	@Column
	private String txnId;
	@Column
	private String mihpayId;
	@Column
	@Enumerated(EnumType.STRING)
	private PaymentMode mode;
	public Payment() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getMihpayId() {
		return mihpayId;
	}
	public void setMihpayId(String mihpayId) {
		this.mihpayId = mihpayId;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	public Payment(String email, String name, String phone, String productInfo, Double amount,
			PaymentStatus paymentStatus, Date paymentDate, String txnId, String mihpayId, PaymentMode mode) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.productInfo = productInfo;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.txnId = txnId;
		this.mihpayId = mihpayId;
		this.mode = mode;
	}
	
}
