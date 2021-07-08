package com.cts.training.collateralwebportal.feign;

import com.cts.training.collateralwebportal.model.LoginModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-client", url = "http://localhost:8081/auth")
public interface AuthClient {
    
    @GetMapping("/validate")
    public boolean validate(String token);
    
    @GetMapping("/validateCustomer")
    public boolean validateCustomer(String token);

    @PostMapping("/login")
    public String login(LoginModel model);
    
    @PostMapping("/loginCustomer")
    public String loginCustomer(LoginModel model);
    
    @GetMapping("/getCustId")
	public int getCustId(@RequestHeader(name = "Authorization") String token1);
}
