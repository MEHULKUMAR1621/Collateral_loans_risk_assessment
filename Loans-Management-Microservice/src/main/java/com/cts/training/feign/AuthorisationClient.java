package com.cts.training.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Authorization Service FeignClient and for Connect with it
 */
@FeignClient(name = "authorization-service", url = "${AUTH_SERVICE:http://localhost:8081}")
public interface AuthorisationClient {

	/**
	 * validate method of Authorization Service for admin
	 * @param token
	 * @return
	 */
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
	
	/** Validate method for Customer
	 * @param token
	 * @return
	 */
	@GetMapping("/auth/validateCustomer")
	public boolean validateCustomer(@RequestHeader(name = "Authorization") String token);
}