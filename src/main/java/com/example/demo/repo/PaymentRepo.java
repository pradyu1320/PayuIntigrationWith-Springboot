package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Payment;
@Repository
public interface PaymentRepo extends CrudRepository{
	Payment findByTxnId(String txnId);
}
