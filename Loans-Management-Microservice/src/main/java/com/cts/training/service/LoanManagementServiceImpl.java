package com.cts.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import com.cts.training.exception.CollateralTypeNotFoundException;
import com.cts.training.exception.CustomerLoanNotFoundException;
import com.cts.training.exception.LoanNotFoundException;
import com.cts.training.feign.CollateralFeign;
import com.cts.training.model.CustomerLoan;
import com.cts.training.model.Loan;
import com.cts.training.model.LoanApplication;
import com.cts.training.pojo.CashDeposit;
import com.cts.training.pojo.RealEstate;
import com.cts.training.repo.CustomerLoanRepo;
import com.cts.training.repo.LoanApplicationRepo;
import com.cts.training.repo.LoanRepo;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * LoanManagementService implementation
 */
@Service
@Slf4j
public class LoanManagementServiceImpl implements LoanManagementService {

	@Autowired
	private CollateralFeign client;

	@Autowired
	private CustomerLoanRepo customerLoanRepo;

	@Autowired
	private LoanRepo loanRepo;
	
	@Autowired
	private LoanApplicationRepo loanApplicationRepo;

	private static final String MESSAGE = "Customer Loan Not found with LoanId: ";

	
	/**
	 * Get Loan Details Implimentation
	 */
	@Override
	public CustomerLoan getLoanDetails(int loanId, int customerId) throws CustomerLoanNotFoundException {
		log.info("Get Loan details using loan id and customer id");
		log.info(loanId+"======="+customerId);
		CustomerLoan customerLoan = customerLoanRepo.findById(loanId)
		.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + loanId));
		/*
		 * Optional<CustomerLoan> customerLoan=customerLoanRepo.findById(loanId);
		 * System.out.println(customerLoan.get()); if(!customerLoan.isPresent()) { throw
		 * new CustomerLoanNotFoundException(MESSAGE+loanId); }
		 */
		System.out.println(customerLoan);
		if (customerLoan.getCustomerId() != customerId) {
			throw new CustomerLoanNotFoundException(MESSAGE + loanId);
		}
		return customerLoan;
	}
	
	/**
	 * Save RealEstate Implementatiom
	 * 
	 * @throws LoanNotFoundException
	 */
	@Override
	public ResponseEntity<String> saveRealEstate(String token, RealEstate realEstate)
			throws CustomerLoanNotFoundException, LoanNotFoundException {
		log.info("Save Real Estate collateral details");
		System.out.println("===========Saving Real Estate details============= from loan management service"+realEstate);
		CustomerLoan customerLoan = customerLoanRepo.findById(realEstate.getLoanId())
				.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + realEstate.getLoanId()));

		Integer prodId = customerLoan.getLoanProductId();
		Optional<Loan> loanop = loanRepo.findById(prodId);
		if(!loanop.isPresent()){
			throw new LoanNotFoundException("Loan Not found by Id" + prodId);
		}else{
			Loan loan = loanop.get();
			String type = loan.getCollateralType();
		try {
			if (type.equals("REAL_ESTATE")) {

				customerLoan.setCollateralId(realEstate.getCollateralId());
				customerLoanRepo.save(customerLoan);
				return client.saveRealEstateCollateral(token, realEstate);
			} else {
				throw new CollateralTypeNotFoundException("Collateral Mismatch");
			}
		} catch (FeignException e) {
			e.printStackTrace();
			throw new CollateralTypeNotFoundException("Collateral already exists with loan id");
		}
		}
	}
	
	/**
	 * Save Cash Deposit Implementation
	 * 
	 * @throws LoanNotFoundException
	 */
	@Override
	public ResponseEntity<String> saveCashDeposit(String token, CashDeposit cashDeposit)
			throws CustomerLoanNotFoundException, LoanNotFoundException {
		log.info("Save Cash Deposit collateral details");
		
		CustomerLoan customerLoan = customerLoanRepo.findById(cashDeposit.getLoanId())
				.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + cashDeposit.getLoanId()));

		Integer prodId = customerLoan.getLoanProductId();
		Optional<Loan> loanop = loanRepo.findById(prodId);
		if(!loanop.isPresent()){
			throw new LoanNotFoundException("Loan not Found By Id:" + prodId);
		}else{
			Loan loan = loanop.get();
			String type = loan.getCollateralType();
			try {
				if (type.equals("CASH_DEPOSIT")) {
					customerLoan.setCollateralId(cashDeposit.getCollateralId());
					customerLoanRepo.save(customerLoan);
					return client.saveCashDepositCollateral(token, cashDeposit);
				} else {
					throw new CollateralTypeNotFoundException("Collateral Mismatch");
				}
			} catch (FeignException e) {
				
				throw new CollateralTypeNotFoundException("Collateral already exists with loan id");
			}
		}
	}
	/**
	 * Saves Loan Application to Database
	 */
	@Override
	public ResponseEntity<String> applyLoan(LoanApplication loanApplication) {
		loanApplicationRepo.save(loanApplication);
		return new ResponseEntity<>("Application Saved", HttpStatus.ACCEPTED);
	}
	/**
	 * Returns list of loans taken by customer, given customer id
	 */
	@Override
	public ArrayList<LoanApplication> viewCustLoan(int custId) {
		ArrayList<LoanApplication> list=new ArrayList<>();
		for(LoanApplication application:loanApplicationRepo.findAll()) {
			if(application.getCustomerId()==custId) {
				
				list.add(application);
			}
		}
		
		return list;
	}
	/**
	 * Returns all applications that have status either Accepted/Rejected
	 */
	@Override
	public ArrayList<LoanApplication> getAll(){
		ArrayList<LoanApplication> list=new ArrayList<LoanApplication>();
		for(LoanApplication application:loanApplicationRepo.findAll()) {
			if(!application.getStatus().equals("Accepted") && !application.getStatus().equals("Rejected"))
				list.add(application);
		}
		return list;
	}
	/**
	 * Given application id, approve loan and add the details to customerloan table
	 */
	@Override
	public ResponseEntity<String> approveLoan(Integer applicationId){
		
		LoanApplication application= loanApplicationRepo.findById(applicationId).get();
		application.setStatus("Accepted");
		loanApplicationRepo.save(application);
		
		
		CustomerLoan customerLoan=new CustomerLoan();
		Integer cId=0;
		if(application.getCollateralDetails().equalsIgnoreCase("Cash Deposit")) {
			cId=101;
		}
		else if(application.getCollateralDetails().equalsIgnoreCase("Real Estate")) {
			Random r = new Random();
			int low = 10;
			int high = 100;
			cId = r.nextInt(high-low) + low;
		}
		Double emi=(Double)application.getLoanAmount()/12.0*application.getTenure();
		customerLoan.setCustomerId(application.getCustomerId());
		customerLoan.setLoanPrincipal(application.getLoanAmount());
		customerLoan.setTenure(application.getTenure());
		customerLoan.setInterest(10.5);
		customerLoan.setEmi(emi);
		customerLoan.setCollateralId(cId);
		customerLoanRepo.save(customerLoan);
		if(application.getCollateralDetails().equalsIgnoreCase("Real Estate")){
			customerLoan.setLoanProductId(1001);
		}
		else {
			customerLoan.setLoanProductId(1002);
		}
		customerLoanRepo.save(customerLoan);
		
		
		return new ResponseEntity<>("Loan Application Accepted", HttpStatus.ACCEPTED);
	
	}
	/**
	 * Given an application id, reject loan and update it in table
	 */ 
	@Override
	public ResponseEntity<String> rejectLoan(Integer applicationId){
		
		LoanApplication application=loanApplicationRepo.findById(applicationId).get();
		application.setStatus("Rejected");
		loanApplicationRepo.save(application);
		return new ResponseEntity<>("Loan Application Rejected", HttpStatus.ACCEPTED);
	
	}
}
