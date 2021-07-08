<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Home Page</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
<style type="text/css">
body{
/* background-image: url("/portal/image/bank_background1.jpg"); */
/* background-color: blue; */
}
</style>
</head>
<body>
	<%-- <jsp:include page="./common/nav.jsp" /> --%>
		<%@ include file="common/header1.jsp"%>
	
	<%@ include file="common/header2.jsp"%>

	<div class="container">

	<!-- <h1>Activities</h1>  -->
	<h1>
	<!-- <button type="button" class="btn btn-primary btn-lg btn-block">ACTIVTIES</button> -->
	<button type="button" class="btn btn-secondary btn-lg btn-block">ACTIVITIES</button></h1>
	<!-- <h1>
		<a class="btn btn-deep-orange"><i class="fas fa-clone left"></i> Activities</a>
		</h1> -->

<div class="sub-container">
		<div class="row">
			<div class="col-lg-6">
			<a href="/portal/applyloan">
				<img class="image" src="/portal/image/applyLoanImage.png" alt="Snow"
					style="width: 300px; height: 300px;">
					<p style="font-size:150%;">Apply For Loan</p></a>
			</div>
			<div class="col-lg-6">
			<a href="/portal/getLoanApplicationStatus">
				<img class="image" src="/portal/image/loanStatusImage.jpeg" alt="Mountains"
					style="width: 300px; height: 300px;">
					<p style="font-size:150%;">View Loan Application Status</p></a>
			</div>
			
			

		</div>


		
	</div>
	</div>
	
	<%--  <p>${sessionScope.token}</p> --%>
	<%@ include file="common/footer.jsp"%>
</body>
</html>