package com.cts.training.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.cts.training.exception.CustomerLoanNotFoundException;
import com.cts.training.exception.LoanNotFoundException;
import com.cts.training.model.CustomerLoan;
import com.cts.training.model.LoanApplication;
import com.cts.training.pojo.CashDeposit;
import com.cts.training.pojo.RealEstate;

/**
 * LoanManagementService Interface for the loan management functionality
 */
public interface LoanManagementService {
	/**
	 * For Fetching the loan details
	 * @param loanId
	 * @param customerId
	 * @return CustomerLoan
	 * @throws CustomerLoanNotFoundException
	 */
	public CustomerLoan getLoanDetails(int loanId, int customerId) throws CustomerLoanNotFoundException;

	/**
	 * For Saving RealEstate Estate 
	 * @param token
	 * @param realEstate
	 * @return ResponseEntity/Status
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveRealEstate(String token, RealEstate realEstate)
			throws CustomerLoanNotFoundException, LoanNotFoundException;
	/**
	 * For Saving CashDeposit Estate
	 * @param token
	 * @param cashDeposit
	 * @return
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveCashDeposit(String token, CashDeposit cashDeposit)
			throws CustomerLoanNotFoundException, LoanNotFoundException;
	
	
	//MyCoe
	
	/**
	 * For saving LoanApplication
	 * @param loanApplication
	 * @return ResponseEntity/Status 
	 */
	public ResponseEntity<String> applyLoan(LoanApplication loanApplication);
	public ArrayList<LoanApplication> viewCustLoan(int custId);
	public ArrayList<LoanApplication> getAll();
	public ResponseEntity<String> approveLoan(Integer applicationId);
	public ResponseEntity<String> rejectLoan(Integer applicationId);
	
}
