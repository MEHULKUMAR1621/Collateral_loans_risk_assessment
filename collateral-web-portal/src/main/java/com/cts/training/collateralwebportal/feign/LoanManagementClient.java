package com.cts.training.collateralwebportal.feign;

 

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.training.collateralwebportal.model.CashDeposit;
import com.cts.training.collateralwebportal.model.CustomerLoan;
import com.cts.training.collateralwebportal.model.LoanApplication;
import com.cts.training.collateralwebportal.model.RealEstate;

 
@FeignClient(name = "loan-management", url = "http://localhost:8100/loan/loan-management")
public interface LoanManagementClient {
    
    @GetMapping(value = "/getLoanDetails/{loanId}/{customerId}")
    public CustomerLoan getLoanDetails(@RequestHeader(name = "Authorization") String token, @PathVariable int loanId,
            @PathVariable int customerId);
    
    @PostMapping(value = "/saveRealEstateCollateral")
    public ResponseEntity<String> saveRealEsateCollateral(@RequestHeader(name = "Authorization") String token,
            @RequestBody RealEstate realEstate);
    
    @PostMapping(value = "/saveCashDepositCollateral")
    public ResponseEntity<String> saveCashDepositCollateral(@RequestHeader(name = "Authorization") String token,
            @RequestBody CashDeposit cashDeposit);
    
    @PostMapping(value="/applyLoan")
	public ResponseEntity<String> applyLoan(@RequestBody LoanApplication loanApplication);
    
    @GetMapping(value = "/getLoanApplicationStatus")
    public ArrayList<LoanApplication> viewCustLoan(@RequestHeader int custId);
    
    @GetMapping(value="/getAll")
    public ArrayList<LoanApplication> getAllApplications();
    
    @GetMapping(value="/approveLoanApplication/{applicationId}")
    public ResponseEntity<String> approveLoan(@RequestHeader Integer applicationId);
    
    @GetMapping(value="/rejectLoanApplication/{applicationId}")
    public ResponseEntity<String> rejectLoan(@RequestHeader  Integer applicationId);
    
    

 

}