package com.cts.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "loanApplication")
@SequenceGenerator(name="seq", initialValue=100, allocationSize=1000)
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@ApiModelProperty(value = "Application id of the LoanApplication")
	private Integer applicationId;
	
	@ApiModelProperty(value = "CustomerId in the Loan application")
	private Integer customerId;
	
	@ApiModelProperty(value = "Loan Amount")
	private Double loanAmount;
	
	@ApiModelProperty(value = "Tenure of the loan")
	private Integer tenure;
	
	@ApiModelProperty(value = "Coleteral Details in the application")
	@Column(columnDefinition = "varchar(100) default '-'")
	private String collateralDetails;
	
	@ApiModelProperty(value = "status of the application")
	@Column(columnDefinition = "varchar(30) default 'Waiting for Approval'")
	private String status;

}
