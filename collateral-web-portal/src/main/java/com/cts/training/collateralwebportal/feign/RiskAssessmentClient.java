package com.cts.training.collateralwebportal.feign;

 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.training.collateralwebportal.model.Collateral;
import com.cts.training.collateralwebportal.model.CollateralRiskPercent;
//Management-Microservice
@FeignClient(name="risk-management", url="http://localhost:8082/risk/riskManagement")
public interface RiskAssessmentClient {
	
    
	@GetMapping("/getCollateralRisk/{loanID}")
	public CollateralRiskPercent getCollateralRisk(@RequestHeader(name = "Authorization") String token,
			@PathVariable("loanID") Integer loanId) throws LoanNotFoundException;

	@GetMapping("/getCollateralsRisk/{loanID}")
	public Collateral getCollateralsRisk(@RequestHeader(name = "Authorization") String token,
			@PathVariable("loanID") Integer loanId) throws LoanNotFoundException;

}
 