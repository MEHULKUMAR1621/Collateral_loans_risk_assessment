<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Form</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
<!-- <style>
.list {
	margin-left: 82%;
}

.btn {
	margin-left: auto;
	margin-right: auto;
	width: 100%;
}
</style> -->
</head>
<body>
	<%@ include file="common/header2.jsp"%>
	<%-- 	<font color="red">${errorMessage}</font> --%>
	<div class="container">
		<div class="list"></div>
		<h1>
			<button type="button" class="btn btn-secondary btn-lg btn-block">Fill
				the Loan Form Details</button>
		</h1>
		<div class="sub-container">
			<div class="error">${status}</div>
			<font color="red" , size=12px>${errorMessage}</font>
			<form:form method="POST" modelAttribute="loanApplication"
				action="applyloan">
				<table>
					<tr>
						<td><form:label path="customerId">Customer Id</form:label></td>
						<td>${custId}</td>
						<form:input path="customerId" value="${custId}" readOnly="true"
							type="hidden" />

					</tr>
					<tr>
						<td><form:label path="loanAmount">Loan Amount</form:label></td>
						<td><form:input type="number" path="loanAmount"
								required="required" /></td>
						<td><form:errors path="loanAmount" /></td>
					</tr>

					<tr>
						<td><form:label path="tenure">Tenure</form:label></td>
						<td><form:input path="tenure" required="required"
								type="number" /></td>
						<td><form:errors path="tenure" /></td>
					</tr>

					<tr>
						<td><form:label path="collateralDetails">Collateral Type</form:label></td>

						<td>
							<%-- Cash<form:radiobutton path="collateralDetails" value="cash"
								style="width:30%;" /> 
							Real Estate<form:radiobutton path="collateralDetails"
								value="Real Estate" style="width:30%;"/> --%>
								
								<form:select path="collateralDetails" style="width:100%;">
								<form:option path="collateralDetails" value="Cash"  />
								<form:option path="collateralDetails" value="Real Estate"  />
								</form:select>
						</td>
						<td><form:errors path="collateralDetails" cssClass="error" />
						</td>
					</tr>


				</table>



				<div class="btn-width">
					<form:button class="btn btn-outline-primary" type="submit">Apply for loan</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>