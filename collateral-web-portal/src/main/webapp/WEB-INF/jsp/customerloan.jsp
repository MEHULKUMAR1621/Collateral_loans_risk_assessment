<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<div class="container">
		<h1><button type="button" class="btn btn-secondary btn-lg btn-block">Enter The Employee Loan Details</button></h1>
		<div class="sub-container">
			<%-- <div class="error">${loan}</div> --%>
			<div class="error">${status}</div>
			<font color="red">${errorMessage}</font>
			<form:form method="POST" modelAttribute="customloan"
				action="customerloan">

				<table>
					<tr>
						<td><form:label path="loanId">Loan ID</form:label></td>
						<td><form:input class="form-control" path="loanId" /></td>
					</tr>
					<tr>
						<td><form:label path="customerId">Customer ID</form:label></td>
						<td><form:input class="form-control" path="customerId" /></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>

				</table>
				<div class="btn-width">
					<form:button class="btn btn-success">Fetch</form:button>
				</div>

			</form:form>
			<%-- ${loanId} ${customerId}  --%>
		</div>


		<div class="sub-container">



			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th scope="col">Loan Id</th>
						<th scope="col">Loan Product Id</th>
						<th scope="col">Customer Id</th>
						<th scope="col">Loan Principal</th>
						<th scope="col">Tenure</th>
						<th scope="col">Interest</th>
						<th scope="col">EMI</th>
						<th scope="col">Collateral Id</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${loan.getLoanId()}</th>
						<td>${loan.getLoanProductId()}</td>
						<td>${loan.getCustomerId()}</td>
						<td>${loan.getLoanPrincipal()}</td>
						<td>${loan.getTenure()}</td>
						<td>${loan.getInterest()}</td>
						<td>${loan.getEmi()}</td>
						<td>${loan.getCollateralId()}</td>

					</tr>
				</tbody>
			</table>

		</div>



	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>