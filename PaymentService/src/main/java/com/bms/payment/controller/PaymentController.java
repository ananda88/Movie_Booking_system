package com.bms.payment.controller;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.payment.dto.Payment;
import com.bms.payment.dto.PaymentEvent;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	private final KafkaTemplate<Long, Object> kafkaTemplate;
	
	public PaymentController(KafkaTemplate<Long, Object> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public void handlePayment(@RequestBody Payment payment) {
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		if(payment.getBookingId()!=2) {
		kafkaTemplate.send("payment_booking", new PaymentEvent(payment.getBookingId(), "SUCCESS", payment.getSeatIds()));
		}else {
			kafkaTemplate.send("payment_booking", new PaymentEvent(payment.getBookingId(), "FAILURE", payment.getSeatIds()));
		}
	}
	
}
