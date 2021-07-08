<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collateral Details</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
</head>
<body>
<body>
<%@ include file="common/header.jsp"%>
<div class="sub-container">
<form:form method="POST" modelAttribute="loan"
				action="/portal/riskassessment/collateralDetails">
				<table>
					<tr>
						<td><form:label path="loanId">Loan ID</form:label></td>
						<td><form:input path="loanId" type="text" /></td>
					</tr>

				</table>
<div class="btn-width">
					<form:button class="btn btn-primary" id="toggle">Get Details</form:button>
				</div>
</div>

<div class="sub-container">
<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th scope="col">Collateral Id</th>
						<th scope="col">Loan Id</th>
						<th scope="col">Collateral Type</th>
						<th scope="col">Owner Name</th>
						<th scope="col">Owner Address</th>
						<th scope="col">Owner Contact</th>
						<th scope="col">Current Value</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${details.getCollateralId()}</th>
						<th scope="row">${details.getLoanId()}</th>
						<th scope="row">${details.getCollateralType()}</th>
						<th scope="row">${details.getOwnerName()}</th>
						<th scope="row">${details.getOwnerAddress()}</th>
						<th scope="row">${details.getOwnerContact()}</th>
						<th scope="row">${details.getCurrentValue()}</th>
					</tr>
				</tbody>
			</table>
</div>
</form:form>
${body}
</body>
</html>