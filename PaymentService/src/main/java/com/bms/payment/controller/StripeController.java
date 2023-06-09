package com.bms.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bms.payment.dto.PaymentEvent;
import com.bms.payment.model.Payment;
import com.bms.payment.repository.PaymentReposioty;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.StripeObject;
import com.stripe.net.Webhook;

@RestController
public class StripeController {
	
	String endpointSecret = "";
	
	private final KafkaTemplate<Long, Object> kafkaTemplate;
	private final PaymentReposioty paymentReposioty;
	Logger log = LoggerFactory.getLogger(StripeController.class);
	
	
	public StripeController(KafkaTemplate<Long, Object> kafkaTemplate, PaymentReposioty paymentReposioty) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.paymentReposioty = paymentReposioty;
	}



	@PostMapping("/webhook")
	public String handleStripeEvents(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
		Event event = null;

        try {
            event = Webhook.constructEvent(
                payload, sigHeader, endpointSecret
            );
        } catch (JsonSyntaxException e) {
            // Invalid payload
            
            return "";
        } catch (SignatureVerificationException e) {
            // Invalid signature
            return "";
        }
        EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
        StripeObject stripeObject = null;
        if (dataObjectDeserializer.getObject().isPresent()) {
            stripeObject = dataObjectDeserializer.getObject().get();
        } else {
            // Deserialization failed, probably due to an API version mismatch.
            // Refer to the Javadoc documentation on `EventDataObjectDeserializer` for
            // instructions on how to handle this case, or return an error here.
        }
        // Handle the event
        switch (event.getType()) {
          case "charge.succeeded": {
            // Then define and call a function to handle the event invoice.payment_succeeded
        	  JsonObject obj = JsonParser.parseString(event.toJson()).getAsJsonObject();
        	  JsonObject dataObj = obj.getAsJsonObject("data");
        	  JsonObject objectObj = dataObj.getAsJsonObject("object");
        	  JsonPrimitive paymentObj = objectObj.getAsJsonPrimitive("payment_intent");
        	  System.out.println(paymentObj.getAsString());
        	  Payment payment = paymentReposioty.findById(paymentObj.getAsString()).get();
        	  log.info("About to publish success event to booking service");
        	  kafkaTemplate.send("payment_booking", new PaymentEvent(payment.getBookingId(), "SUCCESS", payment.getSeatIds()));
            break;
          }
          case "charge.failed" : {
        	  JsonObject obj = JsonParser.parseString(event.toJson()).getAsJsonObject();
        	  JsonObject dataObj = obj.getAsJsonObject("data");
        	  JsonObject objectObj = dataObj.getAsJsonObject("object");
        	  JsonPrimitive paymentObj = objectObj.getAsJsonPrimitive("payment_intent");
        	  System.out.println(paymentObj.getAsString());
        	  Payment payment = paymentReposioty.findById(paymentObj.getAsString()).get();
        	  kafkaTemplate.send("payment_booking", new PaymentEvent(payment.getBookingId(), "FAILURE", payment.getSeatIds()));
        	  break;
          }
          // ... handle other event types
          default:
            System.out.println("Unhandled event type: " + event.getType());
        }

        return "200";

	}

}
