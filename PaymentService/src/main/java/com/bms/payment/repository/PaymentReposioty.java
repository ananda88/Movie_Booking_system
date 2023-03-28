package com.bms.payment.repository;

import org.springframework.data.repository.CrudRepository;

import com.bms.payment.model.Payment;

public interface PaymentReposioty extends CrudRepository<Payment, String>{

}
