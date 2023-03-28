package com.bms.payment.controller;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.payment.dto.PaymentRequest;
import com.bms.payment.model.Payment;
import com.bms.payment.repository.PaymentReposioty;
import com.bms.payment.dto.PaymentEvent;
import com.google.gson.Gson;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	private final PaymentReposioty paymentReposioty;
	
	
	
	public PaymentController(PaymentReposioty paymentReposioty) {
		super();
		this.paymentReposioty = paymentReposioty;
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Payment getPayment(@PathVariable("id") String id) {
		return paymentReposioty.findById(id).get();
	}
	

	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public void handlePayment(@RequestBody PaymentRequest payment) {
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		if(payment.getBookingId()!=2) {
		
		}else {
			
		}
	}
	
	 static class CreatePaymentResponse {
		    private String clientSecret;
		    
		    public CreatePaymentResponse(String clientSecret) {
		      this.clientSecret = clientSecret;
		    }

			public String getClientSecret() {
				return clientSecret;
			}

			public void setClientSecret(String clientSecret) {
				this.clientSecret = clientSecret;
			}
		    
		  }

	
	
	
	@PostMapping(path="/create-payment-intent", consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public CreatePaymentResponse createPaymentIntent(@RequestBody PaymentRequest payment) throws StripeException {
		PaymentIntentCreateParams params =
		        PaymentIntentCreateParams.builder()
		          .setAmount((long)payment.getPrice())
		          .setCurrency("inr")
		          .build();
		     
		      PaymentIntent paymentIntent = PaymentIntent.create(params);
		      System.out.println("intent id : "+paymentIntent.getId());
		      paymentReposioty.save(new Payment(paymentIntent.getId(), payment.getBookingId(), payment.getPrice(), payment.getSeatIds()));

		      CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
		      return paymentResponse;
	}
	
}
