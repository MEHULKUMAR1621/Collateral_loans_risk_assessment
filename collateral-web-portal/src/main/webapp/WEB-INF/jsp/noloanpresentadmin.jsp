<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<h1><button type="button" class="btn btn-secondary btn-lg btn-block">Total Loan Applications</button></h1>
		<div class="sub-container">
		
			<p style="color:red;">No loans have been applied.</p>
		
			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th scope="col">Application Id</th>
						<th scope="col">Customer Id</th>
						<th scope="col">Loan Amount</th>
						<th scope="col">Tenure</th>
						<th scope="col">Collateral Type</th>
						<th scope="col">Status</th>

					</tr>
				</thead>
				<tbody>

					
				</tbody>
			</table>

		
		</div>

	</div>
	
	


	<%@ include file="common/footer.jsp"%>
</body>
</html>