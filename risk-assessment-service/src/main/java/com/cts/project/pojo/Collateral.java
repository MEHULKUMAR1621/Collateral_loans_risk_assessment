package com.cts.project.pojo;

import javax.persistence.Id;



import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiOperation(value = "Model class for collaterals.")
public class Collateral {
	@ApiModelProperty(value = "Id of the collateral.")
	private Integer collateralId;

	@Id
	@ApiModelProperty(value = "Id of the loan.")
	private Integer loanId;

	@ApiModelProperty(value = "Type of collateral-CashDeposit/RealEstate")
	private CollateralType collateralType;

	@ApiModelProperty(value = "Name of owner.")
	private String ownerName;

	@ApiModelProperty(value = "Address of owner.")
	private String ownerAddress;

	@ApiModelProperty(value = "Contact number of owner.")
	private Long ownerContact;

	@ApiModelProperty(value = "Current Value of the collateral.")
	private Double currentValue;
}
