package com.bms.payment;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class PaymentServiceApplication {

	@PostConstruct
	public void setup() {
		Stripe.apiKey = "sk_test_51MqDocSAHwet0SSm8P2mekxpRDw2ldSKlcml5vcFQzUtw01tV6wbWucBTSZCtOatFEZ4O596RreTZlq0hPtEidcs00OvOh2Nkl";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
