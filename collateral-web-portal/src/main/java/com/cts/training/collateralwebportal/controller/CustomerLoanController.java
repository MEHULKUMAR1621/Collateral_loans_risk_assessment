package com.cts.training.collateralwebportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.training.collateralwebportal.feign.AuthClient;
import com.cts.training.collateralwebportal.feign.LoanManagementClient;
import com.cts.training.collateralwebportal.model.CustomerLoan;
import com.cts.training.collateralwebportal.model.CustomerLoanDto;
import com.cts.training.collateralwebportal.model.LoanApplication;

import feign.FeignException;



@Controller
public class CustomerLoanController {
	
	@Autowired
	private LoanManagementClient loanClient;
	
	@Autowired
	private AuthClient authClient;
	
	
	
	   @RequestMapping(value = "/customerloan", method = RequestMethod.GET)
       public String show(@ModelAttribute("customloan")CustomerLoanDto customloan,ModelMap model) {
           return "customerloan";
       }

  
    
    @RequestMapping(value = "/customerloan", method = RequestMethod.POST)
       public String submitLoan(@Valid @ModelAttribute("customloan")CustomerLoanDto customloan, 
         BindingResult result, ModelMap model,HttpServletRequest request) {
          
           if (result.hasErrors()) {
               model.put("errorMessage", "Invalid Customer Loan Details!");
               return "customerloan";
           }
           String token = "Bearer "+(String) request.getSession().getAttribute("token");
           CustomerLoan loan=null;
          
		    try {
			loan=loanClient.getLoanDetails(token, customloan.getLoanId(),customloan.getCustomerId());
			 System.out.println("================inside Customer Loan=====================");
			model.addAttribute("loan", loan);
			return "customerloan";
		    }
		    catch (FeignException e) {
				// TODO: handle exception
				if(e.getMessage().contains("Customer Loan Not found with LoanId")) {
					model.addAttribute("status", "Customer Loan Not found!!");
				}
					return "customerloan";
			}
			// TODO: handle exception
		
           //LoanManagementClient
           //catchException
           //${seterrormessage}
           //redirect to the same page
           
           //if(no exception)-
           //details of loan
           //set it to model attribute
           //redirect to same page
           
           //return "customerloan";
           
       }
    
    @RequestMapping(value = "/applyloan", method = RequestMethod.GET)
    public String applyLoanGet(@ModelAttribute("loanApplication")LoanApplication loanApplication,ModelMap model,HttpServletRequest request) {
    	
    	//for getting session token to get the custId
    	String token=(String)request.getSession().getAttribute("token");
    	int custId=authClient.getCustId(token);
    	model.put("custId", custId);
    	request.setAttribute("custId", custId);
    	
        return "applyLoan";
    }
    
    @RequestMapping(value = "/applyloan", method = RequestMethod.POST)
    public String applyLoanPost(@Valid @ModelAttribute("loanApplication")LoanApplication loanApplication,ModelMap model,BindingResult result) {
    	if(result.hasErrors()) {
    		return "applyLoan";
    	}
    	
    	//for getting session token to get the custId
//    	String token=(String)request.getSession().getAttribute("token");
//    	int custId=authClient.getCustId(token);
    	
    	loanClient.applyLoan(loanApplication);
    	//System.out.println(custId);
    	//model.put("applicationId",loanApplication.getApplicationId());
        return "successfullyAppliedLoan";
    }
    
    @RequestMapping(value = "/getLoanApplicationStatus", method = RequestMethod.GET)
    public String viewLoanCust(ModelMap model,HttpServletRequest request) {
    	String token=(String)request.getSession().getAttribute("token");
    	int custId=authClient.getCustId(token);
    	//System.out.println(request.getAttribute("custId"));
    	//System.out.println(custId);
    	ArrayList<LoanApplication> list= loanClient.viewCustLoan(custId);
    	System.out.println(list);
    	if(list.size()!=0) {
    		model.put("LoanList", list);
    		return "present";
    	}
    	
    	return "noloanpresent";
    	
    }
    
    @RequestMapping(value="/getAll", method=RequestMethod.GET)
    public String getLoanApplications(ModelMap model) {
    	ArrayList<LoanApplication> list=new ArrayList<>();
    	list=loanClient.getAllApplications();
     	System.out.println(list);
     	if(list.size()!=0) {
     		model.addAttribute("LoanList", list);
     		return "adminloanapplication";
     	}
    	
    	return "noloanpresentadmin";
    }
    
    @RequestMapping(value="/approveLoanApplication", method=RequestMethod.GET)
    public String approveLoanApplication(@RequestParam int applicationId) {
    	System.out.println("accepted");
    	loanClient.approveLoan(applicationId);
    	return "redirect:/getAll";
    }
    @RequestMapping(value="/rejectLoanApplication", method=RequestMethod.GET)
    public String rejectLoanApplication(@RequestParam int applicationId) {
    	System.out.println("rejected");
    	loanClient.rejectLoan(applicationId);
    	return "redirect:/getAll";
    }
    
    
    @ModelAttribute("collateralList")
    public List<String> getWebFrameworkList()
    {
       List<String> collateralList = new ArrayList<String>();
       collateralList.add("Cash Deposit");
       collateralList.add("Real Estate");
       
       return collateralList;
    }
    
   
    
   
}

