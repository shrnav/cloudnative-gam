package com.precisely.gam.gamclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class GavClientController {
	@Autowired
	private GavAddressingProxy proxy;
	@GetMapping("/gav-client/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String getResponse(@PathVariable String country,@PathVariable String input,@PathVariable String city,@PathVariable String sp,@PathVariable String postCode) {
		
		return proxy.getGAV(country,input,city,sp,postCode);
	}
	
	@GetMapping("/gta-client/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String getGTAResponse(@PathVariable String country,@PathVariable String input,@PathVariable String city,@PathVariable String sp,@PathVariable String postCode) {
		
		return proxy.getGTA(country,input,city,sp,postCode);
	}
	
	 public String hardcodedResponse(Exception ex) {
		 	
			return ex.getMessage();
		}

}
