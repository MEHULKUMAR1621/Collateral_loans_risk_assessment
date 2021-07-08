package com.cts.training.collateralwebportal.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoanApplication {
	
	
	private Integer applicationId;
	
	
	private Integer customerId;
	
	@NotNull(message = "Fill in the loan amount")
	private Double loanAmount;
	
	@NotNull(message = "Tenure should not be blank")
	private Integer tenure;
	
	private String collateralDetails;
	
	private String status="Pending";

}
